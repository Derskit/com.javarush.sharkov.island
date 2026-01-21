package app;

import entity.island.Island;
import services.*;
import config.Settings;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static void main(String[] args) {
        new Island(Settings.xMapIsland, Settings.yMapIsland);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(new StatisticsTask(), 0, Settings.intervalStatisticsOutputInMillisecond, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new PlantGrowthTask(), 0, Settings.intervalActionsGrowsPlantInMillisecond, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new CorpseCollectorTask(), 0, Settings.intervalCollectingCorpsesInMillisecond, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new SimulationWorker(), 0, Settings.intervalActionsAnimalsInMillisecond, TimeUnit.MILLISECONDS);

    }
}
