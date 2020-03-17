package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalExercises.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.exercise.Exercise;
import seedu.address.testutil.ExerciseBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Exercise validExercise = new ExerciseBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addExercise(validExercise);

        assertCommandSuccess(new AddCommand(validExercise), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validExercise), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Exercise exerciseInList = model.getAddressBook().getExerciseList().get(0);
        assertCommandFailure(new AddCommand(exerciseInList), model, AddCommand.MESSAGE_DUPLICATE_EXERCISE);
    }

}
