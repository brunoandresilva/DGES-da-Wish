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

        boolean x = true;
        while (x) {
            int option;
            System.out.println("-------MENU-PRINCIPAL-------");
            System.out.println("1-> Registar novo Candidato");
            System.out.println("2-> Registar Novo curso c/Numerus Clausus e calc de média");
            System.out.println("3-> Ler cód de Candidato e Mostrar Resultado");
            System.out.println("4-> Lista de colocados de 1 dado curso");
            System.out.println("5-> Curso com maior numero de candidatos do genero feminino");
            System.out.println("6-> Percentagem de alunos colocados com necessidades educativas");
            System.out.println("7-> Curso com média de acesso mais alta");
            System.out.println("8-> Curso com média de acesso mais baixa");
            System.out.println("9-> Aluno com média de acesso mais alta");
            System.out.println("10-> Alunos colocados na primeira opção");
            System.out.println("11-> Curso com maior numero de colocados em 1 opção");
        }

        for (int i = 0; i < cursos.size(); i++) { // print dos cursos para verificar que leu tudo direito
            System.out.println("----------------------------------------------------------");
            System.out.println("Curso: " + cursos.get(i).getNome());
            System.out.println("Numerus clausus: " + cursos.get(i).getNumerusClausus());
            System.out.println("Universidade: " + cursos.get(i).getUniversidade());
            System.out.println("Tipo de Curso: " + cursos.get(i).getTipo());
            System.out.println("Vagas: " + cursos.get(i).getVagas());
        }

        System.out.println("****************************************************************");
        Aluno a = new Aluno(1, "Bruno", 20, 146, 170, 133, 150, false, false, 1);
        a.addCurso(cursos.get(0));
        System.out.println("Candidatos: " + cursos.get(0).getCandidatos().keySet());

    }

}
