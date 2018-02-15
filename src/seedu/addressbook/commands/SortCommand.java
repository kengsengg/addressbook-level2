package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.ArrayList;
import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_LIST_SORTED;

/**
 * Sorts all the people in AddressBook by their names in alphabetically ascending order (case insensitive)
 */

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the entire list of people in AddressBook by their names in alphabetically ascending order (case insensitive).\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortPersons = sortByName(addressBook.getAllPersons().immutableListView());
        return new CommandResult(MESSAGE_LIST_SORTED, sortPersons);
    }

    /**
     * Sorts the whole list of people in alphabetically ascending order (case insensitive)
     *
     * @param allPersons list of people
     * @return sorted list
     */
    private List<ReadOnlyPerson> sortByName(List<ReadOnlyPerson> allPersons) {
        List<ReadOnlyPerson> sortPersons = new ArrayList<>();
        sortPersons.addAll(allPersons);
        sortPersons.sort((person1, person2) -> + person1.getName().toString().compareToIgnoreCase(person2.getName().toString()));
        return sortPersons;
    }
}
