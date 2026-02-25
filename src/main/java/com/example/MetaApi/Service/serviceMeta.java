package com.example.MetaApi.Service;

import com.example.MetaApi.DTO.metaDTO;
import com.example.MetaApi.Repository.repositoryMeta;
import com.example.MetaApi.model.meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class serviceMeta {
    @Autowired
    private repositoryMeta repositoryMeta;

    public  serviceMeta(repositoryMeta repositoryMeta){
        this.repositoryMeta = repositoryMeta;
    }

    public meta Criar(metaDTO dto) {
        if(dto == null){
            return null;
        }
        meta task = new meta(dto.titulo(), dto.descricao(), dto.prazo(), dto.status());
        repositoryMeta.Salvar(task);
        return task;
    }

    public List<meta> mostraTudo(){
        return repositoryMeta.Mostrar();
    }

    public meta mostraById(int id){
        if(id <= 0){
            return null;
        }
        return repositoryMeta.Mostrar1(id);
    }

    public meta atualizaStatus(int id, metaDTO dto){
        String status = dto.status();
        if(id <= 0 && status == null){
            return null;
        }

        meta task = new meta(id, dto.titulo(), dto.descricao(), dto.prazo(), status);
        repositoryMeta.AtualizarStatus(id, status);
        return task;
    }

    public meta upTituloDesc(int id, metaDTO dto){
        String titulo = dto.titulo();
        String descricao = dto.descricao();

        if(id <= 0){
            return null;
        }

        meta task = new meta(id, titulo, descricao, dto.prazo(), dto.status());
        repositoryMeta.AtualizarTituloDesc(id, titulo, descricao);
        return task;
    }

    public boolean Excluir(int id){
        return repositoryMeta.Deletar(id) > 0;
    }
}
