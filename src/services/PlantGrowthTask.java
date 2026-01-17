package services;

import entity.island.Island;
import config.Settings;


public class PlantGrowthTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Settings.xMapIsland; i++) {
            for (int j = 0; j < Settings.yMapIsland; j++) {
                Island.getLocations()[i][j].plantGrowth();
            }
        }
    }
}
