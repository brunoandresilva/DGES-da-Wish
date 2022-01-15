public class Engenharia extends Curso {

    public Engenharia(String nome, String num, String uni) {
        super(nome, num, uni, "Engenharia");
    }

    @Override
    public void calcMedia(Aluno a) {
        double media = 0.25 * a.getExameA() + 0.25 * a.getExameB() + 0.5 * a.getNota();
        if (a.getzonaDesfavorecida())
            media += 2;
        if (a.getDeficiencia())
            media += 5;
        super.addCandidato(a, media);
    }
}
