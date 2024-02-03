package com.marcos.company.shared;

import com.marcos.company.model.Cliente;

public record ClienteCompletoDTO (String nome, Integer Id, String endereco, Integer numeroTelefone) {
    public static ClienteCompletoDTO fromClienteCompletoDto(Cliente cliente) {
    return new ClienteCompletoDTO(cliente.getNome(), cliente.getId(),
                    cliente.getEndereco(), cliente.getNumeroTelefone());
    }
}
