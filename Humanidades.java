import java.util.ArrayList;

public class Humanidades extends Curso {

    public Humanidades(String nome, int num, String uni) {
        super(nome, num, uni);
    }
    
    @Override
    public void calcMedia(Aluno a) {
        double media = 0.25 * a.getExameB() + 0.75 * a.getNota();
        if(a.getzonaDesfavorecida())
            media += 2;
        if(a.getDeficiencia())
            media += 5;
        super.addCandidato(a, media);
    }
}
