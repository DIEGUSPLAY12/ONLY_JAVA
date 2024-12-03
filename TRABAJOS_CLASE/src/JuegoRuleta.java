import java.util.*;

public class JuegoRuleta {

    // Método para obtener el color de un número en la ruleta
    public static String obtenerColor(int numero) {
        // Colores: rojo y negro en una ruleta estándar (0 es verde)
        if (numero == 0) {
            return "Verde";  // El 0 es verde
        }
        // Definir los números rojos y negros en una ruleta estándar
        int[] rojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        for (int rojo : rojos) {
            if (numero == rojo) {
                return "Rojo";
            }

        }
        return "Negro";
    }

    // Método para verificar si el número es par o impar
    public static String obtenerParidad(int numero) {
        if (numero == 0) {
            return "Ni par ni impar (es el 0)";
        }
        return (numero % 2 == 0) ? "Par" : "Impar";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Saldo inicial
        double saldo = 1000.0;
        System.out.println("¡Bienvenido al juego de la ruleta!");
        System.out.println("Tu saldo inicial es: $1000");

        // Bucle para permitir al jugador apostar varias veces
        while (saldo > 0) {
            System.out.println("\nSaldo actual: $" + saldo);
            System.out.println("Elige qué tipo de apuesta quieres hacer:");
            System.out.println("1. Apostar a uno o más números específicos (0-36)");
            System.out.println("2. Apostar a un color (rojo/negro)");
            System.out.println("3. Apostar a par/impar");
            System.out.print("Elige una opción (1, 2 o 3): ");
            int tipoApuesta = scanner.nextInt();

            // Pedir la cantidad a apostar
            System.out.print("¿Cuánto deseas apostar? $");
            double apuestaTotal = scanner.nextDouble();

            // Validar que la apuesta no exceda el saldo
            if (apuestaTotal > saldo) {
                System.out.println("No tienes suficiente saldo.");
                continue;  // Volver al inicio del ciclo
            }

            // Variables para almacenar las apuestas
            Map<Integer, Double> apuestasPorNumero = new HashMap<>();
            String colorApostado = "";
            String paridadApostada = "";

            switch (tipoApuesta) {
                case 1: // Apostar a uno o más números específicos
                    System.out.println("Ingresa los números a los que deseas apostar, separados por espacios (0-36): ");
                    scanner.nextLine(); // Limpiar buffer
                    String input = scanner.nextLine();
                    String[] numeros = input.split(" ");

                    // Dividir la cantidad total de la apuesta entre los números
                    double apuestaPorNumero = apuestaTotal / numeros.length;

                    for (String num : numeros) {
                        try {
                            int numInt = Integer.parseInt(num);
                            if (numInt >= 0 && numInt <= 36) {
                                apuestasPorNumero.put(numInt, apuestaPorNumero);
                            } else {
                                System.out.println("Número " + numInt + " no es válido, será ignorado.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida: " + num + ". Debes ingresar solo números.");
                        }
                    }
                    break;

                case 2: // Apostar a color (rojo/negro)
                    System.out.print("A qué color deseas apostar? (rojo/negro): ");
                    colorApostado = scanner.next().toLowerCase();
                    break;

                case 3: // Apostar a par/impar
                    System.out.print("A qué tipo deseas apostar? (par/impar): ");
                    paridadApostada = scanner.next().toLowerCase();
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    continue;
            }

            // Simular el giro de la ruleta
            int numeroRuleta = random.nextInt(37);  // Un número aleatorio entre 0 y 36
            String colorRuleta = obtenerColor(numeroRuleta);
            String paridadRuleta = obtenerParidad(numeroRuleta);

            // Mostrar el resultado de la ruleta
            System.out.println("La ruleta gira... y el número ganador es: " + numeroRuleta + " (" + colorRuleta + ", " + paridadRuleta + ")");

            // Procesar según el tipo de apuesta
            boolean gano = false;
            switch (tipoApuesta) {
                case 1: // Apostar a uno o más números específicos
                    for (Map.Entry<Integer, Double> entry : apuestasPorNumero.entrySet()) {
                        int numeroApostado = entry.getKey();
                        double cantidadApostada = entry.getValue();
                        if (numeroApostado == numeroRuleta) {
                            System.out.println("¡Felicidades, has ganado en el número " + numeroApostado + "!");
                            saldo += cantidadApostada * 35;  // Pagamos 35 veces la apuesta por acertar el número
                        } else {
                            System.out.println("No has acertado el número " + numeroApostado + ". Pierdes esa apuesta.");
                            saldo -= cantidadApostada;  // Pierde la apuesta
                        }
                    }
                    break;

                case 2: // Apostar a color (rojo/negro)
                    if (colorApostado.equals(colorRuleta.toLowerCase())) {
                        System.out.println("¡Felicidades, has ganado!");
                        saldo += apuestaTotal;  // Pagamos 1:1 por acertar el color
                        gano = true;
                    } else {
                        System.out.println("Lo siento, no has acertado el color.");
                        saldo -= apuestaTotal;
                    }
                    break;

                case 3: // Apostar a par/impar
                    if (paridadApostada.equals(paridadRuleta.toLowerCase())) {
                        System.out.println("¡Felicidades, has ganado!");
                        saldo += apuestaTotal;  // Pagamos 1:1 por acertar la paridad
                        gano = true;
                    } else {
                        System.out.println("Lo siento, no has acertado la paridad.");
                        saldo -= apuestaTotal;
                    }
                    break;
            }

            // Verificar si el jugador ha quedado sin dinero
            if (saldo <= 0) {
                System.out.println("Te has quedado sin dinero. ¿Quieres recargar tu saldo?");
                System.out.print("Ingresa la cantidad para recargar (0 para salir): $");
                double recarga = scanner.nextDouble();
                if (recarga > 0) {
                    saldo += recarga;
                    System.out.println("Tu saldo ha sido recargado. Nuevo saldo: $" + saldo);
                } else {
                    System.out.println("Gracias por jugar. Tu saldo final es: $0");
                    break;
                }
            }

            // Preguntar al jugador si quiere seguir jugando
            if (saldo > 0) {
                System.out.print("¿Quieres seguir jugando? (sí/no): ");
                String respuesta = scanner.next().toLowerCase();
                if (respuesta.equals("no")) {
                    System.out.println("Gracias por jugar. Tu saldo final es: $" + saldo);
                    break;
                }
            }
        }

        scanner.close();
    }
}
