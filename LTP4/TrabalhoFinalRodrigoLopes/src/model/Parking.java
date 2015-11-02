package model;

import java.sql.Date;

public class Parking {
   
    private int cod;
    private String nome;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String uf;
    private int num_vagas;
    private double tarifa_por_hora;
    private double tarifa_por_mes;
    private Date data_registro;
    
    /**
     * 
     * @param cod
     * @param nome
     * @param cnpj
     * @param endereco
     * @param cidade
     * @param uf
     * @param num_vagas
     * @param tarifa_por_hora
     * @param tarifa_por_mes
     * @param data_registro 
     */
    public Parking(int cod, String nome, String cnpj, String endereco, String cidade, String uf, int num_vagas, double tarifa_por_hora, double tarifa_por_mes, Date data_registro) {
        this.cod = cod;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.num_vagas = num_vagas;
        this.tarifa_por_hora = tarifa_por_hora;
        this.tarifa_por_mes = tarifa_por_mes;
        this.data_registro = data_registro;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNum_vagas() {
        return num_vagas;
    }

    public void setNum_vagas(int num_vagas) {
        this.num_vagas = num_vagas;
    }

    public double getTarifa_por_hora() {
        return tarifa_por_hora;
    }

    public void setTarifa_por_hora(float tarifa_por_hora) {
        this.tarifa_por_hora = tarifa_por_hora;
    }

    public double getTarifa_por_mes() {
        return tarifa_por_mes;
    }

    public void setTarifa_por_mes(float tarifa_por_mes) {
        this.tarifa_por_mes = tarifa_por_mes;
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }
}
