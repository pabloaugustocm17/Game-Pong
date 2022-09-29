import java.awt.*;

public class Enemy {

    public double x;
    public double y;
    public int width;
    public int height;

    public Enemy(double x, double y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    public void Tick(){
        this.x += (Main.ball.x - this.x - 6) * 0.4;



    }

    public void Render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y-2, width, height);
    }

}
