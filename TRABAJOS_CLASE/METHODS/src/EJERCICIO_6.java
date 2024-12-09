import java.util.Scanner;
public class EJERCICIO_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca las siguientes medidas del cilindro en metros (Altura y Radio):");
        System.out.println("Altura:");
        double altura = sc.nextDouble();
        System.out.println("Radio:");
        double radio = sc.nextDouble();
        System.out.println(" Ahora que calculo desea hacer de este cilindro : ");
        System.out.println("A- Area de un cilindro.");
        System.out.println("V- Volumen de un cilindro.");

        char n = sc.next().charAt(0);

        switch (n) {
            case 'A':
                Area(altura, radio);
                break;
            case 'V':
                Volumen(altura, radio);
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
    public static void Area(double altura, double radio) {
        double a = 2 * Math.PI * radio + (radio + altura);
        System.out.println("El resultado del area  es: " + a + " m²");
    }
    public static void Volumen(double altura, double radio) {
        double v = Math.PI * (radio * radio) * altura;
        System.out.println("El resultado del volumen es: " + v + " m³");
    }
}
