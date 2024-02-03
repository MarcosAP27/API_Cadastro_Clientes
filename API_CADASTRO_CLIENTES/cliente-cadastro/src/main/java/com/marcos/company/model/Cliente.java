package com.marcos.company.model;

import com.marcos.company.shared.ClienteCompletoDTO;
import jakarta.persistence.*;


@Entity
@Table(schema = "cadastrados", name = "clientes")

public class Cliente {
    public Cliente (){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;
    private Integer numeroTelefone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(Integer numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
    public Cliente(ClienteCompletoDTO dto){
        this.endereco = dto.endereco();
        this.id = dto.Id();
        this.nome = dto.nome();
        this.numeroTelefone = dto.numeroTelefone();
    }
}
