
public  class Aluno {
    private int id;
    private String nome;
    private int idade;
    private int notaSecundario;
    private int notaIngles;
    private int exameA;
    private int exameB;
    private boolean deficiencia;
    private boolean zonaDesfavorecida;
    private int genero;
    
    

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

    }
    //getters
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

    

}