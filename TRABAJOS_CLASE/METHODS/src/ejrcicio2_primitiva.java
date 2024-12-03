import java.util.Scanner;

public class ejrcicio2_primitiva {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numerosUsuario = new int[6];
        int[] numerosSorteo = new int[6];


        System.out.println("Bienvenido al programa de la Primitiva.");
        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.print("Introduce el " + (i + 1) + "° número entre 0 y 49: ");
                int numero = scanner.nextInt();


                if (numero < 0 || numero > 49) {
                    System.out.println("El número debe estar entre 0 y 49.");
                } else {

                    boolean repetido = false;
                    for (int j = 0; j < i; j++) {
                        if (numerosUsuario[j] == numero) {
                            repetido = true;
                            break;
                        }
                    }

                    if (repetido) {
                        System.out.println("Número repetido. Ingresa un número distinto.");
                    } else {
                        numerosUsuario[i] = numero;
                        break;
                    }
                }
            }
        }


        System.out.println("Generando los números sorteados...");
        for (int i = 0; i < 6; i++) {
            int numeroSorteo;
            while (true) {
                numeroSorteo = (int) (Math.random() * 50);
                boolean repetido = false;

                for (int j = 0; j < i; j++) {
                    if (numerosSorteo[j] == numeroSorteo) {
                        repetido = true;
                        break;
                    }
                }

                if (!repetido) {
                    numerosSorteo[i] = numeroSorteo;
                    break;
                }
            }
        }


        System.out.print("Los números sorteados son: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(numerosSorteo[i] + " ");
        }
        System.out.println();

        int aciertos = calcularAciertos(numerosUsuario, numerosSorteo);
        System.out.println("Tienes " + aciertos + " aciertos.");

        scanner.close();
    }
    public static int calcularAciertos(int[] usuario, int[] sorteo) {
        int aciertos = 0;

        for (int i = 0; i < usuario.length; i++) {
            for (int j = 0; j < sorteo.length; j++) {
                if (usuario[i] == sorteo[j]) {
                    aciertos++;
                    break;
                }
            }
        }
        return aciertos;
    }

}


