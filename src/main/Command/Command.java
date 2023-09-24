package Command;

import java.time.format.DateTimeParseException;

import Parser.Parser;
import Storage.Storage;
import TaskList.TaskList;
import Ui.Ui;

public class Command extends Parser {

    private boolean isExit;
    public Command() {
        super();
        this.isExit = false;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        super.command = command;
    }

    public void execute(Storage storage, Ui ui, TaskList taskList) {
        ui.printLineDivider();
        switch (command) {
        case "list":
            ui.printList(taskList.getTaskList());
            break;
        case "bye":
            isExit = true;
            return;
        case "todo":
            try {
                setToDoArguments();
                ui.printTask(taskList.addToDoToList(getDescription()), false);
            } catch (IllegalArgumentException exception) {
                ui.printToDoUsage();
            }
            break;
        case "event":
            try {
                setEventArguments();
                ui.printTask(taskList.addEventToList(getDescription(), getFrom(), getTo()), false);
                ui.printListLength(taskList.getTaskList());
            } catch(IllegalArgumentException exception) {
                ui.printEventUsage();
            } catch(ArrayIndexOutOfBoundsException exception) {
                ui.printEventUsage();
            } catch(DateTimeParseException exception) {
                ui.printEventUsage();
            }
            break;
        case "deadline":
            try {
                setDeadlineArguments();
                ui.printTask(taskList.addDeadlineToList(getDescription(), getBy()), false);
                ui.printListLength(taskList.getTaskList());
            } catch(IllegalArgumentException exception) {
                ui.printDeadlineUsage();
            } catch(ArrayIndexOutOfBoundsException exception) {
                ui.printDeadlineUsage();
            } catch(DateTimeParseException exception) {
                ui.printDeadlineUsage();
            }
            break;
        case "unmark":
            try {
                ui.printMarked(taskList.markList(getMarkListArguments(), false));
            } catch (IndexOutOfBoundsException exception) {
                ui.printUnmarkUsage();
            } catch (NumberFormatException exception) {
                ui.printUnmarkUsage();
            }
            break;
        case "mark":
            try {
                ui.printMarked(taskList.markList(getMarkListArguments(), true));
            } catch (IndexOutOfBoundsException exception) {
                ui.printMarkUsage();
            } catch (NumberFormatException exeption) {
                ui.printMarkUsage();
            }
            break;
        case "delete":
            try{
                ui.printTask(taskList.deleteTaskFromList(getDeleteArguments()), true);
                ui.printListLength(taskList.getTaskList());
            } catch (IndexOutOfBoundsException exception) {
                ui.printDeleteUsage();
            } catch (IllegalArgumentException exception) {
                ui.printDeleteUsage();
            }
            break;
        default:
            ui.printInvalidMessage();
        }
        ui.printLineDivider();
        storage.refreshData(taskList);
    }

    public boolean isExit() {
        return isExit;
    }
}
