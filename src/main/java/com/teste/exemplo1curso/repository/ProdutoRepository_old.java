package com.teste.exemplo1curso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.teste.exemplo1curso.model.Produto;
import com.teste.exemplo1curso.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository_old {
    
    private static final Logger logger = LoggerFactory.getLogger(ProdutoRepository_old.class);

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer lastID = 0 ;
    
    /**
     * 
     * @return Lista com todos os produtos.
     */
    public List<Produto> getAll(){ 
        return produtos;
    }

    /**
     * 
     * @param id do produto a ser encontrado
     * @return produto correspondente ao id recebido caso seja encontrado.
     */
    public Optional<Produto> getForID(Integer id) {
        return produtos.stream()
            .filter(produto -> produto.getId().equals(id))
            .findFirst();
    }

    public Produto adicionar(Produto produto){
        lastID++;
        produto.setId(lastID);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo para deleter o produto pelo id
     * @param id
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId()== id);
    }

    /**
     * 
     * @param produto
     * @return o produto apos atualiza-lo na lista de produtos.
     */
    public Produto atualizar(Produto produto){

        Optional<Produto> produtoEncontrado = getForID(produto.getId());
        logger.info("ATUALIZAR");
        if(produtoEncontrado.isEmpty()){
            logger.info("TA VAZIO");
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        deletar(produto.getId());
        produtos.add(produto);

        return produto;
    }
}
