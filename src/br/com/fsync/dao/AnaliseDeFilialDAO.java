package br.com.fsync.dao;

import br.com.fsync.objetos.AnaliseFilial;
import br.com.fsync.objetos.MetasVendedor;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Marcus Luiz
 */
public class AnaliseDeFilialDAO {

    private Connection conexaoConsys;
    private Connection conexaoLandA;
    public String sql;
    
    public AnaliseDeFilialDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }
    
    //
    public static Date data;
    public double vendaLoja = 0;
    public int diasTrabalhados = 0;
    public double atendimentosLoja = 0;
    public double unidadeVendidaLoja = 0;
    public double descontoLoja = 0;
    public double descontoMaximoLoja = 0;
    public double descontoPreferencial = 0;
    public String criterio = "";
    public double mediaDiaria = 0;
    public double mediaMensal = 0;
    public double meta = 0;
    public double superMeta = 0;
    public double valorEmpenho;
    public double valorEmpenhoMedicamentos;
    public double valorEmpenhoGenericos;
    public double valorEmpenhoNaoMedicamentos;
    public double metaLoja = 0;
    public double superLoja = 0;
    public double metaAtendimentos = 0;

    public List<AnaliseFilial> analiseFilialParaUpdate(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "filial, "
                    + "data, "
                    + "(sum(coalesce(vvena,0)) + sum(coalesce(vvena2,0)) + sum(coalesce(vvena21,0)) + sum(coalesce(vvena3,0)) + sum(coalesce(vvena4,0)) + sum(coalesce(tvendc,0)) - sum(coalesce(tdevol,0))) as total, "
                    + "sum(coalesce(natend,0)) as atendimentos, "
                    + "sum(coalesce(nunida,0)) as unidades "
                    + "from "
                    + "anafil "
                    + "where "
                    + "data between ? and ? "
                    + "group by "
                    + "data, "
                    + "filial";
            List<AnaliseFilial> arrayList = new ArrayList<AnaliseFilial>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("analiseFilialParaUpdate(): " + rs.getStatement());

            while (rs.next()) {

                AnaliseFilial x = new AnaliseFilial();

                x.setLoja(rs.getString("filial"));
                x.setTotalVendido(rs.getDouble("total"));
                x.setData(rs.getDate("data"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setUnidades(rs.getInt(("unidades")));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<AnaliseFilial> analiseFilialParaUpdateLocaweb(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "filial, "
                    + "data, "
                    + "(sum(coalesce(vvena,0)) + sum(coalesce(vvena2,0)) + sum(coalesce(vvena21,0)) + sum(coalesce(vvena3,0)) + sum(coalesce(vvena4,0)) + sum(coalesce(tvendc,0)) - sum(coalesce(tdevol,0))) as total, "
                    + "sum(coalesce(natend,0)) as atendimentos "
                    + "from "
                    + "anafil "
                    + "where "
                    + "data between ? and ? "
                    + "group by "
                    + "data, "
                    + "filial";
            List<AnaliseFilial> arrayList = new ArrayList<AnaliseFilial>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                AnaliseFilial x = new AnaliseFilial();

                x.setLoja(rs.getString("filial"));
                x.setTotalVendido(rs.getDouble("total"));
                x.setData(rs.getDate("data"));
                x.setAtendimentos(rs.getInt("atendimentos"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void insereAnafilResumido(AnaliseFilial x) {
        try {
            sql = "insert ignore into "
                    + "ven_anafilResumo "
                    + "(data, "
                    + "loja, "
                    + "venda, "
                    + "atendimentos, "
                    + "unidades) "
                    + "values "
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setString(2, x.getLoja());
            stmt.setDouble(3, x.getTotalVendido());
            stmt.setInt(4, x.getAtendimentos());
            stmt.setInt(5, x.getUnidades());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void atualisaAnafilResumo(AnaliseFilial x) {
        try {
            sql = "update "
                    + "ven_anafilResumo "
                    + "set "
                    + "venda = ?, "
                    + "atendimentos = ?, "
                    + "unidades = ? "
                    + "where "
                    + "data = ? "
                    + "and "
                    + "loja = ?";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDouble(1, x.getTotalVendido());
            stmt.setInt(2, x.getAtendimentos());
            stmt.setInt(3, x.getUnidades());
            stmt.setDate(4, new java.sql.Date(x.getData().getTime()));
            stmt.setString(5, x.getLoja());
            
            System.out.println(x.getData());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<AnaliseFilial> analiseEmpenhoParaUpdate(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "b.loc, "
                    + "coalesce(a.dtvenda, b.data) as dtvenda, "
                    + "sum(b.valor2) as total "
                    + "from "
                    + "conveni a, "
                    + "mov b "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "a.convenio in ('262', '240') "
                    + "and "
                    + "a.dtvenda between ? and ? "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.codigo = '---P---'";
            List<AnaliseFilial> arrayList = new ArrayList<AnaliseFilial>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("analiseEmpenhoParaUpdate(): " + rs.getStatement());

            while (rs.next()) {
                AnaliseFilial m = new AnaliseFilial();

                m.setTotalVendido(rs.getDouble("total"));
                m.setData(rs.getDate("dtvenda"));
                m.setLoja(rs.getString("loc"));

                if (rs.getDate("dtvenda") != null) {
                    atualisaAnafilResumoEmpenho(m);
                }
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualisaAnafilResumoEmpenho(AnaliseFilial x) {
        try {
            sql = "update ignore "
                    + "ven_anafilResumo "
                    + "set "
                    + "empenho = ? "
                    + "where "
                    + "data = ? "
                    + "and "
                    + "loja = ?";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDouble(1, x.getTotalVendido());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getLoja());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<AnaliseFilial> analiseDescontoManualUpdate(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "a.filnota, "
                    + "a.data, "
                    + "sum(coalesce(a.totcomp, 0)) as descontoManual "
                    + "from "
                    + "conveni a "
                    + "where "
                    + "a.data between ? and ? "
                    + "and "
                    + "a.convenio in ('401', '402', '403', '404', '405', '423', '435', '458', '461', '472', '476') "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "group by "
                    + "a.data, "
                    + "a.filnota";
            List<AnaliseFilial> arrayList = new ArrayList<AnaliseFilial>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                AnaliseFilial m = new AnaliseFilial();

                m.setTotalVendido(rs.getDouble("descontoManual"));
                m.setData(rs.getDate("data"));
                m.setLoja(rs.getString("filnota"));

                arrayList.add(m);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualisaAnafilResumoDescontoManual(AnaliseFilial x) {
        try {
            sql = "update "
                    + "ven_anafilResumo "
                    + "set "
                    + "descontoManual = ? "
                    + "where "
                    + "data = ? "
                    + "and "
                    + "loja = ?";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDouble(1, x.getTotalVendido());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getLoja());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<AnaliseFilial> analiseDescontoCrediarioUpdate(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "loc, "
                    + "data, "
                    + "sum(coalesce(valor1, 0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = 'H' "
                    + "and "
                    + "obs3 = 'D.01.01.016' "
                    + "and "
                    + "sr_deleted = '' "
                    + "group by "
                    + "data, "
                    + "loc";
            List<AnaliseFilial> arrayList = new ArrayList<AnaliseFilial>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("analiseDescontoCrediarioUpdate: " + rs.getStatement());

            while (rs.next()) {
                AnaliseFilial m = new AnaliseFilial();

                m.setTotalVendido(rs.getDouble("valor"));
                m.setData(rs.getDate("data"));
                m.setLoja(rs.getString("loc"));

                arrayList.add(m);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualisaAnafilResumoDescontoCrediario(AnaliseFilial x) {
        try {
            sql = "update "
                    + "ven_anafilResumo "
                    + "set "
                    + "descontoCrediario = ? "
                    + "where "
                    + "data = ? "
                    + "and "
                    + "loja = ?";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDouble(1, x.getTotalVendido());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getLoja());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<MetasVendedor> analiseDeFilial(Date dataI, Date dataF, String loja) {
        try {
            sql = "select "
                    + "coalesce(filial, '') as filial, "
                    + "count(distinct data) as dias, "
                    + "data, "
                    + "sum(coalesce(natend,0)) as atendimentos, "
                    + "sum(coalesce(nunida,0)) as unidades, "
                    + "sum(coalesce(nunida,0)) / sum(coalesce(natend,0)) as unidadesAtendimento, "
                    + "(sum(coalesce(vvena,0)) + "
                    + "sum(coalesce(vvena2,0)) + "
                    + "sum(coalesce(vvena21,0)) + "
                    + "sum(coalesce(vvena3,0)) + "
                    + "sum(coalesce(vvena4,0)) + "
                    + "sum(coalesce(tvendc,0)) - "
                    + "sum(coalesce(tdevol,0))) as total, "
                    + "sum(coalesce(tdescp, 0)) - sum(coalesce(tdescpref, 0)) as descontoPadrao, "
                    + "sum(coalesce(tdesc, 0)) as descontoMaximo, "
                    + "sum(coalesce(tdescpref, 0)) as descontoPreferencial "
                    + "from "
                    + "anafil "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "filial = ?"
                    + criterio;
            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                MetasVendedor x = new MetasVendedor();

                vendaLoja = rs.getDouble("total");
                diasTrabalhados = rs.getInt("dias");
                atendimentosLoja = rs.getInt("atendimentos");
                unidadeVendidaLoja = rs.getInt("unidades");
                descontoLoja = rs.getDouble("descontoPadrao");
                descontoMaximoLoja = rs.getDouble("descontoMaximo");
                descontoPreferencial = rs.getDouble("descontoPreferencial");
                data = rs.getDate("data");

                mediaDiaria = vendaLoja / diasTrabalhados;

                x.setVendaLiquida(rs.getDouble("total"));

                double metaAt = 0;
                if (!rs.getString("filial").equals("")) {
                    mediaMensal = mediaDiaria * 30;
                        metaAt = ((atendimentosLoja + (atendimentosLoja * 0.07)) / diasTrabalhados) * 30;
                }
                meta = (mediaMensal * 0.05) + mediaMensal;
                superMeta = (mediaMensal * 0.07) + mediaMensal;

                NumberFormat df = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
                df.setMaximumFractionDigits(2);

                x.setLoja(rs.getString("filial"));
                x.setData(rs.getDate("data"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setUnidades(rs.getInt("unidades"));
                x.setVendaLiquida(rs.getDouble("total"));
                x.setDescontoMaximo(rs.getDouble("descontoMaximo"));
                x.setDescontoPadrao(rs.getDouble("descontoPadrao"));
                x.setDescontoPreferencial(rs.getDouble("descontoPreferencial"));

                double percentualDescontoMaximo = (100 * x.getDescontoMaximo()) / (x.getVendaLiquida() + x.getDescontoMaximo() + x.getDescontoPadrao() + x.getDescontoPreferencial());

                x.setPercentualDescontoMaximo(percentualDescontoMaximo);
                x.setUnidadesAtendimento(rs.getDouble("unidadesAtendimento"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<MetasVendedor> analiseVendaEmpenho(Date dataI, Date dataF, String loja) {
        valorEmpenho = 0;
        valorEmpenhoGenericos = 0;
        valorEmpenhoMedicamentos = 0;
        valorEmpenhoNaoMedicamentos = 0;
        try {
            sql = "select "
                    + "e.nome as area, "
                    + "sum(b.valor2) as total "
                    + "from "
                    + "conveni a, "
                    + "mov b, "
                    + "alqui c, "
                    + "departs d, "
                    + "areas e "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "b.codigo = c.ccodigo "
                    + "and "
                    + "d.codigo = c.ccoddep "
                    + "and "
                    + "e.codigo = d.codare "
                    + "and "
                    + "a.convenio in ('262', '240') "
                    + "and "
                    + "a.dtvenda between ? and ? "
                    + "and "
                    + "a.filnota like ? "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "group by "
                    + "e.codigo "
                    + "order by "
                    + "e.nome";

            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                valorEmpenho = valorEmpenho + rs.getDouble("total");

                MetasVendedor m = new MetasVendedor();
                m.setVendaLiquida(rs.getDouble("total"));

                if (rs.getString("area").equals("GENERICO")) {
                    valorEmpenhoGenericos = valorEmpenhoGenericos + rs.getDouble("total");
                }
                if (rs.getString("area").equals("SIMILAR")) {
                    valorEmpenhoGenericos = valorEmpenhoGenericos + rs.getDouble("total");
                }
                if (rs.getString("area").equals("MIP")) {
                    valorEmpenhoMedicamentos = valorEmpenhoMedicamentos + rs.getDouble("total");
                }
                if (rs.getString("area").equals("PRESCRICAO")) {
                    valorEmpenhoMedicamentos = valorEmpenhoMedicamentos + rs.getDouble("total");
                }

                arrayList.add(m);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<MetasVendedor> listaMetaLoja(String periodo, String loja) {
        try {
            sql = "select "
                    + "vendedor, "
                    + "loja, "
                    + "meta, "
                    + "vendido, "
                    + "periodo, "
                    + "atendimentos "
                    + "from "
                    + "ven_metas "
                    + "where "
                    + "periodo like ? "
                    + "and "
                    + "vendedor like ?";

            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setString(1, periodo);
            stmt.setString(2, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                MetasVendedor x = new MetasVendedor();

                metaLoja = rs.getDouble("meta");
                superLoja = rs.getDouble("meta");
                metaAtendimentos = rs.getInt("atendimentos");

                x.setMetaAtual(rs.getDouble("meta"));
                x.setMes(rs.getString("periodo").substring(2));
                x.setVendaLiquida(rs.getDouble("vendido"));
                x.setLoja(rs.getString("vendedor"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void fechaConexao() {
        try {
            this.conexaoConsys.close();
            this.conexaoLandA.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
