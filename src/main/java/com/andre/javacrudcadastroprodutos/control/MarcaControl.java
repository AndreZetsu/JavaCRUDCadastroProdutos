/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.control;

import com.andre.javacrudcadastroprodutos.model.dao.MarcaDAO;
import com.andre.javacrudcadastroprodutos.model.domain.Marca;
import java.util.List;

/**
 *
 * @author andre
 */
public class MarcaControl {
    MarcaDAO marcaDAO = new MarcaDAO();
    
    public List<Marca> listarTodos() throws Exception {
        return marcaDAO.listarTodos();
    }
}
