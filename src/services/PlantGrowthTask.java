package services;

import entity.Plant;
import entity.island.Island;
import entity.island.Location;
import util.AddInMap;
import util.Fabrics;
import util.Settings;

import java.util.Random;

public class PlantGrowthTask implements Runnable{

    Random random = new Random();

    @Override
    public void run() {
        Island.getLocations()[random.nextInt(Settings.x)][random.nextInt(Settings.y)].plantGrowth();
    }
}
