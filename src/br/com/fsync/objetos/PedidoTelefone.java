package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class PedidoTelefone {

    String ndc;
    String loja;
    Date data;
    Date ultimaCompra;
    String ultimaCompraStr;
    String dataString;
    String nomeCliente;
    String codigoCliente;
    String telefoneCliente;
    String ddd;
    double valor;
    double valorPago;
    double troco;
    double taxaSite;
    double taxaCorreios;
    String horaPedido;
    String horaChegadaPolo;
    String horaSeparacao;
    String horaSaida;
    String horaRetorno;
    String tempoSeparacao;
    String tempoExpedicao;
    String tempoRetorno;
    String tempoEntrega;
    String portador;
    String vendedor;
    String separador;
    String entregador;
    String endereco;
    String complemento;
    String bairro;
    String cidade;
    String referencia1;
    String referencia2;
    String observacao;
    String operadorLoja;
    String operadorEntrega;
    String status;
    String formaDePagamento;
    String conferido;
    String receber;
    String cep;
    String estado;
    int atendimentos;
    String codigoCorreios;
    String cpf;
    String localPortador;
    String codigoVendedor;
    String codigoProduto;
    int quantidadeProduto;
    String tipoCaixa;
    String tipoEnvio;
    String recno;
    String meioCompra;
    double valorApp;
    double valorSite;
    int atendimentosApp;
    int atendimentosSite;
    String localRetirada;

    public PedidoTelefone() {
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getTaxaSite() {
        return taxaSite;
    }

    public void setTaxaSite(double taxaSite) {
        this.taxaSite = taxaSite;
    }

    public double getTaxaCorreios() {
        return taxaCorreios;
    }

    public void setTaxaCorreios(double taxaCorreios) {
        this.taxaCorreios = taxaCorreios;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getHoraChegadaPolo() {
        return horaChegadaPolo;
    }

    public void setHoraChegadaPolo(String horaChegadaPolo) {
        this.horaChegadaPolo = horaChegadaPolo;
    }

    public String getHoraSeparacao() {
        return horaSeparacao;
    }

    public void setHoraSeparacao(String horaSeparacao) {
        this.horaSeparacao = horaSeparacao;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraRetorno() {
        return horaRetorno;
    }

    public void setHoraRetorno(String horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    public String getTempoSeparacao() {
        return tempoSeparacao;
    }

    public void setTempoSeparacao(String tempoSeparacao) {
        this.tempoSeparacao = tempoSeparacao;
    }

    public String getTempoExpedicao() {
        return tempoExpedicao;
    }

    public void setTempoExpedicao(String tempoExpedicao) {
        this.tempoExpedicao = tempoExpedicao;
    }

    public String getTempoRetorno() {
        return tempoRetorno;
    }

    public void setTempoRetorno(String tempoRetorno) {
        this.tempoRetorno = tempoRetorno;
    }

    public String getTempoEntrega() {
        return tempoEntrega;
    }

    public void setTempoEntrega(String tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
    }

    public String getPortador() {
        return portador;
    }

    public void setPortador(String portador) {
        this.portador = portador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getOperadorLoja() {
        return operadorLoja;
    }

    public void setOperadorLoja(String operadorLoja) {
        this.operadorLoja = operadorLoja;
    }

    public String getOperadorEntrega() {
        return operadorEntrega;
    }

    public void setOperadorEntrega(String operadorEntrega) {
        this.operadorEntrega = operadorEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getConferido() {
        return conferido;
    }

    public void setConferido(String conferido) {
        this.conferido = conferido;
    }

    public String getReceber() {
        return receber;
    }

    public void setReceber(String receber) {
        this.receber = receber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public String getCodigoCorreios() {
        return codigoCorreios;
    }

    public void setCodigoCorreios(String codigoCorreios) {
        this.codigoCorreios = codigoCorreios;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLocalPortador() {
        return localPortador;
    }

    public void setLocalPortador(String localPortador) {
        this.localPortador = localPortador;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getTipoCaixa() {
        return tipoCaixa;
    }

    public void setTipoCaixa(String tipoCaixa) {
        this.tipoCaixa = tipoCaixa;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno;
    }

    public String getMeioCompra() {
        return meioCompra;
    }

    public void setMeioCompra(String meioCompra) {
        this.meioCompra = meioCompra;
    }

    public double getValorApp() {
        return valorApp;
    }

    public void setValorApp(double valorApp) {
        this.valorApp = valorApp;
    }

    public double getValorSite() {
        return valorSite;
    }

    public void setValorSite(double valorSite) {
        this.valorSite = valorSite;
    }

    public int getAtendimentosApp() {
        return atendimentosApp;
    }

    public void setAtendimentosApp(int atendimentosApp) {
        this.atendimentosApp = atendimentosApp;
    }

    public int getAtendimentosSite() {
        return atendimentosSite;
    }

    public void setAtendimentosSite(int atendimentosSite) {
        this.atendimentosSite = atendimentosSite;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }
}