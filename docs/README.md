# User Guide

JBot is a **desktop app for managing tasks, optimized for use via a Command Line Interface** (CLI).

-  [Quick start](#quick-start)
-  [Features](#features)
    -  [Listing all tasks: `list`](#listing-all-tasks-list)
    -  [Exiting the program: `bye`](#exiting-the-program-bye)
    -  [Adding ToDo task: `todo`](#adding-todo-task-todo)
    -  [Adding Event task: `event`](#adding-event-task-event)
    -  [Adding Deadline task: `deadline`](#adding-deadline-task-deadline)
    -  [Unmarking a task as done: `unmark`](#unmarking-a-task-as-done-unmark)
    -  [Marking a task as done: `mark`](#marking-a-task-as-done-mark)
    -  [Deleting a task: `delete`](#deleting-a-task-delete)
    -  [Locating tasks by name: `find`](#locating-tasks-by-name-find)
-  [Command summary](#command-summary)

***

## Quick start
1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest ip.jar from [here](https://github.com/sRanay/ip/releases).

3. Copy the file to the folder you want to use as the home folder for JBot.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use `java -jar ip.jar` command to run the application.

5. Refer to the [Features](#features) below for details of each command.

***

## Features
> **Note**  
> - Words in UPPER_CASE are the parameters to be supplied by the user.<br>
e.g in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be as `todo assignment 1`
> - Extraneous parameters for commands that do not take in parameters (such as `list` and `bye`) will be ignored.<br>
e.g. if the command specifies `list 12`, it will be interpreted as `list`.

### Listing all tasks: `list`

Shows a list of all tasks in the task list.

Format: `list`

### Exiting the program: `bye`

Exiting the program

Format: `bye`

### Adding ToDo task: `todo`

Creates a ToDo task and add it into the task list.

Format: `todo DESCRIPTION`

Example:

- `todo powerpoint slides for cs2113`
- `todo homework`

### Adding Event task: `event`

Creates a Event task and add it into the task list.

Format: `event DESCRIPTION /from START_DATE /to END_DATE`

- `START_DATE` and `END_DATE` must be in the format: `DD/MM/YYYY`.
- `START_DATE` must be before `END_DATE`

Examples:
- `event Overseas Trip /from 26/09/2023 /to 29/09/2023`

### Adding Deadline task: `deadline`

Creates a Deadline task and add it into the task list.

Format: `deadline /by DUE_DATE`

- `DUE_DATE` must be in the format: `DD/MM/YYYY`.
- `DUE_DATE` must be after the current day's date.

Example: 
- `deadline assignment 1 /by 30/09/2023`

### Unmarking a task as done: `unmark`

Unmark the task to be not done.

Format: `unmark INDEX`

- Unmarks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3, ...

Examples:
- `list` followed by `unmark 1` unmark the 1st task as done in the task list.

### Marking a task as done: `mark`

Unmark the task to be not done.

Format: `mark INDEX`

- Marks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3, ...

Examples:
- `list` followed by `mark 1` mark the 1st task as done in the task list.

### Deleting a task: `delete`

Deletes the specified task from the task list.

Format: `delete INDEX`

- Deletes the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3, ...

Examples:
- `list` followed by `delete 1` deletes the 1st task in the task list.

### Locating tasks by name: `find`

Finds the tasks which name contains the given keyword.

Format: `find KEYWORD`

- The search is case-insensitive. e.g `Hello` will match `hello`
- Only the description is searched.
- Only full words will be matched e.g `Hello` will not match `He`

Examples:
- `find midterms` returns `cs1010 midterms` and `cs2100 midterms`

***

## Command Summary

| Action   | Format, Examples                                                                            |
|----------|---------------------------------------------------------------------------------------------|
| list     | `list`                                                                                      |
| bye      | `bye`                                                                                       |
| todo     | `todo DESCRIPTION` `todo powerpoint slides for cs2113`                                      |
| event    | `event DESCRIPTION /from FROM /to TO` `event Overseas Trip /from 26/09/2023 /to 29/09/2023` |
| deadline | `deadline /by BY` `deadline assignment 1 /by 30/09/2023`                                    |
| unmark   | `unmark INDEX` `unmark 1` `unmark 3`                                                        |
| mark     | `mark INDEX` `mark 1` `mark 3`                                                              |
| delete   | `delete INDEX` `delete 1`                                                                   |
| find     | `find KEYWORD` `find midterms`                                                              |

