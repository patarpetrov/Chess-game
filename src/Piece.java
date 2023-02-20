import java.util.LinkedList;


public class Piece {
    int xp;
    int yp;
    int x;
    int y;

    boolean isWhite;
    String name;
    //public static Piece[][] Map = new Piece[8][8];
    boolean[][] allowedMoves = new boolean[8][8];

    public Piece(int xp, int yp, boolean isWhite, String n)
    {
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;
        this.name = n;
        x = xp*64;
        y = yp*64;
        Game.ps.add(this);
    }
    private boolean checkTurn(){
        if(Game.iswhiteturn != this.isWhite)
        {
            x = this.xp*64;
            y = this.yp*64;
            return false;
        }
        return true;
    }

    public boolean move(int xp, int yp)
    {
        //check borders
        if(xp >=  8 || yp >= 8){
            this.returnToOriginalPosition();
            System.out.println("Out of borders");
            return false;
        }
        if(!checkTurn()){
            System.out.println("returning3");
            return false;
        }
        checkPossible();
        if(!this.allowedMoves[yp][xp]){
            System.out.println("Can`t do beacause of rules");
            this.returnToOriginalPosition();
            System.out.println("returning2");
            return false;
        }
        //check if there are already a piece in the position
        Piece p = Game.getPiecePosition(xp*64 + 32 , yp*64 + 42);
        if(p != null)
        {
            if(p.isWhite != isWhite)
            {
                p.kill();
            }
            else{
                System.out.println("They are in the same team");
                this.returnToOriginalPosition();
                System.out.println("returning1");
                return false;
            }
        }
        System.out.println("xp: " + xp + "yp" + yp);
        System.out.println("=======================================");
        if(xp <  8 && yp < 8){
            this.changeTheOriginalPosition(xp, yp);
            return true;
        }
        else{
            System.out.println("Out of borders!");
            this.returnToOriginalPosition();
            return false;
        }
    }
    public void kill(){
        Game.Map[this.yp][this.xp] = null;
        Game.ps.remove(this);
    }
    private void changeTheOriginalPosition(int xp, int yp){
        Game.Map[this.yp][this.xp] = null;
        Game.Map[yp][xp] = this;
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
    }
    private void returnToOriginalPosition(){
        x = this.xp*64;
        y = this.yp*64;
    }
    private void checkPossible(){

        boolean[][] allowedMoves1 = new boolean[8][8];
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++)
            {
                if (Game.Map[i][k] != null){
                System.out.print(Game.Map[i][k].name + " ");
                }
                else{
                System.out.print("null   ");
                }
            }
            System.out.println();
        }
        /*if(this.name.equalsIgnoreCase("pawn"))
        {
            allowedMoves1 = RulesGenerator.generatePawnRules(this);
        }

        if(this.name.equalsIgnoreCase("knight")) {
            allowedMoves1 = RulesGenerator.generateKnightRules(this);

        }
        if(this.name.equalsIgnoreCase("bishop"))
        {
            allowedMoves1 = RulesGenerator.generateBishopRules(this);
        }
        if(this.name.equalsIgnoreCase("rook"))
        {
            allowedMoves1 = RulesGenerator.generateRookRules(this);
        }
        if(this.name.equalsIgnoreCase("king"))
        {
            allowedMoves1 = RulesGenerator.generateKingRules(this);
        }
        if(this.name.equalsIgnoreCase("queen"))
        {
            allowedMoves1 = RulesGenerator.generateQueenRules(this);
        }*/

        switch(this.name){
            case "pawn" :
                allowedMoves1 = RulesGenerator.generatePawnRules(this);
                break;
            case "knight" :
                allowedMoves1 = RulesGenerator.generateKnightRules(this);
                break;
            case "bishop" :
                allowedMoves1 = RulesGenerator.generateBishopRules(this);
                break;
            case "rook" :
                allowedMoves1 = RulesGenerator.generateRookRules(this);
                break;
            case "king" :
                allowedMoves1 = RulesGenerator.generateKingRules(this);
                break;
            case "queen" :
                allowedMoves1 = RulesGenerator.generateQueenRules(this);
                break;
        }
        this.allowedMoves = allowedMoves1;
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                System.out.print(this.allowedMoves[i][k]);
            }
            System.out.println();
        }
    }
}
