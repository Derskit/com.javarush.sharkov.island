package app;

import entity.island.Island;
import services.PlantGrowthTask;
import services.StatisticsTask;
import util.Fabrics;
import util.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static void main() {
        Island island = new Island(Settings.x, Settings.y);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new StatisticsTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new PlantGrowthTask(), 0, 1, TimeUnit.SECONDS);
    }
}
