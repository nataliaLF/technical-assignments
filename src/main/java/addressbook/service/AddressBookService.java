package addressbook.service;

import addressbook.model.Person;
import addressbook.model.Gender;

public interface AddressBookService {

    /**
     * Counts the number of entries for the given gender
     */
    long countByGender(Gender gender);

    /**
     * Searches for the oldest person
     */
    Person oldestPerson();

    /**
     * Given names names of 2 people, calculates the age difference in days
     * Assumption: all names are unique
     */
    long ageDifference(String first, String second);
}
