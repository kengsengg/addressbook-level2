package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's date of birth in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateOfBirth(String)}
 */
public class DateOfBirth {

    public static final String EXAMPLE = "01231995";
    public static final String MESSAGE_DATE_OF_BIRTH_CONSTRAINTS = "Person date of birth should only contain numbers";
    public static final String DATE_OF_BIRTH_VALIDATION_REGEX = "\\d+";
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given date of birth
     *
     * @throws IllegalValueException if given date of birth string is invalid.
     */
    public DateOfBirth(String dob, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedDateOfBirth = dob.trim();
        if (!isValidDateOfBirth(trimmedDateOfBirth)) {
            throw new IllegalValueException(MESSAGE_DATE_OF_BIRTH_CONSTRAINTS);
        }
        this.value = trimmedDateOfBirth;
    }

    /**
     * Returns true if the given string is a valid person date of birth.
     */
    public static boolean isValidDateOfBirth(String test) {
        return test.matches(DATE_OF_BIRTH_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}



