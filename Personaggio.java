public abstract class Personaggio{
    private int x;
    private int y;
    protected boolean vivo;

    public Personaggio(int x, int y) {
        this.x = x;
        this.y = y;
        this.vivo = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVivoFalse(){
        this.vivo=false;
    }

    public abstract void move(Campo campo);

    protected abstract void die();
}
