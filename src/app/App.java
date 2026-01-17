package app;

import entity.island.Island;
import services.CorpseCollectorTask;
import services.LocationTask;
import services.PlantGrowthTask;
import services.StatisticsTask;
import config.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static void main(String[] args) {
        Island island = new Island(Settings.xMapIsland, Settings.yMapIsland);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService simulationService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(new StatisticsTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new PlantGrowthTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new CorpseCollectorTask(),0,1, TimeUnit.SECONDS);

        for (int i = 0; i < Settings.xMapIsland; i++) {
            for (int j = 0; j < Settings.yMapIsland; j++) {
                simulationService.scheduleAtFixedRate(new LocationTask(i, j), 0, 1, TimeUnit.SECONDS);
            }
        }
    }
}
