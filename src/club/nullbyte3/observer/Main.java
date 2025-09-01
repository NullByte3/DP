package club.nullbyte3.observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread weatherThread = new Thread(weatherStation);

        WeatherObserver observer1 = new WeatherObserver("Observer 1 (Phone App)");
        WeatherObserver observer2 = new WeatherObserver("Observer 2 (Website Dashboard)");
        WeatherObserver observer3 = new WeatherObserver("Observer 3 (TV Display)");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        System.out.println("Starting weather simulation...");
        weatherThread.start();

        try {
            System.out.println("--- Simulation running with all observers for 15 seconds ---");
            Thread.sleep(15000);

            System.out.println("--- Removing " + observer2.getName() + " ---");
            weatherStation.removeObserver(observer2);

            System.out.println("--- Simulation continuing for 15 seconds ---");
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            System.out.println("--- Stopping simulation ---");
            weatherThread.interrupt();
        }
    }
}
