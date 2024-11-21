import java.util.Scanner;
public class QUADRAT {
    public static void main (String[] args){
        int numero=0;
        int area=0;
        Scanner llegir = new Scanner(System.in);

        numero = llegir.nextInt();
        area = numero*numero;
        System.out.println(area);
    }
}
