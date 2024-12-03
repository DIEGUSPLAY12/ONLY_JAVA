import java.util.Scanner;

public class Registro_de_usuario_y_contraseña {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el usuario:");
        String usuario = sc.nextLine();
        System.out.println("Introduzca contraseña:");
        String contraseña = sc.nextLine();

        registro(usuario, contraseña);

    }
    public static void registro(String usuario, String contraseña) {
        if(usuario.equals("Diego")){
            System.out.println("Usuario correcto");
        } else{
            System.out.println("Usuario incorrecto");
            }
        if (contraseña.equals("HOLA")){
            System.out.println("Contraseña correcta");
        }else{
            System.out.println("Contraseña incorrecta");
        }

    }
}