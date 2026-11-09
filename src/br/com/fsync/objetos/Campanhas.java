package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus
 */
public class Campanhas {

    String recno;
    Date dataVenda;
    Date dataInicio;
    Date dataFim;
    String vendedor;
    String laboratorio;
    double valorVenda;
    double valorDevolvido;
    int unidadesVenda;
    int unidadesDevolvidas;
    double meta01;
    double meta02;
    double meta03;
    double meta04;
    double meta05;
    String produto;

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorDevolvido() {
        return valorDevolvido;
    }

    public void setValorDevolvido(double valorDevolvido) {
        this.valorDevolvido = valorDevolvido;
    }

    public int getUnidadesVenda() {
        return unidadesVenda;
    }

    public void setUnidadesVenda(int unidadesVenda) {
        this.unidadesVenda = unidadesVenda;
    }

    public int getUnidadesDevolvidas() {
        return unidadesDevolvidas;
    }

    public void setUnidadesDevolvidas(int unidadesDevolvidas) {
        this.unidadesDevolvidas = unidadesDevolvidas;
    }

    public double getMeta01() {
        return meta01;
    }

    public void setMeta01(double meta01) {
        this.meta01 = meta01;
    }

    public double getMeta02() {
        return meta02;
    }

    public void setMeta02(double meta02) {
        this.meta02 = meta02;
    }

    public double getMeta03() {
        return meta03;
    }

    public void setMeta03(double meta03) {
        this.meta03 = meta03;
    }

    public double getMeta04() {
        return meta04;
    }

    public void setMeta04(double meta04) {
        this.meta04 = meta04;
    }

    public double getMeta05() {
        return meta05;
    }

    public void setMeta05(double meta05) {
        this.meta05 = meta05;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    
}
