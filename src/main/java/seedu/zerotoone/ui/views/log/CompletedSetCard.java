package seedu.zerotoone.ui.views.log;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.zerotoone.ui.util.UiPart;

/**
 * An UI component that displays information of a {@code CompletedSet}.
 */
public class CompletedSetCard extends UiPart<Region> {

    private static final String FXML = "log/CompletedSetCard.fxml";
    private static final String COMPLETED_FA_NAME = "CHECK";
    private static final String SKIPPED_FA_NAME = "TIMES";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on LogList level 4</a>
     */

    @FXML
    private Label setTitle;
    @FXML

    private FontAwesomeIcon isSetFinished;

    public CompletedSetCard(String numReps, String weight, Boolean isSetFinished) {
        super(FXML);
        this.setTitle.setText(formatTitle(numReps, weight));
        this.isSetFinished.setGlyphName(isSetFinished ? COMPLETED_FA_NAME : SKIPPED_FA_NAME);
        this.isSetFinished.getStyleClass().add(isSetFinished ? "isCompleted" : "isSkipped");

    }

    private String formatTitle(String numReps, String weight) {
        return String.format(" - %s x %skg", numReps, weight);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CompletedSetCard)) {
            return false;
        }

        // state check
        CompletedSetCard card = (CompletedSetCard) other;
        return this.setTitle.equals(((CompletedSetCard) other).setTitle)
            && isSetFinished.getText().equals(card.isSetFinished.getText());
    }
}
