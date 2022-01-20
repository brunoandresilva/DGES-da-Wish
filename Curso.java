import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Curso implements Serializable{
    private String nome;
    private int id;
    private int numerusClausus;
    private String universidade;
    private String tipo;
    private Map<Aluno, Double> candidatos;
    private ArrayList<Aluno> colocados;

    public Curso(String nome, int num, String uni, String tipo, int id) {
        this.nome = nome;
        this.numerusClausus = num;
        this.universidade = uni;
        this.tipo = tipo;
        this.id = id;
        this.candidatos = new HashMap<>();
        this.colocados = new ArrayList<>();
    }

    public abstract void calcMedia(Aluno a);


    public ArrayList<Aluno> getColocados(){
        return this.colocados;
    }

    public int getId(){
        return this.id;
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

    public Map<Aluno, Double> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(HashMap<Aluno, Double> candidatos) {
        this.candidatos = candidatos;
    }

    public void addColocado(Aluno a){
        this.colocados.add(a);
    }

    public int removeCandidato(Aluno a){
        int counter = 0;
        Iterator<Aluno> itr = this.candidatos.keySet().iterator();
        while(itr.hasNext()){
            if(itr.next() == a){
                this.candidatos.remove(a);
            }
            counter++;
        }
        return counter;
    }

    public boolean removeColocado(Aluno a){
        return this.colocados.remove(a);
    }

    public void addCandidato(Aluno candidato, double media) {
        this.candidatos.put(candidato, media);
    }


}


