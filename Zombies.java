public class Zombies extends Personaggio{
    
    private static int countZombies=0;
    public Zombies(int x, int y) {
        super(x, y);
        Zombies.countZombies++;
    }
    
    public static int getCountZombies() {
        return countZombies;
    }
    
    public static void setCountZombies(int count){
        Zombies.countZombies = count;
    }

    @Override
    protected void die() {
        // TODO Auto-generated method stub
        System.out.println("Hai trovato un alieno!! Annientato!");
    }
    
    @Override
    public void move(Campo campo){
        System.out.println("Zombies");
        
        if(campo.isValidPosition(super.getX(), super.getY()+1)){
            System.out.println("Posizione non valida sei arrivato al margine del banco.");
        }
        else{
            campo.placePersonaggio(super.getX(), super.getY()+1, campo.whois(super.getX(), super.getY()));
        }
    }
    
}
