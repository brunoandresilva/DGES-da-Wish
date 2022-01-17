import java.util.HashMap;

public abstract class Curso {
    private String nome;
    private String numerusClausus;
    private String universidade;
    private String tipo;
    private int vagas;
    private HashMap<String, Double> candidatos = new HashMap<String, Double>();

    public Curso(String nome, String num, String uni, String tipo, int vagas) {
        this.nome = nome;
        this.numerusClausus = num;
        this.universidade = uni;
        this.tipo = tipo;
        this.vagas = vagas;
    }

    public abstract void calcMedia(Aluno a);

    public int getVagas() {
        return this.vagas;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumerusClausus() {
        return numerusClausus;
    }

    public void setNumerusClausus(String numerusClausus) {
        this.numerusClausus = numerusClausus;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public HashMap<String, Double> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(HashMap<String, Double> candidatos) {
        this.candidatos = candidatos;
    }

    public void addCandidato(Aluno candidato, double media) {
        this.candidatos.put(candidato.getNome(), media);
    }

}
