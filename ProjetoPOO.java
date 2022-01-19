import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoPOO {

    public static ArrayList<Curso> cursos = new ArrayList<Curso>();
    public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public static void main(String args[]) {

        read();
        menu();

    }

    public static void newCandidate() {
        Scanner s = new Scanner(System.in);
        int id = alunos.size() + 1; // PODE MUDAR A FORMA DE ATRIBUIÇAO DE ID'S
        String nome;
        int idade;
        int notaSecundario;
        int notaIngles;
        int exameA;
        int exameB;
        boolean deficiencia;
        boolean zonaDesfavorecida;
        int genero = 0;

        System.out.println("-------NOVO ALUNO-------");
        System.out.print("Nome: ");
        nome = s.nextLine();
        System.out.print("Idade: ");
        idade = s.nextInt();
        System.out.print("Nota Secundario: ");
        notaSecundario = s.nextInt();
        System.out.print("Nota Inglês: ");
        notaIngles = s.nextInt();
        System.out.print("Exame A: ");
        exameA = s.nextInt();
        System.out.print("Exame B: ");
        exameB = s.nextInt();
        int choice = 0;
        while (choice != 1 && choice != 2) { // ESPAÇO PARA MELHORIA AO SELECIONAR DEFICIENCIA/ZONA DESF
            System.out.print("Deficiencia Cognitiva(1-Sim/2-Não): ");
            choice = s.nextInt();
        }
        if (choice == 1)
            deficiencia = true;
        else
            deficiencia = false;
        choice = 0;

        while (choice != 1 && choice != 2) {
            System.out.print("Zona Desfavorecida(1-Sim/2-Não): ");
            choice = s.nextInt();
        }
        if (choice == 1)
            zonaDesfavorecida = true;
        else
            zonaDesfavorecida = false;

        while (genero < 1 || genero > 3) {
            System.out.print("Genero(1-Mac/2-Fem/3-Outro): ");
            genero = s.nextInt();
        }

        s.close();
        alunos.add(new Aluno(id, nome, idade, notaSecundario, notaIngles, exameA, exameB, deficiencia,
                zonaDesfavorecida, genero));
        System.out.println("Aluno " + nome + " adicionado com sucesso!");
        return;
    }

    public static void newCourse() {
        // TODO
    }

    public static void runAlgorithm() {
        // MUCH TODO
    }

    public static void listAlunos() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("**********************");
            System.out.println("Nome: " + alunos.get(i).getNome());
            System.out.println("ID: " + alunos.get(i).getId());
        }
        return;
    }

    public static void menu() {
        int option = 0;

        while (true) {
            Scanner s = new Scanner(System.in);
            while (option < 1 || option > 5) {
                System.out.println("-------MENU-PRINCIPAL-------");
                System.out.println("1-> Registar novo Candidato");
                System.out.println("2-> Registar Novo curso c/Numerus Clausus e calc de média");
                System.out.println("3-> Correr Algoritmo");
                System.out.println("4-> Lista de candidatos ao ensino superior");
                System.out.println("5-> EXIT");
                System.out.print("Option: ");
                option = s.nextInt();
            }
            switch (option) {
                case 1:
                    newCandidate();
                    break;
                case 2:
                    newCourse();
                    break;
                case 3:
                    runAlgorithm();
                    break;
                case 4:
                    listAlunos();
                    break;
                case 5:
                    s.close();
                    return;
            }
            s.close();
        }

    }

    public static void read() {
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
    }

}
