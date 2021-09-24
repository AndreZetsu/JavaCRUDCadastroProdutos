/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ConexaoPostgres {
    
    private boolean status = false;
    private String mensagem = ""; 
    private Connection con = null;  
    private Statement statement;
    private ResultSet resultSet;
    private  static  PropriedadesBD propriedadesBD;

    
    public ConexaoPostgres(){}

    /**
     * Abre uma conexao com o banco
     * @return Connection
     */
    public Connection conectar(){
        try {
            propriedadesBD =  new PropriedadesBD();
            Class.forName(propriedadesBD.getDriver());

            this.setCon((Connection) DriverManager.getConnection(propriedadesBD.getUrl(), propriedadesBD.getUsuario(), propriedadesBD.getSenha()));
            //se ocorrer tudo bem, ou seja, se conectar a linha a segui é executada
            this.status = true;
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\nErro: "+ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\nErro: "+ex.getMessage());
        }
        
        return this.getCon();
    }

    /**
     * Executa consultas SQL
     * @param pSQL
     * @return int
     */
    public boolean executarSQL(String pSQL){
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean executarUpdateDeleteSQL(String pSQL){
        try {         
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().execute(pSQL);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Executa insert SQL
     * @param pSQL
     * @return boolean
     */
    public boolean insertSQL(String pSQL){
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().execute(pSQL);
            
            //consulta o último id inserido
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    

    /**
     * encerra a conexão corrente
     * @return boolean
     */
    public boolean fecharConexao(){
       try {
           if((this.getResultSet() != null) && (this.statement != null)){
               this.getResultSet().close();
               this.statement.close();
           }
           this.getCon().close();
           return true;
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return false;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return this.status;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

}

    

