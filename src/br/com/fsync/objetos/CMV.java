package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public abstract class CMV extends Produtos {

    String loja;
    String periodo;
    String codigo;
    String descricao;
    int quantidadeHospitalar;
    int quantidadeVendida;
    int quantidadeComprada;
    double custoCMV;
    double vendaCMV;
    double precoVenda;
    double custoAtual;
    double ultimoCusto;
    double penultimoCusto;
    double custoMedio;
    double custoMedio01;
    double custoMedio02;
    double custoMedio03;
    double custoMedio04;
    double custoMedio05;
    double custoMedio10;
    double markUp;
    double markUp01;
    double markUp02;
    double markUp03;
    double markUp04;
    double markUp05;
    double markUpReal;
    double precoVendaDescontoPadrao;
    double precoVendaDescontoMaximo;
    String departamento;
    String laboratorio;
    Date ultimaCompra01;
    Date ultimaCompra02;
    Date ultimaCompra03;
    Date ultimaCompra04;
    Date ultimaCompra05;
    Date ultimaCompra10;
    Date ultimaVenda01;
    Date ultimaVenda02;
    Date ultimaVenda03;
    Date ultimaVenda04;
    Date ultimaVenda05;
    double custoAnterior;
    double custoMedioAnterior;
    double cm01Anterior;
    double cm02Anterior;
    double cm03Anterior;
    double cm04Anterior;
    double cm05Anterior;
    double resultado;
    double precoIdeal;
    double descontoIdeal;
    double custoCompra01;
    double custoCompra02;
    double custoCompra03;
    double custoCompra04;
    double custoCompra05;
    double custoCompra10;
    //
    String concorrente;
    String localCotacao;
    double pmcConcorrente;
    double precoConcorrente;
    double descontoConcorrente;
    String statusCotacao;
    Date dataCotacao;

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public String getConcorrente() {
        return concorrente;
    }

    public void setConcorrente(String concorrente) {
        this.concorrente = concorrente;
    }

    public String getLocalCotacao() {
        return localCotacao;
    }

    public void setLocalCotacao(String localCotacao) {
        this.localCotacao = localCotacao;
    }

    public double getPmcConcorrente() {
        return pmcConcorrente;
    }

    public void setPmcConcorrente(double pmcConcorrente) {
        this.pmcConcorrente = pmcConcorrente;
    }

    public double getPrecoConcorrente() {
        return precoConcorrente;
    }

    public void setPrecoConcorrente(double precoConcorrente) {
        this.precoConcorrente = precoConcorrente;
    }

    public double getDescontoConcorrente() {
        return descontoConcorrente;
    }

    public void setDescontoConcorrente(double descontoConcorrente) {
        this.descontoConcorrente = descontoConcorrente;
    }

    public String getStatusCotacao() {
        return statusCotacao;
    }

    public void setStatusCotacao(String statusCotacao) {
        this.statusCotacao = statusCotacao;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getQuantidadeHospitalar() {
        return quantidadeHospitalar;
    }

    public void setQuantidadeHospitalar(int quantidadeHospitalar) {
        this.quantidadeHospitalar = quantidadeHospitalar;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getCustoCMV() {
        return custoCMV;
    }

    public void setCustoCMV(double custoCMV) {
        this.custoCMV = custoCMV;
    }

    public double getVendaCMV() {
        return vendaCMV;
    }

    public void setVendaCMV(double vendaCMV) {
        this.vendaCMV = vendaCMV;
    }

    public double getCustoAtual() {
        return custoAtual;
    }

    public void setCustoAtual(double custoAtual) {
        this.custoAtual = custoAtual;
    }

    public double getUltimoCusto() {
        return ultimoCusto;
    }

    public void setUltimoCusto(double ultimoCusto) {
        this.ultimoCusto = ultimoCusto;
    }

    public double getPenultimoCusto() {
        return penultimoCusto;
    }

    public void setPenultimoCusto(double penultimoCusto) {
        this.penultimoCusto = penultimoCusto;
    }

    public double getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(double custoMedio) {
        this.custoMedio = custoMedio;
    }

    public double getCustoMedio01() {
        return custoMedio01;
    }

    public void setCustoMedio01(double custoMedio01) {
        this.custoMedio01 = custoMedio01;
    }

    public double getCustoMedio02() {
        return custoMedio02;
    }

    public void setCustoMedio02(double custoMedio02) {
        this.custoMedio02 = custoMedio02;
    }

    public double getCustoMedio03() {
        return custoMedio03;
    }

    public void setCustoMedio03(double custoMedio03) {
        this.custoMedio03 = custoMedio03;
    }

    public double getCustoMedio04() {
        return custoMedio04;
    }

    public void setCustoMedio04(double custoMedio04) {
        this.custoMedio04 = custoMedio04;
    }

    public double getCustoMedio10() {
        return custoMedio10;
    }

    public void setCustoMedio10(double custoMedio10) {
        this.custoMedio10 = custoMedio10;
    }

    public double getMarkUp01() {
        return markUp01;
    }

    public void setMarkUp01(double markUp01) {
        this.markUp01 = markUp01;
    }

    public double getMarkUp02() {
        return markUp02;
    }

    public void setMarkUp02(double markUp02) {
        this.markUp02 = markUp02;
    }

    public double getMarkUp03() {
        return markUp03;
    }

    public void setMarkUp03(double markUp03) {
        this.markUp03 = markUp03;
    }

    public double getMarkUp04() {
        return markUp04;
    }

    public void setMarkUp04(double markUp04) {
        this.markUp04 = markUp04;
    }

    public double getMarkUpReal() {
        return markUpReal;
    }

    public void setMarkUpReal(double markUpReal) {
        this.markUpReal = markUpReal;
    }

    public double getPrecoVendaDescontoPadrao() {
        return precoVendaDescontoPadrao;
    }

    public void setPrecoVendaDescontoPadrao(double precoVendaDescontoPadrao) {
        this.precoVendaDescontoPadrao = precoVendaDescontoPadrao;
    }

    public double getPrecoVendaDescontoMaximo() {
        return precoVendaDescontoMaximo;
    }

    public void setPrecoVendaDescontoMaximo(double precoVendaDescontoMaximo) {
        this.precoVendaDescontoMaximo = precoVendaDescontoMaximo;
    }

    public Date getUltimaCompra01() {
        return ultimaCompra01;
    }

    public void setUltimaCompra01(Date ultimaCompra01) {
        this.ultimaCompra01 = ultimaCompra01;
    }

    public Date getUltimaCompra02() {
        return ultimaCompra02;
    }

    public void setUltimaCompra02(Date ultimaCompra02) {
        this.ultimaCompra02 = ultimaCompra02;
    }

    public Date getUltimaCompra03() {
        return ultimaCompra03;
    }

    public void setUltimaCompra03(Date ultimaCompra03) {
        this.ultimaCompra03 = ultimaCompra03;
    }

    public Date getUltimaCompra04() {
        return ultimaCompra04;
    }

    public void setUltimaCompra04(Date ultimaCompra04) {
        this.ultimaCompra04 = ultimaCompra04;
    }

    public Date getUltimaCompra10() {
        return ultimaCompra10;
    }

    public void setUltimaCompra10(Date ultimaCompra10) {
        this.ultimaCompra10 = ultimaCompra10;
    }

    public Date getUltimaVenda01() {
        return ultimaVenda01;
    }

    public void setUltimaVenda01(Date ultimaVenda01) {
        this.ultimaVenda01 = ultimaVenda01;
    }

    public Date getUltimaVenda02() {
        return ultimaVenda02;
    }

    public void setUltimaVenda02(Date ultimaVenda02) {
        this.ultimaVenda02 = ultimaVenda02;
    }

    public Date getUltimaVenda03() {
        return ultimaVenda03;
    }

    public void setUltimaVenda03(Date ultimaVenda03) {
        this.ultimaVenda03 = ultimaVenda03;
    }

    public Date getUltimaVenda04() {
        return ultimaVenda04;
    }

    public void setUltimaVenda04(Date ultimaVenda04) {
        this.ultimaVenda04 = ultimaVenda04;
    }

    public double getCustoAnterior() {
        return custoAnterior;
    }

    public void setCustoAnterior(double custoAnterior) {
        this.custoAnterior = custoAnterior;
    }

    public double getCustoMedioAnterior() {
        return custoMedioAnterior;
    }

    public void setCustoMedioAnterior(double custoMedioAnterior) {
        this.custoMedioAnterior = custoMedioAnterior;
    }

    public double getCm01Anterior() {
        return cm01Anterior;
    }

    public void setCm01Anterior(double cm01Anterior) {
        this.cm01Anterior = cm01Anterior;
    }

    public double getCm02Anterior() {
        return cm02Anterior;
    }

    public void setCm02Anterior(double cm02Anterior) {
        this.cm02Anterior = cm02Anterior;
    }

    public double getCm03Anterior() {
        return cm03Anterior;
    }

    public void setCm03Anterior(double cm03Anterior) {
        this.cm03Anterior = cm03Anterior;
    }

    public double getCm04Anterior() {
        return cm04Anterior;
    }

    public void setCm04Anterior(double cm04Anterior) {
        this.cm04Anterior = cm04Anterior;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getPrecoIdeal() {
        return precoIdeal;
    }

    public void setPrecoIdeal(double precoIdeal) {
        this.precoIdeal = precoIdeal;
    }

    public double getDescontoIdeal() {
        return descontoIdeal;
    }

    public void setDescontoIdeal(double descontoIdeal) {
        this.descontoIdeal = descontoIdeal;
    }

    public double getCustoCompra01() {
        return custoCompra01;
    }

    public void setCustoCompra01(double custoCompra01) {
        this.custoCompra01 = custoCompra01;
    }

    public double getCustoCompra02() {
        return custoCompra02;
    }

    public void setCustoCompra02(double custoCompra02) {
        this.custoCompra02 = custoCompra02;
    }

    public double getCustoCompra03() {
        return custoCompra03;
    }

    public void setCustoCompra03(double custoCompra03) {
        this.custoCompra03 = custoCompra03;
    }

    public double getCustoCompra04() {
        return custoCompra04;
    }

    public void setCustoCompra04(double custoCompra04) {
        this.custoCompra04 = custoCompra04;
    }

    public double getCustoCompra10() {
        return custoCompra10;
    }

    public void setCustoCompra10(double custoCompra10) {
        this.custoCompra10 = custoCompra10;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double getCustoMedio05() {
        return custoMedio05;
    }

    public void setCustoMedio05(double custoMedio05) {
        this.custoMedio05 = custoMedio05;
    }

    public double getMarkUp05() {
        return markUp05;
    }

    public void setMarkUp05(double markUp05) {
        this.markUp05 = markUp05;
    }

    public double getCm05Anterior() {
        return cm05Anterior;
    }

    public void setCm05Anterior(double cm05Anterior) {
        this.cm05Anterior = cm05Anterior;
    }

    public double getCustoCompra05() {
        return custoCompra05;
    }

    public void setCustoCompra05(double custoCompra05) {
        this.custoCompra05 = custoCompra05;
    }
}
