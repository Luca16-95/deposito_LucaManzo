import java.util.Scanner;

public class EsercizioCicli3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // array di stringa vuoto
        String[] array = { "", "", "" };
        // inizializzo la variabile i fuori dal ciclo for per usarlo come stampa alla
        // fine
        int i = 0;
        // ciclo for per inserimento dati nello switch
        for (i = 0; i <= array.length; i++) {
            System.out.println("inserisco i numeri nell' array");

            switch (i) {
                case 0:
                    array[i] = input.nextLine();
                    ;
                    break;
                case 1:
                    array[i] = input.nextLine();
                    ;
                    break;
                case 2:
                    array[i] = input.nextLine();
                    ;
                    break;

                default:
                    break;
            }

        }
        // chiedo quale giorno vuole stampare
        System.out.println("scegli quale giorno vuoi visualizzare da 0 a 2");
        // chiedo l'input
        i = input.nextInt();
        System.out.println(array[i]);
        input.close();
    }
}
