package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // A variavel criada do banco de dados é local,
    // caso o banco seja alterado de local para remoto,
    // não esquecer de fazer a alteração da variavel url.
    private static final String url = "jdbc:,mysql://localhost:3306/simulado_ingles";
    private static final String user = "root";
    private static final String password = "1234";

    // criação do objeto Connection (para realizar a conexão)
    // objeto utilizado pela importação da classe java.sql.Connection
    private static Connection conn;

    // metodo para fazer a verificação da conexao,
    // se ela já foi estanciada alguma vez ou não.
    public static Connection getConexao(){

        // caso ocorra algum erro de conexão o try catch dará uma tratativa para este erro
        // (ele informará que a variavel "conn" é null, com isso será feito o processo de
        // conexão novamente).
        try {
        // se a conexão não foi criada ocorre a solicitação dos dados
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else{
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

