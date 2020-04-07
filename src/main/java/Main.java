import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main  extends Canvas implements Runnable{
    public static final String TITLE = "Moja gierka";
    public static final int WIDTH = 800, HEIGHT = 600;
    private boolean RUNNING = false;
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

        //ustawianie okienka na środku
        frame.setLocationRelativeTo(null);
        //zeby nie dalo sie skalowac okna:
        frame.setResizable (false);
        //zeby wgl okno sie pojawilo
        frame.setVisible (true);
    }

    private void start(){
    if(RUNNING) return;
    RUNNING =true;

    new Thread(this, "Game" + TITLE).start();
    }

    private void stop(){
        if(!RUNNING) return;
        RUNNING =false;
        System.exit(0);
    }

    public void run(){
        while(RUNNING){
        update();
        render();
        }
        frame.dispose();
        stop();
    }

    private void update(){
    //System.out.println("pętla");
    }

    private void render(){
    BufferStrategy bs = getBufferStrategy ();
    if(bs==null){
        createBufferStrategy (3);
        return;
    }
    Graphics g = bs.getDrawGraphics ();
    //malowanie ekranu na czarno, od pixela [0,0] w lewym gornym rogu do piksela ostatniego w prawym dolnym [width, height]
    g.setColor(Color.BLACK);
    g.fillRect(0,0,WIDTH, HEIGHT);
    g.dispose();
    bs.show();
    }

    public static void main(String[] args) {
        new Main ( ).start();
    }
}