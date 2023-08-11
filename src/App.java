import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Map<Integer, String> tarefas = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int identificador = 0;

        while (true) {
            menu();
            int opcao = input.nextInt();
            switch(opcao){
                case 1:    
                    input.nextLine(); 
                    identificador += 1;
                    System.out.print("Informe a Descrição da Tarefa: ");
                    String desc = input.nextLine();
                    adicionar_tarefa(tarefas, identificador, desc);
                    System.out.println("Tarefa Cadastrada com Sucesso!");
                    break;

                case 2:
                    mostrar_tarefas(tarefas);
                    break;

                case 3:
                    System.out.print("Escolha a Tarefa a ser Removida: ");
                    int id_delete = input.nextInt();
                    remover_tarefa(tarefas, id_delete);
                    System.out.println("Tarefa Removida com Sucesso");
                    break;

                case 4:
                    System.out.println("Programa Encerrado!");
                    input.close();
                    return;

                default:
                    System.out.println("Opção Inválida! Tente Novamente!");
            }
        }
    }

    public static void menu() throws InterruptedException{

            // Espera 1 Segundo Antes de Exibir o Menu (Não Sei Explicar o Código)
            Thread.currentThread();
            Thread.sleep(1000);

            System.out.println("\n");
            System.out.println("***** GERENCIADOR DE TAREFAS *****");
            System.out.println("*[1] - Incluir Tarefa            *");
            System.out.println("*[2] - Visualizar Tarefas        *");
            System.out.println("*[3] - Remover Tarefa            *");
            System.out.println("*[4] - Sair                      *");
            System.out.println("**********************************");
            System.out.println("\n");
            System.out.print("Escolha uma opção: ");  
        }

    public static Map<Integer, String> adicionar_tarefa(Map<Integer, String> lista, int identificador, String item){
        lista.put(identificador, item);
        return lista;
    }

    public static Map<Integer, String> remover_tarefa(Map<Integer, String> lista, int identificador){
        lista.remove(identificador);
        return lista;
    }

    public static void mostrar_tarefas(Map<Integer, String> lista){
        System.out.println("\n");
        for (Map.Entry<Integer, String> t: lista.entrySet()){
            System.out.println(t.getKey() + " = " + t.getValue());
        }
    }
}
