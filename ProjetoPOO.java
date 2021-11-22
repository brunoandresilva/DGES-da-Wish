import java.util.Scanner;

public class ProjetoPOO {

    
    public static void main(String args[]) {
        boolean i = true;
        while(i){
            int counterAlunos = 0;
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1-Adicionar Aluno");
            System.out.println("2-Remover Aluno");
            System.out.println("3-Exit");

            System.out.println("Escolher opçao");
            choice = sc.nextInt();
            //sc.close();
            
            switch(choice){
                case 1: counterAlunos++;
                Scanner input = new Scanner(System.in);

                int id = counterAlunos;     //counter atribuido automaticamente (numero de aluno)

                System.out.print("Nome: ");
                String nome = input.nextLine();

                System.out.print("Idade: ");
                int idade = input.nextInt();
                
                System.out.print("Nota Secundario: ");
                int notaSecundario = input.nextInt();

                System.out.print("Nota Ingles: ");
                int notaIngles = input.nextInt();
                
                System.out.print("Exame A: ");
                int exameA = input.nextInt();
                
                System.out.print("Exame B: ");
                int exameB = input.nextInt();

                System.out.println("Deficiencia? ");
                System.out.println("1-Sim");
                System.out.println("2-Nao");
                int option = input.nextInt();
                boolean deficiencia = false;
                if(option == 1)    //TODO fazer verificaçao de outros valores
                    deficiencia = true;
                
                else
                    deficiencia = false;


                System.out.println("Zona Desfavorecida? ");
                System.out.println("1-Sim");
                System.out.println("2-Nao");
                option = input.nextInt();
                boolean zonaDesfavorecida = false;
                if(option == 1)    //TODO fazer verificaçao de outros valores
                    zonaDesfavorecida = true;
                
                else
                    zonaDesfavorecida = false;

                System.out.println("Genero: ");
                System.out.println("1-Masculino");
                System.out.println("2-Feminino");
                int genero = input.nextInt();
            
                Aluno a = new Aluno(id, nome, idade, notaSecundario, notaIngles, exameA, exameB, deficiencia, zonaDesfavorecida, genero);
                //input.close();
                break;

                case 2: break;

                case 3: i = false;
                break;
                
            }
            
        }

        
    }
    
}


