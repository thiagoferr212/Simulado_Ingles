package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Verbo;

public class VerboDAO {

    public Verbo getVerboAleatorio(){
        Verbo verbo = null;
        String sql = "SELECT verbo FROM t_verbo ORDER BY RAND() LIMIT 1";

        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                verbo = new Verbo();
                verbo.setVerbo(rs.getString("verbo"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verbo;

    }

    public boolean validarTraducao(String verboTraducao, String respostaUsuario) {
        String sql = "SELECT verbo_traducao FROM t_verbo_traducao WHERE id_verbo = (SELECT id_verbo FROM t_verbo WHERE verbo = ?)";
        boolean estaCerto = false;

        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, verboTraducao);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String traducaoCorreta = rs.getString("verbo_traducao");
                estaCerto = traducaoCorreta.equals(respostaUsuario);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
           e.printStackTrace();
        }

        return estaCerto;
    }
    
}
