import java.util.ArrayList;
import java.util.Scanner;

public class AliensVsZombies{
    public static void main(String[] args) {
        String pedina="0";
        Scanner scanner = new Scanner(System.in);
        int size;
        int numPersonaggi;
        int cont=0;
        ArrayList<Personaggio> personaggi = new ArrayList<Personaggio>();
        do{
            System.out.println("Quanto per lato deve essere lungo il banco di gioco?\n Puo' esserlo massimo 8 caselle:");
            size=scanner.nextInt();
            
            if (size > 8 || size < 2) {
                System.out.println("Errore: dimensione non valida! La dimensione deve essere compresa tra 2 e 8.");
            }
            
        }while(size > 8 || size < 2);
        
        Campo campo = new Campo (size);
        
        do{
            System.out.println("Quanti personaggi per squadra vuoi inserire (almeno uno e massimo "+size+"):");
            numPersonaggi=scanner.nextInt();
            
            if (numPersonaggi < 1 || numPersonaggi > size) {
                System.out.println("Errore: Il numero dei personaggi non e' incline al game!");
            }
        }while(numPersonaggi < 1 || numPersonaggi > size);
        
        campo.setPersonaggiBoard(numPersonaggi);
        while(!campo.gameOver()){
            AliensVsZombies.printBoardState(campo);
            System.out.println("Quale dei personaggi vuoi utilizzare");
            System.out.println("Quale scegli tra (A / Alieni e Z / Zombies): ");
            
            do{
                pedina=scanner.nextLine();    
                scanner.nextInt();
            }while(pedina!="A"||pedina!="a"||pedina!="Z"||pedina!="z");
            System.out.println(pedina);
            for(int j=0;j<campo.getGrid().length;j++){
                for(int i=0;i<campo.getGrid().length;i++){
                    if(campo.whois(i, j) instanceof Zombies && (pedina=="Z" | pedina=="z")){
                        System.out.print("Z ("+i+";"+j+") ");
                        personaggi.add(campo.whois(i, j));
                    }
                    else if(campo.whois(i, j) instanceof Aliens && (pedina=="A" | pedina=="a")){
                        System.out.print("A ("+i+";"+j+") ");
                        personaggi.add(campo.whois(i, j));
                    }
                }
            }
            
            System.out.print("/n"); 
            int x;
            int y;
            do{
                System.out.println("Controlla il personaggio alle coordinate X:");
                x=scanner.nextInt();
                System.out.println("Anche quelle delle coordinate Y:");
                y=scanner.nextInt();
                
                if(!campo.isValidPosition(x, y)){
                    System.out.println("Posizione non valida! Ritenta!");
                }
            }while(!campo.isValidPosition(x, y));
            if (personaggi.contains(campo.whois(x, y))) {
                campo.whois(x, y).move(campo);
            }
            else{
                System.out.println("Personaggio non trovato!!");
            }
            
        }
    }
    
    public static void printBoardState(Campo campo){
        for(int j=0; j<campo.getGrid().length; j++){
            for(int i=0; i<campo.getGrid().length; i++){
                if(campo.getGrid()[i][j] instanceof Zombies){
                    System.out.print("Z ");
                }else if(campo.getGrid()[i][j] instanceof Aliens){
                    System.out.print("A ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println("");

        }
    }
}