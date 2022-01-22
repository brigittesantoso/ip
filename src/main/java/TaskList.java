import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(String.format("%d.%s", i + 1, tasks.get(i)));
        }
    }

    public void markTask(int number) throws IOException {
        tasks.get(number - 1).isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(number - 1));
        saveToList();
    }

    public void unmarkTask(int number) throws IOException {
        tasks.get(number - 1).isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.get(number - 1));
        saveToList();
    }

    public void deleteTask(int number) throws IOException {
        Task removedTask = tasks.remove(number - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println(removedTask);
        System.out.println(String.format("Now you have %d tasks in the list.", tasks.size()));
        saveToList();
    }

    public void addTask(String command, String description) throws IOException {
        System.out.println("Got it. I've added this task:");
        if (command.equals("todo")) {
            tasks.add(new Todo(description));
        }
        else if (command.equals("deadline")) {
            String[] splitDescription = description.split("/by");
            tasks.add(new Deadline(splitDescription[0], splitDescription[1]));
        }
        else {
            String[] splitDescription = description.split("/at");
            tasks.add(new Event(splitDescription[0], splitDescription[1]));
        }
        System.out.println(tasks.get(tasks.size() - 1));
        if (tasks.size() <= 1) {
            System.out.println(String.format("Now you have %d task in the list.", tasks.size()));
        }
        else {
            System.out.println(String.format("Now you have %d tasks in the list.", tasks.size()));
        }
        saveToList();
    }

    public void saveToList() throws IOException {
        File file = new File("./data/duke.txt");
        file.getParentFile().mkdirs();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Task task : tasks) {
            bw.append(task.getFileFormat());
            bw.append("\n");
        }
        bw.close();
    }
}
