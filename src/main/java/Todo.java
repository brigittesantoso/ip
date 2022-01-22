public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getFileFormat() {
        return "T" + super.getFileFormat();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

