package com.teste.exemplo1curso.view.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;


import com.teste.exemplo1curso.services.ProdutoService;
import com.teste.exemplo1curso.shared.ProdutoDTO;
import com.teste.exemplo1curso.view.model.ProdutoRequest;
import com.teste.exemplo1curso.view.model.ProdutoResponse;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoservice;

    @GetMapping  
    public ResponseEntity<List<ProdutoResponse>> getAll(){
        List<ProdutoDTO> produtos = produtoservice.getAll();

        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> response = produtos.stream()
        .map(produto -> mapper.map(produto, ProdutoResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq){
            ModelMapper mapper = new ModelMapper();

            ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

           produtoDto = produtoservice.adicionar(produtoDto);
           
           return new ResponseEntity<ProdutoResponse>(mapper.map(produtoDto, ProdutoResponse.class), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> getForID(@PathVariable Integer id) {
        // Caso eu não trate a excessão, que no caso está sendo tratada no service, usar o try catch.
        //try {
        Optional<ProdutoDTO> produtoDto = produtoservice.getForID(id);
        ProdutoResponse produtoresponse = new ModelMapper().map(produtoDto.get(), ProdutoResponse.class);
    
        return new ResponseEntity<>(Optional.of(produtoresponse), HttpStatus.OK);
    // } catch (Exception e) {
    //      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForID(@PathVariable Integer id){
        produtoservice.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar (@RequestBody ProdutoRequest produtoReq,@PathVariable Integer id){
        ModelMapper mapper = new ModelMapper();

        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

        produtoDto = produtoservice.atualizar(produtoDto,id);

        return new ResponseEntity<>(
            mapper.map(produtoDto, ProdutoResponse.class),
            HttpStatus.OK
            );
    }

}
