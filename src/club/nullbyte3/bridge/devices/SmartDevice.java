package club.nullbyte3.bridge.devices;

public interface SmartDevice extends Device {
    int getBrightness();

    void setBrightness(int percent);

    void openApp(String appName);

    void browseInternet(String url);
}
