/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.control;

import com.andre.javacrudcadastroprodutos.model.dao.ProdutosDAO;
import com.andre.javacrudcadastroprodutos.model.domain.Produtos;
import java.util.List;

/**
 *
 * @author andre
 */
public class ProdutosControl {
    ProdutosDAO produtosDAO = new ProdutosDAO();
    
    public List<Produtos> listarTodos() throws Exception {
        return produtosDAO.listarTodos();
    }
    
    public void inserirFuncionario(Produtos produtos) throws Exception {
        produtosDAO.inserir(produtos);
    }
    
    public void alterarFuncionario(Produtos produtos) throws Exception {
        produtosDAO.alterar(produtos);
    }
    
    public void excluirFuncionario(Produtos produtos) throws Exception {
        produtosDAO.excluir(produtos);
    }
}
