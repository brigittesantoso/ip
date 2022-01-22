package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;

public class UnmarkCommand extends Command {
    protected int number;

    public UnmarkCommand(int number) {
        this.number = number - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.unmarkTask(number);
        ui.showUnmarkTask(tasks.getTasks().get(number));
        storage.save(tasks.getTasks());
    }
}