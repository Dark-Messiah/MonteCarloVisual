import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

class FrameTestBase extends JFrame { // hz zachem on ego extendit

    public static void main(String args[]) {
        FrameTestBase t = new FrameTestBase();
        t.add(new JComponent() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  // toge hz chto eto
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Graphics2D g3 = (Graphics2D) g;
                g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Graphics2D g4 = (Graphics2D) g;
                g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                double s;
                int k=0;
                Random rndx = new Random();
                Random rndy = new Random();
                double rx=0;
                double ry=0;
                double ax,bx,cx,dx;
                double ay,by,cy,dy;
                ax=0;
                cx =80;
                bx = 100;
                by = 100;
                dx = 200;
                dy = 200;
                ay =0;
                cy =50;
                int n= 100000;
// eto byli peremennye


                double[] x = {ax,bx,cx,dx}; // massiv Iksov
                double[] y = {ay,by,cy,dy};
                Arrays.sort(x);
                Arrays.sort(y);
// NAKIDAEM TOCHEK
                for (int i=0 ; i< n; i++) {
                    rx = rndx.nextDouble();
                    rx*=x[3];

                    ry = rndy.nextDouble();
                    ry*=y[3];
                    System.out.println(rx + "   " + ry);// logica sverhrazuma! nu a tak prosto proverka na use usloviya
                    if     ((rx >=ax && rx <= bx && rx>=cx && rx <= dx && ry >=ay && ry <= by && ry>=cy && ry <= dy) ||
                            (rx <=ax && rx >= bx && rx<=cx && rx >= dx && ry <=ay && ry >= by && ry<=cy && ry >= dy)){
                        k++;
                        g2.setColor(Color.MAGENTA);
                        g2.draw(new Line2D.Double(rx,ry,rx,ry));
                        // esli v peresechenii
                    }
                   if(((rx >=ax && rx <= bx && ry>=ay && ry <= by) || rx <=ax && rx >= bx && ry<=ay && ry >= by) && !((rx >=cx && rx <= dx && ry>=cy && ry <= dy) || rx <=cx && rx >= dx && ry<=cy && ry >= dy)){
                        g3.setColor(Color.BLUE);
                        g3.draw(new Line2D.Double(rx,ry,rx,ry));
                        //esli tochka v pervom pryamougle
                    }
                    if(((rx >=cx && rx <= dx && ry>=cy && ry <= dy) || rx <=cx && rx >= dx && ry<=cy && ry >= dy) && !((rx >=ax && rx <= bx && ry>=ay && ry <= by) || rx <=ax && rx >= bx && ry<=ay && ry >= by)){
                        g4.setColor(Color.PINK);
                        g4.draw(new Line2D.Double(rx,ry,rx,ry));
                        //esli tochka vo vtotrom pryamougle
                    }
                }
                System.out.println(k+ " SKOLechko vnutri peresecheniya ");

                double ssl = abs(x[0]-x[3])*abs(y[0]-y[3]);
                System.out.println("ploshad"+ ssl);
                double nn = n + 0.0;
                s = (k/nn)*ssl;
                System.out.println("Ploshad peresecheniya" + s);

                }
        }

);t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(400, 400);
        t.setVisible(true);

        }
    }

