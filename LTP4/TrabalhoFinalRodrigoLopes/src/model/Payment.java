/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author rodrigo.martins
 */
public class Payment {
    
    private int noPagto;
    private int codigo;
    private int mes_referencia;
    private int ano_referencia;
    private Date data_pagto;
    private double valor;

    public Payment(int noPagto, int codigo, int mes_referencia, int ano_referencia, Date data_pagto, double valor) {
        this.noPagto = noPagto;
        this.codigo = codigo;
        this.mes_referencia = mes_referencia;
        this.ano_referencia = ano_referencia;
        this.data_pagto = data_pagto;
        this.valor = valor;
    }

    public int getNoPagto() {
        return noPagto;
    }

    public void setNoPagto(int noPagto) {
        this.noPagto = noPagto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMes_referencia() {
        return mes_referencia;
    }

    public void setMes_referencia(int mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public int getAno_referencia() {
        return ano_referencia;
    }

    public void setAno_referencia(int ano_referencia) {
        this.ano_referencia = ano_referencia;
    }

    public Date getData_pagto() {
        return data_pagto;
    }

    public void setData_pagto(Date data_pagto) {
        this.data_pagto = data_pagto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
