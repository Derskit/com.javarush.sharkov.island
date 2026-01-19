package services;

import config.Settings;

public class SimulationWorker implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < Settings.xMapIsland; i++) {
            for (int j = 0; j < Settings.yMapIsland; j++) {
                Thread thread = new Thread(new LocationTask(i,j));
                thread.start();
            }
        }
    }
}
