package game_components.graphic_display;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import game_components.Grid;
import game_components.graphic_display.states.GameStateManager;

public class Panel extends JPanel implements Runnable{

    private final int width;
    private final int height;
    private Thread thread;
    private final Grid grid;

    private static int blockSize = 50;

    private boolean running = false;
    private BufferedImage img;
    private Graphics2D graphics;
    private MouseHandler mouse;

    private GameStateManager gsm;

    public Panel(Grid grid){
        this.width = grid.getWidth()*blockSize;
        this.height = grid.getLength()*blockSize;
        this.grid = grid;
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();

        if(thread == null){
            thread = new Thread(this, "ConnectFourThread");
            thread.start();
        }
    }

    public void init(){
        running = true;

        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        graphics = (Graphics2D) img.getGraphics();

        mouse = new MouseHandler();

        gsm = new GameStateManager();
    }

    public void run(){
        init();

        final double GAME_HERTZ = 30.0;
        final double TBU = 1000000000/GAME_HERTZ; // Time before update
        final int MUBR = 5; //Must update before render
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 30;
        final double TTBR = 1000000000/TARGET_FPS; //Total Time Before Render

        int frameCount = 0;
        int lastSecondTime = (int)(lastUpdateTime/1000000000);
        int oldFrameCount = 0;

        while(running){

            double now = System.nanoTime();
            int updateCount = 0;
            while(((now - lastUpdateTime) > TBU) && (updateCount< MUBR)){
                update();
                input(mouse);
                lastUpdateTime += TBU;
                updateCount++;
            }

            if(now - lastUpdateTime>TBU){
                lastUpdateTime = now - TBU;
            }
            input(mouse);
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int)(lastUpdateTime/1000000000);
            if(thisSecond > lastSecondTime){
                if(frameCount != oldFrameCount){
                    System.out.println("NEW SECOND " + thisSecond+ " "+frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount=0;
                lastSecondTime = thisSecond;
            }
            while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU){
                Thread.yield();
                try{
                    Thread.sleep(1);
                }catch(Exception e){
                    System.out.println("Error: yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }


    public void update(){
        gsm.update();
    }

    public void input(MouseHandler mouse){
        gsm.input(mouse);
    }

    public void render(){
        if(graphics !=null){
            graphics.setColor(new Color(4, 45, 120));
            graphics.fillRect(0,0,width,height);
            graphics.setColor(new Color(255,255,255));
            for(int i = 0; i<grid.getWidth();i++){
                for(int j=0;j<grid.getLength();j++){
                    graphics.fillOval(i*blockSize,j*blockSize,blockSize,blockSize);
                }
            }
            gsm.render(graphics);
        }
    }

    public void draw(){
        Graphics g = (Graphics) this.getGraphics();
        g.drawImage(img, 0, 0, width,height, null);
        g.dispose();
    }
}