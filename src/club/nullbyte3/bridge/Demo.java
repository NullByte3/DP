package club.nullbyte3.bridge;

import club.nullbyte3.bridge.devices.Device;
import club.nullbyte3.bridge.devices.Radio;
import club.nullbyte3.bridge.devices.SmartTv;
import club.nullbyte3.bridge.devices.Tv;
import club.nullbyte3.bridge.remotes.AdvancedRemote;
import club.nullbyte3.bridge.remotes.BasicRemote;
import club.nullbyte3.bridge.remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern Demo ===");

        testDevice(new Tv());
        testDevice(new Radio());

        System.out.println("\n=== SmartTV with SmartRemote ===");
        SmartTv smartTv = new SmartTv();
        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.togglePower();
        smartRemote.openApp("YouTube");
        smartRemote.setBrightness(80);
        smartRemote.voiceControl("browse https://example.com");
        smartRemote.voiceControl("volume up");
        smartRemote.voiceControl("channel 5");
        smartTv.printStatus();
    }

    private static void testDevice(Device device) {
        System.out.println("\n-- Tests with basic remote --");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        printStatusIfSupported(device);

        System.out.println("-- Tests with advanced remote --");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.mute();
        advancedRemote.togglePower();
        printStatusIfSupported(device);
    }

    private static void printStatusIfSupported(Device device) {
        if (device instanceof Tv) {
            ((Tv) device).printStatus();
        } else if (device instanceof Radio) {
            ((Radio) device).printStatus();
        } else if (device instanceof SmartTv) {
            ((SmartTv) device).printStatus();
        } else {
            System.out.println("(No status printer for device type: " + device.getClass().getSimpleName() + ")");
        }
    }
}
