package com.example.MetaApi.Repository;

import com.example.MetaApi.model.meta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class repositoryMeta {
    private JdbcTemplate jdbcTemplate;
    public repositoryMeta(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void Salvar(meta task){
        String sql = """
                Insert into meta (titulo, descricao, prazo, status) values(?,?,?,?)
                """;

        jdbcTemplate.update(sql,
                task.getTitulo(),task.getDescricao(),task.getPrazo(),task.getStatus() );
    }

    public List<meta> Mostrar(){
        String sql = """
                Select * from meta
                """;
        List<meta> m = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(meta.class));
        return m;
    }

    public meta Mostrar1(int id){
        String sql = """
                Select * from meta where id = ?
                """;
        meta m = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(meta.class));
        return m;
    }

    public void AtualizarStatus(int id, String status){
        String sql = """
                Update meta set status = ? where id = ?
                """;
        jdbcTemplate.update(sql, status, id);
    }

    public void AtualizarTituloDesc(int id, String titulo, String descricao){
        String sql = """
                Update meta set titulo = ?, descricao = ? where id = ?
                """;
        jdbcTemplate.update(sql, titulo, descricao, id);
    }

    public int Deletar(int id){
        String sql = """
                Delete from meta where id = ?
                """;

        return jdbcTemplate.update(sql, id);
    }
}
