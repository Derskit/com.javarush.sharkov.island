package app;

import entity.island.Island;
import services.*;
import config.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static void main(String[] args) throws InterruptedException {
        Island island = new Island(Settings.xMapIsland, Settings.yMapIsland);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(new StatisticsTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new PlantGrowthTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new CorpseCollectorTask(),0,1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new SimulationWorker(),0,1, TimeUnit.SECONDS);

    }
}
