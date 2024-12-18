import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce el primer número:");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo número:");
        int num2 = sc.nextInt();


        System.out.println("¿Qué deseas hacer con estos números?");
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicación");
        System.out.println("4- División");
        System.out.println("5- Exponencial");

        int n = sc.nextInt();


        switch (n) {
            case 1:
                suma(num1, num2);
                break;
            case 2:
                resta(num1, num2);
                break;
            case 3:
                multi(num1, num2);
                break;
            case 4:
                divi(num1, num2);
                break;
            case 5:
                expo(num1, num2);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        sc.close();
    }


    public static void suma(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("La suma equivale a: " + sum);
    }


    public static void resta(int num1, int num2) {
        int resta = num1 - num2;
        System.out.println("La resta equivale a: " + resta);
    }

    public static void multi(int num1, int num2) {
        int multi = num1 * num2;
        System.out.println("La multiplicación equivale a: " + multi);
    }


    public static void divi(int num1, int num2) {
        if (num2 != 0) {
            int divi = num1 / num2;
            System.out.println("La división equivale a: " + divi);
        } else {
            System.out.println("No se puede dividir por cero.");
        }
    }

    public static void expo(int num1, int num2) {
        // Usar Math.pow para la exponenciación
        double expo = Math.pow(num1, num2);
        System.out.println("El resultado de la exponenciación es: " + expo);
    }
}
