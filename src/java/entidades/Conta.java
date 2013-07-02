/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Thalyta
 */
public class Conta {
    private Integer id;
    private Integer numero;
    private Double saldo;
    private Integer id_usuario;
    private Integer id_agencia;
   

    public Conta() {
    }

    public Conta(Integer id, Integer numero, Double saldo, Integer id_usuario, Integer id_agencia) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.id_usuario = id_usuario;
        this.id_agencia = id_agencia;
        
        
    }
    
    public Conta(Integer numero, Double saldo, Integer id_usuario, Integer id_agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.id_usuario = id_usuario;
        this.id_agencia = id_agencia;
        
        
    }

     public Conta(Integer id, Integer numero, Double saldo) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;        
    }    
    
    
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_agencia = id_usuario;
    }
    
    public Integer getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(Integer id_agencia) {
        this.id_agencia = id_agencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo){
    this.saldo= saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", id_usuario=" + id_usuario + ", id_agencia=" + id_agencia + '}';
    }

    

    public void setNumero(String string) {
        this.numero = numero;
    }
            
    
    
}
