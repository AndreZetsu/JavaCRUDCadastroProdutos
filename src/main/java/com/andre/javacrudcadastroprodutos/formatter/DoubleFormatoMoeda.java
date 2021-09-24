/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.formatter;

import com.towel.bean.Formatter;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author andre
 */
public class DoubleFormatoMoeda implements Formatter{

    @Override
    public Object format(Object o) {
        Double valorDouble = (Double) o;
        Locale ptBr = new Locale("pt", "BR");
        String formatoMoeda = NumberFormat.getCurrencyInstance(ptBr).format(valorDouble);
        return formatoMoeda;
    }

    @Override
    public Object parse(Object o) {
        return null;
    }

    @Override
    public String getName() {
        return "valorDouble";
    }
    
}
