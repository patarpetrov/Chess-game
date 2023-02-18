import java.util.LinkedList;


public class Piece {
    int xp;
    int yp;
    int x;
    int y;

    boolean isWhite;
    LinkedList<Piece> ps;
    String name;
    boolean[][] allowedMoves = new boolean[8][8];

    public Piece(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps)
    {
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;
        this.ps = ps;
        this.name = n;
        ps.add(this);
    }
    public boolean move(int xp, int yp, Piece[][] Map, boolean iswhiteturn)
    {
        if(iswhiteturn != this.isWhite)
        {
            x = this.xp*64;
            y = this.yp*64;
            return false;
        }
        this.checkPossible(Map);
        for (int i = 0; i< 8; i++){
            for(int k =0; k < 8; k++)
            {
                System.out.print(this.allowedMoves[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("xp:" + xp + "   " + yp);
        if(!this.allowedMoves[yp][xp]){
            System.out.println("Can`t do beacause of rules");
            x = this.xp*64;
            y = this.yp*64;
            return false;
        }
        //check if there are already a piece in the position
        Piece p = Main.getPiecePosition(xp*64 + 32 , yp*64 + 42);
        if(p != null)
        {
            if(p.isWhite != isWhite)
            {
                p.kill();
            }
            else{
                x = this.xp*64;
                y = this.yp*64;
            }
        }
        if(xp <  8 && yp < 8){
            Map[this.yp][this.xp] = null;
            Map[yp][xp] = this;
            this.xp = xp ;
            this.yp = yp;
            x = xp*64;
            y = yp*64;
            return true;
        }
        else{
            x = this.xp*64;
            y = this.yp*64;
            return false;
        }
    }
    public void kill(){
        ps.remove(this);
    }
    void checkPossible(Piece[][] Map){

        boolean[][] allowedMoves1 = new boolean[8][8];
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++)
            {
                if (Map[i][k] != null){
                System.out.print(Map[i][k].name + " ");
                }
                else{
                System.out.print("null   ");
                }
            }
            System.out.println();
        }
        if(this.name.equalsIgnoreCase("pawn"))
        {
            int change;
            if(this.isWhite){
                change = -1;
            }
            else{
                change = 1;
            }
            System.out.println(5 + change);
            System.out.println("============================");

            try{
                if (Map[this.yp + change][this.xp] == null){
                    System.out.println("1");
                    allowedMoves1[this.yp+ change][this.xp] = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){}
            try{
                if (Map[this.yp + change][this.xp + 1] != null) {
                    System.out.println("2");
                    allowedMoves1[this.yp+change][this.xp+1] = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){}
            try {
                if (Map[this.yp + change][this.xp - 1] != null) {
                    System.out.println("3");
                    allowedMoves1[this.yp + change][this.xp - 1] = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){}
        }

        if(this.name.equalsIgnoreCase("knight")) {
            //aheadleft
            try {
                allowedMoves1[this.yp + 2][this.xp - 1] = true;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
            //aheadright

            try {
                allowedMoves1[this.yp + 2][this.xp + 1] = true;
            } catch (ArrayIndexOutOfBoundsException e) {}

            //RightRight
            try {
                    allowedMoves1[this.yp - 1][this.xp + 2] = true;
            } catch (ArrayIndexOutOfBoundsException e) {}

            //RightLeft
            try {
                    allowedMoves1[this.yp + 1][this.xp + 2] = true;
            } catch (ArrayIndexOutOfBoundsException e) {}

            //LeftRight
            try {
                    allowedMoves1[this.yp - 1][this.xp - 2] = true;
            } catch (ArrayIndexOutOfBoundsException e) {}

            //LeftLeft
            try {
                    allowedMoves1[this.yp + 1][this.xp - 2] = true;
            } catch (ArrayIndexOutOfBoundsException e) {}

            //BehindLeft
            try {
                    allowedMoves1[this.yp - 2][this.xp - 1] = true;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
            //aheadright
            try {
                    allowedMoves1[this.yp - 2][this.xp + 1] = true;
            }catch (ArrayIndexOutOfBoundsException e) {}

        }
        if(this.name.equalsIgnoreCase("bishop"))
        {
            //down Left
            for(int i = 1; i < this.xp + 1; i++)
            {

                try{
                    /*if(Map[this.yp + i][this.xp - i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[this.yp + i][this.xp - i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //down Right
            for(int i = 1; i < 8 - this.xp; i++)
            {
                try{
                   /* if(Map[this.yp + i][this.xp + i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp + i][this.xp + i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //UpLeft
            for(int i = 1; i < this.xp + 1; i++)
            {
                try{
                   /* if(Map[this.yp - i][this.xp - i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp - i][this.xp - i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //up Right
            for(int i = 1; i < 8 - this.xp; i++)
            {
                try{
                    /*if(Map[this.yp - i][this.xp + i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp - i][this.xp + i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
        }
        if(this.name.equalsIgnoreCase("rook"))
        {
            System.out.println("xp: " + this.xp + "yp " + this.yp);
            for(int i = this.xp -1 ; i >= 0; i--)
            {
                //if(Map[this.yp][i] != null){ System.out.println("Break Left"); break;}
                allowedMoves1[this.yp][i] = true;
            }
            for(int i = this.xp + 1; i < 8; i++)
            {
                //if(Map[this.yp][i] != null){ System.out.println("Break Right"); break; }
                allowedMoves1[this.yp][i] = true;
            }
            //Down
            for(int i = this.yp + 1; i < 8; i++)
            {
                //if(Map[i][this.yp] != null){ System.out.println("Break Down"); break; }
                allowedMoves1[i][this.xp] = true;
            }
            for(int i = this.yp - 1; i >= 0; i--)
            {
                //if(Map[i][this.yp] != null){System.out.println("Break Up"); break; }
                allowedMoves1[i][this.xp] = true;
            }
        }
        if(this.name.equalsIgnoreCase("king"))
        {
            for(int i = -1; i <= 1; i++)
            {
                for(int k = -1; k <= 1; k++)
                {
                    try {
                        if (k == i && k == 0) {
                            continue;
                        }
                        if (Map[this.yp + i][this.xp + k] == null) {
                            allowedMoves1[this.yp + i][this.xp + k] = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
        if(this.name.equalsIgnoreCase("queen"))
        {
            for(int i = 1; i < this.xp + 1; i++)
            {

                try{
                    /*if(Map[this.yp + i][this.xp - i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp + i][this.xp - i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //down Right
            for(int i = 1; i < 8 - this.xp; i++)
            {
                try{
                    /*if(Map[this.yp + i][this.xp + i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp + i][this.xp + i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //UpLeft
            for(int i = 1; i < this.xp + 1; i++)
            {
                try{
                    /*if(Map[this.yp - i][this.xp - i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp - i][this.xp - i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            //up Right
            for(int i = 1; i < 8 - this.xp; i++)
            {
                try{
                    /*if(Map[this.yp - i][this.xp + i] != null)
                    {
                        break;
                    }*/
                    allowedMoves1[this.yp - i][this.xp + i] = true;
                } catch(ArrayIndexOutOfBoundsException e) {}
            }
            for(int i = this.xp -1 ; i >= 0; i--)
            {
                //if(Map[this.yp][i] != null){ System.out.println("Break Left"); break;}
                allowedMoves1[this.yp][i] = true;
            }
            for(int i = this.xp + 1; i < 8; i++)
            {
                //if(Map[this.yp][i] != null){ System.out.println("Break Right"); break; }
                allowedMoves1[this.yp][i] = true;
            }
            //Down
            for(int i = this.yp + 1; i < 8; i++)
            {
                //if(Map[i][this.yp] != null){ System.out.println("Break Down"); break; }
                allowedMoves1[i][this.xp] = true;
            }
            for(int i = this.yp - 1; i >= 0; i--)
            {
                //if(Map[i][this.yp] != null){System.out.println("Break Up"); break; }
                allowedMoves1[i][this.xp] = true;
            }
        }
        this.allowedMoves = allowedMoves1;
    }
}
