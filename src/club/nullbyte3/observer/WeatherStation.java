package club.nullbyte3.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Subject, Runnable {
    private final List<Observer> observers;
    private int temperature;
    private final Random random;

    private static final int MIN_TEMP = -10;
    private static final int MAX_TEMP = 40;

    public WeatherStation() {
        this.observers = new ArrayList<>();
        this.random = new Random();
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP; // initial temperature between MIN_TEMP and MAX_TEMP
        System.out.println("Weather station initialized with temperature: " + temperature + " degrees (celsius)");
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // sleep for a random time between 1 and 5 seconds
                Thread.sleep(random.nextInt(4001) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Weather station thread interrupted and will stop.");
                return;
            }

            // update the temperature by +-1
            int change = random.nextBoolean() ? 1 : -1;
            int newTemperature = temperature + change;

            if (newTemperature >= MIN_TEMP && newTemperature <= MAX_TEMP) {
                temperature = newTemperature;
                System.out.println("\nWeather station updated temperature to: " + temperature + "°C");
                notifyObservers();
            }
        }
    }
}
