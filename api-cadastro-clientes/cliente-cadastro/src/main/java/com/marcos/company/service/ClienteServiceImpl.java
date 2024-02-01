package com.marcos.company.service;

import com.marcos.company.model.Cliente;
import com.marcos.company.repositorio.Repository;
import com.marcos.company.shared.ClienteCompletoDTO;
import com.marcos.company.shared.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    public Repository repositorio;
    @Override
    //CadastrarClientes
    public ClienteCompletoDTO cadastrarCliente(ClienteCompletoDTO dto) {
        Cliente cliente1 = new Cliente(dto);
        cliente1 = repositorio.save(cliente1);
        return new ClienteCompletoDTO(cliente1.getNome(), cliente1.getId(), cliente1.getEndereco(),
                                      cliente1.getNumeroTelefone());
    }
    //BuscarClientes
    @Override
    public List<ClienteCompletoDTO> listarClientesCadastrados() {
       return repositorio.findAll().stream().map(ClienteCompletoDTO::fromClienteCompletoDto).toList();
    }
    //BuscarEspecifíco
    @Override
    public Optional<ClienteCompletoDTO> buscarClientePorid(Integer id) {
        Optional <Cliente> cliente1 = repositorio.findById(id);
        if(cliente1.isPresent()){
            return Optional.of(ClienteCompletoDTO.fromClienteCompletoDto(cliente1.get()));
        }
        return Optional.empty();
    }
    //AtualizarClientes
    @Override
    public Optional<ClienteCompletoDTO> atualizarClientePorId(Integer id, ClienteCompletoDTO dto) {
       Optional<Cliente> cliente1 = repositorio.findById(id);

       if(cliente1.isPresent()){
           Cliente clienteNovo = cliente1.get();
           clienteNovo.setNumeroTelefone(dto.numeroTelefone());
           clienteNovo.setNome(dto.nome());
           clienteNovo.setEndereco(dto.endereco());
       Cliente clienteAtualizado = repositorio.save(clienteNovo);

       return Optional.of(ClienteCompletoDTO.fromClienteCompletoDto(clienteAtualizado));
       }
       return Optional.empty();
    }
    //ExcluirCLiente
    @Override
    public void excluirclientePorId(Integer id) {
    repositorio.deleteById(id);
    }
}
