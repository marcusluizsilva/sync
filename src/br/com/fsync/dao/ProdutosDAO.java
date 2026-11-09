package br.com.fsync.dao;

import br.com.fsync.objetos.Venda;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Entrada;
import br.com.fsync.objetos.Mov;
import br.com.fsync.objetos.Perdas;
import br.com.fsync.objetos.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcus
 */
public class ProdutosDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLanda;

    // Construtor da classe VendaDao
    public ProdutosDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLanda = CriaConexaoLanda.getConexao();
    }

    public String sql;
    public String loja;
    public static String atualiza = "LA";
    public static String criterio = "";

    /*
    public String insereProduto = "N";
    public String prod;
    public String criterio;
    public String criterio2;
    public String PAR_loja;*/
    public List<Produtos> listaProdutosAlqui() {
        try {
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement("select "
                    + "ccodigo, "
                    + "cdesc, "
                    + "ean13, "
                    + "seguean13, "
                    + "nlab, "
                    + "ndep, "
                    + "classe, "
                    + "cunida, "
                    + "chospn, "
                    + "ccusto, "
                    + "cvenda, "
                    + "descp, "
                    + "descm, "
                    + "cvenda - (cvenda * (descp/100)) as precoFinal, "
                    + "sr_recno, "
                    + "sr_deleted, "
                    + "ccadini, "
                    + "caltpre, "
                    + "substring(ccurvavo, 2, 1) as curvaU01, "
                    + "substring(ccurvavo, 3, 1) as curvaU02, "
                    + "substring(ccurvavo, 4, 1) as curvaU03, "
                    + "substring(ccurvavo, 5, 1) as curvaU04, "
                    + "substring(ccurvavo, 6, 1) as curvaU05, "
                    + "substring(ccurvavo, 7, 1) as curvaU06, "
                    + "substring(ccurvavo, 8, 1) as curvaU07, "
                    + "substring(ccurvavo, 9, 1) as curvaU08, "
                    + "substring(ccurvavo, 10, 1) as curvaU09, "
                    + "substring(ccurvavo, 11, 1) as curvaU10, "
                    + "substring(ccurvavo, 12, 1) as curvaU11, "
                    + "substring(ccurvavo, 13, 1) as curvaU12, "
                    + "substring(ccurvavo, 14, 1) as curvaU13, "
                    + "substring(ccurvavo, 15, 1) as curvaU14, "
                    + "substring(ccurvava, 2, 1) as curvaF01, "
                    + "substring(ccurvava, 3, 1) as curvaF02, "
                    + "substring(ccurvava, 4, 1) as curvaF03, "
                    + "substring(ccurvava, 5, 1) as curvaF04, "
                    + "substring(ccurvava, 6, 1) as curvaF05, "
                    + "substring(ccurvava, 7, 1) as curvaF06, "
                    + "substring(ccurvava, 8, 1) as curvaF07, "
                    + "substring(ccurvava, 9, 1) as curvaF08, "
                    + "substring(ccurvava, 10, 1) as curvaF09, "
                    + "substring(ccurvava, 11, 1) as curvaF10, "
                    + "substring(ccurvava, 12, 1) as curvaF11, "
                    + "substring(ccurvava, 13, 1) as curvaF12, "
                    + "substring(ccurvava, 14, 1) as curvaF13, "
                    + "substring(ccurvava, 15, 1) as curvaF14, "
                    + "coalesce(cfilial01, 0) as cfilial01, "
                    + "coalesce(cfilial02, 0) as cfilial02, "
                    + "coalesce(cfilial03, 0) as cfilial03, "
                    + "coalesce(cfilial04, 0) as cfilial04, "
                    + "coalesce(cfilial05, 0) as cfilial05, "
                    + "coalesce(cfilial06, 0) as cfilial06, "
                    + "coalesce(cfilial07, 0) as cfilial07, "
                    + "coalesce(cfilial08, 0) as cfilial08, "
                    + "coalesce(cfilial09, 0) as cfilial09, "
                    + "coalesce(cfilial10, 0) as cfilial10, "
                    + "coalesce(cfilial11, 0) as cfilial11, "
                    + "coalesce(cfilial12, 0) as cfilial12, "
                    + "coalesce(cfilial13, 0) as cfilial13, "
                    + "coalesce(cfilial14, 0) as cfilial14, "
                    + "coalesce(calmoxa, 0) as calmoxa, "
                    + "codirece, "
                    + "marcacon, "
                    + "ccodlab, "
                    + "ccustmed, "
                    + "a.grupcomp, "
                    + "(select grupdesc from grupcomp where sr_deleted = '' and grupcodi = a.grupcomp) as descGrupComp, "
                    + "coalesce(a.comiprod, '') as comiprod "
                    + "from "
                    + "alqui a "
                    + "where "
                    + "ccadini >= DATE_ADD(curdate(), INTERVAL -7 DAY)");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produtos f = new Produtos();
                f.setGrupoCompra(rs.getString("descGrupComp"));
                f.setCodigoGrupoCompra(rs.getString("grupComp"));
                f.setCodigo(rs.getString("ccodigo"));
                f.setDescricao(rs.getString("cdesc"));
                f.setLaboratorio(rs.getString("nlab"));
                f.setClasse(rs.getString("classe"));
                f.setDepartamento(rs.getString("ndep"));
                f.setRecno(rs.getString("sr_recno"));
                f.setDeletado(rs.getString("sr_deleted"));
                f.setHospitalar(rs.getInt("chospn"));
                f.setEan1(rs.getString("ean13"));
                f.setEan2(rs.getString("seguean13"));
                f.setDataCadastro(rs.getDate("ccadini"));
                f.setDataAlteracao(rs.getDate("caltpre"));
                f.setDataCadastroString(rs.getString("ccadini"));
                f.setDataAlteracaoString(rs.getString("caltpre"));
                f.setPrecoCusto(rs.getDouble("ccusto"));
                f.setPrecoVenda(rs.getDouble("cvenda"));
                f.setDesconto(rs.getDouble("descp"));
                f.setDescontoMaximo(rs.getDouble("descm"));
                f.setQuant01(rs.getInt("cfilial01"));
                f.setQuant02(rs.getInt("cfilial02"));
                f.setQuant03(rs.getInt("cfilial03"));
                f.setQuant04(rs.getInt("cfilial04"));
                f.setQuant05(rs.getInt("cfilial05"));
                f.setQuant06(rs.getInt("cfilial06"));
                f.setQuant07(rs.getInt("cfilial07"));
                f.setQuant08(rs.getInt("cfilial08"));
                f.setQuant09(rs.getInt("cfilial09"));
                f.setQuant10(rs.getInt("cfilial10"));
                f.setQuant11(rs.getInt("cfilial11"));
                f.setQuant12(rs.getInt("cfilial12"));
                f.setQuant13(rs.getInt("cfilial13"));
                f.setQuant14(rs.getInt("cfilial14"));
                f.setQuantDep(rs.getInt("calmoxa"));
                f.setCurvaValor01(rs.getString("curvaF01"));
                f.setCurvaValor02(rs.getString("curvaF02"));
                f.setCurvaValor03(rs.getString("curvaF03"));
                f.setCurvaValor04(rs.getString("curvaF04"));
                f.setCurvaValor05(rs.getString("curvaF05"));
                f.setCurvaValor06(rs.getString("curvaF06"));
                f.setCurvaValor07(rs.getString("curvaF07"));
                f.setCurvaValor08(rs.getString("curvaF08"));
                f.setCurvaValor09(rs.getString("curvaF09"));
                f.setCurvaValor10(rs.getString("curvaF10"));
                f.setCurvaValor11(rs.getString("curvaF11"));
                f.setCurvaValor12(rs.getString("curvaF12"));
                f.setCurvaValor13(rs.getString("curvaF13"));
                f.setCurvaValor14(rs.getString("curvaF14"));
                f.setCurvaVolume01(rs.getString("curvaU01"));
                f.setCurvaVolume02(rs.getString("curvaU02"));
                f.setCurvaVolume03(rs.getString("curvaU03"));
                f.setCurvaVolume04(rs.getString("curvaU04"));
                f.setCurvaVolume05(rs.getString("curvaU05"));
                f.setCurvaVolume06(rs.getString("curvaU06"));
                f.setCurvaVolume07(rs.getString("curvaU07"));
                f.setCurvaVolume08(rs.getString("curvaU08"));
                f.setCurvaVolume09(rs.getString("curvaU09"));
                f.setCurvaVolume10(rs.getString("curvaU10"));
                f.setCurvaVolume11(rs.getString("curvaU11"));
                f.setCurvaVolume12(rs.getString("curvaU12"));
                f.setCurvaVolume13(rs.getString("curvaU13"));
                f.setCurvaVolume14(rs.getString("curvaU14"));
                f.setTipoReceita(rs.getString("codirece"));
                f.setUsoContinuo(rs.getString("marcacon"));
                f.setCodigoFabricante(rs.getString("ccodlab"));
                f.setCustoMedio(rs.getDouble("ccustmed"));
                if (rs.getString("comiprod").startsWith("V")) {
                    String c = rs.getString("comiprod").substring(1);
                    System.out.println(c + " - " + Double.parseDouble(c));
                    f.setComissaoValor(Double.parseDouble(c));
                } else if (rs.getString("comiprod").startsWith("P")) {
                    String c = rs.getString("comiprod").substring(1);
                    System.out.println(c + " - " + Double.parseDouble(c));
                    f.setComissaoPercentual(Double.parseDouble(c));
                }

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            System.out.println(stmt.getUpdateCount());
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insereProdutoLandA(Produtos p) {
        try {
            sql = "insert ignore into "
                    + "produtos"
                    + "(sr_recno, "
                    + "sr_deleted, "
                    + "codigo, "
                    + "descricao, "
                    + "fabricante, "
                    + "departamento, "
                    + "classe, "
                    + "quantHospitalar, "
                    + "ean13, "
                    + "ean132, "
                    + "dataCadastro, "
                    + "dataAlteracao, "
                    + "custo, "
                    + "venda, "
                    + "descontoPadrao, "
                    + "descontoMaximo, "
                    + "curvaF01, "
                    + "curvaF02, "
                    + "curvaF03, "
                    + "curvaF04, "
                    + "curvaF05, "
                    + "curvaF06, "
                    + "curvaF07, "
                    + "curvaF08, "
                    + "curvaF09, "
                    + "curvaF10, "
                    + "curvaF11, "
                    + "curvaF12, "
                    + "curvaF13, "
                    + "curvaF14, "
                    + "curvaU01, "
                    + "curvaU02, "
                    + "curvaU03, "
                    + "curvaU04, "
                    + "curvaU05, "
                    + "curvaU06, "
                    + "curvaU07, "
                    + "curvaU08, "
                    + "curvaU09, "
                    + "curvaU10, "
                    + "curvaU11, "
                    + "curvaU12, "
                    + "curvaU13, "
                    + "curvaU14, "
                    + "est01, "
                    + "est02, "
                    + "est03, "
                    + "est04, "
                    + "est05, "
                    + "est06, "
                    + "est07, "
                    + "est08, "
                    + "est09, "
                    + "est10, "
                    + "est11, "
                    + "est12, "
                    + "est13, "
                    + "est14, "
                    + "estDep, "
                    + "tipoReceita, "
                    + "codigoFabricante, "
                    + "usoContinuo, "
                    + "custoMedio, "
                    + "codigoCompra, "
                    + "grupoCompra, "
                    + "comissaoValor, "
                    + "comissaoPercentual) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setString(1, p.getRecno());
            stmt.setString(2, p.getDeletado());
            stmt.setString(3, p.getCodigo());
            stmt.setString(4, p.getDescricao());
            stmt.setString(5, p.getLaboratorio());
            stmt.setString(6, p.getDepartamento());
            stmt.setString(7, p.getClasse());
            stmt.setInt(8, p.getHospitalar());
            stmt.setString(9, p.getEan1());
            stmt.setString(10, p.getEan2());
            stmt.setString(11, p.getDataCadastroString());
            stmt.setString(12, p.getDataAlteracaoString());
            stmt.setDouble(13, p.getPrecoCusto());
            stmt.setDouble(14, p.getPrecoVenda());
            stmt.setDouble(15, p.getDesconto());
            stmt.setDouble(16, p.getDescontoMaximo());
            stmt.setString(17, p.getCurvaValor01());
            stmt.setString(18, p.getCurvaValor02());
            stmt.setString(19, p.getCurvaValor03());
            stmt.setString(20, p.getCurvaValor04());
            stmt.setString(21, p.getCurvaValor05());
            stmt.setString(22, p.getCurvaValor06());
            stmt.setString(23, p.getCurvaValor07());
            stmt.setString(24, p.getCurvaValor08());
            stmt.setString(25, p.getCurvaValor09());
            stmt.setString(26, p.getCurvaValor10());
            stmt.setString(27, p.getCurvaValor11());
            stmt.setString(28, p.getCurvaValor12());
            stmt.setString(29, p.getCurvaValor13());
            stmt.setString(30, p.getCurvaValor14());
            stmt.setString(31, p.getCurvaVolume01());
            stmt.setString(32, p.getCurvaVolume02());
            stmt.setString(33, p.getCurvaVolume03());
            stmt.setString(34, p.getCurvaVolume04());
            stmt.setString(35, p.getCurvaVolume05());
            stmt.setString(36, p.getCurvaVolume06());
            stmt.setString(37, p.getCurvaVolume07());
            stmt.setString(38, p.getCurvaVolume08());
            stmt.setString(39, p.getCurvaVolume09());
            stmt.setString(40, p.getCurvaVolume10());
            stmt.setString(41, p.getCurvaVolume11());
            stmt.setString(42, p.getCurvaVolume12());
            stmt.setString(43, p.getCurvaVolume13());
            stmt.setString(44, p.getCurvaVolume14());
            stmt.setInt(45, p.getQuant01());
            stmt.setInt(46, p.getQuant02());
            stmt.setInt(47, p.getQuant03());
            stmt.setInt(48, p.getQuant04());
            stmt.setInt(49, p.getQuant05());
            stmt.setInt(50, p.getQuant06());
            stmt.setInt(51, p.getQuant07());
            stmt.setInt(52, p.getQuant08());
            stmt.setInt(53, p.getQuant09());
            stmt.setInt(54, p.getQuant10());
            stmt.setInt(55, p.getQuant11());
            stmt.setInt(56, p.getQuant12());
            stmt.setInt(57, p.getQuant13());
            stmt.setInt(58, p.getQuant14());
            stmt.setInt(59, p.getQuantDep());
            stmt.setString(60, p.getTipoReceita());
            stmt.setString(61, p.getCodigoFabricante());
            stmt.setString(62, p.getUsoContinuo());
            stmt.setDouble(63, p.getCustoMedio());
            stmt.setString(64, p.getCodigoGrupoCompra());
            stmt.setString(65, p.getGrupoCompra());
            stmt.setDouble(66, p.getComissaoValor());
            stmt.setDouble(67, p.getComissaoPercentual());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Produtos> listaProdutosAlterados() {
        try {
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement("select "
                    + "ccodigo, "
                    + "cdesc, "
                    + "ean13, "
                    + "seguean13, "
                    + "nlab, "
                    + "ndep, "
                    + "classe, "
                    + "cunida, "
                    + "chospn, "
                    + "ccusto, "
                    + "cvenda, "
                    + "descp, "
                    + "descm, "
                    + "cvenda - (cvenda * (descp/100)) as precoFinal, "
                    + "sr_recno, "
                    + "sr_deleted, "
                    + "ccadini, "
                    + "caltpre, "
                    + "substring(ccurvavo, 2, 1) as curvaU01, "
                    + "substring(ccurvavo, 3, 1) as curvaU02, "
                    + "substring(ccurvavo, 4, 1) as curvaU03, "
                    + "substring(ccurvavo, 5, 1) as curvaU04, "
                    + "substring(ccurvavo, 6, 1) as curvaU05, "
                    + "substring(ccurvavo, 7, 1) as curvaU06, "
                    + "substring(ccurvavo, 8, 1) as curvaU07, "
                    + "substring(ccurvavo, 9, 1) as curvaU08, "
                    + "substring(ccurvavo, 10, 1) as curvaU09, "
                    + "substring(ccurvavo, 11, 1) as curvaU10, "
                    + "substring(ccurvavo, 12, 1) as curvaU11, "
                    + "substring(ccurvavo, 13, 1) as curvaU12, "
                    + "substring(ccurvavo, 14, 1) as curvaU13, "
                    + "substring(ccurvavo, 15, 1) as curvaU14, "
                    + "substring(ccurvava, 2, 1) as curvaF01, "
                    + "substring(ccurvava, 3, 1) as curvaF02, "
                    + "substring(ccurvava, 4, 1) as curvaF03, "
                    + "substring(ccurvava, 5, 1) as curvaF04, "
                    + "substring(ccurvava, 6, 1) as curvaF05, "
                    + "substring(ccurvava, 7, 1) as curvaF06, "
                    + "substring(ccurvava, 8, 1) as curvaF07, "
                    + "substring(ccurvava, 9, 1) as curvaF08, "
                    + "substring(ccurvava, 10, 1) as curvaF09, "
                    + "substring(ccurvava, 11, 1) as curvaF10, "
                    + "substring(ccurvava, 12, 1) as curvaF11, "
                    + "substring(ccurvava, 13, 1) as curvaF12, "
                    + "substring(ccurvava, 14, 1) as curvaF13, "
                    + "substring(ccurvava, 15, 1) as curvaF14, "
                    + "coalesce(cfilial01, 0) as cfilial01, "
                    + "coalesce(cfilial02, 0) as cfilial02, "
                    + "coalesce(cfilial03, 0) as cfilial03, "
                    + "coalesce(cfilial04, 0) as cfilial04, "
                    + "coalesce(cfilial05, 0) as cfilial05, "
                    + "coalesce(cfilial06, 0) as cfilial06, "
                    + "coalesce(cfilial07, 0) as cfilial07, "
                    + "coalesce(cfilial08, 0) as cfilial08, "
                    + "coalesce(cfilial09, 0) as cfilial09, "
                    + "coalesce(cfilial10, 0) as cfilial10, "
                    + "coalesce(cfilial11, 0) as cfilial11, "
                    + "coalesce(cfilial12, 0) as cfilial12, "
                    + "coalesce(cfilial13, 0) as cfilial13, "
                    + "coalesce(cfilial14, 0) as cfilial14, "
                    + "coalesce(calmoxa, 0) as calmoxa, "
                    + "marcacon, "
                    + "codirece, "
                    + "ccustmed, "
                    + "a.grupcomp, "
                    + "(select grupdesc from grupcomp where sr_deleted = '' and grupcodi = a.grupcomp) as descGrupComp, "
                    + "coalesce(a.comiprod, '') as comiprod "
                    + "from "
                    + "alqui a "
                    + "where "
                    /*+ "ccadast >= '2000-01-01' "
                    + "or "
                    + "caltpre >= '2000-01-01'");*/
                    + "ccadast >= date_add(curdate(), interval - 7 day) "
                    + "or "
                    + "caltpre >= date_add(curdate(), interval - 7 day)");
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaProdutosAlterados(): " + rs.getStatement());

            while (rs.next()) {

                Produtos f = new Produtos();
                f.setGrupoCompra(rs.getString("descGrupcomp"));
                f.setCodigoGrupoCompra(rs.getString("grupcomp"));
                f.setCodigo(rs.getString("ccodigo"));
                f.setDescricao(rs.getString("cdesc"));
                f.setLaboratorio(rs.getString("nlab"));
                f.setClasse(rs.getString("classe"));
                f.setDepartamento(rs.getString("ndep"));
                f.setRecno(rs.getString("sr_recno"));
                f.setDeletado(rs.getString("sr_deleted"));
                f.setHospitalar(rs.getInt("chospn"));
                f.setEan1(rs.getString("ean13"));
                f.setEan2(rs.getString("seguean13"));
                f.setDataCadastro(rs.getDate("ccadini"));
                f.setDataAlteracao(rs.getDate("caltpre"));
                f.setDataCadastroString(rs.getString("ccadini"));
                f.setDataAlteracaoString(rs.getString("caltpre"));
                f.setPrecoCusto(rs.getDouble("ccusto"));
                f.setPrecoVenda(rs.getDouble("cvenda"));
                f.setDesconto(rs.getDouble("descp"));
                f.setDescontoMaximo(rs.getDouble("descm"));
                f.setQuant01(rs.getInt("cfilial01"));
                f.setQuant02(rs.getInt("cfilial02"));
                f.setQuant03(rs.getInt("cfilial03"));
                f.setQuant04(rs.getInt("cfilial04"));
                f.setQuant05(rs.getInt("cfilial05"));
                f.setQuant06(rs.getInt("cfilial06"));
                f.setQuant07(rs.getInt("cfilial07"));
                f.setQuant08(rs.getInt("cfilial08"));
                f.setQuant09(rs.getInt("cfilial09"));
                f.setQuant10(rs.getInt("cfilial10"));
                f.setQuant11(rs.getInt("cfilial11"));
                f.setQuant12(rs.getInt("cfilial12"));
                f.setQuant13(rs.getInt("cfilial13"));
                f.setQuant14(rs.getInt("cfilial14"));
                f.setQuantDep(rs.getInt("calmoxa"));
                f.setCurvaValor01(rs.getString("curvaF01"));
                f.setCurvaValor02(rs.getString("curvaF02"));
                f.setCurvaValor03(rs.getString("curvaF03"));
                f.setCurvaValor04(rs.getString("curvaF04"));
                f.setCurvaValor05(rs.getString("curvaF05"));
                f.setCurvaValor06(rs.getString("curvaF06"));
                f.setCurvaValor07(rs.getString("curvaF07"));
                f.setCurvaValor08(rs.getString("curvaF08"));
                f.setCurvaValor09(rs.getString("curvaF09"));
                f.setCurvaValor10(rs.getString("curvaF10"));
                f.setCurvaValor11(rs.getString("curvaF11"));
                f.setCurvaValor12(rs.getString("curvaF12"));
                f.setCurvaValor13(rs.getString("curvaF13"));
                f.setCurvaValor14(rs.getString("curvaF14"));
                f.setCurvaVolume01(rs.getString("curvaU01"));
                f.setCurvaVolume02(rs.getString("curvaU02"));
                f.setCurvaVolume03(rs.getString("curvaU03"));
                f.setCurvaVolume04(rs.getString("curvaU04"));
                f.setCurvaVolume05(rs.getString("curvaU05"));
                f.setCurvaVolume06(rs.getString("curvaU06"));
                f.setCurvaVolume07(rs.getString("curvaU07"));
                f.setCurvaVolume08(rs.getString("curvaU08"));
                f.setCurvaVolume09(rs.getString("curvaU09"));
                f.setCurvaVolume10(rs.getString("curvaU10"));
                f.setCurvaVolume11(rs.getString("curvaU11"));
                f.setCurvaVolume12(rs.getString("curvaU12"));
                f.setCurvaVolume13(rs.getString("curvaU13"));
                f.setCurvaVolume14(rs.getString("curvaU14"));
                f.setTipoReceita(rs.getString("codirece"));
                f.setUsoContinuo(rs.getString("marcacon"));
                f.setCustoMedio(rs.getDouble("ccustmed"));
                if (rs.getString("comiprod").startsWith("V")) {
                    String c = rs.getString("comiprod").substring(1);
                    System.out.println(c + " - " + Double.parseDouble(c));
                    f.setComissaoValor(Double.parseDouble(c));
                } else if (rs.getString("comiprod").startsWith("P")) {
                    String c = rs.getString("comiprod").substring(1);
                    System.out.println(c + " - " + Double.parseDouble(c));
                    f.setComissaoPercentual(Double.parseDouble(c));
                }

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            System.out.println(stmt.getUpdateCount());
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaProdutoLandA(Produtos p) {
        try {
            sql = "update "
                    + "produtos "
                    + "set "
                    + "sr_deleted = ?, "
                    + "codigo = ?, "
                    + "descricao = ?, "
                    + "fabricante = ?, "
                    + "departamento = ?, "
                    + "classe = ?, "
                    + "quantHospitalar = ?, "
                    + "ean13 = ?, "
                    + "ean132 = ?, "
                    + "dataCadastro = ?, "
                    + "dataAlteracao = ?, "
                    + "custo = ?, "
                    + "venda = ?, "
                    + "descontoPadrao = ?, "
                    + "descontoMaximo = ?, "
                    + "est01 = ?, "
                    + "est02 = ?, "
                    + "est03 = ?, "
                    + "est04 = ?, "
                    + "est05 = ?, "
                    + "est06 = ?, "
                    + "est07 = ?, "
                    + "est08 = ?, "
                    + "est09 = ?, "
                    + "est10 = ?, "
                    + "est11 = ?, "
                    + "est12 = ?, "
                    + "est13 = ?, "
                    + "est14 = ?, "
                    + "estDep = ?, "
                    + "curvaF01 = ?, "
                    + "curvaF02 = ?, "
                    + "curvaF03 = ?, "
                    + "curvaF04 = ?, "
                    + "curvaF05 = ?, "
                    + "curvaF06 = ?, "
                    + "curvaF07 = ?, "
                    + "curvaF08 = ?, "
                    + "curvaF09 = ?, "
                    + "curvaF10 = ?, "
                    + "curvaF11 = ?, "
                    + "curvaF12 = ?, "
                    + "curvaF13 = ?, "
                    + "curvaF14 = ?, "
                    + "curvaU01 = ?, "
                    + "curvaU02 = ?, "
                    + "curvaU03 = ?, "
                    + "curvaU04 = ?, "
                    + "curvaU05 = ?, "
                    + "curvaU06 = ?, "
                    + "curvaU07 = ?, "
                    + "curvaU08 = ?, "
                    + "curvaU09 = ?, "
                    + "curvaU10 = ?, "
                    + "curvaU11 = ?, "
                    + "curvaU12 = ?, "
                    + "curvaU13 = ?, "
                    + "curvaU14 = ?, "
                    + "tipoReceita = ?, "
                    + "codigoFabricante = ?, "
                    + "usoContinuo = ?, "
                    + "custoMedio = ?, "
                    + "codigoCompra = ?, "
                    + "grupoCompra = ?, "
                    + "comissaoValor = ?, "
                    + "comissaoPercentual = ? "
                    + "where "
                    + "codigo = ? ";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setString(1, p.getDeletado());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getLaboratorio());
            stmt.setString(5, p.getDepartamento());
            stmt.setString(6, p.getClasse());
            stmt.setInt(7, p.getHospitalar());
            stmt.setString(8, p.getEan1());
            stmt.setString(9, p.getEan2());
            stmt.setString(10, p.getDataCadastroString());
            stmt.setString(11, p.getDataAlteracaoString());
            stmt.setDouble(12, p.getPrecoCusto());
            stmt.setDouble(13, p.getPrecoVenda());
            stmt.setDouble(14, p.getDesconto());
            stmt.setDouble(15, p.getDescontoMaximo());
            stmt.setInt(16, p.getQuant01());
            stmt.setInt(17, p.getQuant02());
            stmt.setInt(18, p.getQuant03());
            stmt.setInt(19, p.getQuant04());
            stmt.setInt(20, p.getQuant05());
            stmt.setInt(21, p.getQuant06());
            stmt.setInt(22, p.getQuant07());
            stmt.setInt(23, p.getQuant08());
            stmt.setInt(24, p.getQuant09());
            stmt.setInt(25, p.getQuant10());
            stmt.setInt(26, p.getQuant11());
            stmt.setInt(27, p.getQuant12());
            stmt.setInt(28, p.getQuant13());
            stmt.setInt(29, p.getQuant14());
            stmt.setInt(30, p.getQuantDep());
            stmt.setString(31, p.getCurvaValor01());
            stmt.setString(32, p.getCurvaValor02());
            stmt.setString(33, p.getCurvaValor03());
            stmt.setString(34, p.getCurvaValor04());
            stmt.setString(35, p.getCurvaValor05());
            stmt.setString(36, p.getCurvaValor06());
            stmt.setString(37, p.getCurvaValor07());
            stmt.setString(38, p.getCurvaValor08());
            stmt.setString(39, p.getCurvaValor09());
            stmt.setString(40, p.getCurvaValor10());
            stmt.setString(41, p.getCurvaValor11());
            stmt.setString(42, p.getCurvaValor12());
            stmt.setString(43, p.getCurvaValor13());
            stmt.setString(44, p.getCurvaValor14());
            stmt.setString(45, p.getCurvaVolume01());
            stmt.setString(46, p.getCurvaVolume02());
            stmt.setString(47, p.getCurvaVolume03());
            stmt.setString(48, p.getCurvaVolume04());
            stmt.setString(49, p.getCurvaVolume05());
            stmt.setString(50, p.getCurvaVolume06());
            stmt.setString(51, p.getCurvaVolume07());
            stmt.setString(52, p.getCurvaVolume08());
            stmt.setString(53, p.getCurvaVolume09());
            stmt.setString(54, p.getCurvaVolume10());
            stmt.setString(55, p.getCurvaVolume11());
            stmt.setString(56, p.getCurvaVolume12());
            stmt.setString(57, p.getCurvaVolume13());
            stmt.setString(58, p.getCurvaVolume14());
            stmt.setString(59, p.getTipoReceita());
            stmt.setString(60, p.getCodigoFabricante());
            stmt.setString(61, p.getUsoContinuo());
            stmt.setDouble(62, p.getCustoMedio());
            stmt.setString(63, p.getCodigoGrupoCompra());
            stmt.setString(64, p.getGrupoCompra());
            stmt.setDouble(65, p.getComissaoValor());
            stmt.setDouble(66, p.getComissaoPercentual());
            stmt.setString(67, p.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Produtos> listaProdutosLandA(Date data) {
        try {
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement("select "
                    + "sr_recno, "
                    + "sr_deleted, "
                    + "codigo, "
                    + "descricao, "
                    + "fabricante, "
                    + "departamento, "
                    + "classe, "
                    + "quantHospitalar, "
                    + "ean13, "
                    + "ean132, "
                    + "custo, "
                    + "venda, "
                    + "descontoPadrao, "
                    + "descontoMaximo, "
                    + "coalesce(dataCadastro, '1900-01-01') as dataCadastro, "
                    + "coalesce(dataAlteracao, '1900-01-01') as dataAlteracao, "
                    + "est01, "
                    + "est02, "
                    + "est03, "
                    + "est04, "
                    + "est05, "
                    + "est06, "
                    + "est07, "
                    + "est08, "
                    + "est09, "
                    + "estDep, "
                    + "mediaVenda01, "
                    + "mediaVenda02, "
                    + "mediaVenda03, "
                    + "mediaVenda04, "
                    + "mediaVenda05, "
                    + "mediaVenda06, "
                    + "mediaVenda07, "
                    + "mediaVenda08, "
                    + "mediaVenda09, "
                    + "curvaF01, "
                    + "curvaF02, "
                    + "curvaF03, "
                    + "curvaF04, "
                    + "curvaF05, "
                    + "curvaF06, "
                    + "curvaF07, "
                    + "curvaF08, "
                    + "curvaF09, "
                    + "curvaU01, "
                    + "curvaU02, "
                    + "curvaU03, "
                    + "curvaU04, "
                    + "curvaU05, "
                    + "curvaU06, "
                    + "curvaU07, "
                    + "curvaU08, "
                    + "curvaU09, "
                    + "coalesce(ultimaVenda01, '1900-01-01') as ultimaVenda01, "
                    + "coalesce(ultimaVenda02, '1900-01-01') as ultimaVenda02, "
                    + "coalesce(ultimaVenda03, '1900-01-01') as ultimaVenda03, "
                    + "coalesce(ultimaVenda04, '1900-01-01') as ultimaVenda04, "
                    + "coalesce(ultimaVenda05, '1900-01-01') as ultimaVenda05, "
                    + "coalesce(ultimaVenda06, '1900-01-01') as ultimaVenda06, "
                    + "coalesce(ultimaVenda07, '1900-01-01') as ultimaVenda07, "
                    + "coalesce(ultimaVenda08, '1900-01-01') as ultimaVenda08, "
                    + "coalesce(ultimaVenda09, '1900-01-01') as ultimaVenda09, "
                    + "coalesce(ultimaCompra01, '1900-01-01') as ultimaCompra01, "
                    + "coalesce(ultimaCompra02, '1900-01-01') as ultimaCompra02, "
                    + "coalesce(ultimaCompra03, '1900-01-01') as ultimaCompra03, "
                    + "coalesce(ultimaCompra04, '1900-01-01') as ultimaCompra04, "
                    + "coalesce(ultimaCompra05, '1900-01-01') as ultimaCompra05, "
                    + "coalesce(ultimaCompra06, '1900-01-01') as ultimaCompra06, "
                    + "coalesce(ultimaCompra07, '1900-01-01') as ultimaCompra07, "
                    + "coalesce(ultimaCompra08, '1900-01-01') as ultimaCompra08, "
                    + "coalesce(ultimaCompra09, '1900-01-01') as ultimaCompra09, "
                    + "coalesce(ultimaCompra10, '1900-01-01') as ultimaCompra10, "
                    + "minimo01, "
                    + "minimo02, "
                    + "minimo03, "
                    + "minimo04, "
                    + "minimo05, "
                    + "minimo06, "
                    + "minimo07, "
                    + "minimo08, "
                    + "minimo09, "
                    + "maximo01, "
                    + "maximo02, "
                    + "maximo03, "
                    + "maximo04, "
                    + "maximo05, "
                    + "maximo06, "
                    + "maximo07, "
                    + "maximo08, "
                    + "maximo09 "
                    + "from "
                    + "produtos "
                    + "where "
                    + "dataAlteracao >= ?");
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produtos f = new Produtos();
                f.setRecno(rs.getString("sr_recno"));
                f.setDeletado(rs.getString("sr_deleted"));
                f.setCodigo(rs.getString("codigo"));
                f.setDescricao(rs.getString("descricao"));
                f.setLaboratorio(rs.getString("fabricante"));
                f.setDepartamento(rs.getString("departamento"));
                f.setClasse(rs.getString("classe"));
                f.setHospitalar(rs.getInt("quantHospitalar"));
                f.setEan1(rs.getString("ean13"));
                f.setEan2(rs.getString("ean132"));
                f.setPrecoCusto(rs.getDouble("custo"));
                f.setPrecoVenda(rs.getDouble("venda"));
                f.setDesconto(rs.getDouble("descontoPadrao"));
                f.setDescontoMaximo(rs.getDouble("descontoMaximo"));
                f.setDataCadastro(rs.getDate("dataCadastro"));
                f.setDataAlteracao(rs.getDate("dataAlteracao"));
                f.setQuant01(rs.getInt("est01"));
                f.setQuant02(rs.getInt("est02"));
                f.setQuant03(rs.getInt("est03"));
                f.setQuant04(rs.getInt("est04"));
                f.setQuant05(rs.getInt("est05"));
                f.setQuant06(rs.getInt("est06"));
                f.setQuant07(rs.getInt("est07"));
                f.setQuant08(rs.getInt("est08"));
                f.setQuant09(rs.getInt("est09"));
                f.setQuantDep(rs.getInt("estDep"));
                f.setMediaVenda01(rs.getInt("mediaVenda01"));
                f.setMediaVenda02(rs.getInt("mediaVenda02"));
                f.setMediaVenda03(rs.getInt("mediaVenda03"));
                f.setMediaVenda04(rs.getInt("mediaVenda04"));
                f.setMediaVenda05(rs.getInt("mediaVenda05"));
                f.setMediaVenda06(rs.getInt("mediaVenda06"));
                f.setMediaVenda07(rs.getInt("mediaVenda07"));
                f.setMediaVenda08(rs.getInt("mediaVenda08"));
                f.setMediaVenda09(rs.getInt("mediaVenda09"));
                f.setCurvaValor01(rs.getString("curvaF01"));
                f.setCurvaValor02(rs.getString("curvaF02"));
                f.setCurvaValor03(rs.getString("curvaF03"));
                f.setCurvaValor04(rs.getString("curvaF04"));
                f.setCurvaValor05(rs.getString("curvaF05"));
                f.setCurvaValor06(rs.getString("curvaF06"));
                f.setCurvaValor07(rs.getString("curvaF07"));
                f.setCurvaValor08(rs.getString("curvaF08"));
                f.setCurvaValor09(rs.getString("curvaF09"));
                f.setCurvaVolume01(rs.getString("curvaU01"));
                f.setCurvaVolume02(rs.getString("curvaU02"));
                f.setCurvaVolume03(rs.getString("curvaU03"));
                f.setCurvaVolume04(rs.getString("curvaU04"));
                f.setCurvaVolume05(rs.getString("curvaU05"));
                f.setCurvaVolume06(rs.getString("curvaU06"));
                f.setCurvaVolume07(rs.getString("curvaU07"));
                f.setCurvaVolume08(rs.getString("curvaU08"));
                f.setCurvaVolume09(rs.getString("curvaU09"));
                f.setUltimaCompra01(rs.getDate("ultimaCompra01"));
                f.setUltimaCompra02(rs.getDate("ultimaCompra02"));
                f.setUltimaCompra03(rs.getDate("ultimaCompra03"));
                f.setUltimaCompra04(rs.getDate("ultimaCompra04"));
                f.setUltimaCompra05(rs.getDate("ultimaCompra05"));
                f.setUltimaCompra06(rs.getDate("ultimaCompra06"));
                f.setUltimaCompra07(rs.getDate("ultimaCompra07"));
                f.setUltimaCompra08(rs.getDate("ultimaCompra08"));
                f.setUltimaCompra09(rs.getDate("ultimaCompra09"));
                f.setUltimaCompra10(rs.getDate("ultimaCompra10"));
                f.setMaximo01(rs.getInt("maximo01"));
                f.setMaximo02(rs.getInt("maximo02"));
                f.setMaximo03(rs.getInt("maximo03"));
                f.setMaximo04(rs.getInt("maximo04"));
                f.setMaximo05(rs.getInt("maximo05"));
                f.setMaximo06(rs.getInt("maximo06"));
                f.setMaximo07(rs.getInt("maximo07"));
                f.setMaximo08(rs.getInt("maximo08"));
                f.setMaximo09(rs.getInt("maximo09"));
                f.setMinimo01(rs.getInt("minimo01"));
                f.setMinimo02(rs.getInt("minimo02"));
                f.setMinimo03(rs.getInt("minimo03"));
                f.setMinimo04(rs.getInt("minimo04"));
                f.setMinimo05(rs.getInt("minimo05"));
                f.setMinimo06(rs.getInt("minimo06"));
                f.setMinimo07(rs.getInt("minimo07"));
                f.setMinimo08(rs.getInt("minimo08"));
                f.setMinimo09(rs.getInt("minimo09"));
                f.setUltimaVenda01(rs.getDate("ultimaVenda01"));
                f.setUltimaVenda02(rs.getDate("ultimaVenda02"));
                f.setUltimaVenda03(rs.getDate("ultimaVenda03"));
                f.setUltimaVenda04(rs.getDate("ultimaVenda04"));
                f.setUltimaVenda05(rs.getDate("ultimaVenda05"));
                f.setUltimaVenda06(rs.getDate("ultimaVenda06"));
                f.setUltimaVenda07(rs.getDate("ultimaVenda07"));
                f.setUltimaVenda08(rs.getDate("ultimaVenda08"));
                f.setUltimaVenda09(rs.getDate("ultimaVenda09"));

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            System.out.println(stmt.getUpdateCount());
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaAnavendSemArea() {
        try {
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement("select "
                    + "a.sr_recno, "
                    + "a.depar, "
                    + "b.descArea "
                    + "from "
                    + "ven_anavend a, "
                    + "departamentos b "
                    + "where "
                    + "b.nome = a.depar "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.deletado <> 'T'"
                    + "and "
                    + "a.area is null");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produtos f = new Produtos();
                f.setRecno(rs.getString("sr_recno"));
                f.setArea(rs.getString("descArea"));

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            System.out.println(stmt.getUpdateCount());
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaAreaAnavend(Produtos p) {
        try {
            sql = "update "
                    + "ven_anavend  "
                    + "set "
                    + "area = ? "
                    + "where "
                    + "sr_recno = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setString(1, p.getArea());
            stmt.setString(2, p.getRecno());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void atualizaLaboratorios() {
        try {
            sql = "update alqui a inner join lab b set a.ccodlab = b.codigo where b.nome = a.nlab and a.ccodlab is null and a.sr_deleted = '' and b.sr_deleted = ''";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update produtos set molecula = '' where molecula is null";
            stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set cfilial01 = null, cfilial02 = null, cfilial03 = null, cfilial04 = null, cfilial05 = null, cfilial06 = null, cfilial07 = null, cfilial08 = null, cfilial09 = null, cfilial10 = null,  cfilial11 = null, cfilial12 = null, cfilial13 = null, cfilial14 = null, cfilialal = null, calmoxa = null where cdesc like '@%'";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set cfilial01 = null, cfilial02 = null, cfilial03 = null, cfilial04 = null, cfilial05 = null, cfilial06 = null, cfilial07 = null, cfilial08 = null, cfilial09 = null, cfilial10 = null,  cfilial11 = null, cfilial12 = null, cfilial13 = null, cfilial14 = null, cfilialal = null, calmoxa = null where ndep like 'consumo%'";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void acertaCustoMedio() {
        try {
            sql = "update alqui set custmed01 = ccusto where custmed01 = cvenda";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed02 = ccusto where custmed02 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed03 = ccusto where custmed03 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed04 = ccusto where custmed04 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed05 = ccusto where custmed05 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed06 = ccusto where custmed06 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed07 = ccusto where custmed07 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed08 = ccusto where custmed08 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update alqui set custmed09 = ccusto where custmed09 = cvenda";
            stmt = this.conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "delete from entrega where data = curdate()";
            stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Venda> listaVendasTempoReal() {
        try {
            sql = "SELECT "
                    + "loc, "
                    + "data, "
                    + "EXTRACT(HOUR FROM hora) AS hora, "
                    + "COUNT(DISTINCT ndc) AS atendimentos, "
                    + "SUM(valor2) AS valor "
                    + "FROM "
                    + "ven_resumocaixa "
                    + "WHERE "
                    + "data = CURDATE() "
                    + "AND "
                    + "oper = 'E' "
                    + "AND "
                    + "codigo = '---P---' "
                    + "GROUP BY "
                    + "loc, "
                    + "data, "
                    + "EXTRACT(HOUR FROM hora)";
            List<Venda> arrayList = new ArrayList<Venda>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaVendasTempoReal(): " + rs.getStatement());

            while (rs.next()) {
                Venda x = new Venda();

                x.setLoja(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setHora(rs.getString("hora"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setValorCupom(rs.getDouble("valor"));

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

    public List<Venda> listaVendasTempoRealPeriodo() {
        try {
            sql = "SELECT "
                    + "loc, "
                    + "data, "
                    + "EXTRACT(HOUR FROM hora) AS hora, "
                    + "COUNT(DISTINCT ndc) AS atendimentos, "
                    + "SUM(valor2) AS valor "
                    + "FROM "
                    + "ven_resumocaixa "
                    + "WHERE "
                    + "data BETWEEN (DATE_SUB(CURDATE(), INTERVAL 3 MONTH)) AND CURDATE() "
                    + "AND "
                    + "oper = 'E' "
                    + "AND "
                    + "codigo = '---P---' "
                    + "GROUP BY "
                    + "loc, "
                    + "data, "
                    + "EXTRACT(HOUR FROM hora)";
            List<Venda> arrayList = new ArrayList<Venda>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaVendasTempoReal(): " + rs.getStatement());

            while (rs.next()) {
                Venda x = new Venda();

                x.setLoja(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setHora(rs.getString("hora"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setValorCupom(rs.getDouble("valor"));

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

    public List<Perdas> listaPerdas(Date dataI, Date dataF) {

        try {
            sql = "select "
                    + "a.locper, "
                    + "a.codigo, "
                    + "sum(a.qtd) as qtd, "
                    + "sum(a.mont) as mont "
                    + "from "
                    + "perdas a "
                    + "where "
                    + "a.data between ? and ? "
                    + "and "
                    + "a.codcau = 'VCT' "
                    + "group by "
                    + "a.locper, "
                    + "a.codigo";
            List<Perdas> arrayList = new ArrayList<Perdas>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {

                Perdas x = new Perdas();

                x.setLoja(rs.getString("locper"));
                x.setCodigo(rs.getString("codigo"));
                x.setQuantidade(rs.getInt("qtd"));
                x.setValor(rs.getDouble("mont"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Entrada> listaVencimentos(String loja) {
        try {
            sql = "select "
                    + "a.sr_recno, "
                    + "a.codiprod, "
                    + "a.descprod, "
                    + "a.quanprod, "
                    + "a.numelote, "
                    + "a.datavenc, "
                    + "a.quanlote, "
                    + "a.numelot2, "
                    + "a.dataven2, "
                    + "a.quanlot2, "
                    + "a.numelot3, "
                    + "a.dataven3, "
                    + "a.quanlot3, "
                    + "a.numelot4, "
                    + "a.dataven4, "
                    + "a.quanlot4, "
                    + "a.numelot5, "
                    + "a.dataven5, "
                    + "a.quanlot5, "
                    + "b.clascodi "
                    + "from "
                    + "notapro a, "
                    + "alqui b, "
                    + "alqent c "
                    + "where "
                    + "b.ccodigo = a.codiprod "
                    + "and "
                    + "c.codinota = a.codinota "
                    + "and "
                    + "c.filial = ? "
                    + "and "
                    + "(a.datavenc <= (curdate() + INTERVAL 90 DAY) or a.dataven2 <= (curdate() + INTERVAL 90 DAY) or a.dataven3 <= (curdate() + INTERVAL 90 DAY) or a.dataven4 <= (curdate() + INTERVAL 90 DAY) or a.dataven5 <= (curdate() + INTERVAL 90 DAY)) "
                    + "and "
                    + "a.datavenc >= curdate() "
                    + "and "
                    + "coalesce(b.cfilial" + loja + ", 0) > 0 "
                    + "and "
                    + "c.entrsaid = 'E' "
                    + "and "
                    + "coalesce(c.codidest, '') <> 'AL' "
                    + "and "
                    + "c.dentre  >= (curdate() - INTERVAL 365 DAY) "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "and "
                    + "c.sr_deleted = '' "
                    + "order by "
                    + "a.datavenc";
            List<Entrada> arrayList = new ArrayList<Entrada>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                Entrada x = new Entrada();

                x.setRecno(rs.getString("sr_recno"));
                x.setCodigo(rs.getString("codiprod"));
                x.setDescricao(rs.getString("descprod"));
                x.setClasse(rs.getString("clascodi"));
                x.setQuantidade(rs.getInt("quanprod"));
                x.setLote1(rs.getString("numelote"));
                x.setVencimentoLote1(rs.getDate("datavenc"));
                x.setQuantidadeLote1(rs.getInt("quanlote"));
                x.setLote2(rs.getString("numelot2"));
                x.setVencimentoLote2(rs.getDate("dataven2"));
                x.setQuantidadeLote2(rs.getInt("quanlot2"));
                x.setLote3(rs.getString("numelot3"));
                x.setVencimentoLote3(rs.getDate("dataven3"));
                x.setQuantidadeLote3(rs.getInt("quanlot3"));
                x.setLote4(rs.getString("numelot4"));
                x.setVencimentoLote4(rs.getDate("dataven4"));
                x.setQuantidadeLote4(rs.getInt("quanlot4"));
                x.setLote5(rs.getString("numelot5"));
                x.setVencimentoLote5(rs.getDate("dataven5"));
                x.setQuantidadeLote5(rs.getInt("quanlot5"));
                x.setLoja(loja);

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravaVencimentoEntrada(Entrada x) throws SQLException {
        try {
            String sql = "insert ignore into "
                    + "est_vencimentosentrada "
                    + "(sr_recno, "
                    + "codiprod, "
                    + "descprod, "
                    + "quanprod, "
                    + "numelote, "
                    + "datavenc, "
                    + "quanlote, "
                    + "numelot2, "
                    + "dataven2, "
                    + "quanlot2, "
                    + "numelot3, "
                    + "dataven3, "
                    + "quanlot3, "
                    + "numelot4, "
                    + "dataven4, "
                    + "quanlot4, "
                    + "numelot5, "
                    + "dataven5, "
                    + "quanlot5, "
                    + "loja, "
                    + "classe) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            System.out.println(sql);

            stmt.setString(1, x.getRecno());
            stmt.setString(2, x.getCodigo());
            stmt.setString(3, x.getDescricao());
            stmt.setInt(4, x.getQuantidade());
            stmt.setString(5, x.getLote1());
            if (x.getVencimentoLote1() != null) {
                stmt.setDate(6, new java.sql.Date(x.getVencimentoLote1().getTime()));
            } else {
                stmt.setString(6, null);
            }
            stmt.setInt(7, x.getQuantidadeLote1());
            stmt.setString(8, x.getLote2());
            if (x.getVencimentoLote2() != null) {
                stmt.setDate(9, new java.sql.Date(x.getVencimentoLote2().getTime()));
            } else {
                stmt.setString(9, null);
            }
            stmt.setInt(10, x.getQuantidadeLote2());
            stmt.setString(11, x.getLote3());
            if (x.getVencimentoLote3() != null) {
                stmt.setDate(12, new java.sql.Date(x.getVencimentoLote3().getTime()));
            } else {
                stmt.setString(12, null);
            }
            stmt.setInt(13, x.getQuantidadeLote3());
            stmt.setString(14, x.getLote4());
            if (x.getVencimentoLote4() != null) {
                stmt.setDate(15, new java.sql.Date(x.getVencimentoLote4().getTime()));
            } else {
                stmt.setString(15, null);
            }
            stmt.setInt(16, x.getQuantidadeLote4());
            stmt.setString(17, x.getLote5());
            if (x.getVencimentoLote5() != null) {
                stmt.setDate(18, new java.sql.Date(x.getVencimentoLote5().getTime()));
            } else {
                stmt.setString(18, null);
            }
            stmt.setInt(19, x.getQuantidadeLote5());
            stmt.setString(20, x.getLoja());
            stmt.setString(21, x.getClasse());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void informaPerdas(String loja, Perdas x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "vencido" + loja + " = ?,"
                    + "unVencido" + loja + " = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            System.out.println(sql);

            stmt.setDouble(1, x.getValor());
            stmt.setInt(2, x.getQuantidade());
            stmt.setString(3, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaProdutosRecCaixa() {
        try {
            sql = "select "
                    + "a.codigo "
                    + "from "
                    + "ven_bonificados a";
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaProdutosRecCaixa(): " + rs.getStatement());

            while (rs.next()) {

                Produtos f = new Produtos();

                f.setCodigo(rs.getString("codigo"));

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaDadosRecCaixa(String codigo) {
        try {
            sql = "select "
                    + "a.codigo, "
                    + "a.descricao, "
                    + "a.fabricante, "
                    + "a.custo, "
                    + "a.venda, "
                    + "a.descontoPadrao, "
                    + "a.venda - (a.venda * (coalesce(descontoPadrao, 0)/100)) as liquido "
                    + "from "
                    + "produtos a "
                    + "where "
                    + "a.codigo = ?";
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaDadosRecCaixa(): " + rs.getStatement());

            while (rs.next()) {

                Produtos f = new Produtos();
                f.setCodigo(rs.getString("codigo"));
                f.setDescricao(rs.getString("descricao"));
                f.setLaboratorio(rs.getString("fabricante"));
                f.setPrecoCusto(rs.getDouble("custo"));
                f.setPrecoVenda(rs.getDouble("venda"));
                f.setDesconto(rs.getDouble("descontoPadrao"));
                f.setPrecoFinal(rs.getDouble("liquido"));

                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaProdutosRecCaixa(Produtos x) throws SQLException {
        try {
            String sql = "update "
                    + "ven_bonificados "
                    + "set "
                    + "descricao = ?, "
                    + "fabricante = ?, "
                    + "custo = ?, "
                    + "venda = ?, "
                    + "desconto = ?, "
                    + "precoFinal = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            System.out.println(sql);

            stmt.setString(1, x.getDescricao());
            stmt.setString(2, x.getLaboratorio());
            stmt.setDouble(3, x.getPrecoCusto());
            stmt.setDouble(4, x.getPrecoVenda());
            stmt.setDouble(5, x.getDesconto());
            stmt.setDouble(6, x.getPrecoFinal());
            stmt.setString(7, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> relacionaVendasBonificadosCaixa() {
        try {
            sql = "select "
                    + "a.sr_recno, "
                    + "a.loc, "
                    + "a.data, "
                    + "a.ndc, "
                    + "a.resp, "
                    + "a.codigo, "
                    + "a.qt, "
                    + "a.valor5, "
                    + "a.valor2, "
                    + "a.hora, "
                    + "b.cvenda - (b.cvenda * (coalesce(descp, 0)/100)) as valorProduto, "
                    + "a.oper "
                    + "from "
                    + "mov a, "
                    + "alqui b "
                    + "where "
                    + "b.ccodigo = a.codigo "
                    + "and "
                    + "a.codigo in (" + criterio + ") "
                    + "and "
                    + "a.oper not in ('K', 'G', 'R', 'F', 'C')";
            List<Mov> pd = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov f = new Mov();
//                f.setSr_recno(rs.getString("sr_recno"));
                f.setLoc(rs.getString("loc"));
                f.setData(rs.getDate("data"));
                f.setResp(rs.getString("resp"));
                f.setQt(rs.getInt("qt"));
                f.setValor5(rs.getDouble("valor5"));
                f.setValor2(rs.getDouble("valor2"));
                f.setNdc(rs.getString("ndc"));
                f.setCodigo(rs.getString("codigo"));
                f.setValor6(rs.getDouble("valorProduto"));
                f.setOper(rs.getString("oper"));
                f.setHora(rs.getString("hora"));

                //              registraBonificadosVendidos(f);
                // Adicionando o objeto à lista
                pd.add(f);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void zeraPrecoFidelidade() throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "fidelidade01 = null, "
                    + "fidelidade02 = null, "
                    + "fidelidade03 = null, "
                    + "fidelidade04 = null, "
                    + "fidelidade05 = null, "
                    + "fidelidade06 = null, "
                    + "fidelidade07 = null, "
                    + "fidelidade08 = null, "
                    + "fidelidade09 = null, "
                    + "fidelidade10 = null, "
                    + "fidelidade11 = null, "
                    + "fidelidade12 = null, "
                    + "fidelidade13 = null, "
                    + "fidelidade14 = null";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaFidelidadeProdutos() {
        try {
            sql = "select "
                    + "d.codifili, "
                    + "a.ccodigo, "
                    + "a.cvenda, "
                    + "a.descp, "
                    + "a.codigfid, "
                    + "b.nomegfid, "
                    + "e.nomegrup, "
                    + "c.taxadesc "
                    + "from "
                    + "alqui a, "
                    + "cadagfid b, "
                    + "policond c, "
                    + "polifili d, "
                    + "poligrup e "
                    + "where "
                    + "b.codigfid = a.codigfid "
                    + "and "
                    + "c.codigfid = b.codigfid "
                    + "and "
                    + "d.codigfid = b.codigfid "
                    + "and "
                    + "d.codigrup = c.codigrup "
                    + "and "
                    + "e.codigrup = c.codigrup "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "and "
                    + "c.sr_deleted = '' "
                    + "and "
                    + "d.sr_deleted = '' "
                    + "and "
                    + "e.sr_deleted = ''";
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaFidelidadeProdutos(): " + rs.getStatement());

            while (rs.next()) {
                Produtos x = new Produtos();

                x.setLoja(rs.getString("codifili"));
                x.setCodigo(rs.getString("ccodigo"));
                x.setPrecoVenda(rs.getDouble("cvenda"));
                x.setDesconto(rs.getDouble("descp"));
                x.setCodigoFidelidade(rs.getString("codigfid"));
                x.setGrupoFidelidade(rs.getString("nomegfid"));
                x.setListaFidelidade(rs.getString("nomegrup"));
                x.setDescontoFidelidade(rs.getDouble("taxadesc"));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void zeraPrecosListas() throws SQLException {
        try {
            String sql = "update produtos set precoWloja = null, precoAppSite = null";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaPrecoWloja() {
        try {
            sql = "select "
                    + "codigo, "
                    + "preco "
                    + "from "
                    + "arqlista "
                    + "where "
                    + "sr_deleted = '' "
                    + "and "
                    + "codlis = '050'";
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPrecoWloja(): " + rs.getStatement());

            while (rs.next()) {
                Produtos x = new Produtos();

                x.setCodigo(rs.getString("codigo"));
                x.setPrecoVenda(rs.getDouble("preco"));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void gravaPrecoWloja(Produtos x) throws SQLException {
        try {
            String sql = "update produtos set precoWloja = ? where codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setDouble(1, x.getPrecoVenda());
            stmt.setString(2, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produtos> listaPrecoAppSite() {
        try {
            sql = "select "
                    + "codigo, "
                    + "preco - (preco * (coalesce(desconto, 0) / 100)) as preco "
                    + "from "
                    + "arqlista "
                    + "where "
                    + "sr_deleted = '' "
                    + "and "
                    + "codlis = '144'";
            List<Produtos> pd = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPrecoAppSite(): " + rs.getStatement());

            while (rs.next()) {
                Produtos x = new Produtos();

                x.setCodigo(rs.getString("codigo"));
                x.setPrecoVenda(rs.getDouble("preco"));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void gravaPrecoAppSite(Produtos x) throws SQLException {
        try {
            String sql = "update produtos set precoAppSite = ? where codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setDouble(1, x.getPrecoVenda());
            stmt.setString(2, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravaPrecoFidelidade(Produtos x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "fidelidade" + x.getLoja() + " = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setDouble(1, x.getDescontoFidelidade());
            stmt.setString(2, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fechaConexao() {
        try {
            this.conexaoConsys.close();
            this.conexaoLanda.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
