/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.model.domain;

import com.towel.el.annotation.Resolvable;

/**
 *
 * @author andre
 */
public class Marca {
    
    @Resolvable(colName="Código")
    private long codigo;
    @Resolvable(colName="Descrição")
    private String descricao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao+"";
    }
}

