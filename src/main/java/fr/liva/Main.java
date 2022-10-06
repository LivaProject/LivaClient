package fr.liva;

import fr.liva.launcher.Launcher;
import fr.liva.utils.servers.ServersUtils;

public class Main {

    public static final String NAME = "LivaClient";

    public static final int WIDTH = 1080;
    public static final int HEIGHT = 780;

    public static Launcher launcher;

    public static LivaClient livaClient = null;

    public static void main(String[] args) {

        // Load
        ServersUtils.createServerFile();
        ServersUtils.loadServers();

        // Start
        launcher = new Launcher();

    }

}
