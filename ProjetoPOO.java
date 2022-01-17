import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoPOO {

    public static void main(String args[]) {

        ArrayList<Curso> cursos = new ArrayList<Curso>(); // ArrayList para guardar todos os cursos disponíveis

        try {
            File myObj = new File("cursos.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) { // Enquanto a próxima linha do ficheiro != NULL vai ler
                switch (myReader.nextLine()) { // nextLine() lê a linha e avança para a próxima, daí ao adicionar fazer
                                               // sempre nextLine()
                    case "engenharia":
                        cursos.add(new Engenharia(myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                Integer.parseInt(myReader.nextLine())));
                        break;
                    case "biociencias":
                        cursos.add(new Biociencias(myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                Integer.parseInt(myReader.nextLine())));
                        break;
                    case "ciencias":
                        cursos.add(new Ciencias(myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                Integer.parseInt(myReader.nextLine())));
                        break;
                    case "cienciasjur":
                        cursos.add(new CienciasJur(myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                Integer.parseInt(myReader.nextLine())));
                        break;
                    case "humanidades":
                        cursos.add(new Humanidades(myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                Integer.parseInt(myReader.nextLine())));
                        break;
                    default:
                        System.out.println("Tipo de curso nao identificado"); // se houver algum erro no ficheiro com os
                                                                              // cursos, vai para o case default
                }

            }
            myReader.close(); // fechar o scanner
        } catch (FileNotFoundException o) { // exception caso haja algum problema ao abrir o ficheiro (é obrigatório!)
            System.out.println("Erro ao ler do ficheiro");
            o.printStackTrace();
        }

        for (int i = 0; i < cursos.size(); i++) { // print dos cursos para verificar que leu tudo direito
            System.out.println("----------------------------------------------------------");
            System.out.println("Curso: " + cursos.get(i).getNome());
            System.out.println("Numerus clausus: " + cursos.get(i).getNumerusClausus());
            System.out.println("Universidade: " + cursos.get(i).getUniversidade());
            System.out.println("Tipo de Curso: " + cursos.get(i).getTipo());
            System.out.println("Vagas: " + cursos.get(i).getVagas());
        }

    }

}
