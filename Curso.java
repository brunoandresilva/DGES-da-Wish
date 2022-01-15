import java.util.HashMap;

public abstract class Curso {
    private String nome;
    private String numerusClausus;
    private String universidade;
    private String tipo;
    private HashMap<Aluno, Double> candidatos = new HashMap<Aluno, Double>();

    public Curso(String nome, String num, String uni, String tipo) {
        this.nome = nome;
        this.numerusClausus = num;
        this.universidade = uni;
        this.tipo = tipo;
    }

    public abstract void calcMedia(Aluno a);

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

    public HashMap<Aluno, Double> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(HashMap<Aluno, Double> candidatos) {
        this.candidatos = candidatos;
    }

    public void addCandidato(Aluno candidato, double media) {
        this.candidatos.put(candidato, media);
    }

}
