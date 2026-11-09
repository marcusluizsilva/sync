package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author marcusluiz
 */
public class MetasVendedor extends Funcionarios {

    String periodo;
    double metaAtual;
    double superMetaAtual;
    double metaDesconto;
    int atendimentos;
    int unidades;
    double valorVista;
    double valorCredito;
    double devolucao;
    double vendaLiquida;
    double descontoMaximo;
    double descontoPadrao;
    double descontoPreferencial;
    double percentualDescontoPadrao;
    double percentualDescontoMaximo;
    int diasTrabalhados;
    double mediaDiaria;
    double mediaMensal;
    String status;
    double resultadoMeta;
    double resultadoDesconto;
    double parcialEtico;
    double parcialGenerico;
    double parcialSimilar;
    double parcialDesconto;
    double fechamento;
    double fechamentoDesconto;
    String area;
    Date data;
    double metaGenerico;
    String ano;
    String mes;
    double unidadesAtendimento;
    double ticketMedio;
    String sucesso;
    double metaSimilar;
    double metaEtico;
    double vendaEtico;
    double vendaGenerico;
    double vendaSimilar;
    double metaValorBP;
    double metaValorVR;
    double metaValorMendes;
    int metaAtendimentoBP;
    int metaAtendimentoVR;
    int metaAtendimentoMendes;
    double metaTMBP;
    double metaTMVR;
    double metaTMMendes;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getMetaAtual() {
        return metaAtual;
    }

    public void setMetaAtual(double metaAtual) {
        this.metaAtual = metaAtual;
    }

    public double getSuperMetaAtual() {
        return superMetaAtual;
    }

    public void setSuperMetaAtual(double superMetaAtual) {
        this.superMetaAtual = superMetaAtual;
    }

    public double getMetaDesconto() {
        return metaDesconto;
    }

    public void setMetaDesconto(double metaDesconto) {
        this.metaDesconto = metaDesconto;
    }

    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getValorVista() {
        return valorVista;
    }

    public void setValorVista(double valorVista) {
        this.valorVista = valorVista;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(double devolucao) {
        this.devolucao = devolucao;
    }

    public double getVendaLiquida() {
        return vendaLiquida;
    }

    public void setVendaLiquida(double vendaLiquida) {
        this.vendaLiquida = vendaLiquida;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public double getDescontoPadrao() {
        return descontoPadrao;
    }

    public void setDescontoPadrao(double descontoPadrao) {
        this.descontoPadrao = descontoPadrao;
    }

    public double getDescontoPreferencial() {
        return descontoPreferencial;
    }

    public void setDescontoPreferencial(double descontoPreferencial) {
        this.descontoPreferencial = descontoPreferencial;
    }

    public double getPercentualDescontoPadrao() {
        return percentualDescontoPadrao;
    }

    public void setPercentualDescontoPadrao(double percentualDescontoPadrao) {
        this.percentualDescontoPadrao = percentualDescontoPadrao;
    }

    public double getPercentualDescontoMaximo() {
        return percentualDescontoMaximo;
    }

    public void setPercentualDescontoMaximo(double percentualDescontoMaximo) {
        this.percentualDescontoMaximo = percentualDescontoMaximo;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public double getMediaDiaria() {
        return mediaDiaria;
    }

    public void setMediaDiaria(double mediaDiaria) {
        this.mediaDiaria = mediaDiaria;
    }

    public double getMediaMensal() {
        return mediaMensal;
    }

    public void setMediaMensal(double mediaMensal) {
        this.mediaMensal = mediaMensal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getResultadoMeta() {
        return resultadoMeta;
    }

    public void setResultadoMeta(double resultadoMeta) {
        this.resultadoMeta = resultadoMeta;
    }

    public double getResultadoDesconto() {
        return resultadoDesconto;
    }

    public void setResultadoDesconto(double resultadoDesconto) {
        this.resultadoDesconto = resultadoDesconto;
    }

    public double getParcialEtico() {
        return parcialEtico;
    }

    public void setParcialEtico(double parcialEtico) {
        this.parcialEtico = parcialEtico;
    }

    public double getParcialGenerico() {
        return parcialGenerico;
    }

    public void setParcialGenerico(double parcialGenerico) {
        this.parcialGenerico = parcialGenerico;
    }

    public double getParcialSimilar() {
        return parcialSimilar;
    }

    public void setParcialSimilar(double parcialSimilar) {
        this.parcialSimilar = parcialSimilar;
    }

    public double getParcialDesconto() {
        return parcialDesconto;
    }

    public void setParcialDesconto(double parcialDesconto) {
        this.parcialDesconto = parcialDesconto;
    }

    public double getFechamento() {
        return fechamento;
    }

    public void setFechamento(double fechamento) {
        this.fechamento = fechamento;
    }

    public double getFechamentoDesconto() {
        return fechamentoDesconto;
    }

    public void setFechamentoDesconto(double fechamentoDesconto) {
        this.fechamentoDesconto = fechamentoDesconto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getMetaGenerico() {
        return metaGenerico;
    }

    public void setMetaGenerico(double metaGenerico) {
        this.metaGenerico = metaGenerico;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getUnidadesAtendimento() {
        return unidadesAtendimento;
    }

    public void setUnidadesAtendimento(double unidadesAtendimento) {
        this.unidadesAtendimento = unidadesAtendimento;
    }

    public double getTicketMedio() {
        return ticketMedio;
    }

    public void setTicketMedio(double ticketMedio) {
        this.ticketMedio = ticketMedio;
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public double getMetaSimilar() {
        return metaSimilar;
    }

    public void setMetaSimilar(double metaSimilar) {
        this.metaSimilar = metaSimilar;
    }

    public double getMetaEtico() {
        return metaEtico;
    }

    public void setMetaEtico(double metaEtico) {
        this.metaEtico = metaEtico;
    }

    public double getVendaEtico() {
        return vendaEtico;
    }

    public void setVendaEtico(double vendaEtico) {
        this.vendaEtico = vendaEtico;
    }

    public double getVendaGenerico() {
        return vendaGenerico;
    }

    public void setVendaGenerico(double vendaGenerico) {
        this.vendaGenerico = vendaGenerico;
    }

    public double getVendaSimilar() {
        return vendaSimilar;
    }

    public void setVendaSimilar(double vendaSimilar) {
        this.vendaSimilar = vendaSimilar;
    }

    public double getMetaValorBP() {
        return metaValorBP;
    }

    public void setMetaValorBP(double metaValorBP) {
        this.metaValorBP = metaValorBP;
    }

    public double getMetaValorVR() {
        return metaValorVR;
    }

    public void setMetaValorVR(double metaValorVR) {
        this.metaValorVR = metaValorVR;
    }

    public double getMetaValorMendes() {
        return metaValorMendes;
    }

    public void setMetaValorMendes(double metaValorMendes) {
        this.metaValorMendes = metaValorMendes;
    }

    public int getMetaAtendimentoBP() {
        return metaAtendimentoBP;
    }

    public void setMetaAtendimentoBP(int metaAtendimentoBP) {
        this.metaAtendimentoBP = metaAtendimentoBP;
    }

    public int getMetaAtendimentoVR() {
        return metaAtendimentoVR;
    }

    public void setMetaAtendimentoVR(int metaAtendimentoVR) {
        this.metaAtendimentoVR = metaAtendimentoVR;
    }

    public int getMetaAtendimentoMendes() {
        return metaAtendimentoMendes;
    }

    public void setMetaAtendimentoMendes(int metaAtendimentoMendes) {
        this.metaAtendimentoMendes = metaAtendimentoMendes;
    }

    public double getMetaTMBP() {
        return metaTMBP;
    }

    public void setMetaTMBP(double metaTMBP) {
        this.metaTMBP = metaTMBP;
    }

    public double getMetaTMVR() {
        return metaTMVR;
    }

    public void setMetaTMVR(double metaTMVR) {
        this.metaTMVR = metaTMVR;
    }

    public double getMetaTMMendes() {
        return metaTMMendes;
    }

    public void setMetaTMMendes(double metaTMMendes) {
        this.metaTMMendes = metaTMMendes;
    }

    
}
