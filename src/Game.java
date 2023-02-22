import java.util.LinkedList;

public class Game {
    public static LinkedList<Piece> ps;
    public static Piece[][] Map;
    public static Frame window;
    public static boolean iswhiteturn;

    public static void startGame(){
        setPieces();
        buildWindow();
        iswhiteturn = true;
        MouseListeners.addMouseListeners();

    }
    public static void endGame(){
        window.setVisible(false);
        window.dispose();
    }
    private static void buildWindow(){
        window = new Frame();
        window.drawBoard();
        window.build();
    }

    public static Piece getPiecePosition(int x, int y){
        int xp = (x - 5)/64;
        int yp = (y - 32)/64;
       //System.out.println("mouse" + x + " " + y);
        System.out.println("quadrant mouse" + xp + " " + yp);
        if (Map[yp][xp] != null){
            System.out.println("Namerih " + Map[yp][xp].name);
        }
        return Map[yp][xp];
    }
    private static void setPieces(){
        System.out.println("Setting pieces...");
        Map = new Piece[8][8];
        ps = new LinkedList<>();
        Map[0][0]=new Piece(0, 0, false, "rook");
        Map[0][1]=new Piece(1, 0, false, "knight");
        Map[0][2]=new Piece(2, 0, false, "bishop");
        Map[0][3]=new Piece(3, 0, false, "queen");
        Map[0][4]=new Piece(4, 0, false, "king");
        Map[0][5]=new Piece(5, 0, false, "bishop");
        Map[0][6]=new Piece(6, 0, false, "knight");
        Map[0][7]=new Piece(7, 0, false, "rook");
        Map[1][1]=new Piece(1, 1, false, "pawn");
        Map[1][2]=new Piece(2, 1, false, "pawn");
        Map[1][3]=new Piece(3, 1, false, "pawn");
        Map[1][4]=new Piece(4, 1, false, "pawn");
        Map[1][5]=new Piece(5, 1, false, "pawn");
        Map[1][6]=new Piece(6, 1, false, "pawn");
        Map[1][7]=new Piece(7, 1, false, "pawn");
        Map[1][0]=new Piece(0, 1, false, "pawn");

        Map[7][0]=new Piece(0, 7, true, "rook");
        Map[7][1]=new Piece(1, 7, true, "knight");
        Map[7][2]=new Piece(2, 7, true, "bishop");
        Map[7][3]=new Piece(3, 7, true, "queen");
        Map[7][4]=new Piece(4, 7, true, "king");
        Map[7][5]=new Piece(5, 7, true, "bishop");
        Map[7][6]=new Piece(6, 7, true, "knight");
        Map[7][7]=new Piece(7, 7, true, "rook");
        Map[6][1]=new Piece(1, 6, true, "pawn");
        Map[6][2]=new Piece(2, 6, true, "pawn");
        Map[6][3]=new Piece(3, 6, true, "pawn");
        Map[6][4]=new Piece(4, 6, true, "pawn");
        Map[6][5]=new Piece(5, 6, true, "pawn");
        Map[6][6]=new Piece(6, 6, true, "pawn");
        Map[6][7]=new Piece(7, 6, true, "pawn");
        Map[6][0]=new Piece(0, 6, true, "pawn");
    }
}
