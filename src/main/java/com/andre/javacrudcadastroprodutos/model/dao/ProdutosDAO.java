/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.model.dao;

import com.andre.javacrudcadastroprodutos.bd.ConexaoPostgres;
import com.andre.javacrudcadastroprodutos.model.domain.Marca;
import com.andre.javacrudcadastroprodutos.model.domain.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ProdutosDAO extends ConexaoPostgres {
        public List<Produtos> listarTodos() throws Exception {
        List<Produtos> lProdutos = new LinkedList<>();
        try{
            this.conectar();
            ProdutosDAO produDAO = new ProdutosDAO();
            String sql = "SELECT * FROM PRODUTOS ORDER BY CODIGO";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produtos produtos = new Produtos();
                produtos.setCodigo(rs.getInt("CODIGO"));
                produtos.setDescricao(rs.getString("DESCRICAO"));
                produtos.setMarca(produDAO.recuperar(rs.getInt("MARCA")));
                produtos.setPreco(rs.getDouble("PRECO"));
                produtos.setQuantidade(rs.getInt("QUANTIDADE"));
                lProdutos.add(produtos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return lProdutos;
    }
    
    public void inserir(Produtos produtos) throws Exception {
        try{
            this.conectar();
            this.insertSQL("INSERT INTO FUNCIONARIO ( DESCRICAO, MARCA, PRECO, QUANTIDADE) "
                    + "VALUES ("
                    + "'" + produtos.getDescricao()+ "',"
                    + "'" + produtos.getMarca().getCodigo() + "'"
                    + "'" + produtos.getPreco() + "',"
                    + "'" + produtos.getQuantidade() + " "
                    + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }
    
    public void alterar(Produtos produtos) throws Exception {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "UPDATE PRODUTOS SET "
                    + "DESCRICAO = '" + produtos.getDescricao()+ "',"
                    + "PRECO = '" + produtos.getPreco()+ "',"
                    + "QUANTIDADE = '" + produtos.getQuantidade()+ "',"
                    + "MARCA = '" + produtos.getMarca().getCodigo() + "'"
                + " WHERE "
                    + "CODIGO = '" + produtos.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }
    
    public void excluir(Produtos produtos) throws Exception {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "DELETE FROM PRODUTOS "
                + " WHERE "
                    + "CODIGO = '" + produtos.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
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
