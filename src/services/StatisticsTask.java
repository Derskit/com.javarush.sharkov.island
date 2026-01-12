package services;

import entity.Plant;
import entity.island.Island;
import entity.island.Location;
import util.AddInMap;
import util.Fabrics;
import util.Settings;

import java.util.Random;

public class StatisticsTask implements Runnable{
    @Override
    public void run() {
        System.out.println(Island.getLocations()[0][0].quantityEatables.toString());
    }
}
