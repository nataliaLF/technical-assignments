package addressbook;

import java.io.IOException;
import java.util.List;
import addressbook.dao.AddressBookDao;
import addressbook.dao.AddressBookFileDao;
import addressbook.model.AddressBook;
import addressbook.model.Gender;
import addressbook.model.Person;
import addressbook.service.AddressBookService;
import addressbook.service.AddressBookServiceImpl;

public class AddressBookLauncher {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/nataliiaslyvar/IdeaProjects/gumtreeuk/src/main/resources/address_book.csv";

        AddressBookDao dao = new AddressBookFileDao(fileName);
        List<Person> people = dao.getPeople();

        AddressBook book = new AddressBook(people);
        AddressBookService service = new AddressBookServiceImpl(book);

        long numberOfMales = service.countByGender(Gender.MALE);
        Person oldestPerson = service.oldestPerson();
        long ageDifference = service.ageDifference("Bill McKnight", "Paul Robinson");

        System.out.println("There are " + numberOfMales + " males in the address book");
        System.out.println("The oldest person in the address book is " + oldestPerson.getName());
        System.out.println("Bill is older then Paul by " + ageDifference + " days");
    }
}
