package club.nullbyte3.bridge.devices;

public class SmartTv extends Tv implements SmartDevice {
    private int brightness = 50; // 0 to 100.

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public void setBrightness(int percent) {
        int newVal = Math.max(0, Math.min(100, percent));
        System.out.println("SmartTV: set brightness to " + newVal);
        brightness = newVal;
    }

    @Override
    public void openApp(String appName) {
        if (!isEnabled()) {
            System.out.println("SmartTV: cannot open app while power is OFF");
            return;
        }
        System.out.println("SmartTV: opening app '" + appName + "'");
    }

    @Override
    public void browseInternet(String url) {
        if (!isEnabled()) {
            System.out.println("SmartTV: cannot browse while power is OFF");
            return;
        }
        System.out.println("SmartTV: browsing " + url);
    }

    @Override
    public void printStatus() {
        System.out.println("---------------------");
        System.out.println("SmartTV status:");
        System.out.println(" - Power: " + (isEnabled() ? "ON" : "OFF"));
        System.out.println(" - Volume: " + getVolume());
        System.out.println(" - Channel: " + getChannel());
        System.out.println(" - Brightness: " + brightness);
        System.out.println("---------------------");
    }
}
