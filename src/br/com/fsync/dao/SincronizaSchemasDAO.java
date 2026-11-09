package br.com.fsync.dao;

import br.com.fsync.objetos.PedidoTelefone;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcus Luiz
 */
public class SincronizaSchemasDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA;
    public String sql;
    public String criterio;
    public int registros;
    public int registrosIgnorados;

    // Construtor da classe VendaDao
    public SincronizaSchemasDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    public void atualizaStatusWlojaCerto() throws SQLException, ParseException {
        try {
            sql = "ALTER TABLE entrega CONVERT TO CHARACTER SET latin1 COLLATE 'latin1_general_ci'";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update ignore "
                    + "ent_pedidos a "
                    + "inner join "
                    + "entrega b "
                    + "set "
                    + "a.status = b.status, "
                    + "a.nomcli = b.nomcli, "
                    + "a.telcli = b.telcli, "
                    + "a.filial = b.filial, "
                    + "a.entregador = b.entregador, "
                    + "a.canal = b.canalent, "
                    + "a.horaped = b.horaped, "
                    + "a.horasep = b.horasep, "
                    + "a.horaret = b.horaret, "
                    + "a.horasai = b.horasai, "
                    + "a.poloent = b.poloent, "
                    + "a.separador = b.separador, "
                    + "a.valor = b.total, "
                    + "a.matriculaWloja = b.entregador "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "a.data >= date_add(curdate(), interval -3 day)";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            /*sql = "update ignore "
                    + "ent_pedidos a "
                    + "inner join "
                    + "ent_telawloja b "
                    + "set "
                    + "a.status = b.situacao, "
                    + "a.nomcli = b.cliente, "
                    + "a.entregador = substring(b.entregador, 1, 4), "
                    + "a.horaped = b.horapedido, "
                    + "a.horasep = b.horaseparacao, "
                    + "a.horaret = b.horaretorno, "
                    + "a.horasai = b.horasaida, "
                    + "a.poloent = b.polo, "
                    + "a.valor = b.valorPedido, "
                    + "a.matriculaWloja = substring(b.entregador, 1, 4) "
                    + "where "
                    + "b.pedido = a.ndc "
                    + "and "
                    + "a.data "
                    + "between ? and ?";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));

            stmt.execute();
            stmt.close();*/
            sql = "update ignore "
                    + "ent_pedidos a "
                    + "inner join "
                    + "ent_pedido b "
                    + "set "
                    + "a.nomcli = b.nomcli, "
                    + "a.telcli = b.telcli, "
                    + "a.status = b.status, "
                    + "a.filial = b.filial, "
                    + "a.entregador = b.entregador, "
                    + "a.horaped = b.horaped, "
                    + "a.horasep = b.horasep, "
                    + "a.horaret = b.horaret, "
                    + "a.horasai = b.horasai, "
                    + "a.poloent = b.polo, "
                    + "a.separador = b.separador, "
                    + "a.matriculaWloja = (select matriculaWloja from funcionarios where codigo = b.entregador) "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "a.data >= date_add(curdate(), interval -3 day) "
                    + "and "
                    + "b.filial in ('02', '03', '04', '05', '09', '10', '12', '14')";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            /*sql = "update ent_pedidos set filial = '07' where filial = '05' and ndc like '00%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update ent_pedido set status = '5' where filial in ('05', '09') and data >= '20200401'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();*/
 /* Comentado em 14/11/2021
            sql = "delete from ent_pedidos where telcli is null and data between ? and ?";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));

            stmt.execute();
            stmt.close();*/
            sql = "update funcionarios set conta = null, agencia = null where conta = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update "
                    + "ent_pedidos "
                    + "set "
                    + "status = '5' "
                    + "where "
                    + "filial in ('02', '03', '04', '05', '09', '10', '12', '14') "
                    + "and "
                    + "coalesce(horasai, '') <> '' "
                    + "and "
                    + "coalesce(entregador, '') <> '' "
                    + "and "
                    + "status not in ('0', '5', '8') "
                    + "and "
                    + "data <> curdate()";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update "
                    + "ent_pedido "
                    + "set "
                    + "status = '5' "
                    + "where "
                    + "filial in ('02', '03', '04', '05', '09', '10', '12', '14') "
                    + "and "
                    + "coalesce(horasai, '') <> '' "
                    + "and "
                    + "coalesce(entregador, '') <> '' "
                    + "and "
                    + "status not in ('0', '5', '8') "
                    + "and "
                    + "data <> curdate()";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update entrega set filial = '01' where filial = '02' and ndc not like '02%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '01' where filial = '02' and ndc not like '02%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedido set filial = '01' where filial = '02' and ndc not like '02%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update entrega set filial = '07' where filial = '05' and ndc not like '05%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '07' where filial = '05' and ndc not like '05%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedido set filial = '07' where filial = '05' and ndc not like '05%'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set status = '5' where filial in ('05', '09') and data between '20210522' and '20210523'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedido set status = '5' where filial in ('05', '09') and data between '20210522' and '20210523'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update ent_pedidos set status = '5' where filial = ('14') and data between '20220919' and '20220921'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update ent_pedido set status = '5' where filial = ('14') and data between '20220919' and '20220921'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set matriculaWloja = '0574' where matriculaWloja = '0573'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set matriculaWloja = '0579' where matriculaWloja = '0584'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set matriculaWloja = '0578' where matriculaWloja = '0583'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedido set status = '5' where filial = '10' and data between '20210731' and '20210910'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set status = '5' where filial = '10' and data between '20210731' and '20210910'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos a inner join ent_telawloja b set a.entregador = substring(b.entregador, 1, 4), a.matriculawloja = substring(b.entregador, 1, 4) where b.pedido = a.ndc and b.data >= date_add(curdate(), interval -3 day)";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set matriculawloja = entregador where filial in ('01', '06', '07', '08', '11')";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '01' where filial <> '01' and poloent = '1' and ndc like '00%' and compreRetire = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '07' where filial <> '07' and poloent = '2' and ndc like '00%' and compreRetire = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '06' where filial <> '06' and poloent = '3' and ndc like '00%' and compreRetire = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '08' where filial <> '08' and poloent = '4' and ndc like '00%' and compreRetire = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update ent_pedidos set filial = '11' where filial <> '11' and poloent = '5' and ndc like '00%' and compreRetire = '0'";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "delete from ent_pedidos where data >= date_add(curdate(), interval -3 day) and filial in ('01', '07', '06', '08', '11') and ndc not like '00%'";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            registrosIgnorados = registrosIgnorados + 1;
            throw new RuntimeException(ex);
        }
    }

    public void deletaSemLojaBI() throws SQLException, ParseException {
        try {
            sql = "delete from bi_entregas where loja is null";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            registrosIgnorados = registrosIgnorados + 1;
            throw new RuntimeException(ex);
        }
    }

    public List<PedidoTelefone> listaPedidosWlojaCerto() {
        try {
            sql = "SELECT "
                    + "poloent, "
                    + "filial, "
                    + "ndc, "
                    + "data, "
                    + "total, "
                    + "status, "
                    + "canalent, "
                    + "pdvret "
                    + "FROM "
                    + "entrega "
                    + "where "
                    + "data >= date_add(curdate(), interval -3 day) "
                    + "order by "
                    + "data desc";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                if (rs.getString("poloent").equals("1 - BP")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2 - VR")) {
                    x.setLoja("07");
                } else if (rs.getString("poloent").equals("3 - MENDES")) {
                    x.setLoja("06");
                } else if (rs.getString("poloent").equals("4 - BM")) {
                    x.setLoja("08");
                } else if (rs.getString("poloent").equals("5 - RETIRO")) {
                    x.setLoja("11");
                }
                if (rs.getString("poloent").equals("1")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2")) {
                    x.setLoja("07");
                } else if (rs.getString("poloent").equals("3")) {
                    x.setLoja("06");
                } else if (rs.getString("poloent").equals("4")) {
                    x.setLoja("08");
                } else if (rs.getString("poloent").equals("5")) {
                    x.setLoja("11");
                }
                x.setMeioCompra(rs.getString("canalent"));
                x.setValor(rs.getDouble("total"));
                x.setNdc(rs.getString("ndc"));
                x.setStatus(rs.getString("status"));
                x.setLocalRetirada(rs.getString("pdvret"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosWlojaCsv(Date dataI, Date dataF) {
        try {
            sql = "SELECT "
                    + "polo, "
                    + "pedido, "
                    + "data, "
                    + "valorPedido, "
                    + "situacao "
                    + "FROM "
                    + "ent_telaWloja "
                    + "where "
                    + "data between ? and ?";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();

                if (rs.getString("polo").equals("1")) {
                    x.setLoja("01");
                } else if (rs.getString("polo").equals("2")) {
                    x.setLoja("07");
                } else if (rs.getString("polo").equals("3")) {
                    x.setLoja("06");
                } else if (rs.getString("polo").equals("4")) {
                    x.setLoja("08");
                } else if (rs.getString("polo").equals("5")) {
                    x.setLoja("11");
                }
                x.setValor(rs.getDouble("valorPedido"));
                x.setNdc(rs.getString("pedido"));
                x.setStatus(rs.getString("situacao"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Altera o status do pedido para 9 NA BASE DO WEBTELE. Indica que o pedido esta pronto para ser expedido
    public void inserePedido(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "insert ignore into ent_pedidos "
                    + "(filial, data, valor, ndc, entregador, status, horaped, canal, compreRetire) values "
                    + "(?, ?, ?, ?, ?, '5', ?, ?, ?)";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setString(1, p.getLoja());
            stmt.setString(2, p.getDataString());
            stmt.setDouble(3, p.getValor());
            stmt.setString(4, p.getNdc());
            stmt.setString(5, p.getEntregador());
            //stmt.setString(6, p.getStatus());
            stmt.setString(6, p.getHoraPedido());
            stmt.setString(7, p.getMeioCompra());
            stmt.setString(8, p.getLocalRetirada());

            stmt.execute();
            stmt.close();

            registros = registros + 1;
        } catch (SQLException ex) {
            registrosIgnorados = registrosIgnorados + 1;
            throw new RuntimeException(ex);
        }
    }

    public void alteraStatus(Date dataI, Date dataF) throws SQLException, ParseException {
        try {
            sql = "update ent_pedidos set status = '5' where status = '1' and data between ? and ?";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            System.out.println(stmt.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            registrosIgnorados = registrosIgnorados + 1;
            throw new RuntimeException(ex);
        }
    }

    public void importaWloja() throws SQLException, ParseException {
        try {
            sql = "LOAD DATA LOCAL INFILE 'C:/conscubo/teste.csv' "
                    + "INTO TABLE ent_wloja "
                    + "FIELDS TERMINATED BY ';' "
                    + "LINES TERMINATED BY '\n' "
                    + "IGNORE 1 LINES";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "LOAD DATA LOCAL INFILE 'C:/conscubo/teste2.csv' "
                    + "INTO TABLE ent_wloja "
                    + "FIELDS TERMINATED BY ';' "
                    + "LINES TERMINATED BY '\n' "
                    + "IGNORE 1 LINES";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            /*sql = "LOAD DATA LOCAL INFILE 'C:/conscubo/teste3.csv' "
                    + "INTO TABLE ent_wloja "
                    + "FIELDS TERMINATED BY ';' "
                    + "LINES TERMINATED BY '\n' "
                    + "IGNORE 1 LINES";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();*/
            sql = "update ent_wloja set valor = replace(valor, '$', '')";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update ent_wloja set valor = replace(valor, ',', '.')";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update ent_wloja set taxa = replace(taxa, ',', '.');";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update ent_wloja set total = replace(total, ',', '.');";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update ent_wloja set data = concat(substring(dataStr, 7, 4), '-', substring(dataStr, 4, 2), '-', substring(dataStr, 1, 2));";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "delete from ent_wloja where pedido like '%total%';";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "delete from ent_wloja where pedido = '';";
            stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            registrosIgnorados = registrosIgnorados + 1;
            throw new RuntimeException(ex);
        }
    }

    public List<PedidoTelefone> listaPedidosCheck() {
        try {
            sql = "SELECT "
                    + "ndc, "
                    + "data, "
                    + "filial, "
                    + "valor, "
                    + "entregador, "
                    + "pagok, "
                    + "horaped "
                    + "FROM "
                    + "histent "
                    + "where "
                    + "data >= date_add(curdate(), interval -3 day) "
                    + "order by "
                    + "data desc";
            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();
                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valor"));
                x.setNdc(rs.getString("ndc"));
                x.setEntregador(rs.getString("entregador"));
                x.setHoraPedido(rs.getString("horaped"));

                if (rs.getString("pagok").equals("P")) {
                    x.setStatus("5");
                } else {
                    x.setStatus(rs.getString("pagok"));
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public List<PedidoTelefone> listaPedidosWebtele(Date dataI, Date dataF) {
        try {
            sql = "SELECT "
                    + "filial, "
                    + "ndc, "
                    + "data, "
                    + "coalesce(poloent, '1') as poloent, "
                    + "total, "
                    + "entregador, "
                    + "status, "
                    + "horaped "
                    + "FROM "
                    + "entrega "
                    + "where "
                    + "data between ? and ? ";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoWebtele.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaPedidosWebtele:" + rs.getStatement());

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();
                x.setLoja(rs.getString("filial"));
                if (rs.getString("poloent").equals("1 - BP")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2 - VR")) {
                    x.setLoja("07");
                } else if (rs.getString("poloent").equals("3 - MENDES")) {
                    x.setLoja("06");
                } else if (rs.getString("poloent").equals("4 - BM")) {
                    x.setLoja("08");
                }
                if (rs.getString("poloent").equals("1")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2")) {
                    x.setLoja("07");
                } else if (rs.getString("poloent").equals("3")) {
                    x.setLoja("06");
                } else if (rs.getString("poloent").equals("4")) {
                    x.setLoja("08");
                }

                x.setValor(rs.getDouble("total"));
                x.setNdc(rs.getString("ndc"));
                x.setEntregador(rs.getString("entregador"));
                x.setStatus(rs.getString("status"));
                x.setHoraPedido(rs.getString("horaped"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
    public List<PedidoTelefone> listaPedidosWloja(Date dataI, Date dataF) {
        try {
            sql = "SELECT "
                    + "poloent, "
                    + "filial, "
                    + "ndc, "
                    + "data, "
                    + "valor, "
                    + "status "
                    + "FROM "
                    + "ent_wloja "
                    + "where "
                    + "data between ? and ?";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                if (rs.getString("poloent").equals("1 - BP")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2 - VR")) {
                    x.setLoja("07");
                } else {
                    x.setLoja("06");
                }
                x.setValor(rs.getDouble("valor"));
                x.setNdc(rs.getString("pedido"));
                x.setStatus(rs.getString("status"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                inserePedido(x);

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public List<PedidoTelefone> listaPedidosWebtele07(Date dataI, Date dataF) {
        try {
            sql = "SELECT "
                    + "ndc, "
                    + "data, "
                    + "poloent, "
                    + "valor, "
                    + "entregador, "
                    + "status, "
                    + "horaped "
                    + "FROM "
                    + "entrega "
                    + "where "
                    + "data between ? and ? ";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoWebtele.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("WT07:" + rs.getStatement());

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();
                if (rs.getString("poloent").equals("1")) {
                    x.setLoja("01");
                } else if (rs.getString("poloent").equals("2")) {
                    x.setLoja("07");
                }

                x.setValor(rs.getDouble("valor"));
                x.setNdc(rs.getString("ndc"));
                x.setEntregador(rs.getString("entregador"));
                x.setStatus(rs.getString("status"));
                x.setHoraPedido(rs.getString("horaped"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                inserePedido(x);

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (ParseException | SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

 /*public List<PedidoTelefone> listaPedidosWebteleZ(Date dataI, Date dataF, String loja) {
        try {
            sql = "SELECT "
                    + "loja, "
                    + "ndc, "
                    + "data, "
                    + "valor, "
                    + "entregador, "
                    + "status, "
                    + "horaped "
                    + "FROM "
                    + "zentrega "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "loja = ?";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoWebtele.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone x = new PedidoTelefone();

                x.setValor(rs.getDouble("valor"));
                x.setNdc(rs.getString("ndc"));
                x.setEntregador(rs.getString("entregador"));
                x.setStatus(rs.getString("status"));
                x.setHoraPedido(rs.getString("horaped"));
                x.setLoja(rs.getString("loja"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                x.setDataString(sdf.format((rs.getDate("data"))));

                inserePedido(x);

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (ParseException | SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    public List<PedidoTelefone> listaPedidosRegiaoMovBP() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0)) as valorVenda "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '01' "
                    + "and "
                    + "substr(ndc, 3,2) = '31' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "oper = 'E' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosRegiaoMovBM() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0)) as valorVenda "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '08' "
                    + "and "
                    + "substr(ndc, 3,2) = '07' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "oper = 'E' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosRegiaoMovM() {
        try {
            String sql = sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0)) as valorVenda "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '06' "
                    + "and "
                    + "substr(ndc, 3,2) = '14' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "oper = 'E' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosRegiaoMovVR() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0)) as valorVenda "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '07' "
                    + "and "
                    + "substr(ndc, 3,2) = '05' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "oper = 'E' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaDevolucaoPedidosRegiaoMovBP() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0) * coalesce(qt, 0)) as valorDevolucao "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '01' "
                    + "and "
                    + "substr(ndc, 3,2) = '31' "
                    + "and "
                    + "oper = 'A' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorDevolucao"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaDevolucaoPedidosRegiaoMovBM() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0) * coalesce(qt, 0)) as valorDevolucao "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '08' "
                    + "and "
                    + "substr(ndc, 3,2) = '07' "
                    + "and "
                    + "oper = 'A' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorDevolucao"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaDevolucaoPedidosRegiaoMovM() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0) * coalesce(qt, 0)) as valorDevolucao "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '06' "
                    + "and "
                    + "substr(ndc, 3,2) = '14' "
                    + "and "
                    + "oper = 'A' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorDevolucao"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaDevolucaoPedidosRegiaoMovVR() {
        try {
            String sql = "select "
                    + "loc as filial, "
                    + "data, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(coalesce(valor2,0) * coalesce(qt, 0)) as valorDevolucao "
                    + "from "
                    + "mov a "
                    + "where "
                    + "data = curdate() - 3 "
                    + "and "
                    + "loc = '07' "
                    + "and "
                    + "substr(ndc, 3,2) = '05' "
                    + "and "
                    + "oper = 'A' "
                    + "group by "
                    + "data "
                    + "order by "
                    + "data";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorDevolucao"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (x.getLoja() != null) {
                    arrayList.add(x);
                }
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosBIWloja(String canal) {
        try {
            String sql = "select "
                    + "data, "
                    + "filial, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(valor) as valor "
                    + "from "
                    + "ent_pedidos "
                    + "where "
                    + "data >= date_add(curdate(), interval -3 day) "
                    + "and "
                    + "status = '5' "
                    + "and "
                    + "coalesce(canal, '0') like ? "
                    + "group by "
                    + "data, "
                    + "filial "
                    + "order by "
                    + "data desc";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setString(1, canal);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valor"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                arrayList.add(x);
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosBIWhatsapp() {
        try {
            String sql = "select "
                    + "a.filial, "
                    + "a.data, "
                    + "count(distinct a.ndc) as atendimentos, "
                    + "sum(coalesce(a.valor, 0)) as valor "
                    + "from "
                    + "ent_pedidos a, "
                    + "ent_whatsapp b "
                    + "where "
                    + "b.observacao = cast(a.ndc as unsigned) "
                    + "and "
                    + "a.data >= date_add(curdate(), interval -1 day) "
                    + "group by "
                    + "data, "
                    + "filial "
                    + "order by "
                    + "filial";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valor"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                arrayList.add(x);
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosSiteAppMov(Date dataI, Date dataF, String canal) {
        try {
            String sql = "select "
                    + "data, "
                    + "loc, "
                    + "count(distinct ndc) as atendimentos, "
                    + "sum(valor2) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "resp = ? "
                    + "group by "
                    + "data, "
                    + "loc";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, canal);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setLoja(rs.getString("loc"));
                x.setValor(rs.getDouble("valor"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                arrayList.add(x);
            }

            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoTelefone> listaPedidosUpdateLocaweb(Date dataI, Date dataF) {
        try {
            String sql = "select "
                    + "data, "
                    + "filial, "
                    + "sum(valor) as valor, "
                    + "count(*) as atendimentos "
                    + "from "
                    + "ent_pedidos "
                    + "where "
                    + "status = '5' "
                    + "and "
                    + "data between ? and ? "
                    + "group by "
                    + "data, "
                    + "filial";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();

                x.setData(rs.getDate("data"));
                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda") - rs.getDouble("valorDevolucoes"));
                x.setAtendimentos(rs.getInt("atendimentos") - rs.getInt("devolucoes"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void gravaPedidoBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "insert ignore into bi_entregas "
                    + "(data, loja, valor, atendimentos) values "
                    + "(?, ?, ?, ?)";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setString(2, p.getLoja());
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getAtendimentos());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void gravaPedidoAppBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "insert ignore into bi_entregas "
                    + "(data, loja, valorApp, atendimentosApp) values "
                    + "(?, ?, ?, ?)";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setString(2, p.getLoja());
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getAtendimentos());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void gravaPedidoWhatsappBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "insert ignore into bi_entregas "
                    + "(data, loja, valorWhatsapp, atendimentosWhatsapp) values "
                    + "(?, ?, ?, ?)";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setString(2, p.getLoja());
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getAtendimentos());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void gravaPedidoSiteBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "insert ignore into bi_entregas "
                    + "(data, loja, valorSite, atendimentosSite) values "
                    + "(?, ?, ?, ?)";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setString(2, p.getLoja());
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getAtendimentos());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atualizaEntregaBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "update ignore "
                    + "bi_entregas "
                    + "set "
                    + "valor = ?, "
                    + "atendimentos = ?, "
                    + "valorDevolucao = 0, "
                    + "devolucoes = 0 "
                    + "where "
                    + "data  = ? "
                    + "and "
                    + "loja = ?";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDouble(1, p.getValor());
            stmt.setInt(2, p.getAtendimentos());
            stmt.setDate(3, new java.sql.Date(p.getData().getTime()));
            stmt.setString(4, p.getLoja());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atualizaAppBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "update ignore "
                    + "bi_entregas "
                    + "set "
                    + "valorApp = ?, "
                    + "atendimentosApp = ?, "
                    + "valorDevolucao = 0, "
                    + "devolucoes = 0 "
                    + "where "
                    + "data  = ? "
                    + "and "
                    + "loja = ?";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDouble(1, p.getValor());
            stmt.setInt(2, p.getAtendimentos());
            stmt.setDate(3, new java.sql.Date(p.getData().getTime()));
            stmt.setString(4, p.getLoja());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void atualizaWhatsappBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "update ignore "
                    + "bi_entregas "
                    + "set "
                    + "valorWhatsapp = ?, "
                    + "atendimentosWhatsapp = ?, "
                    + "valorDevolucao = 0, "
                    + "devolucoes = 0 "
                    + "where "
                    + "data  = ? "
                    + "and "
                    + "loja = ?";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDouble(1, p.getValor());
            stmt.setInt(2, p.getAtendimentos());
            stmt.setDate(3, new java.sql.Date(p.getData().getTime()));
            stmt.setString(4, p.getLoja());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atualizaSiteBI(PedidoTelefone p) throws SQLException, ParseException {
        try {
            sql = "update ignore "
                    + "bi_entregas "
                    + "set "
                    + "valorSite = ?, "
                    + "atendimentosSite = ?, "
                    + "valorDevolucao = 0, "
                    + "devolucoes = 0 "
                    + "where "
                    + "data  = ? "
                    + "and "
                    + "loja = ?";

            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            //System.out.println(sql);
            System.out.println(stmt.toString());

            stmt.setDouble(1, p.getValor());
            stmt.setInt(2, p.getAtendimentos());
            stmt.setDate(3, new java.sql.Date(p.getData().getTime()));
            stmt.setString(4, p.getLoja());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
