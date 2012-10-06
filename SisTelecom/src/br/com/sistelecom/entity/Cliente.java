/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

import java.util.Date;

/**
 *
 * @author Danilo Alves
 */
public class Cliente {
    
    private Integer idCliente;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Integer ramo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cidade;
    private Integer uf;
    private long cep;
    private long tel1;
    private long tel2;
    private String email;
    private long inscEst;
    private Date desde;
    private String cpfResp1;
    private String nomeResp1;
    private Date nascResp1;
    private String cpfResp2;
    private String nomeResp2;
    private Date nascResp2;
    private String cpfResp3;
    private String nomeResp3;
    private Date nascResp3;

    public Cliente(Integer idCliente, String cnpj, String razaoSocial, String nomeFantasia, Integer ramo, 
            String logradouro, Integer numero, String complemento, String bairro, Integer cidade, Integer uf, 
            long cep, long tel1, long tel2, String email, long inscEst, Date desde, String cpfResp1, 
            String nomeResp1, Date nascResp1, String cpfResp2, String nomeResp2, Date nascResp2, 
            String cpfResp3, String nomeResp3, Date nascResp3) {
        
        this.idCliente = idCliente;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.ramo = ramo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.email = email;
        this.inscEst = inscEst;
        this.desde = desde;
        this.cpfResp1 = cpfResp1;
        this.nomeResp1 = nomeResp1;
        this.nascResp1 = nascResp1;
        this.cpfResp2 = cpfResp2;
        this.nomeResp2 = nomeResp2;
        this.nascResp2 = nascResp2;
        this.cpfResp3 = cpfResp3;
        this.nomeResp3 = nomeResp3;
        this.nascResp3 = nascResp3;
    }
    
    
    public Cliente(){
    }

    
    /**
     * @return the id
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param id the id to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the razao_social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razao_social the razao_social to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the nome_fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nome_fantasia the nome_fantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cidade
     */
    public Integer getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public Integer getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(Integer uf) {
        this.uf = uf;
    }

    /**
     * @return the cep
     */
    public long getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(long cep) {
        this.cep = cep;
    }

    /**
     * @return the tel_1
     */
    public long getTel1() {
        return tel1;
    }

    /**
     * @param tel_1 the tel_1 to set
     */
    public void setTel1(long tel1) {
        this.tel1 = tel1;
    }

    /**
     * @return the tel_2
     */
    public long getTel2() {
        return tel2;
    }

    /**
     * @param tel_2 the tel_2 to set
     */
    public void setTel2(long tel2) {
        this.tel2 = tel2;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the inscEst
     */
    public long getInscEst() {
        return inscEst;
    }

    public void setInscEst(long inscEst) {
        this.inscEst = inscEst;
    }

    /**
     * @return the desde
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * @param desde the desde to set
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     * @return the cpf_resp_1
     */
    public String getCpfResp1() {
        return cpfResp1;
    }

    /**
     * @param cpf_resp_1 the cpf_resp_1 to set
     */
    public void setCpfResp1(String cpfResp1) {
        this.cpfResp1 = cpfResp1;
    }

    /**
     * @return the nomeResp1
     */
    public String getNomeResp1() {
        return nomeResp1;
    }

    /**
     * @param nome_resp_1 the nomeResp1 to set
     */
    public void setNomeResp1(String nomeResp1) {
        this.nomeResp1 = nomeResp1;
    }

    /**
     * @return the nascResp1
     */
    public Date getNascResp1() {
        return nascResp1;
    }

    /**
     * @param nasc_resp_1 the nascResp1 to set
     */
    public void setNascResp1(Date nascResp1) {
        this.nascResp1 = nascResp1;
    }

    /**
     * @return the cpfResp2
     */
    public String getCpfResp2() {
        return cpfResp2;
    }

    /**
     * @param cpf_resp_2 the cpfResp2 to set
     */
    public void setCpfResp2(String cpfResp2) {
        this.cpfResp2 = cpfResp2;
    }

    /**
     * @return the nomeResp2
     */
    public String getNomeResp2() {
        return nomeResp2;
    }

    /**
     * @param nome_resp_2 the nomeResp2 to set
     */
    public void setNomeResp2(String nomeResp2) {
        this.nomeResp2 = nomeResp2;
    }

    /**
     * @return the nascResp2
     */
    public Date getNascResp2() {
        return nascResp2;
    }

    /**
     * @param nasc_resp_2 the nascResp2 to set
     */
    public void setNascResp2(Date nascResp2) {
        this.nascResp2 = nascResp2;
    }

    /**
     * @return the cpfResp3
     */
    public String getCpfResp3() {
        return cpfResp3;
    }

    /**
     * @param cpf_resp_3 the cpfResp3 to set
     */
    public void setCpfResp3(String cpfResp3) {
        this.cpfResp3 = cpfResp3;
    }

    /**
     * @return the nomeResp3
     */
    public String getNomeResp3() {
        return nomeResp3;
    }

    /**
     * @param nascResp3 the nomeResp3 to set
     */
    public void setNomeResp3(String nomeResp3) {
        this.nomeResp3 = nomeResp3;
    }

    /**
     * @return the nascResp3
     */
    public Date getNascResp3() {
        return nascResp3;
    }

    /**
     * @param nascResp3 the nascResp3 to set
     */
    public void setNascResp3(Date nascResp3) {
        this.nascResp3 = nascResp3;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getRamo() {
        return ramo;
    }

    public void setRamo(Integer ramo) {
        this.ramo = ramo;
    }

}
