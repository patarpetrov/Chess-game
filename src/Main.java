import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static Piece selectedPiece = null;
    public static LinkedList<Piece> ps;
    public static Piece[][] Map = new Piece[8][8];
    public static boolean iswhiteturn = true;
    public static void main(String[] args) {



        ps = StartGame();
        Frame window = new Frame(ps);

        window.drawBoard();
        //window.addPieces();
        window.build();
        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPiecePosition(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece.isWhite == iswhiteturn) {
                    if (selectedPiece.move((e.getX() - 5) / 64, (e.getY() - 32) / 64, Map, iswhiteturn)) {
                        iswhiteturn = !iswhiteturn;
                    }
                    window.repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        window.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece.isWhite == iswhiteturn) {
                    if (selectedPiece != null) {
                        selectedPiece.x = e.getX() - 32;
                        selectedPiece.y = e.getY() - 64;
                        window.repaint();
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        //window.setLayout(null);

    }
    public static LinkedList<Piece> StartGame(){
        LinkedList<Piece> ps = new LinkedList();

        Map[0][0]=new Piece(0, 0, false, "rook", ps);
        Map[0][1]=new Piece(1, 0, false, "knight", ps);
        Map[0][2]=new Piece(2, 0, false, "bishop", ps);
        Map[0][3]=new Piece(3, 0, false, "queen", ps);
        Map[0][4]=new Piece(4, 0, false, "king", ps);
        Map[0][5]=new Piece(5, 0, false, "bishop", ps);
        Map[0][6]=new Piece(6, 0, false, "knight", ps);
        Map[0][7]=new Piece(7, 0, false, "rook", ps);
        Map[1][1]=new Piece(1, 1, false, "pawn", ps);
        Map[1][2]=new Piece(2, 1, false, "pawn", ps);
        Map[1][3]=new Piece(3, 1, false, "pawn", ps);
        Map[1][4]=new Piece(4, 1, false, "pawn", ps);
        Map[1][5]=new Piece(5, 1, false, "pawn", ps);
        Map[1][6]=new Piece(6, 1, false, "pawn", ps);
        Map[1][7]=new Piece(7, 1, false, "pawn", ps);
        Map[1][0]=new Piece(0, 1, false, "pawn", ps);

        Map[7][0]=new Piece(0, 7, true, "rook", ps);
        Map[7][1]=new Piece(1, 7, true, "knight", ps);
        Map[7][2]=new Piece(2, 7, true, "bishop", ps);
        Map[7][3]=new Piece(3, 7, true, "queen", ps);
        Map[7][4]=new Piece(4, 7, true, "king", ps);
        Map[7][5]=new Piece(5, 7, true, "bishop", ps);
        Map[7][6]=new Piece(6, 7, true, "knight", ps);
        Map[7][7]=new Piece(7, 7, true, "rook", ps);
        Map[6][1]=new Piece(1, 6, true, "pawn", ps);
        Map[6][2]=new Piece(2, 6, true, "pawn", ps);
        Map[6][3]=new Piece(3, 6, true, "pawn", ps);
        Map[6][4]=new Piece(4, 6, true, "pawn", ps);
        Map[6][5]=new Piece(5, 6, true, "pawn", ps);
        Map[6][6]=new Piece(6, 6, true, "pawn", ps);
        Map[6][7]=new Piece(7, 6, true, "pawn", ps);
        Map[6][0]=new Piece(0, 6, true, "pawn", ps);
        return ps;

    }
    public static Piece getPiecePosition(int x, int y){
        int xp = (x - 5)/64;
        int yp = (y - 32)/64;
        System.out.println("mouse" + x + " " + y);
        System.out.println("quadrant mouse" + xp + " " + yp);
        for (Piece p: ps){
            if(p.xp == xp && p.yp == yp){
                System.out.println(p.name);
                return p;
            }
        }
        return null;
    }
}