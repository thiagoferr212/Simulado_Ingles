package entity;
import java.util.List;

public class Verbo {

    private int idVerbo;
    private int idVerboTraducao;
    private int idVerboParticipioPassado;
    private int idVerboPreteritoPerfeito;
    private String verbo;
    private String verboParticipioPassado;
    private String verboPreteritoPerfeito;
    private List<String> verbosTraducao;

    public int getIdVerbo() {
        return idVerbo;
    }
    public void setIdVerbo(int idVerbo) {
        this.idVerbo = idVerbo;
    }
    public int getIdVerboTraducao() {
        return idVerboTraducao;
    }
    public void setIdVerboTraducao(int idVerboTraducao) {
        this.idVerboTraducao = idVerboTraducao;
    }
    public int getIdVerboParticipioPassado() {
        return idVerboParticipioPassado;
    }
    public void setIdVerboParticipioPassado(int idVerboParticipioPassado) {
        this.idVerboParticipioPassado = idVerboParticipioPassado;
    }
    public int getIdVerboPreteritoPerfeito() {
        return idVerboPreteritoPerfeito;
    }
    public void setIdVerboPreteritoPerfeito(int idVerboPreteritoPerfeito) {
        this.idVerboPreteritoPerfeito = idVerboPreteritoPerfeito;
    }
    public String getVerbo() {
        return verbo;
    }
    public void setVerbo(String verbo) {
        this.verbo = verbo;
    }
    public String getVerboParticipioPassado() {
        return verboParticipioPassado;
    }
    public void setVerboParticipioPassado(String verboParticipioPassado) {
        this.verboParticipioPassado = verboParticipioPassado;
    }
    public String getVerboPreteritoPerfeito() {
        return verboPreteritoPerfeito;
    }
    public void setVerboPreteritoPerfeito(String verboPreteritoPerfeito) {
        this.verboPreteritoPerfeito = verboPreteritoPerfeito;
    }
    public List<String> getVerbosTraducao() {
        return verbosTraducao;
    }
    public void setVerbosTraducao(List<String> verbosTraducao) {
        this.verbosTraducao = verbosTraducao;
    } 

}
