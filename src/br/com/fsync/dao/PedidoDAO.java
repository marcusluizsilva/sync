package br.com.fsync.dao;

import br.com.fsync.objetos.Pedido;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcus
 */
public class PedidoDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLanda;

    // Construtor da classe VendaDao
    public PedidoDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLanda = CriaConexaoLanda.getConexao();
    }

    // Declaração de variáveis
    public String sql;
    public int itens;
    public static String atualiza = "LA";

    public List<Pedido> listaPosicaoEstoque() {
        itens = 0;
        try {
            List<Pedido> pd = new ArrayList<Pedido>();
            sql = "select "
                    + "a.ccodigo, "
                    + "a.cfilial01, "
                    + "a.cfilial02, "
                    + "a.cfilial03, "
                    + "a.cfilial04, "
                    + "a.cfilial05, "
                    + "a.cfilial06, "
                    + "a.cfilial07, "
                    + "a.cfilial08, "
                    + "a.cfilial09, "
                    + "a.cfilial10, "
                    + "a.cfilial11, "
                    + "a.cfilial12, "
                    + "a.cfilial13, "
                    + "a.cfilial14, "
                    + "a.calmoxa "
                    + "from "
                    + "alqui a "
                    + "where "
                    + "a.sr_deleted = ''";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Pedido p = new Pedido();

                p.setCodigo(rs.getString("ccodigo"));
                p.setEstoque01(rs.getInt("cfilial01"));
                p.setEstoque02(rs.getInt("cfilial02"));
                p.setEstoque03(rs.getInt("cfilial03"));
                p.setEstoque04(rs.getInt("cfilial04"));
                p.setEstoque05(rs.getInt("cfilial05"));
                p.setEstoque06(rs.getInt("cfilial06"));
                p.setEstoque07(rs.getInt("cfilial07"));
                p.setEstoque08(rs.getInt("cfilial08"));
                p.setEstoque09(rs.getInt("cfilial09"));
                p.setEstoque10(rs.getInt("cfilial10"));
                p.setEstoque11(rs.getInt("cfilial11"));
                p.setEstoque12(rs.getInt("cfilial12"));
                p.setEstoque13(rs.getInt("cfilial13"));
                p.setEstoque14(rs.getInt("cfilial14"));
                p.setEstoqueDeposito(rs.getInt("calmoxa"));

                // Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> listaPosicaoEstoqueData() {
        try {
            List<Pedido> pd = new ArrayList<Pedido>();
            sql = "select distinct "
                    + "a.ccodigo, "
                    + "a.cfilial01, "
                    + "a.cfilial02, "
                    + "a.cfilial03, "
                    + "a.cfilial04, "
                    + "a.cfilial05, "
                    + "a.cfilial06, "
                    + "a.cfilial07, "
                    + "a.cfilial08, "
                    + "a.cfilial09, "
                    + "a.cfilial10, "
                    + "a.cfilial11, "
                    + "a.cfilial12, "
                    + "a.cfilial13, "
                    + "a.cfilial14, "
                    + "a.calmoxa "
                    + "from "
                    + "alqui a, "
                    + "mov b "
                    + "where "
                    + "b.codigo = a.ccodigo "
                    + "and "
                    + "b.data >= date_add(curdate(), interval -1 day) "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = ''";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Pedido p = new Pedido();

                p.setCodigo(rs.getString("ccodigo"));
                p.setEstoque01(rs.getInt("cfilial01"));
                p.setEstoque02(rs.getInt("cfilial02"));
                p.setEstoque03(rs.getInt("cfilial03"));
                p.setEstoque04(rs.getInt("cfilial04"));
                p.setEstoque05(rs.getInt("cfilial05"));
                p.setEstoque06(rs.getInt("cfilial06"));
                p.setEstoque07(rs.getInt("cfilial07"));
                p.setEstoque08(rs.getInt("cfilial08"));
                p.setEstoque09(rs.getInt("cfilial09"));
                p.setEstoque10(rs.getInt("cfilial10"));
                p.setEstoque11(rs.getInt("cfilial11"));
                p.setEstoque12(rs.getInt("cfilial12"));
                p.setEstoque13(rs.getInt("cfilial13"));
                p.setEstoque14(rs.getInt("cfilial14"));
                p.setEstoqueDeposito(rs.getInt("calmoxa"));

                // Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produtos> listaProdutosPBM(String status) {
        itens = 0;
        try {
            List<Produtos> pd = new ArrayList<Produtos>();
            sql = "select "
                    + "codiprod, "
                    + "codipbms, "
                    + "codiprog "
                    + "from "
                    + "pbmprod "
                    + "where "
                    + "sr_deleted = ?";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Produtos p = new Produtos();

                p.setCodigo(rs.getString("codiprod"));
                p.setCodigoPBM(rs.getString("codipbms"));
                p.setProgramaPBM(rs.getString("codiprog"));

                // Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> listaItensPendencia() {
        itens = 0;
        try {
            List<Pedido> pd = new ArrayList<Pedido>();
            sql = "select "
                    + "b.loc, "
                    + "b.codigo, "
                    + "sum(b.qt) as qt "
                    + "from "
                    + "fila a, "
                    + "mov b "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "a.pend = 'P' "
                    + "and "
                    + "b.codigo is not null "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "group by "
                    + "b.loc, "
                    + "b.codigo";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Pedido p = new Pedido();

                p.setLoja(rs.getString("loc"));
                p.setCodigo(rs.getString("codigo"));
                p.setQuant01(rs.getInt("qt"));

                atualizaPendencias(p);

                // Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaEstoques(Pedido x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
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
                    + "estDep = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setInt(1, x.getEstoque01());
            stmt.setInt(2, x.getEstoque02());
            stmt.setInt(3, x.getEstoque03());
            stmt.setInt(4, x.getEstoque04());
            stmt.setInt(5, x.getEstoque05());
            stmt.setInt(6, x.getEstoque06());
            stmt.setInt(7, x.getEstoque07());
            stmt.setInt(8, x.getEstoque08());
            stmt.setInt(9, x.getEstoque09());
            stmt.setInt(10, x.getEstoque10());
            stmt.setInt(11, x.getEstoque11());
            stmt.setInt(12, x.getEstoque12());
            stmt.setInt(13, x.getEstoque13());
            stmt.setInt(14, x.getEstoque14());
            stmt.setInt(15, x.getEstoqueDeposito());
            stmt.setString(16, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atualizaPendencias(Pedido x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "pendencia01 = ?, "
                    + "pendencia02 = ?, "
                    + "pendencia03 = ?, "
                    + "pendencia04 = ?, "
                    + "pendencia05 = ?, "
                    + "pendencia06 = ?, "
                    + "pendencia07 = ?, "
                    + "pendencia08 = ?, "
                    + "pendencia09 = ?, "
                    + "pendenciaCD = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = conexaoLanda.prepareStatement(sql);

            stmt.setInt(1, x.getEstoque01());
            stmt.setInt(2, x.getEstoque02());
            stmt.setInt(3, x.getEstoque03());
            stmt.setInt(4, x.getEstoque04());
            stmt.setInt(5, x.getEstoque05());
            stmt.setInt(6, x.getEstoque06());
            stmt.setInt(7, x.getEstoque07());
            stmt.setInt(8, x.getEstoque08());
            stmt.setInt(9, x.getEstoque09());
            stmt.setInt(10, x.getEstoqueDeposito());
            stmt.setString(11, x.getCodigo());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Pedido> selectCopven() {
        try {
            List<Pedido> pd = new ArrayList<Pedido>();
            sql = "select "
                    + "a.ccodigo, "
                    + "b.cdesc, "
                    + "coalesce(a.ultven01, '1900-01-01') as ultven01, "
                    + "coalesce(a.ultven02, '1900-01-01') as ultven02, "
                    + "coalesce(a.ultven03, '1900-01-01') as ultven03, "
                    + "coalesce(a.ultven04, '1900-01-01') as ultven04, "
                    + "coalesce(a.ultven05, '1900-01-01') as ultven05, "
                    + "coalesce(a.ultven06, '1900-01-01') as ultven06, "
                    + "coalesce(a.ultven07, '1900-01-01') as ultven07, "
                    + "coalesce(a.ultven08, '1900-01-01') as ultven08, "
                    + "coalesce(a.ultven09, '1900-01-01') as ultven09, "
                    + "coalesce(a.ultven10, '1900-01-01') as ultven10, "
                    + "coalesce(a.ultven11, '1900-01-01') as ultven11, "
                    + "coalesce(a.ultven12, '1900-01-01') as ultven12, "
                    + "coalesce(a.ultven13, '1900-01-01') as ultven13, "
                    + "coalesce(a.ultven14, '1900-01-01') as ultven14, "
                    + "coalesce(a.ultcom01, '1900-01-01') as ultcom01, "
                    + "coalesce(a.ultcom02, '1900-01-01') as ultcom02, "
                    + "coalesce(a.ultcom03, '1900-01-01') as ultcom03, "
                    + "coalesce(a.ultcom04, '1900-01-01') as ultcom04, "
                    + "coalesce(a.ultcom05, '1900-01-01') as ultcom05, "
                    + "coalesce(a.ultcom06, '1900-01-01') as ultcom06, "
                    + "coalesce(a.ultcom07, '1900-01-01') as ultcom07, "
                    + "coalesce(a.ultcom08, '1900-01-01') as ultcom08, "
                    + "coalesce(a.ultcom09, '1900-01-01') as ultcom09, "
                    + "coalesce(a.ultcom10, '1900-01-01') as ultcom10, "
                    + "coalesce(a.ultcom11, '1900-01-01') as ultcom11, "
                    + "coalesce(a.ultcom12, '1900-01-01') as ultcom12, "
                    + "coalesce(a.ultcom13, '1900-01-01') as ultcom13, "
                    + "coalesce(a.ultcom14, '1900-01-01') as ultcom14, "
                    + "coalesce(a.ultcomal, '1900-01-01') as ultcomal, "
                    + "b.cminfil01, "
                    + "b.cmaxfil01, "
                    + "b.cminfil02, "
                    + "b.cmaxfil02, "
                    + "b.cminfil03, "
                    + "b.cmaxfil03, "
                    + "b.cminfil04, "
                    + "b.cmaxfil04, "
                    + "b.cminfil05, "
                    + "b.cmaxfil05, "
                    + "b.cminfil06, "
                    + "b.cmaxfil06, "
                    + "b.cminfil07, "
                    + "b.cmaxfil07, "
                    + "b.cminfil08, "
                    + "b.cmaxfil08, "
                    + "b.cminfil09, "
                    + "b.cmaxfil09, "
                    + "b.cminfil10, "
                    + "b.cmaxfil10, "
                    + "b.cminfil11, "
                    + "b.cmaxfil11, "
                    + "b.cminfil12, "
                    + "b.cmaxfil12, "
                    + "b.cminfil13, "
                    + "b.cmaxfil13, "
                    + "b.cminfil14, "
                    + "b.cmaxfil14 "
                    + "from "
                    + "copven a, "
                    + "alqui b "
                    + "where "
                    + "b.ccodigo = a.ccodigo "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "and "
                    + "(ultven01 >= date_add(curdate(), interval -3 day) or "
                    + "ultven02 >= date_add(curdate(), interval -3 day) or "
                    + "ultven03 >= date_add(curdate(), interval -3 day) or "
                    + "ultven04 >= date_add(curdate(), interval -3 day) or "
                    + "ultven05 >= date_add(curdate(), interval -3 day) or "
                    + "ultven06 >= date_add(curdate(), interval -3 day) or "
                    + "ultven07 >= date_add(curdate(), interval -3 day) or "
                    + "ultven08 >= date_add(curdate(), interval -3 day) or "
                    + "ultven09 >= date_add(curdate(), interval -3 day) or "
                    + "ultven10 >= date_add(curdate(), interval -3 day) or "
                    + "ultven11 >= date_add(curdate(), interval -3 day) or "
                    + "ultven12 >= date_add(curdate(), interval -3 day) or "
                    + "ultven13 >= date_add(curdate(), interval -3 day) or "
                    + "ultven14 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom01 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom02 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom03 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom04 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom05 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom06 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom07 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom08 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom09 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom10 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom11 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom12 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom13 >= date_add(curdate(), interval -3 day) or "
                    + "ultcom14 >= date_add(curdate(), interval -3 day)) "
                    + "order by "
                    + "b.cdesc";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Pedido p = new Pedido();

                p.setCodigo(rs.getString("ccodigo"));
                p.setDescricao(rs.getString("cdesc"));
                p.setUltimaCompra01(rs.getDate("ultcom01"));
                p.setUltimaCompra02(rs.getDate("ultcom02"));
                p.setUltimaCompra03(rs.getDate("ultcom03"));
                p.setUltimaCompra04(rs.getDate("ultcom04"));
                p.setUltimaCompra05(rs.getDate("ultcom05"));
                p.setUltimaCompra06(rs.getDate("ultcom06"));
                p.setUltimaCompra07(rs.getDate("ultcom07"));
                p.setUltimaCompra08(rs.getDate("ultcom08"));
                p.setUltimaCompra09(rs.getDate("ultcom09"));
                p.setUltimaCompra10(rs.getDate("ultcom10"));
                p.setUltimaCompra11(rs.getDate("ultcom11"));
                p.setUltimaCompra12(rs.getDate("ultcom12"));
                p.setUltimaCompra13(rs.getDate("ultcom13"));
                p.setUltimaCompra14(rs.getDate("ultcom14"));
                p.setUltimaCompraDeposito(rs.getDate("ultcomal"));
                p.setUltimaVenda01(rs.getDate("ultven01"));
                p.setUltimaVenda02(rs.getDate("ultven02"));
                p.setUltimaVenda03(rs.getDate("ultven03"));
                p.setUltimaVenda04(rs.getDate("ultven04"));
                p.setUltimaVenda05(rs.getDate("ultven05"));
                p.setUltimaVenda06(rs.getDate("ultven06"));
                p.setUltimaVenda07(rs.getDate("ultven07"));
                p.setUltimaVenda08(rs.getDate("ultven08"));
                p.setUltimaVenda09(rs.getDate("ultven09"));
                p.setUltimaVenda10(rs.getDate("ultven10"));
                p.setUltimaVenda11(rs.getDate("ultven11"));
                p.setUltimaVenda12(rs.getDate("ultven12"));
                p.setUltimaVenda13(rs.getDate("ultven13"));
                p.setUltimaVenda14(rs.getDate("ultven14"));
                p.setMaximo01(rs.getInt("cmaxfil01"));
                p.setMaximo02(rs.getInt("cmaxfil02"));
                p.setMaximo03(rs.getInt("cmaxfil03"));
                p.setMaximo04(rs.getInt("cmaxfil04"));
                p.setMaximo05(rs.getInt("cmaxfil05"));
                p.setMaximo06(rs.getInt("cmaxfil06"));
                p.setMaximo07(rs.getInt("cmaxfil07"));
                p.setMaximo08(rs.getInt("cmaxfil08"));
                p.setMaximo09(rs.getInt("cmaxfil09"));
                p.setMaximo10(rs.getInt("cmaxfil10"));
                p.setMaximo11(rs.getInt("cmaxfil11"));
                p.setMaximo12(rs.getInt("cmaxfil12"));
                p.setMaximo13(rs.getInt("cmaxfil13"));
                p.setMaximo14(rs.getInt("cmaxfil14"));
                p.setMinimo01(rs.getInt("cminfil01"));
                p.setMinimo02(rs.getInt("cminfil02"));
                p.setMinimo03(rs.getInt("cminfil03"));
                p.setMinimo04(rs.getInt("cminfil04"));
                p.setMinimo05(rs.getInt("cminfil05"));
                p.setMinimo06(rs.getInt("cminfil06"));
                p.setMinimo07(rs.getInt("cminfil07"));
                p.setMinimo08(rs.getInt("cminfil08"));
                p.setMinimo09(rs.getInt("cminfil09"));
                p.setMinimo10(rs.getInt("cminfil10"));
                p.setMinimo11(rs.getInt("cminfil11"));
                p.setMinimo12(rs.getInt("cminfil12"));
                p.setMinimo13(rs.getInt("cminfil13"));
                p.setMinimo14(rs.getInt("cminfil14"));

                // Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaCopvenLandA(Pedido x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "ultimaCompra01 = ?, "
                    + "ultimaCompra02 = ?, "
                    + "ultimaCompra03 = ?, "
                    + "ultimaCompra04 = ?, "
                    + "ultimaCompra05 = ?, "
                    + "ultimaCompra06 = ?, "
                    + "ultimaCompra07 = ?, "
                    + "ultimaCompra08 = ?, "
                    + "ultimaCompra09 = ?, "
                    + "ultimaCompra10 = ?, "
                    + "ultimaCompra11 = ?, "
                    + "ultimaCompra12 = ?, "
                    + "ultimaCompra13 = ?, "
                    + "ultimaCompra14 = ?, "
                    + "ultimaCompraCD = ?, "
                    + "ultimaVenda01 = ?, "
                    + "ultimaVenda02 = ?, "
                    + "ultimaVenda03 = ?, "
                    + "ultimaVenda04 = ?, "
                    + "ultimaVenda05 = ?, "
                    + "ultimaVenda06 = ?, "
                    + "ultimaVenda07 = ?, "
                    + "ultimaVenda08 = ?, "
                    + "ultimaVenda09 = ?, "
                    + "ultimaVenda10 = ?, "
                    + "ultimaVenda11 = ?, "
                    + "ultimaVenda12 = ?, "
                    + "ultimaVenda13 = ?, "
                    + "ultimaVenda14 = ?, "
                    + "maximo01 = ?, "
                    + "maximo02 = ?, "
                    + "maximo03 = ?, "
                    + "maximo04 = ?, "
                    + "maximo05 = ?, "
                    + "maximo06 = ?, "
                    + "maximo07 = ?, "
                    + "maximo08 = ?, "
                    + "maximo09 = ?, "
                    + "maximo10 = ?, "
                    + "maximo11 = ?, "
                    + "maximo12 = ?, "
                    + "maximo13 = ?, "
                    + "maximo14 = ?, "
                    + "minimo01 = ?, "
                    + "minimo02 = ?, "
                    + "minimo03 = ?, "
                    + "minimo04 = ?, "
                    + "minimo05 = ?, "
                    + "minimo06 = ?, "
                    + "minimo07 = ?, "
                    + "minimo08 = ?, "
                    + "minimo09 = ?, "
                    + "minimo10 = ?, "
                    + "minimo11 = ?, "
                    + "minimo12 = ?, "
                    + "minimo13 = ?, "
                    + "minimo14 = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(x.getUltimaCompra01().getTime()));
            stmt.setDate(2, new java.sql.Date(x.getUltimaCompra02().getTime()));
            stmt.setDate(3, new java.sql.Date(x.getUltimaCompra03().getTime()));
            stmt.setDate(4, new java.sql.Date(x.getUltimaCompra04().getTime()));
            stmt.setDate(5, new java.sql.Date(x.getUltimaCompra05().getTime()));
            stmt.setDate(6, new java.sql.Date(x.getUltimaCompra06().getTime()));
            stmt.setDate(7, new java.sql.Date(x.getUltimaCompra07().getTime()));
            stmt.setDate(8, new java.sql.Date(x.getUltimaCompra08().getTime()));
            stmt.setDate(9, new java.sql.Date(x.getUltimaCompra09().getTime()));
            stmt.setDate(10, new java.sql.Date(x.getUltimaCompra10().getTime()));
            stmt.setDate(11, new java.sql.Date(x.getUltimaCompra11().getTime()));
            stmt.setDate(12, new java.sql.Date(x.getUltimaCompra12().getTime()));
            stmt.setDate(13, new java.sql.Date(x.getUltimaCompra13().getTime()));
            stmt.setDate(14, new java.sql.Date(x.getUltimaCompra14().getTime()));
            stmt.setDate(15, new java.sql.Date(x.getUltimaCompraDeposito().getTime()));
            stmt.setDate(16, new java.sql.Date(x.getUltimaVenda01().getTime()));
            stmt.setDate(17, new java.sql.Date(x.getUltimaVenda02().getTime()));
            stmt.setDate(18, new java.sql.Date(x.getUltimaVenda03().getTime()));
            stmt.setDate(19, new java.sql.Date(x.getUltimaVenda04().getTime()));
            stmt.setDate(20, new java.sql.Date(x.getUltimaVenda05().getTime()));
            stmt.setDate(21, new java.sql.Date(x.getUltimaVenda06().getTime()));
            stmt.setDate(22, new java.sql.Date(x.getUltimaVenda07().getTime()));
            stmt.setDate(23, new java.sql.Date(x.getUltimaVenda08().getTime()));
            stmt.setDate(24, new java.sql.Date(x.getUltimaVenda09().getTime()));
            stmt.setDate(25, new java.sql.Date(x.getUltimaVenda10().getTime()));
            stmt.setDate(26, new java.sql.Date(x.getUltimaVenda11().getTime()));
            stmt.setDate(27, new java.sql.Date(x.getUltimaVenda12().getTime()));
            stmt.setDate(28, new java.sql.Date(x.getUltimaVenda13().getTime()));
            stmt.setDate(29, new java.sql.Date(x.getUltimaVenda14().getTime()));
            stmt.setInt(30, x.getMaximo01());
            stmt.setInt(31, x.getMaximo02());
            stmt.setInt(32, x.getMaximo03());
            stmt.setInt(33, x.getMaximo04());
            stmt.setInt(34, x.getMaximo05());
            stmt.setInt(35, x.getMaximo06());
            stmt.setInt(36, x.getMaximo07());
            stmt.setInt(37, x.getMaximo08());
            stmt.setInt(38, x.getMaximo09());
            stmt.setInt(39, x.getMaximo10());
            stmt.setInt(40, x.getMaximo11());
            stmt.setInt(41, x.getMaximo12());
            stmt.setInt(42, x.getMaximo13());
            stmt.setInt(43, x.getMaximo14());
            stmt.setInt(44, x.getMinimo01());
            stmt.setInt(45, x.getMinimo02());
            stmt.setInt(46, x.getMinimo03());
            stmt.setInt(47, x.getMinimo04());
            stmt.setInt(48, x.getMinimo05());
            stmt.setInt(49, x.getMinimo06());
            stmt.setInt(50, x.getMinimo07());
            stmt.setInt(51, x.getMinimo08());
            stmt.setInt(52, x.getMinimo09());
            stmt.setInt(53, x.getMinimo10());
            stmt.setInt(54, x.getMinimo11());
            stmt.setInt(55, x.getMinimo12());
            stmt.setInt(56, x.getMinimo13());
            stmt.setInt(57, x.getMinimo14());
            stmt.setString(58, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void informaPBM(Produtos x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "codigoPbm = ?, "
                    + "pbm = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setString(1, x.getCodigoPBM());
            stmt.setString(2, x.getProgramaPBM());
            stmt.setString(3, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
