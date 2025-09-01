package club.nullbyte3.singleton;

public class Main {

    // honestly, a good practice is to make it with limitation of the size.
    // once I made one of my servers have 1.6TB of logs overnight because of a bug -Vivsam.
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();
    }

}
