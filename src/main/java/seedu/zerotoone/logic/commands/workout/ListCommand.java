package seedu.zerotoone.logic.commands.workout;

import static java.util.Objects.requireNonNull;
import static seedu.zerotoone.model.Model.PREDICATE_SHOW_ALL_WORKOUTS;

import seedu.zerotoone.logic.commands.Command;
import seedu.zerotoone.logic.commands.CommandResult;
import seedu.zerotoone.logic.commands.exceptions.CommandException;
import seedu.zerotoone.model.Model;

/**
 * Lists all workouts in the workout list to the user.
 */
public class ListCommand extends WorkoutCommand {
    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_SUCCESS = "Here is a list of all your workouts!";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.isInSession()) {
            throw new CommandException(Command.MESSAGE_SESSION_STARTED);
        }
        model.updateFilteredWorkoutList(PREDICATE_SHOW_ALL_WORKOUTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListCommand); // instanceof handles nulls
    }
}
