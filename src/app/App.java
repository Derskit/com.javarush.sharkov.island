package app;

import entity.island.Island;
import util.Settings;

public class App {
    static void main() {
        Island island = new Island(Settings.x, Settings.y);
    }
}
