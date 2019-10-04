package mypackage;
/**
 * Created by Brandizzy on 5/17/2017.
 */

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
		Thread thread;
        private boolean isRunning = false;

        private Handler handler;
        public int clicks = 0;
        public int score = 0;

    public Game(){
            new Window(640, 480, "Java: Catch Clown Game!", this);
            start();

            handler = new Handler();

            handler.addObject(new Clown(100, 100, ID.Clown));
            this.addMouseListener(new MouseInput(handler, this));
        }
        private void start(){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
        private void stop(){
            isRunning = false;
            try{
                thread.join();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        public void run(){
            Long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            Long timer = System.currentTimeMillis();
            int frames = 0;
            while(isRunning){
                Long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
                    tick();
                    delta--;
                }
                if(isRunning)
                    render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println("FPS: " + frames);
                    frames = 0;

                }
            }
            stop();
        }

            public void tick(){
                handler.tick();

            }
            public void render(){
                BufferStrategy bs = this.getBufferStrategy();
                if(bs == null){
                    this.createBufferStrategy(3);
                    return;
                }

                Graphics g = bs.getDrawGraphics();

                g.setColor(Color.green);
                g.fillRect(0,0,680,480);

                handler.render(g);
                
                g.setColor(Color.black);
                g.drawString("Score: " + score, 10, 15);

                g.dispose();
                bs.show();
            }
        public static void main(String[] args){
            new Game();

    }
}

