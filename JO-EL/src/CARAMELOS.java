import java.util.Scanner;
public class CARAMELOS {
    public static void main (String[] args){
       int caramelo=0;
       int nietos=0;
       int resultado=0;
       Scanner llegir = new Scanner(System.in);
       caramelo=llegir.nextInt();
       nietos=llegir.nextInt();
       resultado= caramelo%nietos;
       System.out.println(resultado);

    }
}