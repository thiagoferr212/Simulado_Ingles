package simulado;

import DAO.VerboDAO;
import entity.Verbo;
import java.util.List;
import java.util.Scanner;

public class Simulado {
    public static void main(String[] args) {
        VerboDAO verboDAO = new VerboDAO();
        Verbo verbo  = verboDAO.buscarVerbo();

        if (verbo != null) {
            System.out.println("Id Verbo: " + verbo.getIdVerbo());
            System.out.println("Verbo: " + verbo.getVerbo());

            List<String> traducoes = verboDAO.buscarTraducao(verbo.getIdVerbo());

            // Exibe as traduções
            if (!traducoes.isEmpty()) {
                System.out.println("Traduções: ");
            
                // Solicita a tradução do usuário
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite a tradução do verbo: ");
                String respostaUsuario = scanner.nextLine();

                // Verifica se a resposta do usuário está correta
                if (traducoes.contains(respostaUsuario)) {
                    System.out.println("Correto! A tradução está correta.");
                } else {
                    System.out.println("Incorreto. As traduções corretas são:");
                    for (String traducao : traducoes) {
                        System.out.println("- " + traducao);
                    }
                }
                
                scanner.close();
            } else {
                System.out.println("Nenhuma tradução encontrada.");
            }
        } else {
            System.out.println("Nenhum verbo encontrado.");
        }
        
        /*Usuario u = new Usuario();
        u.setNome("Thiago");
        u.setSobrenome("Ferreira");
        u.setEmail("thiago@gmail.com");
        u.setSenha("1234");

        new UsuarioDAO().cadastroUsuario(u);*/
    }
}
