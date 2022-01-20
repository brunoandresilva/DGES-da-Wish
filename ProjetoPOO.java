import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ProjetoPOO {

    public static ArrayList<Curso> cursos = new ArrayList<Curso>();
    public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public static void main(String args[]) {

        read();
        menu();

    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static void runAlgorithm() {
        alunos.stream().forEach(a->a.setColocado(false));
        for(Aluno a: alunos){
            for(Curso c: a.getCandidatura()){
                c.calcMedia(a); //ao calc media, ja adiciona aluno a lista de candidatos do curso
            }
        }

        //ordenaçao por media
        for(Curso c: cursos){
            HashMap<Aluno, Double> tmp = new HashMap<>();
            List<Entry<Aluno, Double>> list = new ArrayList<>(c.getCandidatos().entrySet());
            list.sort(Entry.comparingByValue());
            list.forEach(e -> tmp.put(e.getKey(), e.getValue()));
            Collections.reverse(list);
            c.setCandidatos(tmp);
        }

        LinkedList<Curso> tempCursos = new LinkedList<>(cursos);
        List<Aluno> tempAlunos;
        try{
            for(int i = 0; i < tempCursos.size(); i++){
                Curso c = tempCursos.get(i);
                //tempCursos.remove(c);
                tempAlunos = c.getCandidatos().keySet().stream().limit(c.getNumerusClausus()).filter(a -> a.getColocado() == false).toList();
                tempAlunos.stream().forEach(a -> {a.setColocado(true); c.addColocado(a); System.out.println("Aluno " + a.getNome() + " - " + c.getNome());});
                for(Aluno a: tempAlunos){
                    boolean flag = false;
                    for(Curso x: a.getCandidatura()){
                        if(flag){
                            System.out.println("1");
                            if(x.removeCandidato(a) < x.getNumerusClausus()){
                                System.out.println("1.1");
                                tempCursos.add(x);
                                x.removeColocado(a);
                            }
                                
                            System.out.println("passou");
                        }
                        if(x == c){
                            flag = true;
                        }
                    }
                }
            }
        } catch(Exception e){System.out.println("ainda nao da " + e);}
    }

    public static void showResults(){
        for(Curso c: cursos){
            System.out.println("Curso: " + c.getNome());
            System.out.println("Lista de Colocados: ");
            for(Aluno a: c.getColocados()){
                System.out.println("************************************");
                System.out.println("Nome: " + a.getNome());
                System.out.println("Media: " + c.getCandidatos().get(a));
            }
        }
        Scanner s = new Scanner(System.in);
        s.nextLine();
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
        int id = cursos.size() + 1;
        System.out.print("Nome: ");
        String nome = curso.nextLine();
        System.out.print("Universidade: ");
        String uni = curso.nextLine();
        System.out.print("Numerus Clausus: ");
        int numerus = curso.nextInt();
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
                cursos.add(new Engenharia(nome, numerus, uni, id));
                break;
            case 2: 
                cursos.add(new Ciencias(nome, numerus, uni, id));
                break;
            case 3:
                cursos.add(new CienciasJur(nome, numerus, uni, id));
                break;
            case 4:
                cursos.add(new Biociencias(nome, numerus, uni, id));
                break;
            case 5:
                cursos.add(new Humanidades(nome, numerus, uni, id));
                break;
        }
        System.out.println("Curso " + nome + " adicionado com sucesso!");
        
    }

    public static void addCandidatura(){
        Scanner m = new Scanner(System.in);
        System.out.println("-------ADICIONAR CANDIDATURA-------");
        System.out.print("ID do aluno que quer proceder a candidatura: ");
        int id = m.nextInt();
        clearScreen();
        System.out.println("-------ADICIONAR CANDIDATURA-------");
        Aluno a = null;
        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getId() == id)
                a = alunos.get(i);
        }
        if(a == null){
            System.out.println("Nao ha nenhum aluno com esse id");
            return;
        }
        
        int i = 0;
        int option = -1;
        a.setCandidatura(new ArrayList<Curso>());
        for(Curso c: cursos){
            c.removeCandidato(a);
        }
        while(i < 6 && option != 0){
            clearScreen();
            System.out.println("ID: " + id);
            System.out.println("Nome: " + a.getNome());
            System.out.println("Idade: " + a.getIdade() + "anos");
            for(int j = 0; j < cursos.size(); j++){
                System.out.println("*****************CURSOS*********************");
                System.out.println("ID: " + cursos.get(j).getId());
                System.out.println("Nome: " + cursos.get(j).getNome());
                System.out.println("--------------");
            }
            System.out.println("Responder com o ID do curso pretendido");
            System.out.print((i+1) + "ª opção(introduzir 0 para acabar candidatura): ");
            option = m.nextInt();
            if(option > 0){
                for(Curso k: cursos){
                    if(option == k.getId()){
                        a.addCurso(k);
                    }
                }
            }
            i++;
        }
    }

    public static void cursoInfo(){
        Scanner n = new Scanner(System.in);
        System.out.print("ID: ");
        int id = n.nextInt();
        Curso c = null;
        for(Curso i: cursos){
            if(id == i.getId())
                c = i;
        }
        if(c == null){
            System.out.println("Nao ha nenhum curso com esse id");
            return;
        }
        clearScreen();
        System.out.println(c.getNome());
        System.out.println("**************");
        System.out.println("Tipo de Curso: " + c.getTipo());
        System.out.println("ID: " + c.getId());
        System.out.println("Numerus Clausus: " + c.getNumerusClausus());
        System.out.println("Universidade: " + c.getUniversidade());
        System.out.println("Candidatos a este curso: \n\n");
        Iterator<Aluno> itr = c.getCandidatos().keySet().iterator();
        while(itr.hasNext()){
            Aluno a = itr.next();
            Double media = c.getCandidatos().get(a);
            System.out.println(a.getNome() + ", com media: " + media);
        }
        System.out.println("\n\nPressione qualquer tecla para voltar");
        n.next();
    }

    public static void listCursos(){
        Scanner z = new Scanner(System.in);
        int option = 0;
        for(int i = 0; i < cursos.size(); i++){
            System.out.println("**********************");
            System.out.println("ID: " + cursos.get(i).getId());
            System.out.println("Nome: " + cursos.get(i).getNome());
        }
        while(option < 1 || option > 2){
            System.out.println("1-> Info sobre algum curso");
            System.out.println("2-> Voltar");
            System.out.print("Escolha: ");
            option = z.nextInt();
        }
        if(option == 1)
            cursoInfo();
        //return;
    }

    public static void listAlunos() {
        Scanner x = new Scanner(System.in);
        int option = 0;
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("**********************"); 
            System.out.println("ID: " + alunos.get(i).getId());
            System.out.println("Nome: " + alunos.get(i).getNome());
        }
        while(option < 1 || option > 2){
            System.out.println("1-> Adicionar Candidatura");
            System.out.println("2-> Voltar");
            System.out.print("Escolha: ");
            option = x.nextInt();
        }
        if (option == 1)
            addCandidatura();
        else
            return;
    }

    public static void read(){
        //CURSOS
        try {
            FileInputStream fos = new FileInputStream("t.tmp");
            ObjectInputStream oos = new ObjectInputStream(fos);
            while(true){
                try{
                    cursos.add((Curso) oos.readObject());
                }catch(Exception e){
                    break;
                }
            }
            oos.close();
        } catch (EOFException e) {
            // Just finish? Kinda nasty...
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //ALUNOS
        try {
            FileInputStream fos = new FileInputStream("t2.tmp");
            ObjectInputStream oos = new ObjectInputStream(fos);
            while(true){
                try{
                    alunos.add((Aluno) oos.readObject());
                }catch(Exception e){
                    break;
                }
            }
            oos.close();
        } catch (EOFException e) {
            // Just finish? Kinda nasty...
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void save(){
        //CURSOS
        try {
            FileOutputStream fos = new FileOutputStream("t.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for(int i = 0; i < cursos.size(); i++){
                oos.writeObject(cursos.get(i));
            }
            oos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //ALUNOS
        try {
            FileOutputStream fos = new FileOutputStream("t2.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i < alunos.size(); i++){
                oos.writeObject(alunos.get(i));
            }
            oos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void menu() {
        int option = 0;
        boolean x = true;
        while (x) {
            Scanner input = new Scanner(System.in);
            while (option < 1 || option > 6) {
                clearScreen(); 
                System.out.println("-------MENU-PRINCIPAL-------");
                System.out.println("1-> Registar novo Candidato");
                System.out.println("2-> Registar Novo curso c/Numerus Clausus e calc de média");
                System.out.println("3-> Correr Algoritmo");
                System.out.println("4-> Lista de candidatos ao ensino superior");
                System.out.println("5-> Lista de cursos");
                System.out.println("6-> EXIT");
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
                    showResults();
                    option = 0;
                    break;
                case 4:
                    listAlunos();
                    option = 0;
                    break;
                case 5:
                    listCursos();
                    option = 0;
                    break;
                case 6:
                    save();
                    x = false;
                    break;
            }
            
        }

    }
}
