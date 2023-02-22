import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class MouseListeners {
    private static Piece selectedPiece;
    public static void addMouseListeners(){

        Game.window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = Game.getPiecePosition(e.getX(), e.getY());
                System.out.println(Game.getPiecePosition(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //try{
                    //System.out.println("SELECTED PIECE: " + selectedPiece.name);
                if (selectedPiece != null){
                    if(selectedPiece.isWhite == Game.iswhiteturn) {
                        if (selectedPiece.move((e.getX() - 5) / 64, (e.getY() - 32) / 64)) {
                            Game.iswhiteturn = !Game.iswhiteturn;
                        }
                        Game.window.repaint();
                    }
                    else{
                        System.out.println("It`s not your turn");
                    }
                }
                //}catch(NullPointerException e1){}
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
            Game.window.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece != null) {
                    if (selectedPiece.isWhite == Game.iswhiteturn) {
                        selectedPiece.x = e.getX() - 32;
                        selectedPiece.y = e.getY() - 64;
                        Game.window.repaint();
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
}
