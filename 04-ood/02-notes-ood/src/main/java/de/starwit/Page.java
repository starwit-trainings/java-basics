package de.starwit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Page {
    private String content;
    private LocalTime lastChanged;

    public Page(String content) {
        this.setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.lastChanged = LocalTime.now();
    }

    public LocalTime getLastChanged() {
        return lastChanged;
    }

    public String toString() {
        return this.content + " (at " + this.lastChanged.truncatedTo(ChronoUnit.MINUTES) + ")";
    }
}
