package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author marcu
 */
public class Vendas {
    
    Date data;
    String rota;
    int pedidos;
    double valor;
    int itens;
    int unidades;
    String rotaId;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getPedidos() {
        return pedidos;
    }

    public void setPedidos(int pedidos) {
        this.pedidos = pedidos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public String getRotaId() {
        return rotaId;
    }

    public void setRotaId(String rotaId) {
        this.rotaId = rotaId;
    }
    
    
}
