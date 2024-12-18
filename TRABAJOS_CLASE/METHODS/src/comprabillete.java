import java.util.Scanner;

public class comprabillete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Benvingut a la màquina de venda de bitllets!");
            int tipusBitllet = demanarTipusBitllet(scanner);
            int zones = demanarZones(scanner);
            int nombreBitllets = demanarNombreBitllets(scanner);

            double preu = calcularPreu(tipusBitllet, zones, nombreBitllets);
            System.out.printf("El preu total és: %.2f€%n", preu);

            if (cobrar(scanner, preu)) {
                System.out.println("Pagament completat. Gràcies per la teva compra!");

                System.out.print("Vols un tiquet? (sí/no): ");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("si")) {
                    imprimirTiquet(tipusBitllet, zones, nombreBitllets, preu);
                }

                System.out.println("Torna quan vulguis!");
            } else {
                System.out.println("Pagament cancel·lat. Torna-ho a intentar.");
            }

            System.out.print("Vols comprar un altre bitllet? (sí/no): ");
            String respostaFinal = scanner.next();
            continuar = respostaFinal.equalsIgnoreCase("si");
        }

        scanner.close();
    }

    public static int demanarTipusBitllet(Scanner scanner) {
        while (true) {
            System.out.println("Selecciona el tipus de bitllet:");
            System.out.println("1. Bitllet senzill\n2. TCasual\n3. TUsual\n4. TFamiliar\n5. TJove");
            int opcio = scanner.nextInt();
            if (opcio >= 1 && opcio <= 5) {
                return opcio;
            } else {
                System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }
    }

    public static int demanarZones(Scanner scanner) {
        while (true) {
            System.out.println("Introdueix el número de zones (1, 2 o 3):");
            int zones = scanner.nextInt();
            if (zones >= 1 && zones <= 3) {
                return zones;
            } else {
                System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }
    }

    public static int demanarNombreBitllets(Scanner scanner) {
        while (true) {
            System.out.println("Quants bitllets vols? (1, 2 o 3):");
            int nombre = scanner.nextInt();
            if (nombre >= 1 && nombre <= 3) {
                return nombre;
            } else {
                System.out.println("Nombre no vàlid. Torna a intentar-ho.");
            }
        }
    }

    public static double calcularPreu(int tipusBitllet, int zones, int nombreBitllets) {
        double preuBase;

        switch (tipusBitllet) {
            case 1: preuBase = 2.40; break;
            case 2: preuBase = 11.35; break;
            case 3: preuBase = 40.00; break;
            case 4: preuBase = 10.00; break;
            case 5: preuBase = 80.00; break;
            default: throw new IllegalArgumentException("Tipus de bitllet no vàlid");
        }

        double factorZona = (zones == 1) ? 1.0 : (zones == 2) ? 1.3125 : 1.8443;
        return preuBase * factorZona * nombreBitllets;
    }

    public static boolean cobrar(Scanner scanner, double preu) {
        double totalIntroduit = 0.0;
        System.out.printf("Introdueix %.2f€ (acceptem monedes i bitllets):%n", preu);

        while (totalIntroduit < preu) {
            System.out.printf("Falten %.2f€. Introdueix una quantitat:%n", preu - totalIntroduit);
            double introduit = scanner.nextDouble();

            if (introduit == 0.05 || introduit == 0.10 || introduit == 0.20 || introduit == 0.50 ||
                    introduit == 1.00 || introduit == 2.00 || introduit == 5.00 || introduit == 10.00 || introduit == 20.00 || introduit == 50.00) {
                totalIntroduit += introduit;
            } else {
                System.out.println("Quantitat no vàlida. Introdueix una altra quantitat.");
            }
        }

        double canvi = totalIntroduit - preu;
        if (canvi > 0) {
            System.out.printf("El teu canvi és: %.2f€%n", canvi);
        }

        return true;
    }

    public static void imprimirTiquet(int tipusBitllet, int zones, int nombreBitllets, double preu) {
        String nomBitllet;
        switch (tipusBitllet) {
            case 1: nomBitllet = "Bitllet senzill"; break;
            case 2: nomBitllet = "TCasual"; break;
            case 3: nomBitllet = "TUsual"; break;
            case 4: nomBitllet = "TFamiliar"; break;
            case 5: nomBitllet = "TJove"; break;
            default: throw new IllegalArgumentException("Tipus de bitllet no vàlid");
        }

        System.out.println("********** Tiquet **********");
        System.out.printf("Tipus de bitllet: %s%n", nomBitllet);
        System.out.printf("Zones: %d%n", zones);
        System.out.printf("Nombre de bitllets: %d%n", nombreBitllets);
        System.out.printf("Preu total: %.2f€%n", preu);
        System.out.println("****************************");
    }
}
