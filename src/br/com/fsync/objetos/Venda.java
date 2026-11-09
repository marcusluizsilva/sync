package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus
 */
public class Venda extends Produtos {
    
    Date data;
    double acrescimo;
    double descontoManual;
    double percentualDesconto;
    double precoConcorrente;
    double valorBruto;
    double valorLiquido;
    double valorMS;
    double valorPago;
    double valorPopular;
    double precoBrick;
    double valorCupom;
    int atendimentos;
    int diasAtraso;
    int quantidade;
    String autorizacao;
    String codigoCliente;
    String cpf;
    String codigoVendedor;
    String conferido;
    String cupom;
    String formaPagamento;
    String gratuitoPopular;
    String hora;
    String loja;
    String ndc;
    String nomeCliente;
    String nomeVendedor;
    String observacao;
    String operador;
    String responsavel;
    String concorrente;
    String codigoCartao;
    String bairro;
    String cidade;
    String cep;
    String telefone;
    Date nascimento;
    String sexo;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public double getDescontoManual() {
        return descontoManual;
    }

    public void setDescontoManual(double descontoManual) {
        this.descontoManual = descontoManual;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getPrecoConcorrente() {
        return precoConcorrente;
    }

    public void setPrecoConcorrente(double precoConcorrente) {
        this.precoConcorrente = precoConcorrente;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getValorMS() {
        return valorMS;
    }

    public void setValorMS(double valorMS) {
        this.valorMS = valorMS;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorPopular() {
        return valorPopular;
    }

    public void setValorPopular(double valorPopular) {
        this.valorPopular = valorPopular;
    }

    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getConferido() {
        return conferido;
    }

    public void setConferido(String conferido) {
        this.conferido = conferido;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getGratuitoPopular() {
        return gratuitoPopular;
    }

    public void setGratuitoPopular(String gratuitoPopular) {
        this.gratuitoPopular = gratuitoPopular;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getPrecoBrick() {
        return precoBrick;
    }

    public void setPrecoBrick(double precoBrick) {
        this.precoBrick = precoBrick;
    }

    public String getConcorrente() {
        return concorrente;
    }

    public void setConcorrente(String concorrente) {
        this.concorrente = concorrente;
    }

    public double getValorCupom() {
        return valorCupom;
    }

    public void setValorCupom(double valorCupom) {
        this.valorCupom = valorCupom;
    }

    public String getCodigoCartao() {
        return codigoCartao;
    }

    public void setCodigoCartao(String codigoCartao) {
        this.codigoCartao = codigoCartao;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}
