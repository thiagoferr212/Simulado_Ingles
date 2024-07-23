import cadastro.Cadastro;
import entity.Usuario;

public class Simulado {
    public static void main(String[] args) throws Exception {
        
        Usuario u = new Usuario();
        u.setNome("Thiago");
        u.setSobrenome("Ferreira");
        u.setEmail("thiago@gmail.com");
        u.setSenha("1234");

        new Cadastro().cadastroUsuario(u);
    }
}
