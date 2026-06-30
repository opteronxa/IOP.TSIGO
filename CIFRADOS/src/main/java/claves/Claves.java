package claves;

import java.util.Scanner;

/**
 *
 * @author xanum
 */
public class Claves {

    public static void main(String[] args) {
        try {
            try (Scanner y_scanner = new Scanner(System.in)) {
                System.out.print( "\r\n\r\nEscribe un Texto Cualquiera <Enter>: ");
                String y_msj = y_scanner.nextLine();
                //==
                Criptor_AES128 y_aes = new Criptor_AES128();
                String y_key=y_aes.getAESKEY();
                String y_cifradoaes = y_aes.encriota(y_msj);
                System.out.println("\r\n------------------------------------------------");
                System.out.println("1) LLave generada para cifrar el mensaje con AES-128 (Base64): " + y_key + "\r\n");
                System.out.println("2) Par de llaves generadas para SRA (Base64): ");
                Criptor_RSA y_rsa = new Criptor_RSA();
                System.out.println("\r\n------------------------------------------------");
                System.out.println("3) Cifrando Mensaje \"" + y_msj + "\" Con la llave AES-128 " + y_key + " nos queda como: " + y_cifradoaes);
                System.out.println("\r\n------------------------------------------------");
                String y_cifradorsa = y_rsa.Cifra(y_key);
                System.out.println("4) Cifrando la LLave AES-128 " + y_key + " con la PUBLIC-KEY RSA nos queda como: " + y_cifradorsa);
                System.out.println("\r\n------------------------------------------------");
                System.out.println("5) Descifrando AES-128 utilizando la PRIVATE-KEY RSA nos queda como: " + y_rsa.Descifar(y_cifradorsa));
                System.out.println("\r\n------------------------------------------------");
                System.out.println("7) Por ultimo decifrando el mensaje \r\n" + y_cifradoaes + "\r\ncon la llave " + y_key + " ya desifrada, nos queda: " + y_aes.desencripta(y_cifradoaes) + " \r\nque debe ser identico al Mensaaje Original");
                System.out.println("\r\n------------------------------------------------");
                //==
            }
        } catch (Exception ex) {
            System.getLogger(Claves.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
}
