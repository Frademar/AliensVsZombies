import java.util.Scanner;

public class AliensVsZombies{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int numPersonaggi;
        do{
            System.out.println("Quanto per lato deve essere lungo il banco di gioco?\n Puo' esserlo massimo 8 caselle:");
            size=scanner.nextInt();
            
            if (size > 8 || size < 2) {
                System.out.println("Errore: dimensione non valida! La dimensione deve essere compresa tra 2 e 8.");
            }
            
        }while(size > 8 || size < 2);
        
        Campo campo = new Campo (size);
        
        do{
            System.out.println("Quanti personaggi per squdra vuoi inserire (almeno uno e massimo "+size+"):");
            numPersonaggi=scanner.nextInt();
            
            if (numPersonaggi < 1 || numPersonaggi > size) {
                System.out.println("Errore: Il numero dei personaggi non e' incline al game!");
            }
        }while(numPersonaggi < 1 || numPersonaggi > size);
        
        campo.setPersonaggiBoard(numPersonaggi);
    }
}