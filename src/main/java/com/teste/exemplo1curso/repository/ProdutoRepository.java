package com.teste.exemplo1curso.repository;

import org.springframework.stereotype.Repository;

import com.teste.exemplo1curso.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
