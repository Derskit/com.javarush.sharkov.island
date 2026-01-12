package app;

import entity.island.Island;
import util.Fabrics;
import util.Settings;

public class App {
    static void main() {
        Island island = new Island(new Fabrics(),Settings.x, Settings.y);
    }
}
