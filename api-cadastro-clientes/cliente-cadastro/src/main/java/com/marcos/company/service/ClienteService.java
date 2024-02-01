package com.marcos.company.service;

import com.marcos.company.shared.ClienteCompletoDTO;
import com.marcos.company.shared.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {
    public ClienteCompletoDTO cadastrarCliente (ClienteCompletoDTO dto);
    public List<ClienteCompletoDTO> listarClientesCadastrados();
    public Optional<ClienteCompletoDTO> buscarClientePorid(Integer id);
    public Optional<ClienteCompletoDTO> atualizarClientePorId(Integer id, ClienteCompletoDTO dto);
    public void excluirclientePorId(Integer id);
}
