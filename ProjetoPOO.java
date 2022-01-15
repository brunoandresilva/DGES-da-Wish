import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoPOO {

    public static void main(String args[]) {

        ArrayList<Curso> cursos = new ArrayList<Curso>();

        try {
            File myObj = new File("cursos.txt");
            Scanner myReader = new Scanner(myObj);
            String name;
            int numerus;
            String uni;
            while (myReader.hasNextLine()) {
                switch (myReader.nextLine()) {
                    case "engenharia":
                        cursos.add(new Engenharia(myReader.nextLine(), Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine()));
                        break;
                    case "biociencias":
                        cursos.add(new Biociencias(myReader.nextLine(), Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine()));
                        break;
                    case "ciencias":
                        cursos.add(new Ciencias(myReader.nextLine(), Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine()));
                        break;
                    case "cienciasjur":
                        cursos.add(new CienciasJur(myReader.nextLine(), Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine()));
                        break;
                    case "humanidades":
                        cursos.add(new Humanidades(myReader.nextLine(), Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine()));
                        break;
                    default:
                        System.out.println("Tipo de curso nao identificado");
                }

                // String data = myReader.nextLine();
                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException o) {
            System.out.println("Erro ao ler do ficheiro");
            o.printStackTrace();
        }

        for (int i = 0; i < cursos.size(); i++) {
            // System.out.println("Tipo: " + cursos.get(i).getClass());
            System.out.println("Curso: " + cursos.get(i).getNome());
            System.out.println("Numerus clausus: " + cursos.get(i).getNumerusClausus());
            System.out.println("Universidade: " + cursos.get(i).getUniversidade());
        }

    }

}
