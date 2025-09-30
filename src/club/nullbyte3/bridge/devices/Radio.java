package club.nullbyte3.bridge.devices;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 30; // 0 to 100.
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio: power ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio: power OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        int newVol = Math.max(0, Math.min(100, percent));
        System.out.println("Radio: set volume to " + newVol);
        volume = newVol;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        int newCh = Math.max(1, channel);
        System.out.println("Radio: set channel to " + newCh);
        this.channel = newCh;
    }

    public void printStatus() {
        System.out.println("---------------------");
        System.out.println("Radio status:");
        System.out.println(" - Power: " + (on ? "ON" : "OFF"));
        System.out.println(" - Volume: " + volume);
        System.out.println(" - Channel: " + channel);
        System.out.println("---------------------");
    }
}
