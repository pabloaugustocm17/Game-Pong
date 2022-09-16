import java.awt.*;

public class Player {

    public boolean right;
    public boolean left;

    public int width;

    public int height;

    public int x;

    public int y;

    Player(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    public void Tick(){

        if(right){
            this.x++;

        }else if(left){
            this.x--;
        }

        //Colisão

        if(width+x > Main.WIDTH){
            x = Main.WIDTH - width;
        } else if(x < 0){
            x = 0;
        }



    }

    public void Render(Graphics g){

        g.setColor(Color.white);
        g.fillRect(x, y-2, width, height);


    }


}


