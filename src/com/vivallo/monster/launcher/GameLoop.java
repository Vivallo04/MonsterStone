package com.vivallo.monster.launcher;

public class GameLoop implements Runnable{

    private Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStatTime;
    private int fps;
    private int ups;

    public GameLoop(Game game){
        this.game = game;

    }


    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime = System.currentTimeMillis();
        long lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;


        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTime = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTime;
            lastUpdate = currentTime;

            while (accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }

            render();
            printStats();
        }

    }

    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, " +
                    "UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void render() {
        game.render();
        fps++;
    }

    private void update() {
        //Updates per second
        game.update();
        ups++;
    }
}
