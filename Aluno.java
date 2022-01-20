import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  class Aluno implements Serializable{
    private int id;
    private String nome;
    private int idade;
    private int notaSecundario;
    private int notaIngles;
    private int exameA;
    private int exameB;
    private boolean deficiencia;
    private boolean zonaDesfavorecida;
    private int genero; //1-masc; 2-fem; 3-outro 
    private List<Curso> candidatura;
    private boolean colocado;
    
    

    //constructor
    public Aluno(int id, String nome, int idade, int notaSecundario, int notaIngles, int exameA, int exameB, boolean deficiencia, boolean zonaDesfavorecida, int genero)
    { 
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.notaSecundario = notaSecundario;
        this.notaIngles = notaIngles;
        this.exameA = exameA;
        this.exameB = exameB;
        this.deficiencia = deficiencia;
        this.zonaDesfavorecida = zonaDesfavorecida;
        this.genero = genero;
        this.colocado = false;
        this.candidatura = new ArrayList<>();
    }
    //getters
    public boolean getColocado(){
        return this.colocado;
    }
    public int getId(){
        return this.id;
    }
    public String getNome()
    {
        return this.nome;
    }
    public int getIdade()
    {
        return this.idade;
    }
    public int getNota()
    {
        return this.notaSecundario;
    }
    public int getExameA()
    {
        return this.exameA;
    }
    public int getExameB()
    {
        return this.exameB;
    }
    public int getExameIngles()
    {
        return this.notaIngles;
    }
    public boolean getDeficiencia()
    {
        return this.deficiencia;
    }
    public boolean getzonaDesfavorecida()
    {
        return this.zonaDesfavorecida;
    }
    public int getGenero(){
        return this.genero;
    }
    public List<Curso> getCandidatura() {
        return candidatura;
    }

    //setters
    public void setColocado(boolean c){
        this.colocado = c;
    }
    public void setCandidatura(ArrayList<Curso> candidatura) {
        this.candidatura = candidatura;
    }

    public void addCurso(Curso c){
        this.candidatura.add(c);
        //c.calcMedia(this);
    }

    public Aluno clone(){
        Aluno temp = new Aluno(this.getId(), this.getNome(), this.getIdade(), this.getNota(), this.getExameIngles(), this.getExameA(), this.getExameB(), this.getDeficiencia(), this.getzonaDesfavorecida(), this.getGenero());
        temp.setColocado(this.getColocado());
        for(Curso c: this.getCandidatura()){
            temp.addCurso(c);
        }
        return temp;
    }

    public boolean equals(Object o){
        if (this == o) 
            return true; 
        if (o == null) 
            return false;
        if ( this.getClass() != o.getClass() ) 
            return false;
            
        Curso temp = (Curso) o;
        return temp.getId() == this.getId(); 
    }

    

}