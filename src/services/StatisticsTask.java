package services;

import entity.Eatable;
import entity.island.Island;
import config.Settings;

import java.util.Map;

public class StatisticsTask implements Runnable {

    @Override
    public void run() {
        Map<Enum, Integer> map = Settings.createEatablesStatistic();
        for (int i = 0; i < Settings.xMapIsland; i++) {
            for (int j = 0; j < Settings.yMapIsland; j++) {
                Island.getLocations()[i][j].getQuantityEatables().forEach((k, v) -> map.merge(k, v.size(), Integer::sum));
            }
        }
        System.out.println(Island.day + ": " + map);
        Island.day += 1;
    }
}
