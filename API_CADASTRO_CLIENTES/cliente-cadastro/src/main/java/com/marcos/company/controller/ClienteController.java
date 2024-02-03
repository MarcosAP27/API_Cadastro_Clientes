package com.marcos.company.controller;


import com.marcos.company.service.ClienteService;
import com.marcos.company.shared.ClienteCompletoDTO;
import com.marcos.company.shared.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastros-clientes")
public class ClienteController {
    @Autowired
    private ClienteService servico;

    //CREATE
    @PostMapping
    public ResponseEntity<ClienteCompletoDTO> cadastrarCliente(@RequestBody ClienteCompletoDTO dto){
        return new ResponseEntity<>(servico.cadastrarCliente(dto), HttpStatus.CREATED);
    }
    //READ
    @GetMapping
    public ResponseEntity<List<ClienteCompletoDTO>> listaDeClientes(){
        return new ResponseEntity<>(servico.listarClientesCadastrados(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<ClienteCompletoDTO> clienteEspecifico(@PathVariable Integer id){
        Optional<ClienteCompletoDTO> cliente1 = servico.buscarClientePorid(id);

        if(cliente1.isPresent()){
            return new ResponseEntity<>(cliente1.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<ClienteCompletoDTO> atualizarcliente(@PathVariable Integer id,
                                                               @RequestBody ClienteCompletoDTO dto){
        Optional<ClienteCompletoDTO> clienteAtt = servico.atualizarClientePorId(id,dto);
        if(clienteAtt.isPresent()){
            return new ResponseEntity<>(clienteAtt.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<ClienteCompletoDTO> excluirCliente(@PathVariable Integer id){
       servico.excluirclientePorId(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
