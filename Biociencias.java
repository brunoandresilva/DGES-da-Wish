public class Biociencias extends Curso {

    public Biociencias(String nome, int num, String uni) {
        super(nome, num, uni);
    }
    
    @Override
    public void calcMedia(Aluno a) {
        double media = 0.1 * a.getExameIngles() + 0.4 * a.getExameA() + 0.5 * a.getNota();
        if(a.getzonaDesfavorecida())
            media += 2;
        if(a.getDeficiencia())
            media += 5;
        super.addCandidato(a, media);
    }
}
