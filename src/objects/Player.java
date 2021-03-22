package objects;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player {

    protected Image img;
    protected Image hearth_img;

    protected int pos_x_Herz;

    protected int pos_x;
    protected int pos_y;

    protected int speed;

    protected Shape hitbox;
    protected float hitbox_size;

    protected Shape attackBox;

    protected float hp;

    protected float damage;


    public Player(Image img, Image hearth_img, int x, int y, int speed, float hitbox_size, float hp){

        this.img = img;
        this.hearth_img = hearth_img;
        this.pos_x = x;
        this.pos_y = y;
        this.speed = speed;
        this.hitbox_size = hitbox_size;
        this.hp = hp;
        this.damage = 1;
        this.pos_x_Herz = this.hearth_img.getWidth();

        this.hitbox = new Rectangle(x, y, hitbox_size, hitbox_size);

    }

    //TODO: unverwundbarkeit wenn man gehittet wird

    public void update(){
        this.pos_y += this.speed;
        this.hitbox.setLocation(this.getPos_x() - hitbox_size/2, this.getPos_y() - hitbox_size/2);
    }

    public void draw(Graphics g){
        this.img.drawCentered(this.getPos_x(), this.getPos_y());
        g.setColor(Color.green);
        g.draw(this.hitbox);

        this.pos_x_Herz = 0;

        for(int i = 0; i < this.hp ; i++){
            this.hearth_img.draw(this.pos_x_Herz ,370);
            this.pos_x_Herz += this.hearth_img.getWidth();
        }

    }

    public Image getImg(){
        return this.img;
    }

    public Shape getHitbox(){
        return this.hitbox;
    }

    public int getPos_x(){return pos_x;}
    public int getPos_y(){return pos_y;}

    public void setPos_x(int x){this.pos_x = x;}
    public void setPos_y(int y){this.pos_y = y;}

    public float getHP(){return hp;}
    public void setHp(float hp){
        this.hp = hp;
    }

    public float getDamage(){return damage;}


}
