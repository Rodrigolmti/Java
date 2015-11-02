package model;

import java.sql.Timestamp;

public class Vehicle {
    
    private int noTicket;
    private int cod_estacionamento;
    private int codigo;
    private String placa;
    private Timestamp entrada;
    private Timestamp saida;
    private double permanencia_em_horas;
    private double tarifa_por_hora;
    private double valor_pago;

    public Vehicle(int noTicket, int cod_estacionamento, int codigo, String placa, Timestamp entrada, Timestamp saida, double permanencia_em_horas, double tarifa_por_hora, double valor_pago) {
        this.noTicket = noTicket;
        this.cod_estacionamento = cod_estacionamento;
        this.codigo = codigo;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.permanencia_em_horas = permanencia_em_horas;
        this.tarifa_por_hora = tarifa_por_hora;
        this.valor_pago = valor_pago;
    }

    public int getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(int noTicket) {
        this.noTicket = noTicket;
    }

    public int getCod_estacionamento() {
        return cod_estacionamento;
    }

    public void setCod_estacionamento(int cod_estacionamento) {
        this.cod_estacionamento = cod_estacionamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSaida() {
        return saida;
    }

    public void setSaida(Timestamp saida) {
        this.saida = saida;
    }

    public double getPermanencia_em_horas() {
        return permanencia_em_horas;
    }

    public void setPermanencia_em_horas(double permanencia_em_horas) {
        this.permanencia_em_horas = permanencia_em_horas;
    }

    public double getTarifa_por_hora() {
        return tarifa_por_hora;
    }

    public void setTarifa_por_hora(double tarifa_por_hora) {
        this.tarifa_por_hora = tarifa_por_hora;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }
    
    
}