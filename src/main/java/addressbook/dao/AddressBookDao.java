package addressbook.dao;

import java.io.IOException;
import java.util.List;
import addressbook.model.Person;

public interface AddressBookDao {

    List<Person> getPeople() throws IOException;
}
