public class RulesGenerator {
    private static boolean[][] allowedMoves1;

    public static boolean[][] generatePawnRules(Piece p){
        allowedMoves1 = new boolean[8][8];
        int change;
        int firstmove;
        if(p.isWhite){
            change = -1;
            firstmove = -2;
        }
        else{
            change = 1;
            firstmove = 2;
        }
        System.out.println(5 + change);
        System.out.println("============================");

        try{
            if (Game.Map[p.yp + change][p.xp] == null){
                System.out.println("1");
                allowedMoves1[p.yp+ change][p.xp] = true;
            }
            if ((p.yp == 6 && p.isWhite == true)||(p.yp == 1 && p.isWhite == false)){
                if (Game.Map[p.yp + firstmove][p.xp] == null){
                    allowedMoves1[p.yp + firstmove][p.xp] = true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        try{
            if (Game.Map[p.yp + change][p.xp + 1] != null) {
                System.out.println("2");
                allowedMoves1[p.yp+change][p.xp+1] = true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        try {
            if (Game.Map[p.yp + change][p.xp - 1] != null) {
                System.out.println("3");
                allowedMoves1[p.yp + change][p.xp - 1] = true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return allowedMoves1;
    }
    public static boolean[][] generateKnightRules(Piece p) {
        allowedMoves1 = new boolean[8][8];
        //aheadleft
        try {
            System.out.println("AheadLeft");
            allowedMoves1[p.yp + 2][p.xp - 1] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}
        //aheadright

        try {
            System.out.println("AheadRight");
            allowedMoves1[p.yp + 2][p.xp + 1] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //RightRight
        try {
            System.out.println("RightRight");
            allowedMoves1[p.yp - 1][p.xp + 2] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //RightLeft
        try {
            System.out.println("RightLeft");
            allowedMoves1[p.yp + 1][p.xp + 2] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //LeftRight
        try {
            System.out.println("LeftRight");
            allowedMoves1[p.yp - 1][p.xp - 2] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //LeftLeft
        try {
            System.out.println("LeftLeft");
            allowedMoves1[p.yp + 1][p.xp - 2] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //BehindLeft
        try {
            System.out.println("behindLeft");
            allowedMoves1[p.yp - 2][p.xp - 1] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}

        //aheadright
        try {
            System.out.println("BehindRight");
            allowedMoves1[p.yp - 2][p.xp + 1] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}
        return allowedMoves1;
    }

    public static boolean[][] generateBishopRules(Piece p) {
        allowedMoves1 = new boolean[8][8];
        //down Left
        for(int i = 1; i < p.xp + 1; i++)
        {

            try{
                    /*if(Map[this.yp + i][this.xp - i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp + i][p.xp - i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //down Right
        for(int i = 1; i < 8 - p.xp; i++)
        {
            try{
                   /* if(Map[this.yp + i][this.xp + i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp + i][p.xp + i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //UpLeft
        for(int i = 1; i < p.xp + 1; i++)
        {
            try{
                   /* if(Map[this.yp - i][this.xp - i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp - i][p.xp - i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //up Right
        for(int i = 1; i < 8 - p.xp; i++)
        {
            try{
                    /*if(Map[this.yp - i][this.xp + i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp - i][p.xp + i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        return allowedMoves1;
    }

    public static boolean[][] generateRookRules(Piece p){
        allowedMoves1 = new boolean[8][8];
        for(int i = p.xp -1 ; i >= 0; i--)
        {
            //if(Map[this.yp][i] != null){ System.out.println("Break Left"); break;}
            allowedMoves1[p.yp][i] = true;
        }
        for(int i = p.xp + 1; i < 8; i++)
        {
            //if(Map[this.yp][i] != null){ System.out.println("Break Right"); break; }
            allowedMoves1[p.yp][i] = true;
        }
        //Down
        for(int i = p.yp + 1; i < 8; i++)
        {
            //if(Map[i][this.yp] != null){ System.out.println("Break Down"); break; }
            allowedMoves1[i][p.xp] = true;
        }
        for(int i = p.yp - 1; i >= 0; i--)
        {
            //if(Map[i][this.yp] != null){System.out.println("Break Up"); break; }
            allowedMoves1[i][p.xp] = true;
        }
        return allowedMoves1;
    }
    public static boolean[][] generateKingRules(Piece p){
        allowedMoves1 = new boolean[8][8];
        for(int i = -1; i <= 1; i++)
        {
            for(int k = -1; k <= 1; k++)
            {
                try {
                    if (k == i && k == 0) {
                        continue;
                    }
                    allowedMoves1[p.yp + i][p.xp + k] = true;

                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }
        return allowedMoves1;
    }
    public static boolean[][] generateQueenRules(Piece p ){
        allowedMoves1 = new boolean[8][8];
        for(int i = 1; i < p.xp + 1; i++)
        {

            try{
                    /*if(Map[this.yp + i][this.xp - i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp + i][p.xp - i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //down Right
        for(int i = 1; i < 8 - p.xp; i++)
        {
            try{
                    /*if(Map[this.yp + i][this.xp + i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp + i][p.xp + i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //UpLeft
        for(int i = 1; i < p.xp + 1; i++)
        {
            try{
                    /*if(Map[this.yp - i][this.xp - i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp - i][p.xp - i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        //up Right
        for(int i = 1; i < 8 - p.xp; i++)
        {
            try{
                    /*if(Map[this.yp - i][this.xp + i] != null)
                    {
                        break;
                    }*/
                allowedMoves1[p.yp - i][p.xp + i] = true;
            } catch(ArrayIndexOutOfBoundsException e) {}
        }
        for(int i = p.xp -1 ; i >= 0; i--)
        {
            //if(Map[this.yp][i] != null){ System.out.println("Break Left"); break;}
            allowedMoves1[p.yp][i] = true;
        }
        for(int i = p.xp + 1; i < 8; i++)
        {
            //if(Map[this.yp][i] != null){ System.out.println("Break Right"); break; }
            allowedMoves1[p.yp][i] = true;
        }
        //Down
        for(int i = p.yp + 1; i < 8; i++)
        {
            //if(Map[i][this.yp] != null){ System.out.println("Break Down"); break; }
            allowedMoves1[i][p.xp] = true;
        }
        for(int i = p.yp - 1; i >= 0; i--)
        {
            //if(Map[i][this.yp] != null){System.out.println("Break Up"); break; }
            allowedMoves1[i][p.xp] = true;
        }
        return allowedMoves1;
    }
}
