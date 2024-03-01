package com.teste.exemplo1curso.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.exemplo1curso.model.Produto;
import com.teste.exemplo1curso.model.exception.ResourceNotFoundException;
import com.teste.exemplo1curso.repository.ProdutoRepository;
import com.teste.exemplo1curso.shared.ProdutoDTO;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getAll() {
        // Colocar regra de negócio aqui.
        
       List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
        .map(produto -> new ModelMapper()
        .map(produto,ProdutoDTO.class)).collect(Collectors.toList());

    }
    
    /**
     * @param id
     * @return
     */
    public Optional<ProdutoDTO> getForID(Integer id) {
       
        @SuppressWarnings("null")
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id " + id + " não encontrado.");
        }

        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);

        return Optional.of(dto);
    }

    
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        // Colocar regra de negócio aqui.

        produtoDto.setId(null);

        // criando objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        Produto produto = mapper.map(produtoDto, Produto.class);

        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());

        return produtoDto;
    }

    public void deletar(Integer id){
        // Colocar regra de negócio aqui.
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletear o produto com id: " + id + " Produto não encontrado.");
        }

        produtoRepository.deleteById(id);
    }

    public ProdutoDTO atualizar(ProdutoDTO produtodTO, Integer id){
        produtodTO.setId(id);

        ModelMapper mapper = new ModelMapper();
         
        Produto produto = mapper.map(produtodTO, Produto.class);
        
        produtoRepository.save(produto);
        
        return produtodTO;
    }
    
}
