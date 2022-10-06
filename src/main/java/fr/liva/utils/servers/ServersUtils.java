package fr.liva.utils.servers;

import java.io.*;
import java.util.Scanner;

public abstract class ServersUtils {

    public static final String PATH = getFolder();

    public static final String FILE = "servers.txt";

    public static void createServerFile() {

        File directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(PATH + FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        } else {
            return;
        }
        ServersList.servers.put("Official", new Server("172.20.10.2", 30001));
        saveServers();
    }

    public static void loadServers() {

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH + FILE);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String value = line.split("=")[1];

                String key = line.split("=")[0];

                String address = value.split(";")[0];
                int port = Integer.parseInt(value.split(";")[1]);

                ServersList.servers.put(key, new Server(address, port));
            }

            scanner.close();
        } catch (Exception e) {

        }
    }

    public static void saveServers() {

        try {
            PrintWriter writer = new PrintWriter(PATH + FILE, "UTF-8");
            ServersList.servers.forEach((key, value) -> {
                writer.println(key + "=" + value.getAddress() + ";" + value.getPort());
            });
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

        }
    }

    public static String getFolder() {
        String fileFolder = System.getenv("APPDATA") + "\\" + "Liva\\";

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN")) {
            fileFolder = System.getenv("APPDATA") + "\\" + "Liva\\";
        } else if (os.contains("MAC")) {
            fileFolder = System.getProperty("user.home") + "/Library/Application " + "Support"
                    + "Liva/";
        } else if (os.contains("NUX")) {
            fileFolder = System.getProperty("user.dir") + ".Liva.";
        }

        return fileFolder;
    }
}
