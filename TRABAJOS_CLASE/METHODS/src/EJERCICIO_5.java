
import java.util.Scanner;
public class EJERCICIO_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la temperatura que desea cambiar:");
        double num = sc.nextDouble();
        System.out.println("Que conversion desea hacer con este numero: ");
        System.out.println("1- De Celsius a Fahrenheit.");
        System.out.println("2- De Fahrenheit a Celsius.");

        int n = sc.nextInt();

        switch (n) {
            case 1:
                celsius(num);
                break;
            case 2:
                fahrenheit(num);
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
    public static void celsius(double num) {
            double op1 = num * 1.8 + 32;
        System.out.println("El resultado es: " + op1 + " °F");
    }
    public static void fahrenheit(double num) {
        double op2 = (5.0 / 9) * (num - 32);
        System.out.println("El resultado es: " + op2 + " °C");
    }
}
