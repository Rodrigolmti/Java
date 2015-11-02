package model;

import java.sql.Timestamp;


public class Salaried {
   
    private int codigo;
    private int cod_estacionameto;
    private String nome;
    private String telefone;
    private String placa;
    private Timestamp data_entrada;
    private Timestamp data_saida;

    public Salaried(int codigo, int cod_estacionameto, String nome, String telefone, String placa, Timestamp data_entrada, Timestamp data_saida) {
        this.codigo = codigo;
        this.cod_estacionameto = cod_estacionameto;
        this.nome = nome;
        this.telefone = telefone;
        this.placa = placa;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_estacionameto() {
        return cod_estacionameto;
    }

    public void setCod_estacionameto(int cod_estacionameto) {
        this.cod_estacionameto = cod_estacionameto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Timestamp getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Timestamp data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Timestamp getData_saida() {
        return data_saida;
    }

    public void setData_saida(Timestamp data_saida) {
        this.data_saida = data_saida;
    }
    
    
}
