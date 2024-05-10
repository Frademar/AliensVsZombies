public class Aliens extends Personaggio{
    private static int countAliens=0;
    public Aliens(int x, int y) {
        super(x, y);
        Aliens.countAliens++;
    }
    
    public static int getCountAliens() {
        return countAliens;
    }
    
    public static void setCountAliens(int count){
        Aliens.countAliens = count;
    }

    @Override
    protected void die() {
        System.out.println("Hai trovato uno zombies!! Laseeeratooooo!");
    }

    @Override
    public void move(Campo campo) {
        if(campo.isValidPosition(super.getX()+1, super.getY()+1)==false){
            System.out.println("Posizione non valida sei arrivato al margine del banco.");
        }
        else{
            System.out.println("X: "+super.getX());
            System.out.println("Y: "+super.getY());
            campo.placePersonaggio(super.getX()+1, super.getY()+1, campo.whois(super.getX(), super.getY()));
        }
    }
}
