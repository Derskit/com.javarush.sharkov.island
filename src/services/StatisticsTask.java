package services;

import entity.island.Island;
import config.Settings;

import java.util.HashMap;
import java.util.Map;

public class StatisticsTask implements Runnable{

    @Override
    public void run() {
        Map<Enum, Integer> map = Settings.createEatables();
        for (int i = 0; i < Settings.x; i++) {
            for (int j = 0; j < Settings.y; j++) {
                Island.getLocations()[i][j].getQuantityEatables().forEach((k,v) -> map.merge(k,v,Integer::sum));
            }
        }
        System.out.println(Island.motion + "" + map.toString());
        Island.motion += 1;
    }
}
