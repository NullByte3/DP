package club.nullbyte3.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName;

    private Logger() {
        setFileName("app.log");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    public void setFileName(String fileName) {
        if (this.fileName != null && this.fileName.equals(fileName)) {
            return;
        }

        close();
        this.fileName = fileName;
        try {
            writer = new PrintWriter(new FileWriter(this.fileName, true));
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
            writer = null;
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
