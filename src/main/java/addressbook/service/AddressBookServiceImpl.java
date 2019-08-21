package addressbook.service;

import addressbook.model.AddressBook;
import addressbook.model.Person;
import addressbook.model.Gender;
import static java.lang.Math.*;
import static java.util.Collections.min;
import static java.util.Comparator.comparing;

public class AddressBookServiceImpl implements AddressBookService {

    private AddressBook book;

    public AddressBookServiceImpl(AddressBook book) {
        this.book = book;
    }

    @Override
    public long countByGender(Gender gender) {
        return book.getPeople().stream()
                .map(Person::getGender)
                .filter(gender::equals)
                .count();
    }

    @Override
    public Person oldestPerson() {
        return min(book.getPeople(), comparing(Person::getDate));
    }

    @Override
    public long ageDifference(String first, String second) {
        Person firstPerson = getPersonByName(first);
        Person secondPerson = getPersonByName(second);
        return abs(firstPerson.getDate().toEpochDay() - secondPerson.getDate().toEpochDay());
    }

    private Person getPersonByName(String name) {
        return book.getPeople().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name)) //Ignore case??
                .findFirst().orElse(null);
    }
}
