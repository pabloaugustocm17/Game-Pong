import javax.swing.*;
import java.awt.*;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 240;
    public static final int HEIGHT = 120 ;
    public static final int SCALE = 3;

    public Main(){
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    }

    public static void main(String[] args) {

        //Por extender de canvas, esse método seria considerado um jogo, por isso inicializá-lo
        Main game = new Main();

        //Para criar uma janela
        JFrame janela = criaJanela("PONG", game);

        //Fazer a janela aparecer
        janela.setVisible(true);


    }

    private static JFrame criaJanela(String nome_aplicacao, Component component){

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

    @Override
    public void run() {

    }


}