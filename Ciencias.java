public class Ciencias extends Curso {

    public Ciencias(String nome, String num, String uni, int vagas) {
        super(nome, num, uni, "Ciências", vagas);
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
}
