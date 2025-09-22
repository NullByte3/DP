package club.nullbyte3.memento;

import java.time.LocalDateTime;

public interface Memento {
    LocalDateTime getTimestamp();
    String getDescription();
}
