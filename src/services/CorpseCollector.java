package services;

import config.Settings;
import entity.Eatable;
import entity.island.Island;

public class CorpseCollector implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < Settings.x; i++) {
            for (int j = 0; j < Settings.y; j++) {
                for (int k = 0; k < Island.getLocations()[i][j].getEatables().size(); k++) {
                    if (Island.getLocations()[i][j].getEatables().get(k).getIsLock()){
                        Island.getLocations()[i][j].getEatables().remove(k);
                    }
                }
            }
        }
    }
}
