package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class Clientes {

    String id;
    String codigo;
    String nome;
    String telefone;
    String celular;
    String loja;
    double limite;
    double debito;
    double desconto;
    double saldo;
    String status;
    Date ultimaCompra;
    String ultimaCompraStr;
    Date ultimoPagamento;
    Date dataVencimento;
    Date primeiraCompra;
    String endereco;
    String bairro;
    String numero;
    String complemento;
    String cidade;
    String estado;
    String cep;
    String referencia1;
    String referencia2;
    String observacao;
    String telefoneContato;
    String contato;
    String email;
    String sexo;
    String ddd;
    Date ultimaAtualizacao;
    String ultimaAtualizacaoStr;
    int diasAtraso;
    int diasLimite;
    String ndc;
    String nomeCartaoCliente;
    String codigoCartaoCliente;
    String cpf;
    int idade;
    double valor;
    double atendimentos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(Date ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }

    public String getUltimaCompraStr() {
        return ultimaCompraStr;
    }

    public void setUltimaCompraStr(String ultimaCompraStr) {
        this.ultimaCompraStr = ultimaCompraStr;
    }

    public Date getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(Date ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getUltimaAtualizacaoStr() {
        return ultimaAtualizacaoStr;
    }

    public void setUltimaAtualizacaoStr(String ultimaAtualizacaoStr) {
        this.ultimaAtualizacaoStr = ultimaAtualizacaoStr;
    }

    public Date getPrimeiraCompra() {
        return primeiraCompra;
    }

    public void setPrimeiraCompra(Date primeiraCompra) {
        this.primeiraCompra = primeiraCompra;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public int getDiasLimite() {
        return diasLimite;
    }

    public void setDiasLimite(int diasLimite) {
        this.diasLimite = diasLimite;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getNomeCartaoCliente() {
        return nomeCartaoCliente;
    }

    public void setNomeCartaoCliente(String nomeCartaoCliente) {
        this.nomeCartaoCliente = nomeCartaoCliente;
    }

    public String getCodigoCartaoCliente() {
        return codigoCartaoCliente;
    }

    public void setCodigoCartaoCliente(String codigoCartaoCliente) {
        this.codigoCartaoCliente = codigoCartaoCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(double atendimentos) {
        this.atendimentos = atendimentos;
    }
    
    
}
