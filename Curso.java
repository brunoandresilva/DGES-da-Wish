import java.util.ArrayList;
import java.util.HashMap;

public abstract class Curso {
    private String nome;
    private int numerusClausus;
    private String universidade;
    private HashMap<Aluno, Double> candidatos = new HashMap<Aluno, Double>();


    public Curso(String nome, int num, String uni){
        this.nome = nome;
        this.numerusClausus = num;
        this.universidade = uni;
    }
    public abstract void calcMedia (Aluno a);
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumerusClausus() {
        return numerusClausus;
    }
    public void setNumerusClausus(int numerusClausus) {
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

    public void addCandidato(Aluno candidato, double media){
        this.candidatos.put(candidato, media);
    }
    
}
