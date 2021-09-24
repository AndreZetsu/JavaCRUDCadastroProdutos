/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.javacrudcadastroprodutos.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author andre
 */
public class Utilitario {
    public static String converterDoubleFormatoMoeda(double valorDouble) {
        Locale ptBr = new Locale("pt", "BR");
        String formatoMoeda = NumberFormat.getCurrencyInstance(ptBr).format(valorDouble);
        return formatoMoeda;
    }
}
