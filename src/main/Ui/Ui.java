package Ui;

import java.util.Iterator;

import Task.Task;
import TaskList.TaskList;

public class Ui {
    private static final String BOT_NAME = "JBot";
    private static final String LINE_DIVIDER = "----------------------------------------";
    private static final String TODO_USAGE_MSG = "Usage: todo <description>";
    private static final String EVENT_USAGE_MSG = "Usage: event <description> /from <dd/mm/yyyy> /to <dd/mm/yyyy>";
    private static final String DEADLINE_USAGE_MSG = "Usage: deadline <description> /by <dd/mm/yyyy>";
    private static final String MARK_LIST_USAGE_MSG = "Usage: mark <index>";
    private static final String UNMARK_LIST_USAGE_MSG = "Usage: unmark <index>";
    private static final String DELETE_TASK_USAGE_MSG = "Usage: delete <index>";
    private static final String FIND_TASK_USAGE_MSG = "Usage: find <keyword>";

    public void printByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_DIVIDER);
    }

    public void printBotMessage() {
        System.out.println(LINE_DIVIDER);
        System.out.println("Hello! I'm " + BOT_NAME);
        System.out.println("What can I do for you?");
    }

    public void printLineDivider() {
        System.out.println(LINE_DIVIDER);
    }

    public void printListLength(TaskList taskList) {
        System.out.println("Now you have " + taskList.getLength() + " task in the list");
    }

    /**
     * Prints the all the task in the task list.
     * 
     * @param taskList TaskList object to be used.
     */
    public void printList(TaskList taskList) {
        System.out.println("Here are the task in your list:");
        Iterator<Task> taskListIter = taskList.getTaskList().iterator();
        for(int i = 1; taskListIter.hasNext(); i++) {
            Task task = taskListIter.next();
            System.out.println(i + "." + task);
        }
    }

    /**
     * Prints the tasks that contains the keyword
     * 
     * @param taskList TaskList object to be searched through.
     * @param find Keyword to be used in the search.
     */
    public void printFindList(TaskList taskList, String find) {
        boolean isFound = false;
        String output = "Here are the matching tasks in your list:\n";
        Iterator<Task> taskListIter = taskList.getTaskList().iterator();
        for(int i = 1; taskListIter.hasNext();) {
            Task task = taskListIter.next();
            if(task.getName().toLowerCase().contains(find.toLowerCase())) {
                output += i + "." + task + "\n";
                isFound = true;
                i++;
            }
        }
        if(isFound) {
            System.out.print(output);
        } else {
            System.out.println("No Tasks Found");
        }
    }

    /**
     * Prints task that is added or deleted
     * 
     * @param task Newly created task or deleted task
     * @param isDelete check if it is new task or deleted task
     */
    public void printTask(Task task, boolean isDelete) {
        if(task == null) {
            return;
        }
        if(isDelete) {
            System.out.println("Noted. I've removed this task:");
        } else {
            System.out.println("Got it. I've added this task:");
        }
        System.out.print("  ");
        System.out.println(task);
    }

    /**
     * Print task that is marked or unmarked
     * 
     * @param task Task that is marked or unmarked.
     */
    public void printMarked(Task task) {
        if(task == null) {
            return;
        }
        if(task.isCompleted()) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(task);
        } else {
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(task);
        }
    }

    public void printInvalidMessage() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void printEventUsage() {
        System.out.println(EVENT_USAGE_MSG);
    }

    public void printToDoUsage() {
        System.out.println(TODO_USAGE_MSG);
    }

    public void printDeadlineUsage() {
        System.out.println(DEADLINE_USAGE_MSG);
    }

    public void printMarkUsage() {
        System.out.println(MARK_LIST_USAGE_MSG);
    }

    public void printUnmarkUsage() {
        System.out.println(UNMARK_LIST_USAGE_MSG);
    }

    public void printDeleteUsage() {
        System.out.println(DELETE_TASK_USAGE_MSG);
    }

    public void printFindUsage() {
        System.out.println(FIND_TASK_USAGE_MSG);
    }
}
