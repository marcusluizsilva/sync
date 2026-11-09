package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class Pedido {

    String recno;
    Date data;
    String hora;
    String responsavel;

    String dataStr;
    String loja;
    String idPedido;
    String descricaoPedido;
    String status;

    String codigo;
    String ean13;
    String descricao;
    String laboratorio;
    String curvaValor;
    String curvaVolume;
    String area;
    String departamento;

    String curvaF01;
    String curvaF02;
    String curvaF03;
    String curvaF04;
    String curvaF05;
    String curvaF06;
    String curvaF07;
    String curvaF08;
    String curvaF09;
    String curvaF10;
    String curvaF11;
    String curvaF12;
    String curvaF13;
    String curvaF14;
    String curvaFGeral;
    String curvaU01;
    String curvaU02;
    String curvaU03;
    String curvaU04;
    String curvaU05;
    String curvaU06;
    String curvaU07;
    String curvaU08;
    String curvaU09;
    String curvaU10;
    String curvaU11;
    String curvaU12;
    String curvaU13;
    String curvaU14;
    String curvaUGeral;
    String codigoFornecedor;
    String nomeFornecedor;

    int estoque01;
    int estoque02;
    int estoque03;
    int estoque04;
    int estoque05;
    int estoque06;
    int estoque07;
    int estoque08;
    int estoque09;
    int estoque10;
    int estoque11;
    int estoque12;
    int estoque13;
    int estoque14;
    int estoqueDeposito;
    
    int quant01;
    int quant02;
    int quant03;
    int quant04;
    int quant05;
    int quant06;
    int quant07;
    int quant08;
    int quant09;
    int quant10;
    int quant11;
    int quant12;
    int quant13;
    int quant14;

    int mediaVenda01;
    int mediaVenda02;
    int mediaVenda03;
    int mediaVenda04;
    int mediaVenda05;
    int mediaVenda06;
    int mediaVenda07;
    int mediaVenda08;
    int mediaVenda09;
    int mediaVenda10;
    int mediaVenda11;
    int mediaVenda12;
    int mediaVenda13;
    int mediaVenda14;
    
    int itens;
    int unidades;
    double valor;
    double venda;
    double desconto;
    double precoFinal;
    double totalItem;
    
    Date ultimaCompra01;
    Date ultimaCompra02;
    Date ultimaCompra03;
    Date ultimaCompra04;
    Date ultimaCompra05;
    Date ultimaCompra06;
    Date ultimaCompra07;
    Date ultimaCompra08;
    Date ultimaCompra09;
    Date ultimaCompra10;
    Date ultimaCompra11;
    Date ultimaCompra12;
    Date ultimaCompra13;
    Date ultimaCompra14;
    Date ultimaCompraDeposito;
    Date ultimaVenda01;
    Date ultimaVenda02;
    Date ultimaVenda03;
    Date ultimaVenda04;
    Date ultimaVenda05;
    Date ultimaVenda06;
    Date ultimaVenda07;
    Date ultimaVenda08;
    Date ultimaVenda09;
    Date ultimaVenda10;
    Date ultimaVenda11;
    Date ultimaVenda12;
    Date ultimaVenda13;
    Date ultimaVenda14;
    Date penultimaVenda01;
    Date penultimaVenda02;
    Date penultimaVenda03;
    Date penultimaVenda04;
    Date penultimaVenda05;
    Date penultimaVenda06;
    Date penultimaVenda07;
    Date penultimaVenda08;
    Date penultimaVenda09;
    Date penultimaVenda10;
    Date penultimaVenda11;
    Date penultimaVenda12;
    Date penultimaVenda13;
    Date penultimaVenda14;
    
    int maximo01;
    int maximo02;
    int maximo03;
    int maximo04;
    int maximo05;
    int maximo06;
    int maximo07;
    int maximo08;
    int maximo09;
    int maximo10;
    int maximo11;
    int maximo12;
    int maximo13;
    int maximo14;
    int minimo01;
    int minimo02;
    int minimo03;
    int minimo04;
    int minimo05;
    int minimo06;
    int minimo07;
    int minimo08;
    int minimo09;
    int minimo10;
    int minimo11;
    int minimo12;
    int minimo13;
    int minimo14;
    
    double comissaoValor;
    double comissaoPercentual;

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCurvaValor() {
        return curvaValor;
    }

    public void setCurvaValor(String curvaValor) {
        this.curvaValor = curvaValor;
    }

    public String getCurvaVolume() {
        return curvaVolume;
    }

    public void setCurvaVolume(String curvaVolume) {
        this.curvaVolume = curvaVolume;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCurvaF01() {
        return curvaF01;
    }

    public void setCurvaF01(String curvaF01) {
        this.curvaF01 = curvaF01;
    }

    public String getCurvaF02() {
        return curvaF02;
    }

    public void setCurvaF02(String curvaF02) {
        this.curvaF02 = curvaF02;
    }

    public String getCurvaF03() {
        return curvaF03;
    }

    public void setCurvaF03(String curvaF03) {
        this.curvaF03 = curvaF03;
    }

    public String getCurvaF04() {
        return curvaF04;
    }

    public void setCurvaF04(String curvaF04) {
        this.curvaF04 = curvaF04;
    }

    public String getCurvaF05() {
        return curvaF05;
    }

    public void setCurvaF05(String curvaF05) {
        this.curvaF05 = curvaF05;
    }

    public String getCurvaF06() {
        return curvaF06;
    }

    public void setCurvaF06(String curvaF06) {
        this.curvaF06 = curvaF06;
    }

    public String getCurvaF07() {
        return curvaF07;
    }

    public void setCurvaF07(String curvaF07) {
        this.curvaF07 = curvaF07;
    }

    public String getCurvaF08() {
        return curvaF08;
    }

    public void setCurvaF08(String curvaF08) {
        this.curvaF08 = curvaF08;
    }

    public String getCurvaF09() {
        return curvaF09;
    }

    public void setCurvaF09(String curvaF09) {
        this.curvaF09 = curvaF09;
    }

    public String getCurvaF10() {
        return curvaF10;
    }

    public void setCurvaF10(String curvaF10) {
        this.curvaF10 = curvaF10;
    }

    public String getCurvaF11() {
        return curvaF11;
    }

    public void setCurvaF11(String curvaF11) {
        this.curvaF11 = curvaF11;
    }

    public String getCurvaFGeral() {
        return curvaFGeral;
    }

    public void setCurvaFGeral(String curvaFGeral) {
        this.curvaFGeral = curvaFGeral;
    }

    public String getCurvaU01() {
        return curvaU01;
    }

    public void setCurvaU01(String curvaU01) {
        this.curvaU01 = curvaU01;
    }

    public String getCurvaU02() {
        return curvaU02;
    }

    public void setCurvaU02(String curvaU02) {
        this.curvaU02 = curvaU02;
    }

    public String getCurvaU03() {
        return curvaU03;
    }

    public void setCurvaU03(String curvaU03) {
        this.curvaU03 = curvaU03;
    }

    public String getCurvaU04() {
        return curvaU04;
    }

    public void setCurvaU04(String curvaU04) {
        this.curvaU04 = curvaU04;
    }

    public String getCurvaU05() {
        return curvaU05;
    }

    public void setCurvaU05(String curvaU05) {
        this.curvaU05 = curvaU05;
    }

    public String getCurvaU06() {
        return curvaU06;
    }

    public void setCurvaU06(String curvaU06) {
        this.curvaU06 = curvaU06;
    }

    public String getCurvaU07() {
        return curvaU07;
    }

    public void setCurvaU07(String curvaU07) {
        this.curvaU07 = curvaU07;
    }

    public String getCurvaU08() {
        return curvaU08;
    }

    public void setCurvaU08(String curvaU08) {
        this.curvaU08 = curvaU08;
    }

    public String getCurvaU09() {
        return curvaU09;
    }

    public void setCurvaU09(String curvaU09) {
        this.curvaU09 = curvaU09;
    }

    public String getCurvaU10() {
        return curvaU10;
    }

    public void setCurvaU10(String curvaU10) {
        this.curvaU10 = curvaU10;
    }

    public String getCurvaU11() {
        return curvaU11;
    }

    public void setCurvaU11(String curvaU11) {
        this.curvaU11 = curvaU11;
    }

    public String getCurvaUGeral() {
        return curvaUGeral;
    }

    public void setCurvaUGeral(String curvaUGeral) {
        this.curvaUGeral = curvaUGeral;
    }

    public String getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(String codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public int getEstoque01() {
        return estoque01;
    }

    public void setEstoque01(int estoque01) {
        this.estoque01 = estoque01;
    }

    public int getEstoque02() {
        return estoque02;
    }

    public void setEstoque02(int estoque02) {
        this.estoque02 = estoque02;
    }

    public int getEstoque03() {
        return estoque03;
    }

    public void setEstoque03(int estoque03) {
        this.estoque03 = estoque03;
    }

    public int getEstoque04() {
        return estoque04;
    }

    public void setEstoque04(int estoque04) {
        this.estoque04 = estoque04;
    }

    public int getEstoque05() {
        return estoque05;
    }

    public void setEstoque05(int estoque05) {
        this.estoque05 = estoque05;
    }

    public int getEstoque06() {
        return estoque06;
    }

    public void setEstoque06(int estoque06) {
        this.estoque06 = estoque06;
    }

    public int getEstoque07() {
        return estoque07;
    }

    public void setEstoque07(int estoque07) {
        this.estoque07 = estoque07;
    }

    public int getEstoque08() {
        return estoque08;
    }

    public void setEstoque08(int estoque08) {
        this.estoque08 = estoque08;
    }

    public int getEstoque09() {
        return estoque09;
    }

    public void setEstoque09(int estoque09) {
        this.estoque09 = estoque09;
    }

    public int getEstoque10() {
        return estoque10;
    }

    public void setEstoque10(int estoque10) {
        this.estoque10 = estoque10;
    }

    public int getEstoque11() {
        return estoque11;
    }

    public void setEstoque11(int estoque11) {
        this.estoque11 = estoque11;
    }

    public int getEstoqueDeposito() {
        return estoqueDeposito;
    }

    public void setEstoqueDeposito(int estoqueDeposito) {
        this.estoqueDeposito = estoqueDeposito;
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

    public int getQuant05() {
        return quant05;
    }

    public void setQuant05(int quant05) {
        this.quant05 = quant05;
    }

    public int getQuant06() {
        return quant06;
    }

    public void setQuant06(int quant06) {
        this.quant06 = quant06;
    }

    public int getQuant07() {
        return quant07;
    }

    public void setQuant07(int quant07) {
        this.quant07 = quant07;
    }

    public int getQuant08() {
        return quant08;
    }

    public void setQuant08(int quant08) {
        this.quant08 = quant08;
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

    public int getQuant11() {
        return quant11;
    }

    public void setQuant11(int quant11) {
        this.quant11 = quant11;
    }

    public int getMediaVenda01() {
        return mediaVenda01;
    }

    public void setMediaVenda01(int mediaVenda01) {
        this.mediaVenda01 = mediaVenda01;
    }

    public int getMediaVenda02() {
        return mediaVenda02;
    }

    public void setMediaVenda02(int mediaVenda02) {
        this.mediaVenda02 = mediaVenda02;
    }

    public int getMediaVenda03() {
        return mediaVenda03;
    }

    public void setMediaVenda03(int mediaVenda03) {
        this.mediaVenda03 = mediaVenda03;
    }

    public int getMediaVenda04() {
        return mediaVenda04;
    }

    public void setMediaVenda04(int mediaVenda04) {
        this.mediaVenda04 = mediaVenda04;
    }

    public int getMediaVenda05() {
        return mediaVenda05;
    }

    public void setMediaVenda05(int mediaVenda05) {
        this.mediaVenda05 = mediaVenda05;
    }

    public int getMediaVenda06() {
        return mediaVenda06;
    }

    public void setMediaVenda06(int mediaVenda06) {
        this.mediaVenda06 = mediaVenda06;
    }

    public int getMediaVenda07() {
        return mediaVenda07;
    }

    public void setMediaVenda07(int mediaVenda07) {
        this.mediaVenda07 = mediaVenda07;
    }

    public int getMediaVenda08() {
        return mediaVenda08;
    }

    public void setMediaVenda08(int mediaVenda08) {
        this.mediaVenda08 = mediaVenda08;
    }

    public int getMediaVenda09() {
        return mediaVenda09;
    }

    public void setMediaVenda09(int mediaVenda09) {
        this.mediaVenda09 = mediaVenda09;
    }

    public int getMediaVenda10() {
        return mediaVenda10;
    }

    public void setMediaVenda10(int mediaVenda10) {
        this.mediaVenda10 = mediaVenda10;
    }

    public int getMediaVenda11() {
        return mediaVenda11;
    }

    public void setMediaVenda11(int mediaVenda11) {
        this.mediaVenda11 = mediaVenda11;
    }

    public int getItens() {
        return itens;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
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

    public Date getUltimaCompra05() {
        return ultimaCompra05;
    }

    public void setUltimaCompra05(Date ultimaCompra05) {
        this.ultimaCompra05 = ultimaCompra05;
    }

    public Date getUltimaCompra06() {
        return ultimaCompra06;
    }

    public void setUltimaCompra06(Date ultimaCompra06) {
        this.ultimaCompra06 = ultimaCompra06;
    }

    public Date getUltimaCompra07() {
        return ultimaCompra07;
    }

    public void setUltimaCompra07(Date ultimaCompra07) {
        this.ultimaCompra07 = ultimaCompra07;
    }

    public Date getUltimaCompra08() {
        return ultimaCompra08;
    }

    public void setUltimaCompra08(Date ultimaCompra08) {
        this.ultimaCompra08 = ultimaCompra08;
    }

    public Date getUltimaCompra09() {
        return ultimaCompra09;
    }

    public void setUltimaCompra09(Date ultimaCompra09) {
        this.ultimaCompra09 = ultimaCompra09;
    }

    public Date getUltimaCompra10() {
        return ultimaCompra10;
    }

    public void setUltimaCompra10(Date ultimaCompra10) {
        this.ultimaCompra10 = ultimaCompra10;
    }

    public Date getUltimaCompra11() {
        return ultimaCompra11;
    }

    public void setUltimaCompra11(Date ultimaCompra11) {
        this.ultimaCompra11 = ultimaCompra11;
    }

    public Date getUltimaCompraDeposito() {
        return ultimaCompraDeposito;
    }

    public void setUltimaCompraDeposito(Date ultimaCompraDeposito) {
        this.ultimaCompraDeposito = ultimaCompraDeposito;
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

    public Date getUltimaVenda05() {
        return ultimaVenda05;
    }

    public void setUltimaVenda05(Date ultimaVenda05) {
        this.ultimaVenda05 = ultimaVenda05;
    }

    public Date getUltimaVenda06() {
        return ultimaVenda06;
    }

    public void setUltimaVenda06(Date ultimaVenda06) {
        this.ultimaVenda06 = ultimaVenda06;
    }

    public Date getUltimaVenda07() {
        return ultimaVenda07;
    }

    public void setUltimaVenda07(Date ultimaVenda07) {
        this.ultimaVenda07 = ultimaVenda07;
    }

    public Date getUltimaVenda08() {
        return ultimaVenda08;
    }

    public void setUltimaVenda08(Date ultimaVenda08) {
        this.ultimaVenda08 = ultimaVenda08;
    }

    public Date getUltimaVenda09() {
        return ultimaVenda09;
    }

    public void setUltimaVenda09(Date ultimaVenda09) {
        this.ultimaVenda09 = ultimaVenda09;
    }

    public Date getUltimaVenda10() {
        return ultimaVenda10;
    }

    public void setUltimaVenda10(Date ultimaVenda10) {
        this.ultimaVenda10 = ultimaVenda10;
    }

    public Date getUltimaVenda11() {
        return ultimaVenda11;
    }

    public void setUltimaVenda11(Date ultimaVenda11) {
        this.ultimaVenda11 = ultimaVenda11;
    }

    public Date getPenultimaVenda01() {
        return penultimaVenda01;
    }

    public void setPenultimaVenda01(Date penultimaVenda01) {
        this.penultimaVenda01 = penultimaVenda01;
    }

    public Date getPenultimaVenda02() {
        return penultimaVenda02;
    }

    public void setPenultimaVenda02(Date penultimaVenda02) {
        this.penultimaVenda02 = penultimaVenda02;
    }

    public Date getPenultimaVenda03() {
        return penultimaVenda03;
    }

    public void setPenultimaVenda03(Date penultimaVenda03) {
        this.penultimaVenda03 = penultimaVenda03;
    }

    public Date getPenultimaVenda04() {
        return penultimaVenda04;
    }

    public void setPenultimaVenda04(Date penultimaVenda04) {
        this.penultimaVenda04 = penultimaVenda04;
    }

    public Date getPenultimaVenda05() {
        return penultimaVenda05;
    }

    public void setPenultimaVenda05(Date penultimaVenda05) {
        this.penultimaVenda05 = penultimaVenda05;
    }

    public Date getPenultimaVenda06() {
        return penultimaVenda06;
    }

    public void setPenultimaVenda06(Date penultimaVenda06) {
        this.penultimaVenda06 = penultimaVenda06;
    }

    public Date getPenultimaVenda07() {
        return penultimaVenda07;
    }

    public void setPenultimaVenda07(Date penultimaVenda07) {
        this.penultimaVenda07 = penultimaVenda07;
    }

    public Date getPenultimaVenda08() {
        return penultimaVenda08;
    }

    public void setPenultimaVenda08(Date penultimaVenda08) {
        this.penultimaVenda08 = penultimaVenda08;
    }

    public Date getPenultimaVenda09() {
        return penultimaVenda09;
    }

    public void setPenultimaVenda09(Date penultimaVenda09) {
        this.penultimaVenda09 = penultimaVenda09;
    }

    public Date getPenultimaVenda10() {
        return penultimaVenda10;
    }

    public void setPenultimaVenda10(Date penultimaVenda10) {
        this.penultimaVenda10 = penultimaVenda10;
    }

    public Date getPenultimaVenda11() {
        return penultimaVenda11;
    }

    public void setPenultimaVenda11(Date penultimaVenda11) {
        this.penultimaVenda11 = penultimaVenda11;
    }

    public int getMaximo01() {
        return maximo01;
    }

    public void setMaximo01(int maximo01) {
        this.maximo01 = maximo01;
    }

    public int getMaximo02() {
        return maximo02;
    }

    public void setMaximo02(int maximo02) {
        this.maximo02 = maximo02;
    }

    public int getMaximo03() {
        return maximo03;
    }

    public void setMaximo03(int maximo03) {
        this.maximo03 = maximo03;
    }

    public int getMaximo04() {
        return maximo04;
    }

    public void setMaximo04(int maximo04) {
        this.maximo04 = maximo04;
    }

    public int getMaximo05() {
        return maximo05;
    }

    public void setMaximo05(int maximo05) {
        this.maximo05 = maximo05;
    }

    public int getMaximo06() {
        return maximo06;
    }

    public void setMaximo06(int maximo06) {
        this.maximo06 = maximo06;
    }

    public int getMaximo07() {
        return maximo07;
    }

    public void setMaximo07(int maximo07) {
        this.maximo07 = maximo07;
    }

    public int getMaximo08() {
        return maximo08;
    }

    public void setMaximo08(int maximo08) {
        this.maximo08 = maximo08;
    }

    public int getMaximo09() {
        return maximo09;
    }

    public void setMaximo09(int maximo09) {
        this.maximo09 = maximo09;
    }

    public int getMaximo10() {
        return maximo10;
    }

    public void setMaximo10(int maximo10) {
        this.maximo10 = maximo10;
    }

    public int getMaximo11() {
        return maximo11;
    }

    public void setMaximo11(int maximo11) {
        this.maximo11 = maximo11;
    }

    public int getMinimo01() {
        return minimo01;
    }

    public void setMinimo01(int minimo01) {
        this.minimo01 = minimo01;
    }

    public int getMinimo02() {
        return minimo02;
    }

    public void setMinimo02(int minimo02) {
        this.minimo02 = minimo02;
    }

    public int getMinimo03() {
        return minimo03;
    }

    public void setMinimo03(int minimo03) {
        this.minimo03 = minimo03;
    }

    public int getMinimo04() {
        return minimo04;
    }

    public void setMinimo04(int minimo04) {
        this.minimo04 = minimo04;
    }

    public int getMinimo05() {
        return minimo05;
    }

    public void setMinimo05(int minimo05) {
        this.minimo05 = minimo05;
    }

    public int getMinimo06() {
        return minimo06;
    }

    public void setMinimo06(int minimo06) {
        this.minimo06 = minimo06;
    }

    public int getMinimo07() {
        return minimo07;
    }

    public void setMinimo07(int minimo07) {
        this.minimo07 = minimo07;
    }

    public int getMinimo08() {
        return minimo08;
    }

    public void setMinimo08(int minimo08) {
        this.minimo08 = minimo08;
    }

    public int getMinimo09() {
        return minimo09;
    }

    public void setMinimo09(int minimo09) {
        this.minimo09 = minimo09;
    }

    public int getMinimo10() {
        return minimo10;
    }

    public void setMinimo10(int minimo10) {
        this.minimo10 = minimo10;
    }

    public int getMinimo11() {
        return minimo11;
    }

    public void setMinimo11(int minimo11) {
        this.minimo11 = minimo11;
    }

    public double getComissaoValor() {
        return comissaoValor;
    }

    public void setComissaoValor(double comissaoValor) {
        this.comissaoValor = comissaoValor;
    }

    public double getComissaoPercentual() {
        return comissaoPercentual;
    }

    public void setComissaoPercentual(double comissaoPercentual) {
        this.comissaoPercentual = comissaoPercentual;
    }

    public String getCurvaF12() {
        return curvaF12;
    }

    public void setCurvaF12(String curvaF12) {
        this.curvaF12 = curvaF12;
    }

    public String getCurvaF13() {
        return curvaF13;
    }

    public void setCurvaF13(String curvaF13) {
        this.curvaF13 = curvaF13;
    }

    public String getCurvaF14() {
        return curvaF14;
    }

    public void setCurvaF14(String curvaF14) {
        this.curvaF14 = curvaF14;
    }

    public String getCurvaU12() {
        return curvaU12;
    }

    public void setCurvaU12(String curvaU12) {
        this.curvaU12 = curvaU12;
    }

    public String getCurvaU13() {
        return curvaU13;
    }

    public void setCurvaU13(String curvaU13) {
        this.curvaU13 = curvaU13;
    }

    public String getCurvaU14() {
        return curvaU14;
    }

    public void setCurvaU14(String curvaU14) {
        this.curvaU14 = curvaU14;
    }

    public int getEstoque12() {
        return estoque12;
    }

    public void setEstoque12(int estoque12) {
        this.estoque12 = estoque12;
    }

    public int getEstoque13() {
        return estoque13;
    }

    public void setEstoque13(int estoque13) {
        this.estoque13 = estoque13;
    }

    public int getEstoque14() {
        return estoque14;
    }

    public void setEstoque14(int estoque14) {
        this.estoque14 = estoque14;
    }

    public int getQuant12() {
        return quant12;
    }

    public void setQuant12(int quant12) {
        this.quant12 = quant12;
    }

    public int getQuant13() {
        return quant13;
    }

    public void setQuant13(int quant13) {
        this.quant13 = quant13;
    }

    public int getQuant14() {
        return quant14;
    }

    public void setQuant14(int quant14) {
        this.quant14 = quant14;
    }

    public int getMediaVenda12() {
        return mediaVenda12;
    }

    public void setMediaVenda12(int mediaVenda12) {
        this.mediaVenda12 = mediaVenda12;
    }

    public int getMediaVenda13() {
        return mediaVenda13;
    }

    public void setMediaVenda13(int mediaVenda13) {
        this.mediaVenda13 = mediaVenda13;
    }

    public int getMediaVenda14() {
        return mediaVenda14;
    }

    public void setMediaVenda14(int mediaVenda14) {
        this.mediaVenda14 = mediaVenda14;
    }

    public Date getUltimaCompra12() {
        return ultimaCompra12;
    }

    public void setUltimaCompra12(Date ultimaCompra12) {
        this.ultimaCompra12 = ultimaCompra12;
    }

    public Date getUltimaCompra13() {
        return ultimaCompra13;
    }

    public void setUltimaCompra13(Date ultimaCompra13) {
        this.ultimaCompra13 = ultimaCompra13;
    }

    public Date getUltimaCompra14() {
        return ultimaCompra14;
    }

    public void setUltimaCompra14(Date ultimaCompra14) {
        this.ultimaCompra14 = ultimaCompra14;
    }

    public Date getUltimaVenda12() {
        return ultimaVenda12;
    }

    public void setUltimaVenda12(Date ultimaVenda12) {
        this.ultimaVenda12 = ultimaVenda12;
    }

    public Date getUltimaVenda13() {
        return ultimaVenda13;
    }

    public void setUltimaVenda13(Date ultimaVenda13) {
        this.ultimaVenda13 = ultimaVenda13;
    }

    public Date getUltimaVenda14() {
        return ultimaVenda14;
    }

    public void setUltimaVenda14(Date ultimaVenda14) {
        this.ultimaVenda14 = ultimaVenda14;
    }

    public Date getPenultimaVenda12() {
        return penultimaVenda12;
    }

    public void setPenultimaVenda12(Date penultimaVenda12) {
        this.penultimaVenda12 = penultimaVenda12;
    }

    public Date getPenultimaVenda13() {
        return penultimaVenda13;
    }

    public void setPenultimaVenda13(Date penultimaVenda13) {
        this.penultimaVenda13 = penultimaVenda13;
    }

    public Date getPenultimaVenda14() {
        return penultimaVenda14;
    }

    public void setPenultimaVenda14(Date penultimaVenda14) {
        this.penultimaVenda14 = penultimaVenda14;
    }

    public int getMaximo12() {
        return maximo12;
    }

    public void setMaximo12(int maximo12) {
        this.maximo12 = maximo12;
    }

    public int getMaximo13() {
        return maximo13;
    }

    public void setMaximo13(int maximo13) {
        this.maximo13 = maximo13;
    }

    public int getMaximo14() {
        return maximo14;
    }

    public void setMaximo14(int maximo14) {
        this.maximo14 = maximo14;
    }

    public int getMinimo12() {
        return minimo12;
    }

    public void setMinimo12(int minimo12) {
        this.minimo12 = minimo12;
    }

    public int getMinimo13() {
        return minimo13;
    }

    public void setMinimo13(int minimo13) {
        this.minimo13 = minimo13;
    }

    public int getMinimo14() {
        return minimo14;
    }

    public void setMinimo14(int minimo14) {
        this.minimo14 = minimo14;
    }

    
}