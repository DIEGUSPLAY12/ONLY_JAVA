import java.util.Scanner;
public class harry_el_potas {
    public static void main (String[] args){
        String casa;
        Scanner llegir = new Scanner(System.in);
        casa = llegir.nextLine();
        switch (casa){
            case "Coratge":
                System.out.println("Gryffindor");
                break;
            case "Coneixement":
                System.out.println("Ravenclaw");
                break;
            case "Ambicio":
                System.out.println("Slytherin");
                break;
            default:
                System.out.println("Hufflepuff");
                break;
        }



    }
}