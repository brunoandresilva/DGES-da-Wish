import java.util.Scanner;

public class ProjetoPOO {

    
    public static void main(String args[]) {
        Engenharia e = new Engenharia("MIETI", 123, "Uminho");
        Aluno a = new Aluno(1, "jasaddad", 18, 156, 170, 130, 145, false, false, 1);
        a.addCurso(e);
        System.out.println("Aluno: " + a.getNome() + " entrou em " + e.getNome() + " com media de " + e.getCandidatos().get(a));
    }
    
}


