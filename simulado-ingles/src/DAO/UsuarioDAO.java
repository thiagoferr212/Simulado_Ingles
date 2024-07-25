package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {

    public void cadastroUsuario(Usuario usuario){

        String sql = "INSERT INTO t_usuario (nome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
