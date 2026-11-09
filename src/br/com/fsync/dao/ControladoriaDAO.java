package br.com.fsync.dao;

import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Balanco;
import br.com.fsync.objetos.Clientes;
import br.com.fsync.objetos.ContasAPagar;
import br.com.fsync.objetos.ContasAReceber;
import br.com.fsync.objetos.Deposito;
import br.com.fsync.objetos.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcu
 */
public class ControladoriaDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA;

    // Construtor da classe VendaDao
    public ControladoriaDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    public List<Balanco> listaAnaliseDiariaBalanco(String loja) {
        try {
            List<Balanco> arrayList = new ArrayList<Balanco>();
            String sql = "select "
                    + "filial, "
                    + "data, "
                    + "COUNT(IF(codimoti is null, 1, NULL)) as naoAnalisado, "
                    + "count(if(codimoti is not null, 1, NULL)) as analisado "
                    + "from "
                    + "prodbal "
                    + "where "
                    + "data >= '20200101' "
                    + "and "
                    + "filial = ? "
                    + "group by "
                    + "filial, "
                    + "data "
                    + "order by "
                    + "data, "
                    + "filial";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaAnaliseDiariaBalanco(): " + rs.getStatement());

            while (rs.next()) {
                Balanco x = new Balanco();

                x.setLoja(rs.getString("filial"));
                x.setData(rs.getDate("data"));
                x.setItensNaoAnalisados(rs.getInt("naoAnalisado"));
                x.setItensAnalisados(rs.getInt("analisado"));

                if ((rs.getInt("naoAnalisado") != rs.getInt("analisado")) && (rs.getInt("naoAnalisado") != 0)) {
                    arrayList.add(x);
                }
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContasAPagar> listaContasPagar() {
        try {
            List<ContasAPagar> arrayList = new ArrayList<ContasAPagar>();
            String sql = "select "
                    + "filial, "
                    + "sum(valor) - sum(coalesce(descont, 0)) as valor "
                    + "from "
                    + "apagar "
                    + "where "
                    + "vencime = curdate() "
                    + "and "
                    + "sr_deleted = '' "
                    + "and "
                    + "status = '1' "
                    + "and "
                    + "pagame is null "
                    + "group by "
                    + "filial";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaContasPagar(): " + rs.getStatement());

            while (rs.next()) {
                ContasAPagar x = new ContasAPagar();

                x.setLoja(rs.getString("filial"));
                x.setValorAPagar(rs.getDouble("valor"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContasAReceber> listaContasReceber() {
        try {
            List<ContasAReceber> arrayList = new ArrayList<ContasAReceber>();
            String sql = "select "
                    + "filial, "
                    + "substr(codcli, 1, 1) as codcli, "
                    + "sum(valor) as valor "
                    + "from "
                    + "areceb "
                    + "where "
                    + "vencime = curdate() "
                    + "and "
                    + "fatu = '0' "
                    + "and "
                    + "sr_deleted = '' "
                    + "and "
                    + "filial <> 'AL' "
                    + "group by "
                    + "filial, "
                    + "substr(codcli, 1, 1) "
                    + "order by "
                    + "filial, "
                    + "substr(codcli, 1, 1)";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaContasReceber(): " + rs.getStatement());

            while (rs.next()) {
                ContasAReceber x = new ContasAReceber();

                x.setLoja(rs.getString("filial"));
                if (rs.getString("codcli").equals("C")) {
                    x.setConta("CARTÃO");
                } else if (rs.getString("codcli").equals("K")) {
                    x.setConta("CONVÊNIO");
                } else {
                    x.setConta("CHEQUE");
                }
                x.setValor(rs.getDouble("valor"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContasAReceber> listaConveniosEmAberto() {
        try {
            List<ContasAReceber> arrayList = new ArrayList<ContasAReceber>();
            String sql = "select "
                    + "vencime as data, "
                    + "substr(cliente, 16) as cliente, "
                    + "valor "
                    + "from "
                    + "areceb "
                    + "where "
                    + "codcli like 'k%' "
                    + "and "
                    + "pagame is null "
                    + "and "
                    + "fatu = '0' "
                    + "and "
                    + "sr_deleted = '' "
                    + "and "
                    + "codcli not in ('401', '402', '403', '404', '405', '423', '435', '458', '461', '472', '476') "
                    + "and "
                    + "vencime is not null "
                    + "and "
                    + "vencime < curdate() "
                    + "group by "
                    + "cliente, "
                    + "vencime "
                    + "order by "
                    + "cliente, "
                    + "vencime";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaConveniosEmAberto(): " + rs.getStatement());

            while (rs.next()) {
                ContasAReceber x = new ContasAReceber();

                x.setVencimento(rs.getDate("data"));
                x.setConta(rs.getString("cliente"));
                x.setValor(rs.getDouble("valor"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Deposito> listaDepositosLoja() throws SQLException {
        try {
            String sql = "select "
                    + "a.loc, "
                    + "sum(a.valor1) as valor "
                    + "from "
                    + "mov a "
                    + "where "
                    + "a.data = DATE_ADD(CURDATE(), INTERVAL -1 DAY) "
                    + "and "
                    + "a.oper = 'T' "
                    + "and "
                    + "extract(hour from hora) >= 12 "
                    + "group by "
                    + "a.loc "
                    + "order by "
                    + "a.loc";

            List<Deposito> arrayList = new ArrayList<Deposito>();
            System.out.println(sql);
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaDepositosLoja(): " + rs.getStatement());

            while (rs.next()) {

                Deposito x = new Deposito();

                x.setLoja(rs.getString("loc"));
                x.setValorDinheiro(rs.getDouble("valor"));

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

    public List<Clientes> listaPrevisaoCrediario() {
        try {
            String sql = "select "
                    + "a.filial, "
                    + "sum(qt * valor) as valor "
                    + "from "
                    + "clientes a, "
                    + "vecli b "
                    + "where "
                    + "b.codcli = a.codigo "
                    + "and "
                    + "a.codconv = '000' "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "and "
                    + "DATE_ADD(b.data, INTERVAL a.mdias DAY) = curdate() "
                    + "group by "
                    + "a.filial "
                    + "order by "
                    + "a.filial";
            List<Clientes> arrayList = new ArrayList<Clientes>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPrevisaoCrediario(): " + rs.getStatement());

            while (rs.next()) {

                Clientes x = new Clientes();
                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valor"));

                arrayList.add(x);

                // Adicionando o objeto à lista
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Clientes> listaCrediarioAtraso() {
        try {
            String sql = "select "
                    + "coalesce(a.filial, '01') as filial, "
                    + "sum(qt * valor) as valor "
                    + "from "
                    + "clientes a, "
                    + "vecli b "
                    + "where "
                    + "b.codcli = a.codigo "
                    + "and "
                    + "a.codconv = '000' "
                    + "and "
                    + "a.sr_deleted = '' "
                    + "and "
                    + "b.sr_deleted = '' "
                    + "and "
                    //+ "DATE_ADD(b.data, INTERVAL a.mdias DAY) between '2019-01-01' and DATE_ADD(CURDATE(), INTERVAL -1 DAY) "
                    + "DATE_ADD(b.data, INTERVAL a.mdias DAY) between DATE_ADD(CURDATE(), INTERVAL -5 YEAR) and DATE_ADD(CURDATE(), INTERVAL -1 DAY) "
                    + "group by "
                    + "coalesce(a.filial, '01') "
                    + "order by "
                    + "a.filial";
            List<Clientes> arrayList = new ArrayList<Clientes>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPrevisaoCrediario(): " + rs.getStatement());

            while (rs.next()) {

                Clientes x = new Clientes();
                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valor"));

                arrayList.add(x);

                // Adicionando o objeto à lista
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produtos> listaVencimentosProximos() {
        try {
            String sql = "SELECT "
                    + "a.loja, "
                    + "SUM(a.quantidade) AS quantidade, "
                    + "COUNT(DISTINCT a.codigo) AS itens, "
                    + "SUM(a.quantidade * b.custo) AS valor "
                    + "FROM "
                    + "est_vencimentos a, "
                    + "produtos b "
                    + "WHERE "
                    + "b.codigo = a.codigo "
                    + "AND "
                    + "a.vencimento BETWEEN DATE_ADD(CURDATE(), INTERVAL 30 DAY) AND DATE_ADD(CURDATE(), INTERVAL 120 DAY) "
                    + "GROUP BY "
                    + "a.loja "
                    + "ORDER BY "
                    + "a.loja";
            List<Produtos> arrayList = new ArrayList<Produtos>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPrevisaoCrediario(): " + rs.getStatement());

            while (rs.next()) {

                Produtos x = new Produtos();
                x.setLoja(rs.getString("loja"));
                x.setEstoque(rs.getInt("quantidade"));
                x.setQuant(rs.getInt("itens"));
                x.setPrecoCusto(rs.getDouble("valor"));

                arrayList.add(x);

                // Adicionando o objeto à lista
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
