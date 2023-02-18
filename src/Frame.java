import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Frame extends JFrame {
    LinkedList<Piece> ps;
    JPanel main;
    JPanel background;
    Frame(LinkedList<Piece> ps) {
        this.setTitle("Chess game");
        this.setBounds(10, 10, 512, 612);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        this.ps = ps;
        this.main = new JPanel();
        this.background = new JPanel();
    }

    public void drawBoard() {
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                //reading the images for pieces
                Image piecesImages[] = new Image[12];
                BufferedImage image = null;
                //reading the image and catching if error occurs
                try {
                    image = ImageIO.read(new File("chess.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
                //cutting the image
                int index = 0;
                for (int y = 0; y < 400; y += 200) {
                    for (int x = 0; x < 1200; x += 200) {
                        piecesImages[index] = image.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                        index++;
                    }
                }
                //painting the background
                boolean white = true;
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            g.setColor(new Color(242, 225, 195));
                        } else {
                            g.setColor(new Color(195, 160,130));
                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
                //painting the pieces

                for (Piece p : ps) {
                    int index1 = 0;
                    if (p.name.equalsIgnoreCase("king")) {
                        index1 = 0;
                    } else if (p.name.equalsIgnoreCase("queen")) {
                        index1 = 1;
                    } else if (p.name.equalsIgnoreCase("bishop")) {
                        index1 = 2;
                    } else if (p.name.equalsIgnoreCase("knight")) {
                        index1 = 3;
                    } else if (p.name.equalsIgnoreCase("rook")) {
                        index1 = 4;
                    } else if (p.name.equalsIgnoreCase("pawn")) {
                        index1 = 5;
                    }
                    if (!p.isWhite) {
                        index1 += 6;
                    }
                    g.drawImage(piecesImages[index1], p.x , p.y, this);
                }
            }
        };
        //this.add(panel);
        this.main = panel;
        System.out.println("Background panel added");
    }


    public void build(){

        this.add(this.main);
        //this.add(this.main);
    }
}


