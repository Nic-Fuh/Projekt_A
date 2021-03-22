package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class GameObject {

    protected Image img;

    protected int pos_x;
    protected int pos_y;

    protected int speed;

    protected Shape hitbox;
    protected int hitbox_size;

    protected int hp;

    protected int damage;

    public GameObject(Image img, int x, int y, int speed, int hitbox_size, int hp){

        this.img = img;
        this.pos_x = x;
        this.pos_y = y;
        this.speed = speed;
        this.hitbox_size = hitbox_size;
        this.hp = hp;
        this.damage = 1;

        this.hitbox = new Rectangle(x, y, hitbox_size, hitbox_size);

    }

    public void update(){
        this.pos_y += this.speed;
        this.hitbox.setLocation(this.getPos_x() - hitbox_size/2, this.getPos_y() - hitbox_size/2);

    }

    public void draw(Graphics g){
        img.drawCentered(this.getPos_x(), this.getPos_y());
        g.setColor(Color.red);
        g.draw(this.hitbox);
    }

    public Image getImg(){
        return this.img;
    }

    public Shape getHitbox(){
        return this.hitbox;
    }

    public int getPos_x(){return pos_x;}
    public int getPos_y(){return pos_y;}

    public int getHP(){return hp;}
    public void setHp(int hp){this.hp = hp;}

    public int getDamage(){return damage;}



}
