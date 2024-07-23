package simulado;
import java.util.Scanner;

import DAO.UsuarioDAO;
import DAO.VerboDAO;
import entity.Usuario;
import entity.Verbo;

public class Simulado {
    public static void main(String[] args) throws Exception {
        
        Usuario u = new Usuario();
        u.setNome("Thiago");
        u.setSobrenome("Ferreira");
        u.setEmail("thiago@gmail.com");
        u.setSenha("1234");

        new UsuarioDAO().cadastroUsuario(u);

        // Lógica de recuperação e validação do verbo em inglês
        VerboDAO verboDAO = new VerboDAO();
        Verbo verbo = verboDAO.getVerboAleatorio();

        if (verbo != null) {
            System.out.println("Verbo em inglês: " + verbo.getVerbo());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a tradução: ");
            String respostaUsuario = scanner.nextLine();

            System.out.println(verbo.getVerbo());
            boolean estaCerto = verboDAO.validarTraducao(verbo.getVerbo(), respostaUsuario);

            if (estaCerto) {
                System.out.println("Tradução correta!");
            } else {
                System.out.println("Tradução incorreta. Tente novamente.");
            }

            scanner.close();
        } 
        else {
            System.out.println("Nenhum verbo encontrado no banco de dados.");
            
        }

    }
}
