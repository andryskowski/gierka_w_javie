package entities;

import java.awt.*;

public class Player extends Creature{

    public Player ( float x, float y ) {
        super (x, y);
    }

    @Override
    public void tick () {

    }

    @Override
    public void render ( Graphics g ) {
   // g.drawImage(Asstets.player, (int) x, (int) y,observer);
    }
}
