package duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testStringConversion() {
        assertEquals("[T][ ] read book", new Todo("read book").toString());
    }
}
