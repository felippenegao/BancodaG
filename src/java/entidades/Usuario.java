/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Thalyta
 */
public class Usuario {
    private Integer id;
    private String login;
    private String senha;
    private String cpf;
    private String nome;
    private String rg;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String email;
    private String datanasc;
    private int tipo;
    private Telefones telefoneContato;
    

    public Usuario() {
    }
    
        public Usuario(String login, String senha, String cpf, String nome, String rg, String rua, String bairro, String cidade, String estado, String cep, String email, String datanasc, int tipo, Telefones telefoneContato) {
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.datanasc = datanasc;
        this.tipo = tipo;
        this.telefoneContato = telefoneContato;
    }
              

    public Usuario(Integer id,String login, String senha, String cpf, String nome, String rg, String rua, String bairro, String cidade, String estado, String cep, String email, String datanasc, int tipo, Telefones telefoneContato) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.datanasc = datanasc;
        this.tipo = tipo;
        this.telefoneContato = telefoneContato;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Telefones getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(Telefones telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", email=" + email + ", datanasc=" + datanasc + ", tipo=" + tipo + ", telefoneContato=" + telefoneContato + '}';
    }
    
    
    
}
