public class Campo{
    
    private Personaggio[][] grid;

    public Campo(int size){
        this.grid=new Personaggio[size][size];
    }
// Stampa la griglia di personaggi
    public Personaggio[][] getGrid(){
        return this.grid;
    }
// Indichiamo alla nostra API, nell'occasione di liberare una cella da un personaggio, con l'attributo vivo per determinare una cella con nessuna proprietà.
    public void removePersonaggio(int x, int y){
        this.grid[x][y].die();
        this.grid[x][y]=null;
    }
// Con l'upcasting di java è possibile assegnare una della specializzazioni della classe generica padre ad un suo riferimento.
    public void placePersonaggio(int x, int y, Personaggio personaggio){
        if(this.grid[x][y] instanceof Zombies){
            Zombies.setCountZombies(Zombies.getCountZombies()-1);
            this.grid[x][y]=personaggio;
            this.removePersonaggio(x, y);

        }else if(this.grid[x][y] instanceof Aliens){
            Aliens.setCountAliens(Aliens.getCountAliens()-1);
            this.grid[x][y]=personaggio;
            this.removePersonaggio(x, y);
        }else{
            this.grid[x][y]=personaggio;
        }
    }
// Stabiliamo che la posizione dove si vuole muovere il personaggio sia consona alla dimensione del campo
    public boolean isValidPosition(int x, int y){
        if(x > this.grid.length || x < 2 || y > this.grid.length || y < 2){
            return false;
        }else{
            return true;
        }
    }
// Inizializiamo la nostra scacchiera con tutte le caselle false perche all'inizio al tavolo non partecipa nessun personaggio.
    // public void startBoard(){
    //     for(int i=0;i<this.grid.length;i++){
    //         for(int j=0;j<this.grid.length;j++){
                
    //             this.grid[i][j].setVivoFalse();
    //         }
    //     }
    // }
// Dopo la sua inizializzazione configuriamo sulla scacchiera i personaggi nelle caselle opposte
    public void setPersonaggiBoard(int num){
        Zombies.setCountZombies(num);
        Aliens.setCountAliens(num);  
        for(int i=0;i<num;i++){
            this.grid[i][0]=new Zombies(i, 0);
        }
        for(int j=this.grid.length-1;num>0;num-- , j--){
            this.grid[j][this.grid.length-1]=new Aliens(j, this.grid.length-1);
    }
    }
// Metodo che garantisce la restituzione di un personaggio
    public Personaggio whois(int x, int y){
        return this.grid[x][y];
    }

    public boolean gameOver(){
        if(Zombies.getCountZombies()==0){
            return true;
        }
        else if(Aliens.getCountAliens()==0){
            return true;
        }else{
            return false,
        }
    }
}