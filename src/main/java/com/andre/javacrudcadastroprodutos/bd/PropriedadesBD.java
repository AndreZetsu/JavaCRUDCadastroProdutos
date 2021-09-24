/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
class PropriedadesBD {
    private String localServidor;
    private String nomeBanco;
    private String usuario;
    private String senha;
    private String url ;
    private String outro;
    private String bancoDados;
    private String driver;
    final private String POSTGRES  =  "POSTGRES";


    public  PropriedadesBD() {

        FileReader ler =  null ;
        try {           
            ler =  new FileReader(new File("").getAbsolutePath() +"/config.txt");
            BufferedReader leitor =  new BufferedReader(ler);
            while((outro = leitor.readLine()) !=  null) {
                if (outro.equals("BANCODADOS")) {
                    bancoDados = leitor.readLine();
                }
                if (outro.equals("ENDERECO")) {
                    localServidor = leitor.readLine();
                }
                if (outro.equals("BANCO")) {
                    nomeBanco = leitor.readLine();
                }
                if (outro.equals("USUARIO")) {
                    usuario = leitor.readLine();
                }
                if (outro.equals("SENHA")) {
                    senha = leitor.readLine();
                }
            }
            
            if (bancoDados.equalsIgnoreCase(POSTGRES)) {
                url = "jdbc:postgresql://"+ localServidor.trim()+":5432/"+nomeBanco.trim()+"";
                driver = "org.postgresql.Driver";
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropriedadesBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropriedadesBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  finally {
            try {
                ler.close();
            } catch ( IOException ex) {
                Logger.getLogger(PropriedadesBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

    }

    public String getLocalServidor() {
        return localServidor;
    }

    public void setLocalServidor(String localServidor) {
        this.localServidor = localServidor;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public String getBancoDados() {
        return bancoDados;
    }

    public void setBancoDados(String bancoDados) {
        this.bancoDados = bancoDados;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
