import Display.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage;


    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
    this.title=title;
    }

    private void init(){
        display = new Display(title, width, height);
        testImage = ImageLoader.loadImage ("/textures/wies.png" );
    }
private void tick(){

}
private void render(){
bs=display.getCanvas().getBufferStrategy ();
if(bs==null){
    display.getCanvas().createBufferStrategy (3);
    return;
}
g = bs.getDrawGraphics ();
//Draw here
    //rysujemy od (0,0) do (width, height)
    //g.fillRect(0,0,width, height);
    //Clear Screen
    g.clearRect(0,0,width,height);
   /* g.setColor(Color.blue);
    g.fillRect(10,50,50,70);
    g.setColor(Color.yellow);
    g.fillRect(0,0,10,10); */
   g.drawImage(testImage, 20, 20, null);
    //End drawing
    bs.show();
    g.dispose();
}
    public void run(){
    init();
    while(running){
    tick();
    render();
    }
    stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
    thread = new Thread(this);
    thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running =false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
