import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Main extends Canvas implements Runnable, KeyListener {

    public static final int WIDTH = 160;
    public static final int HEIGHT = 120 ;
    public static final int SCALE = 3;

    public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    public static Player player ;

    public static Enemy enemy;

    public static Ball ball;

    public Main(){
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.addKeyListener(this);
        player = new Player(100, HEIGHT-5);
        enemy = new Enemy(100,5 );
        ball = new Ball(100, HEIGHT/2 - 1);
    }

    public static void main(String[] args) {

        //Por extender de canvas, esse método seria considerado um jogo, por isso inicializá-lo
        Main game = new Main();

        //Para criar uma janela
        JFrame janela = criaJanela("PONG", game);

        //Fazer a janela aparecer
        janela.setVisible(true);

        new Thread(game).start();


    }

    public void Tick(){

        player.Tick();
        enemy.Tick();
        ball.Tick();

    }

    public void Render(){

        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();


        g.setColor(Color.black);

        g.fillRect(0,0, WIDTH, HEIGHT);

        player.Render(g);
        enemy.Render(g);
        ball.Render(g);

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);

        bs.show();

    }

    public static JFrame criaJanela(String nome_aplicacao, Component component){

        JFrame janela = new JFrame(nome_aplicacao);

        //Deixa a janela não dimensionável
        janela.setResizable(false);

        //Ao clicar no 'exit' a janela é fechada
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adicionando o canvas
        janela.add(component);

        //Método window
        janela.pack();

        //Deixara a janela sempre ao centro da tela
        janela.setLocationRelativeTo(null);


        return janela;


    }

    /* Implements */

    @Override
    public void run() {

        while (true){

            Tick();
            Render();

            try{

                Thread.sleep(1000/60);



            }catch (Exception e){

            }

        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D){

            player.right = true;

        }else if(e.getKeyCode() == KeyEvent.VK_A){

            player.left = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D){

            player.right = false;

        }else if(e.getKeyCode() == KeyEvent.VK_A){

            player.left = false;

        }


    }
}