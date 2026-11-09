package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class AnaliseFilial {

    Date data;
    Date dataFinal;
    String loja;
    int atendimentos;
    double totalVendido;
    double duplicatasPagas;
    double titulosPagos;
    double resultadoBruto;
    double cmv;
    double custoOperacional;
    double lucroLiquido;
    double percentualDuplicatas;
    double percentualTitulos;
    double percentualVendas;
    double percentualDescontoP;
    double percentualDescontoM;
    String area;
    String periodo;
    double valorLoja01;
    double valorLoja02;
    double valorLoja03;
    double valorLoja04;
    double valorLoja05;
    double valorDeposito;
    String dataString;
    double descontoPadrao;
    double descontoMaximo;
    double descontoPreferencial;
    int unidades;
    double ticketMedio;
    int diasUteis;
    int sabados;
    int domingos;
    int feriados;
    int feriadosSabado;
    int feriadosBP;
    int feriadosSabadoBP;
    int feriadosVR;
    int feriadosSabadoVR;
    String diaDaSemana;
    int segundas;
    int tercas;
    int quartas;
    int quintas;
    int sextas;
    int dias;
    double valorEmpenho;
    double descontoManual;
    double descontoCrediario;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public double getDuplicatasPagas() {
        return duplicatasPagas;
    }

    public void setDuplicatasPagas(double duplicatasPagas) {
        this.duplicatasPagas = duplicatasPagas;
    }

    public double getTitulosPagos() {
        return titulosPagos;
    }

    public void setTitulosPagos(double titulosPagos) {
        this.titulosPagos = titulosPagos;
    }

    public double getResultadoBruto() {
        return resultadoBruto;
    }

    public void setResultadoBruto(double resultadoBruto) {
        this.resultadoBruto = resultadoBruto;
    }

    public double getCmv() {
        return cmv;
    }

    public void setCmv(double cmv) {
        this.cmv = cmv;
    }

    public double getCustoOperacional() {
        return custoOperacional;
    }

    public void setCustoOperacional(double custoOperacional) {
        this.custoOperacional = custoOperacional;
    }

    public double getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(double lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public double getPercentualDuplicatas() {
        return percentualDuplicatas;
    }

    public void setPercentualDuplicatas(double percentualDuplicatas) {
        this.percentualDuplicatas = percentualDuplicatas;
    }

    public double getPercentualTitulos() {
        return percentualTitulos;
    }

    public void setPercentualTitulos(double percentualTitulos) {
        this.percentualTitulos = percentualTitulos;
    }

    public double getPercentualVendas() {
        return percentualVendas;
    }

    public void setPercentualVendas(double percentualVendas) {
        this.percentualVendas = percentualVendas;
    }

    public double getPercentualDescontoP() {
        return percentualDescontoP;
    }

    public void setPercentualDescontoP(double percentualDescontoP) {
        this.percentualDescontoP = percentualDescontoP;
    }

    public double getPercentualDescontoM() {
        return percentualDescontoM;
    }

    public void setPercentualDescontoM(double percentualDescontoM) {
        this.percentualDescontoM = percentualDescontoM;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getValorLoja01() {
        return valorLoja01;
    }

    public void setValorLoja01(double valorLoja01) {
        this.valorLoja01 = valorLoja01;
    }

    public double getValorLoja02() {
        return valorLoja02;
    }

    public void setValorLoja02(double valorLoja02) {
        this.valorLoja02 = valorLoja02;
    }

    public double getValorLoja03() {
        return valorLoja03;
    }

    public void setValorLoja03(double valorLoja03) {
        this.valorLoja03 = valorLoja03;
    }

    public double getValorLoja04() {
        return valorLoja04;
    }

    public void setValorLoja04(double valorLoja04) {
        this.valorLoja04 = valorLoja04;
    }

    public double getValorDeposito() {
        return valorDeposito;
    }

    public void setValorDeposito(double valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public double getDescontoPadrao() {
        return descontoPadrao;
    }

    public void setDescontoPadrao(double descontoPadrao) {
        this.descontoPadrao = descontoPadrao;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public double getDescontoPreferencial() {
        return descontoPreferencial;
    }

    public void setDescontoPreferencial(double descontoPreferencial) {
        this.descontoPreferencial = descontoPreferencial;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getTicketMedio() {
        return ticketMedio;
    }

    public void setTicketMedio(double ticketMedio) {
        this.ticketMedio = ticketMedio;
    }

    public double getValorLoja05() {
        return valorLoja05;
    }

    public void setValorLoja05(double valorLoja05) {
        this.valorLoja05 = valorLoja05;
    }

    public int getDiasUteis() {
        return diasUteis;
    }

    public void setDiasUteis(int diasUteis) {
        this.diasUteis = diasUteis;
    }

    public int getSabados() {
        return sabados;
    }

    public void setSabados(int sabados) {
        this.sabados = sabados;
    }

    public int getDomingos() {
        return domingos;
    }

    public void setDomingos(int domingos) {
        this.domingos = domingos;
    }

    public int getFeriados() {
        return feriados;
    }

    public void setFeriados(int feriados) {
        this.feriados = feriados;
    }

    public int getFeriadosSabado() {
        return feriadosSabado;
    }

    public void setFeriadosSabado(int feriadosSabado) {
        this.feriadosSabado = feriadosSabado;
    }

    public int getFeriadosBP() {
        return feriadosBP;
    }

    public void setFeriadosBP(int feriadosBP) {
        this.feriadosBP = feriadosBP;
    }

    public int getFeriadosSabadoBP() {
        return feriadosSabadoBP;
    }

    public void setFeriadosSabadoBP(int feriadosSabadoBP) {
        this.feriadosSabadoBP = feriadosSabadoBP;
    }

    public int getFeriadosVR() {
        return feriadosVR;
    }

    public void setFeriadosVR(int feriadosVR) {
        this.feriadosVR = feriadosVR;
    }

    public int getFeriadosSabadoVR() {
        return feriadosSabadoVR;
    }

    public void setFeriadosSabadoVR(int feriadosSabadoVR) {
        this.feriadosSabadoVR = feriadosSabadoVR;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public int getSegundas() {
        return segundas;
    }

    public void setSegundas(int segundas) {
        this.segundas = segundas;
    }

    public int getTercas() {
        return tercas;
    }

    public void setTercas(int tercas) {
        this.tercas = tercas;
    }

    public int getQuartas() {
        return quartas;
    }

    public void setQuartas(int quartas) {
        this.quartas = quartas;
    }

    public int getQuintas() {
        return quintas;
    }

    public void setQuintas(int quintas) {
        this.quintas = quintas;
    }

    public int getSextas() {
        return sextas;
    }

    public void setSextas(int sextas) {
        this.sextas = sextas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getValorEmpenho() {
        return valorEmpenho;
    }

    public void setValorEmpenho(double valorEmpenho) {
        this.valorEmpenho = valorEmpenho;
    }

    public double getDescontoManual() {
        return descontoManual;
    }

    public void setDescontoManual(double descontoManual) {
        this.descontoManual = descontoManual;
    }

    public double getDescontoCrediario() {
        return descontoCrediario;
    }

    public void setDescontoCrediario(double descontoCrediario) {
        this.descontoCrediario = descontoCrediario;
    }
    
    
}
