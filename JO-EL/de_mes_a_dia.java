import java.util.Scanner;
public class de_mes_a_dia {
    public static void main (String[] args){
        int numero=0;
        Scanner llegir = new Scanner(System.in);
        numero = llegir.nextInt();
        if (numero<31){
            System.out.println(1);
        } else if (numero>31 && numero<=59){
            System.out.println(2);
        } else if (numero>59 && numero<=90){
            System.out.println(3);
        } else if (numero>90 && numero<=120){
            System.out.println(4);
        } else if (numero>120 && numero<=151){
            System.out.println(5);
        } else if (numero>151 && numero<=181){
            System.out.println(6);
        } else if (numero>181 && numero<=212){
            System.out.println(7);
        } else if (numero>212 && numero<=242){
            System.out.println(8);
        } else if (numero>242 && numero<=273){
            System.out.println(9);
        } else if (numero>273 && numero<=303){
            System.out.println(10);
        } else if (numero>303 && numero<=334){
            System.out.println(11);
        } else if (numero>334 && numero<=365){
            System.out.println(12);
        }



    }
}