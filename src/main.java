import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al Fabioleitor 2000");
        System.out.println("Piensa un número entero del 1 al 100");
        System.out.println("Respuestas validas [mayor]+[menor]+[correcto]");
        int userChoice = 0;

        while (userChoice != 1 && userChoice != 2) {
            System.out.print("Quieres jugar al modo random o al modo binario\n1.Random Mode\n2.Modo Binario\nOpción: ");
            userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) {
                numeroDelFabioleitor(1, 100, sc, 0);
            } else if (userChoice == 2) {
                numeroDelFabioleitor2(1, 100, sc, 0);
            } else {
                System.out.println("Eres tonto y en tú casa lo saben");
            }
        }
        sc.close();
    }

    // MODO RANDOM RECURSIVO
    private static void numeroDelFabioleitor(int min, int max, Scanner sc, int trys) {
        if (min > max) {
            System.out.println("¡A trolear a tu casa! Quizás no sepa el número pero se que me has mentido");
            return;
        }

        int fabioleitorSays = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Tú número es [" + fabioleitorSays + "]?");
        String userSays = sc.nextLine();

        if (userSays.equalsIgnoreCase("correcto")) {
            trys++;
            System.out.println("Fabioleitor 2000 lo ha vuelto a hacer");
            System.out.println("He acertado tu número con la maravillosa cantidad de [" + trys + "] intentos.");
        } else if (userSays.equalsIgnoreCase("mayor")) {
            numeroDelFabioleitor(fabioleitorSays + 1, max, sc, trys + 1);
        } else if (userSays.equalsIgnoreCase("menor")) {
            numeroDelFabioleitor(min, fabioleitorSays - 1, sc, trys + 1);
        } else {
            System.out.println("A trolear a tu casa");
            System.out.println("Respuestas validas [mayor]+[menor]+[correcto]");
            numeroDelFabioleitor(min, max, sc, trys);
        }
    }

    // MODO BINARIO RECURSIVO
    private static void numeroDelFabioleitor2(int min, int max, Scanner sc, int trys) {

        if (min > max) {
            System.out.println("¡A trolear a tu casa! Quizás no sepa el número pero se que me has mentido");
            return;
        }

        int fabioleitor2Says = min + (max - min) / 2;
        System.out.println("Tú número es [" + fabioleitor2Says + "]?");
        String userSays = sc.nextLine();


        if (userSays.equalsIgnoreCase("correcto")) {
            trys++;
            System.out.println("Fabioleitor 2000 lo ha vuelto a hacer");
            System.out.println("He acertado tu número con la maravillosa cantidad de [" + trys + "] intentos.");
        } else if (userSays.equalsIgnoreCase("mayor")) {
            numeroDelFabioleitor2(fabioleitor2Says + 1, max, sc, trys + 1);
        } else if (userSays.equalsIgnoreCase("menor")) {
            numeroDelFabioleitor2(min, fabioleitor2Says - 1, sc, trys + 1);
        } else {
            System.out.println("A trolear a tu casa");
            System.out.println("Respuestas validas [mayor]+[menor]+[correcto]");
            numeroDelFabioleitor2(min, max, sc, trys);
        }
    }
}


