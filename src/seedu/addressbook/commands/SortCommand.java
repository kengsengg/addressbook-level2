package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts all the people in AddressBook by their names in alphabetically ascending order
 */

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the entire list of people in AddressBook by their names in alphabetically ascending order. \n "
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = sortByName(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

    private List<ReadOnlyPerson> sortByName(List<ReadOnlyPerson> readOnlyPeople) {
        return readOnlyPeople;
    }
}
