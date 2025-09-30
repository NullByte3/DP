package club.nullbyte3.bridge.remotes;

import club.nullbyte3.bridge.devices.SmartDevice;

public class SmartRemote extends AdvancedRemote {
    private final SmartDevice smartDevice;

    public SmartRemote(SmartDevice device) {
        super(device);
        this.smartDevice = device;
    }

    public void setBrightness(int percent) {
        System.out.println("SmartRemote: set brightness");
        smartDevice.setBrightness(percent);
    }

    public void openApp(String appName) {
        System.out.println("SmartRemote: open app '" + appName + "'");
        smartDevice.openApp(appName);
    }

    public void voiceControl(String command) {
        if (command == null) {
            System.out.println("SmartRemote: voice command not recognized");
            return;
        }
        String cmd = command.trim().toLowerCase();
        System.out.println("SmartRemote: voice command -> " + cmd);

        if (cmd.equals("power")) {
            togglePower();
        } else if (cmd.equals("volume up")) {
            volumeUp();
        } else if (cmd.equals("volume down")) {
            volumeDown();
        } else if (cmd.equals("channel up")) {
            channelUp();
        } else if (cmd.equals("channel down")) {
            channelDown();
        } else if (cmd.startsWith("channel ")) {
            try {
                int ch = Integer.parseInt(cmd.substring("channel ".length()).trim());
                smartDevice.setChannel(ch);
            } catch (NumberFormatException e) {
                System.out.println("SmartRemote: invalid channel number");
            }
        } else if (cmd.startsWith("brightness ")) {
            try {
                int b = Integer.parseInt(cmd.substring("brightness ".length()).trim());
                setBrightness(b);
            } catch (NumberFormatException e) {
                System.out.println("SmartRemote: invalid brightness value");
            }
        } else if (cmd.startsWith("open ")) {
            String app = cmd.substring("open ".length()).trim();
            openApp(app);
        } else if (cmd.startsWith("browse ")) {
            String url = cmd.substring("browse ".length()).trim();
            smartDevice.browseInternet(url);
        } else if (cmd.equals("mute")) {
            mute();
        } else {
            System.out.println("SmartRemote: command not recognized");
        }
    }
}
