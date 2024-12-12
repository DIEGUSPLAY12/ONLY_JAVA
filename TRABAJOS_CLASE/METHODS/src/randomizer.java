import java.util.Scanner;

public class randomizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int salir=0;
                do{
                    System.out.println("Bienvenido a la ruleta aleatoria");
                    System.out.println("Introduce primero el numero de huecos que pondras en la ruleta:");
                    int huecos = sc.nextInt();

                    String[] ruleta = new String[huecos];

                for (int i = 0; i < huecos; i++) {
                    System.out.println("Hueco numero"+ (i+1));
                    ruleta[i] = sc.next();
                }

                    int randomIndex = (int) (Math.random() * huecos);
                    String randomName = ruleta[randomIndex];


                    System.out.println("¡El nombre seleccionado al azar es: " + randomName + "!");
                    System.out.println("Desea salir de la ruleta? SI=1 NO=2");
                    salir = sc.nextInt();

                }while(salir==2);


    }
}
