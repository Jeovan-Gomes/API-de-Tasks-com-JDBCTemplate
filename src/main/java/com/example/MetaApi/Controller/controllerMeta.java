package com.example.MetaApi.Controller;

import com.example.MetaApi.DTO.metaDTO;
import com.example.MetaApi.Service.serviceMeta;
import com.example.MetaApi.model.meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;import java.util.List;

@RestController
@RequestMapping("/task")
public class controllerMeta {
    @Autowired
    private final serviceMeta serviceMeta;

    public controllerMeta(serviceMeta serviceMeta) {
        this.serviceMeta = serviceMeta;
    }

    @PostMapping
    public ResponseEntity<meta> SaveTask(@RequestBody metaDTO dto){
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(serviceMeta.Criar(dto));
    }

    @GetMapping
    public ResponseEntity<?> GetAllTasks(){
        return ResponseEntity.ok(serviceMeta.mostraTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetTaskById(@PathVariable int id){
        if(id <= 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(serviceMeta.mostraById(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable int id, @RequestBody metaDTO dto){
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(serviceMeta.atualizaStatus(id, dto));
    }

    @PatchMapping("/titulo/{id}")
    public ResponseEntity<?> updateTitulo(@PathVariable int id, @RequestBody metaDTO dto){
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(serviceMeta.upTituloDesc(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
        if(id <= 0){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(serviceMeta.Excluir(id));
    }
}
