import javax.swing.*;
import java.awt.*;

public class Main  extends Canvas {
    public static final String TITLE = "Moja gierka";
    public static final int WIDTH = 800, HEIGHT = 600;

    private JFrame frame;

    public Main () {
        setPreferredSize (new Dimension (WIDTH, HEIGHT));
        setMinimumSize (new Dimension (WIDTH, HEIGHT));
        setMaximumSize (new Dimension (WIDTH, HEIGHT));

        frame = new JFrame ("TITLE");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.add (this, new BorderLayout ( ).CENTER);
//frame.pack akceptuje dodanie rzeczy do okienka
        frame.pack ( );

        //zeby nie dalo sie skalowac okna:
        frame.setResizable (false);
        //zeby wgl okno sie pojawilo
        frame.setVisible (true);
    }
    public static void main(String[] args) {
        new Main ( );
    }
}