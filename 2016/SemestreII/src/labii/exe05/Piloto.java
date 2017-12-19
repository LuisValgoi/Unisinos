package labii.exe05;

public class Piloto implements Comparable{

    private String numeroCarro;
    private String nomePiloto;
    private String nomeEquipe;
    private String numeroVoltasCompletadas;
    private String tempoMotivoConclusao;
    private int pontosObtidos;

    public Piloto(String numeroCarro, String nomePiloto, String nomeEquipe, String numeroVoltasCompletadas, String tempoMotivoConclusao, int pontosObtidos) {
        this.numeroCarro = numeroCarro;
        this.nomePiloto = nomePiloto;
        this.nomeEquipe = nomeEquipe;
        this.numeroVoltasCompletadas = numeroVoltasCompletadas;
        this.tempoMotivoConclusao = tempoMotivoConclusao;
        this.pontosObtidos = pontosObtidos;
    }    
    
    public String getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(String numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getNumeroVoltasCompletadas() {
        return numeroVoltasCompletadas;
    }

    public void setNumeroVoltasCompletadas(String numeroVoltasCompletadas) {
        this.numeroVoltasCompletadas = numeroVoltasCompletadas;
    }

    public String getTempoMotivoConclusao() {
        return tempoMotivoConclusao;
    }

    public void setTempoMotivoConclusao(String tempoMotivoConclusao) {
        this.tempoMotivoConclusao = tempoMotivoConclusao;
    }

    public int getPontosObtidos() {
        return pontosObtidos;
    }

    public void setPontosObtidos(int pontosObtidos) {
        this.pontosObtidos = pontosObtidos;
    }

    @Override
    public String toString(){
        return "[Nº do carro: " + getNumeroCarro() + "], "
                + "[Nome Piloto: " + getNomePiloto() + "], "
                + "[Nome Equipe: " + getNomeEquipe() + "], "
                + "[Nº Voltas Completadas: " + getNumeroVoltasCompletadas() + "]"
                + "[Tempo / Motivo de Conclusão: " + getTempoMotivoConclusao() + "]"
                + "[Pontos Obtidos: " + getPontosObtidos() + "]";
    }
    
    @Override
    public int compareTo(Object o) {
        Piloto p = (Piloto) o;
        return p.getPontosObtidos() - this.pontosObtidos;
    }
     
}
