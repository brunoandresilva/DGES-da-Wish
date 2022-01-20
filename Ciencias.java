import java.util.Iterator;

public class Ciencias extends Curso {

    public Ciencias(String nome, int num, String uni, int id) {
        super(nome, num, uni, "ciências", id);
    }


    public Biociencias clone(){
        Biociencias temp = new Biociencias(super.getNome(), super.getNumerusClausus(), super.getUniversidade(), super.getId());
        for(Aluno a: super.getColocados()){
            temp.addColocado(a);
        }
        Iterator<Aluno> itr = super.getCandidatos().keySet().iterator();
        while(itr.hasNext()){
            super.addCandidato(itr.next(), super.getCandidatos().get(itr.next()));
        }
        return temp;
    }

    @Override
    public void calcMedia(Aluno a) {
        double media = 0.25 * a.getExameIngles() + 0.25 * a.getExameA() + 0.25 * a.getExameB() + 0.25 * a.getNota();
        if (a.getzonaDesfavorecida())
            media += 2;
        if (a.getDeficiencia())
            media += 5;
        super.addCandidato(a, media);
    }

    
    public boolean equals(Object o){
        if (this == o) 
            return true; 
        if (o == null) 
            return false;
        if ( this.getClass() != o.getClass() ) 
            return false;
            
        Curso temp = (Curso) o;
        return temp.getId() == super.getId(); 
    }
}
