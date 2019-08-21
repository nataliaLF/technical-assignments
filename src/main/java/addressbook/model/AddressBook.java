package addressbook.model;

import java.util.List;

public class AddressBook {

   private List<Person> people;

   public AddressBook(List<Person> people) {
       this.people = people;
   }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}

