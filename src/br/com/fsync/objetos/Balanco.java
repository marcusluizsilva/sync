package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class Balanco extends Produtos {

    Date data;
    Date ultimoBalanco;
    String dataString;
    String loja;
    String horaBalanco;
    String horaRecontagem;
    String horaFim;
    String ndc;
    String responsavel;
    String operacao;
    String formaDePagamento;
    String origem;
    String destino;
    String fornecedor;
    String nota;
    String observacao;
    String motivoDoErro;
    String statusBalanco;
    String codigoBalanco;
    String recno;
    String deletado;
    String chave;
    int quantidadeAnterior;
    int quantidadeApos;
    int diferenca;
    int itensSobras;
    int itensFaltas;
    int itensCertos;
    int unidadesSobras;
    int unidadesFaltas;
    int unidadesCertas;
    int itensContados;
    int unidadesContadas;
    int quant01;
    int quant02;
    int quant03;
    int quant04;
    int quant09;
    int quant10;
    int quantEstoque;
    int quantEntrada;
    double precoCustoSobra;
    double precoCustoFalta;
    double precoVendaSobra;
    double precoVendaFalta;
    double valorContado;
    double valorSobrasContado;
    double valorFaltasContado;
    double valorCertosContado;
    int lojasContadas;
    int classesContadas;
    int itensAnalisados;
    int itensNaoAnalisados;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getUltimoBalanco() {
        return ultimoBalanco;
    }

    public void setUltimoBalanco(Date ultimoBalanco) {
        this.ultimoBalanco = ultimoBalanco;
    }
    
    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getHoraBalanco() {
        return horaBalanco;
    }

    public void setHoraBalanco(String horaBalanco) {
        this.horaBalanco = horaBalanco;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getMotivoDoErro() {
        return motivoDoErro;
    }

    public void setMotivoDoErro(String motivoDoErro) {
        this.motivoDoErro = motivoDoErro;
    }

    public String getStatusBalanco() {
        return statusBalanco;
    }

    public void setStatusBalanco(String statusBalanco) {
        this.statusBalanco = statusBalanco;
    }

    public String getCodigoBalanco() {
        return codigoBalanco;
    }

    public void setCodigoBalanco(String codigoBalanco) {
        this.codigoBalanco = codigoBalanco;
    }

    public int getQuantidadeAnterior() {
        return quantidadeAnterior;
    }

    public void setQuantidadeAnterior(int quantidadeAnterior) {
        this.quantidadeAnterior = quantidadeAnterior;
    }

    public int getQuantidadeApos() {
        return quantidadeApos;
    }

    public void setQuantidadeApos(int quantidadeApos) {
        this.quantidadeApos = quantidadeApos;
    }

    public int getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(int diferenca) {
        this.diferenca = diferenca;
    }

    public int getItensSobras() {
        return itensSobras;
    }

    public void setItensSobras(int itensSobras) {
        this.itensSobras = itensSobras;
    }

    public int getItensFaltas() {
        return itensFaltas;
    }

    public void setItensFaltas(int itensFaltas) {
        this.itensFaltas = itensFaltas;
    }

    public int getItensCertos() {
        return itensCertos;
    }

    public void setItensCertos(int itensCertos) {
        this.itensCertos = itensCertos;
    }

    public int getUnidadesSobras() {
        return unidadesSobras;
    }

    public void setUnidadesSobras(int unidadesSobras) {
        this.unidadesSobras = unidadesSobras;
    }

    public int getUnidadesFaltas() {
        return unidadesFaltas;
    }

    public void setUnidadesFaltas(int unidadesFaltas) {
        this.unidadesFaltas = unidadesFaltas;
    }

    public int getUnidadesCertas() {
        return unidadesCertas;
    }

    public void setUnidadesCertas(int unidadesCertas) {
        this.unidadesCertas = unidadesCertas;
    }

    public int getItensContados() {
        return itensContados;
    }

    public void setItensContados(int itensContados) {
        this.itensContados = itensContados;
    }

    public int getUnidadesContadas() {
        return unidadesContadas;
    }

    public void setUnidadesContadas(int unidadesContadas) {
        this.unidadesContadas = unidadesContadas;
    }

    public int getQuant09() {
        return quant09;
    }

    public void setQuant09(int quant09) {
        this.quant09 = quant09;
    }

    public int getQuant10() {
        return quant10;
    }

    public void setQuant10(int quant10) {
        this.quant10 = quant10;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public double getPrecoCustoSobra() {
        return precoCustoSobra;
    }

    public void setPrecoCustoSobra(double precoCustoSobra) {
        this.precoCustoSobra = precoCustoSobra;
    }

    public double getPrecoCustoFalta() {
        return precoCustoFalta;
    }

    public void setPrecoCustoFalta(double precoCustoFalta) {
        this.precoCustoFalta = precoCustoFalta;
    }

    public double getPrecoVendaSobra() {
        return precoVendaSobra;
    }

    public void setPrecoVendaSobra(double precoVendaSobra) {
        this.precoVendaSobra = precoVendaSobra;
    }

    public double getPrecoVendaFalta() {
        return precoVendaFalta;
    }

    public void setPrecoVendaFalta(double precoVendaFalta) {
        this.precoVendaFalta = precoVendaFalta;
    }

    public double getValorContado() {
        return valorContado;
    }

    public void setValorContado(double valorContado) {
        this.valorContado = valorContado;
    }

    public double getValorSobrasContado() {
        return valorSobrasContado;
    }

    public void setValorSobrasContado(double valorSobrasContado) {
        this.valorSobrasContado = valorSobrasContado;
    }

    public double getValorFaltasContado() {
        return valorFaltasContado;
    }

    public void setValorFaltasContado(double valorFaltasContado) {
        this.valorFaltasContado = valorFaltasContado;
    }

    public double getValorCertosContado() {
        return valorCertosContado;
    }

    public void setValorCertosContado(double valorCertosContado) {
        this.valorCertosContado = valorCertosContado;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getQuantEntrada() {
        return quantEntrada;
    }

    public void setQuantEntrada(int quantEntrada) {
        this.quantEntrada = quantEntrada;
    }

    public int getLojasContadas() {
        return lojasContadas;
    }

    public void setLojasContadas(int lojasContadas) {
        this.lojasContadas = lojasContadas;
    }

    public int getClassesContadas() {
        return classesContadas;
    }

    public void setClassesContadas(int classesContadas) {
        this.classesContadas = classesContadas;
    }

    public String getHoraRecontagem() {
        return horaRecontagem;
    }

    public void setHoraRecontagem(String horaRecontagem) {
        this.horaRecontagem = horaRecontagem;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public int getQuant01() {
        return quant01;
    }

    public void setQuant01(int quant01) {
        this.quant01 = quant01;
    }

    public int getQuant02() {
        return quant02;
    }

    public void setQuant02(int quant02) {
        this.quant02 = quant02;
    }

    public int getQuant03() {
        return quant03;
    }

    public void setQuant03(int quant03) {
        this.quant03 = quant03;
    }

    public int getQuant04() {
        return quant04;
    }

    public void setQuant04(int quant04) {
        this.quant04 = quant04;
    }

    public int getItensAnalisados() {
        return itensAnalisados;
    }

    public void setItensAnalisados(int itensAnalisados) {
        this.itensAnalisados = itensAnalisados;
    }

    public int getItensNaoAnalisados() {
        return itensNaoAnalisados;
    }

    public void setItensNaoAnalisados(int itensNaoAnalisados) {
        this.itensNaoAnalisados = itensNaoAnalisados;
    }

    
}
