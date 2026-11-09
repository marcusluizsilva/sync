package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class ContasAPagar {

    String recno;
    String codigo;
    String fatura;
    String fornecedor;
    String codigoEFornecedor;
    String cheatBaixa;
    Date vencimento;
    Date lancamento;
    Date pagamento;
    String status;
    double valorNormal;
    double valorAPagar;
    double valorPago;
    double desconto;
    String banco;
    String descricao;
    String loja;
    String portador;
    String tipo;
    String controle;
    Date emissao;
    Date vencimentoAntecipado;
    double valorAntecipado;
    double valorDiaAntecipacao;
    String tipoDia;
    double juros;
    double devolucao;
    double extra;
    String vencimentoStr;
    String pagamentoStr;
    String codigoContaCusto;
    String descricaoContaCusto;
    String consumo;
    String periodo;

    public String getVencimentoStr() {
        return vencimentoStr;
    }

    public void setVencimentoStr(String vencimentoStr) {
        this.vencimentoStr = vencimentoStr;
    }

    public String getPagamentoStr() {
        return pagamentoStr;
    }

    public void setPagamentoStr(String pagamentoStr) {
        this.pagamentoStr = pagamentoStr;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public double getValorNormal() {
        return valorNormal;
    }

    public void setValorNormal(double valorNormal) {
        this.valorNormal = valorNormal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getCodigoEFornecedor() {
        return codigoEFornecedor;
    }

    public void setCodigoEFornecedor(String codigoEFornecedor) {
        this.codigoEFornecedor = codigoEFornecedor;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(double devolucao) {
        this.devolucao = devolucao;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public String getPortador() {
        return portador;
    }

    public void setPortador(String portador) {
        this.portador = portador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(String tipoDia) {
        this.tipoDia = tipoDia;
    }

    public double getValorAntecipado() {
        return valorAntecipado;
    }

    public void setValorAntecipado(double valorAntecipado) {
        this.valorAntecipado = valorAntecipado;
    }

    public double getValorDiaAntecipacao() {
        return valorDiaAntecipacao;
    }

    public void setValorDiaAntecipacao(double valorDiaAntecipacao) {
        this.valorDiaAntecipacao = valorDiaAntecipacao;
    }

    public Date getVencimentoAntecipado() {
        return vencimentoAntecipado;
    }

    public void setVencimentoAntecipado(Date vencimentoAntecipado) {
        this.vencimentoAntecipado = vencimentoAntecipado;
    }

    public String getCheatBaixa() {
        return cheatBaixa;
    }

    public void setCheatBaixa(String cheatBaixa) {
        this.cheatBaixa = cheatBaixa;
    }

    public String getCodigoContaCusto() {
        return codigoContaCusto;
    }

    public void setCodigoContaCusto(String codigoContaCusto) {
        this.codigoContaCusto = codigoContaCusto;
    }

    public String getDescricaoContaCusto() {
        return descricaoContaCusto;
    }

    public void setDescricaoContaCusto(String descricaoContaCusto) {
        this.descricaoContaCusto = descricaoContaCusto;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
}
