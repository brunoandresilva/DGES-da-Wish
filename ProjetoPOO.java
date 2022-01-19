import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.xml.XMLConstants;

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
            System.out.print("Genero(1-Masc/2-Fem/3-Outro): ");
            genero = s.nextInt();
        }

        alunos.add(new Aluno(id, nome, idade, notaSecundario, notaIngles, exameA, exameB, deficiencia,
                zonaDesfavorecida, genero));
        System.out.println("Aluno " + nome + " adicionado com sucesso!");
        return;
    }

    public static void newCourse() {
        Scanner curso = new Scanner(System.in);
        int option = 0;
        System.out.println("-------NOVO CURSO-------");
        System.out.print("Nome: ");
        String nome = curso.nextLine();
        System.out.print("Numerus Clausus: ");
        String numerus = curso.nextLine();
        System.out.print("Universidade: ");
        String uni = curso.nextLine();
        System.out.print("Vagas: ");
        int vagas = curso.nextInt();
        while(option < 1 || option > 5){
            System.out.println("Tipo de Curso");
            System.out.println("1-> Engenharia");
            System.out.println("2-> Ciencias");
            System.out.println("3-> Ciencias Juridicas");
            System.out.println("4-> Biociencias");
            System.out.println("5-> Humanidades");
            System.out.print("Opcao: ");
            option  = curso.nextInt();
        }
        
        switch(option){
            case 1:
                cursos.add(new Engenharia(nome, numerus, uni, vagas));
                break;
            case 2: 
                cursos.add(new Ciencias(nome, numerus, uni, vagas));
                break;
            case 3:
                cursos.add(new CienciasJur(nome, numerus, uni, vagas));
                break;
            case 4:
                cursos.add(new Biociencias(nome, numerus, uni, vagas));
                break;
            case 5:
                cursos.add(new Humanidades(nome, numerus, uni, vagas));
                break;
        }
        System.out.println("Curso " + nome + " adicionado com sucesso!");
        
    }

    public static void runAlgorithm() {
        // MUCH TODO
    }

    public static void listAlunos() {
        Scanner x = new Scanner(System.in);
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("**********************");
            System.out.println("Nome: " + alunos.get(i).getNome());
            System.out.println("ID: " + alunos.get(i).getId());
        }
        return;
    }

    public static void readObject(){
        //TODO
    }
    public static void saveObject(){
        //TODO
    }

    public static void menu() {
        int option = 0;
        boolean x = true;
        while (x) {
            Scanner input = new Scanner(System.in);
            while (option < 1 || option > 5) {
                System.out.println("-------MENU-PRINCIPAL-------");
                System.out.println("1-> Registar novo Candidato");
                System.out.println("2-> Registar Novo curso c/Numerus Clausus e calc de média");
                System.out.println("3-> Correr Algoritmo");
                System.out.println("4-> Lista de candidatos ao ensino superior");
                System.out.println("5-> EXIT");
                System.out.print("Option: ");
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    newCandidate();
                    option = 0;
                    break;
                case 2:
                    newCourse();
                    option = 0;
                    break;
                case 3:
                    runAlgorithm();
                    option = 0;
                    break;
                case 4:
                    listAlunos();
                    option = 0;
                    break;
                case 5:
                    save();
                    x = false;
                    break;
            }
            
        }

    }


    public static void save(){
        //CURSOS
        try{
            FileWriter writer1 = new FileWriter("cursos.txt");
            for(int i = 0; i < cursos.size(); i++){
                Curso c = cursos.get(i);
                writer1.write(c.getTipo() + "\n");
                writer1.write(c.getNome() + "\n");
                writer1.write(c.getNumerusClausus() + "\n");
                writer1.write(c.getUniversidade() + "\n");
                writer1.write(String.valueOf(c.getVagas()) + "\n");
            }
            writer1.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //ALUNOS
        try{
            FileWriter writer2 = new FileWriter("alunos.txt");
            for(int i = 0; i < alunos.size(); i++){
                Aluno a = alunos.get(i);
                writer2.write(String.valueOf(a.getId()) + "\n");
                writer2.write(a.getNome() + "\n");
                writer2.write(String.valueOf(a.getIdade()) + "\n");
                writer2.write(String.valueOf(a.getNota()) + "\n");
                writer2.write(String.valueOf(a.getExameIngles()) + "\n");
                writer2.write(String.valueOf(a.getExameA()) + "\n");
                writer2.write(String.valueOf(a.getExameB()) + "\n");
                writer2.write(String.valueOf(a.getDeficiencia()) + "\n");
                writer2.write(String.valueOf(a.getzonaDesfavorecida()) + "\n");
                writer2.write(String.valueOf(a.getGenero()) + "\n");
            }
            writer2.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void read() {
        //CURSOS
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
                    case "ciencias juridicas":
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

        //ALUNOS
        try{
            File file = new File("alunos.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                int id = Integer.parseInt(reader.nextLine());
                String nome = reader.nextLine();
                int idade = Integer.parseInt(reader.nextLine());
                int secundario = Integer.parseInt(reader.nextLine());
                int ingles = Integer.parseInt(reader.nextLine());
                int exameA = Integer.parseInt(reader.nextLine());
                int exameB = Integer.parseInt(reader.nextLine());
                boolean deficiencia;
                boolean zonaDesfavorecida;
                if(reader.nextLine().equals("true"))
                    deficiencia = true;
                else
                    deficiencia = false;
                if(reader.nextLine().equals("true"))
                    zonaDesfavorecida = true;
                else
                    zonaDesfavorecida = false;
                int genero = Integer.parseInt(reader.nextLine());
                alunos.add(new Aluno(id, nome, idade, secundario, ingles, exameA, exameB, deficiencia, zonaDesfavorecida, genero));
            }
            reader.close();
        }  catch (FileNotFoundException o) { // exception caso haja algum problema ao abrir o ficheiro (é obrigatório!)
            System.out.println("Erro ao ler do ficheiro");
            o.printStackTrace();
        }
    
    }

}
