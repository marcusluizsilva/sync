package br.com.fsync.objetos;

import java.util.Date;

/**
 *
 * @author Marcus Luiz
 */
public class Escala {
    
    String id;
    String loja;
    Date data;
    String responsavel;
    String funcionario;
    String setor;
    String horaEntrada;
    String horaSaida;
    String saidaAlmoco;
    String retornoAlmoco;
    String saidaLanche;
    String retornoLanche;
    String status;
    String folga;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getSaidaAlmoco() {
        return saidaAlmoco;
    }

    public void setSaidaAlmoco(String saidaAlmoco) {
        this.saidaAlmoco = saidaAlmoco;
    }

    public String getRetornoAlmoco() {
        return retornoAlmoco;
    }

    public void setRetornoAlmoco(String retornoAlmoco) {
        this.retornoAlmoco = retornoAlmoco;
    }

    public String getSaidaLanche() {
        return saidaLanche;
    }

    public void setSaidaLanche(String saidaLanche) {
        this.saidaLanche = saidaLanche;
    }

    public String getRetornoLanche() {
        return retornoLanche;
    }

    public void setRetornoLanche(String retornoLanche) {
        this.retornoLanche = retornoLanche;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFolga() {
        return folga;
    }

    public void setFolga(String folga) {
        this.folga = folga;
    }
    
    
}