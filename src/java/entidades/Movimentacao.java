/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Thalyta
 */
public class Movimentacao implements Serializable{
    
    private Integer id;
    private Date data;
    private Conta conta;
    private String titular;
    private String tipoMovimentacao;
    private double valor;
    private Timestamp hora;

    
    public Movimentacao() {
    }

   
    public Movimentacao(Integer id, Date data, Conta conta, String titular, String tipoMovimentacao,double  valor) {
        this.id = id;
        this.data = data;
        this.conta = conta;
        this.titular = titular;
        this.tipoMovimentacao = tipoMovimentacao;
        this.valor = valor;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    @Override
    public String toString() {
        return "Movimentacao{" + "id=" + id + ", data=" + data + ", conta=" + conta + ", titular=" + titular + ", tipoMovimentacao=" + tipoMovimentacao + ", valor=" + valor + '}';
    }

    
    
    
    
    
    
}
