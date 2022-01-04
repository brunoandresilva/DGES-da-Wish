import java.util.ArrayList;

public abstract class Curso {
    String nome;
    int numerusClausus;
    String universidade;
    ;


    public Curso(String nome, int num, String uni, Aluno alu){
        this.nome = nome;
        this.numerusClausus = num;
        this.universidade = uni;
        candidatos.add(alu);
        
    }
    public abstract media (int media);
}
