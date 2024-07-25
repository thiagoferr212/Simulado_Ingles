package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Verbo;


public class VerboDAO {

    public Verbo buscarVerbo(){
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Verbo verbo = null;

        try{
            connection = Conexao.getConexao();
            String sql = "SELECT id_verbo, verbo FROM t_verbo ORDER BY RAND() LIMIT 1";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                verbo = new Verbo();
                verbo.setIdVerbo(resultSet.getInt("id_verbo"));
                verbo.setVerbo(resultSet.getString("verbo"));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        // Bloco finally garante que os recursos sejam fechados, independentemente
        // de uma exceção ter ocorrido ou não.
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return verbo;
    }

    public List<String> buscarTraducao(int idVerbo){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> verbosTraducao = new ArrayList<>();

        try{
            connection = Conexao.getConexao();
            String sql = "SELECT verbo_traducao FROM t_verbo_traducao WHERE id_verbo = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idVerbo);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                verbosTraducao.add(resultSet.getString("verbo_traducao"));                                
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return verbosTraducao;
    }
    
    public Verbo buscarVerbosIrregulares(int idVerbo){
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Verbo verbosIrregulares = null;

        try{
            connection = Conexao.getConexao();
            String sql = "SELECT verbo_preterito_perfeito, verbo_participio_passado " +
                     "FROM t_verbo_participio_passado ps, t_verbo_preterito_perfeito pf " +
                     "WHERE ps.id_verbo = pf.id_verbo AND ps.id_verbo = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idVerbo);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                verbosIrregulares = new Verbo();
                verbosIrregulares.setVerboPreteritoPerfeito(resultSet.getString("verbo_preterito_perfeito"));
                verbosIrregulares.setVerboParticipioPassado(resultSet.getString("verbo_participio_passado"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return verbosIrregulares;
    }
}
