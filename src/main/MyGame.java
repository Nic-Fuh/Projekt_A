package main;

import objects.GameObject;
import objects.Player;
import org.newdawn.slick.*;

import java.util.ArrayList;

public class MyGame extends BasicGame {

    //pp :(

    static int width = 400;
    static int height = 400;

    static boolean fullscreenMode = false;
    static boolean showFPS = true;
    static String title = "Slick2D Basic Game Template";
    static int fpslimit = 60;
    static boolean vsyncState = false;

    public static Input in;

    public static Image player_img;
    public static Image hearth_img;

    public static int steps = 1;

    public static Player player;
    public static GameObject enemy;

    public static boolean playerAlive = true;

    public static int playerInvicebleTimer;

    public ArrayList<GameObject> objectArrayList = new ArrayList<>();

    public MyGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        in = gameContainer.getInput();
        player_img = new Image("Assets/Boy.png");
        hearth_img = new Image("Assets/hearth.png");

        player = new Player(player_img, hearth_img, width/2, 300, 0, player_img.getHeight(), 10);
        enemy = new GameObject(player_img, width/2, 200, 0, player_img.getHeight(), 10);

        objectArrayList.add(enemy);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        player.update();
        if (playerAlive) {
            if (in.isKeyDown(Input.KEY_W)) {
                player.setPos_y(player.getPos_y() - steps);
            }
            if (in.isKeyDown(Input.KEY_S)) {
                player.setPos_y(player.getPos_y() + steps);
            }
            if (in.isKeyDown(Input.KEY_A)) {
                player.setPos_x(player.getPos_x() - steps);
            }
            if (in.isKeyDown(Input.KEY_D)) {
                player.setPos_x(player.getPos_x() + steps);
            }
        }

        if(!(player.getHitbox().intersects(enemy.getHitbox()))){

            for (GameObject gameObject : objectArrayList) {
                gameObject.update();
            }
        }else{
            if (player.getHP() <= 0){
                this.playerAlive = false;
            }else {
                player.setHp(player.getHP() - enemy.getDamage());
                System.out.println(player.getHP());
            }
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        player.draw(graphics);

        for (GameObject gameObject : objectArrayList) {
            gameObject.draw(graphics);
        }
    }

    public static void main(String[] args) throws SlickException{
        AppGameContainer app = new AppGameContainer(new MyGame(title));

        app.setDisplayMode(width, height, fullscreenMode);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.setVSync(vsyncState);
        app.start();
    }
}
