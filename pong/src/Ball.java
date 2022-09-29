import java.awt.*;
import java.util.Random;

public class Ball {

    public double x;
    public double y;
    public int width;
    public int height;
    public double dx;
    public double dy;
    public double speed = 1.7;


    public Ball(double x, double y){

        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 4;

        int angle = new Random().nextInt(120 - 45) + 45 + 1;
        this.dx = Math.cos(Math.toRadians(angle));
        this.dy = Math.sin(Math.toDegrees(angle));
    }

    public void Tick(){

        if(this.x + (this.dx * this.speed) + width >= Main.WIDTH){
            this.dx *= -1;
        }else if(this.x + (this.dx * this.speed) < 0){
            this.dx *= -1;
        }

        if(y >= Main.HEIGHT){
            System.out.println("Ponto inimigo");
            new Main();
            return;
        }else if(y < 0){
            System.out.println("Ponto jogador");
            new Main();
            return;
        }

        Rectangle bounds = new Rectangle((int) (this.x + (this.dx * this.speed)),
                (int)(this.y + (this.dy * this.speed)), width, height);

        Rectangle boundsPlayer = new Rectangle(Main.player.x, Main.player.y,
                Main.player.width, Main.player.height);

        Rectangle boundsEnemy = new Rectangle((int)Main.enemy.x, (int)Main.enemy.y,
                Main.enemy.width, Main.enemy.height);

        if(bounds.intersects(boundsPlayer)){
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toDegrees(angle));
            if(this.dy > 0){
                this.dy *= -1;
            }
        }else if(bounds.intersects(boundsEnemy)){
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toDegrees(angle));
            if(this.dy < 0){
                this.dy *= -1;
            }
        }

        this.x += this.dx * this.speed;
        this.y += this.dy * this.speed;

    }

    public void Render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y-2, width, height);
    }


}
