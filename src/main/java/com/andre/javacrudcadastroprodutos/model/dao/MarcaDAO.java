/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.model.dao;

import com.andre.javacrudcadastroprodutos.bd.ConexaoPostgres;
import com.andre.javacrudcadastroprodutos.model.domain.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author andre
 */
public class MarcaDAO extends ConexaoPostgres {
     public List<Marca> listarTodos() throws Exception {
        List<Marca> lMarca = new LinkedList<>();
        try{
            this.conectar();
            String sql = "SELECT * FROM MARCA ORDER BY CODIGO";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("CODIGO"));
                marca.setDescricao(rs.getString("DESCRICAO"));
                lMarca.add(marca);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return lMarca;
    }
    
    public Marca recuperar(int codigo) throws Exception {
        Marca marca = new Marca();
        try{
            this.conectar();
            String sql = "SELECT * FROM MARCA WHERE CODIGO=?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                marca.setCodigo(rs.getInt("CODIGO"));
                marca.setDescricao(rs.getString("DESCRICAO"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return marca;
    }
}
