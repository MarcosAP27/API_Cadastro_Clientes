package com.marcos.company.shared;

import com.marcos.company.model.Cliente;

public record ClienteDTO  (String nome, Integer numeroTelefone) {
    public static ClienteDTO fromClienteDTO (Cliente cliente){
        return new ClienteDTO(cliente.getNome(), cliente.getNumeroTelefone());
    }
}
