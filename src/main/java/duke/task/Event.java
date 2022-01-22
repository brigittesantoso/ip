package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task
 */
public class Event extends Task {
    protected String at;
    protected LocalDate date;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, LocalDate date) {
        super(description);
        this.at = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        this.date = date;

    }

    /**
     * Get format to display event task on file
     *
     * @return format to display event task on file
     */
    @Override
    public String getFileFormat() {
        return "E" + super.getFileFormat() + " | " + at;
    }

    /**
     * Get general format to display event task
     *
     * @return general format to display event task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}