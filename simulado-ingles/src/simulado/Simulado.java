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
            Verbo verboIrregular = verboDAO.buscarVerbosIrregulares(verbo.getIdVerbo());
            
            if (verboIrregular != null) {
                System.out.println("Preterito: " + verboIrregular.getVerboPreteritoPerfeito());
                System.out.println("Participio: " + verboIrregular.getVerboParticipioPassado());
                System.out.println();
            } else {
                System.out.println("Nenhum verbo irregular encontrado.");
            }
            if (!traducoes.isEmpty()) {
                Scanner scanner = new Scanner(System.in);
                String respostaUsuarioParticipioPassado, respostaUsuarioPreteritoPerfeito, respostaUsuarioTraducao;
                
                System.out.print("Digite o Preterito Perfeito do verbo: ");
                respostaUsuarioPreteritoPerfeito = scanner.nextLine();
                System.out.println();
                System.out.print("Digite a Participio Passado do verbo: ");
                respostaUsuarioParticipioPassado = scanner.nextLine();
                System.out.println();
                System.out.print("Digite a Tradução do verbo: ");
                respostaUsuarioTraducao = scanner.nextLine();
                System.out.println();
                System.out.println("------------------------------------(RESPOSTAS)------------------------------------\n");

                if (verboIrregular.getVerboPreteritoPerfeito().equals(respostaUsuarioPreteritoPerfeito)) {
                    System.out.println("O Preterito Perfeito do verbo informado está correto!\n");
                } else {
                    System.out.print("O verbo no Preterito perfeito que você informou está incorreto, o certo seria: ");
                    System.out.println(verboIrregular.getVerboPreteritoPerfeito() + "\n");
                }
                if (verboIrregular.getVerboParticipioPassado().equals(respostaUsuarioParticipioPassado)) {
                    System.out.println("O Participio Passado do verbo informado está correto!\n");
                } else {
                    System.out.print("O verbo no Participio Passado que você informou está incorreto, o certo seria: ");
                    System.out.println(verboIrregular.getVerboParticipioPassado() + "\n");
                }
                if (traducoes.contains(respostaUsuarioTraducao)) {
                    System.out.println("A Tradução do verbo está correta!\n");
                } else {
                    System.out.println("A tradução de verbo que você informou está incorreta, o certo seria algumas destas opções: \n");
                    for (String traducao : traducoes) {
                        System.out.println("- " + traducao);
                    }
                    System.out.println();
                }

                scanner.close();
            } else {
                System.out.println("Nenhuma tradução encontrada.");
            }
        } else {
            System.out.println("Nenhum verbo encontrado.");
        }
              
    }
}
