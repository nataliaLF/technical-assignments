package addressbook.dao;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import addressbook.model.Gender;
import addressbook.model.Person;


public class AddressBookFileDao implements AddressBookDao {

    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

    private String fileName;

    public AddressBookFileDao(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Person> getPeople() throws IOException {

        Path path = FileSystems.getDefault().getPath("resources", "address_book.csv");
        System.out.println(path.toAbsolutePath());
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream
                    .map(line -> Arrays.asList(line.split(", ")))
                    .map(value -> new Person(value.get(0), Gender.fromString(value.get(1)), LocalDate.parse(value.get(2), FORMATTER)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Person createPersonFromList(List<String> list) {
        String name = list.get(0);
        Gender gender = Gender.fromString(list.get(1));
        LocalDate date = LocalDate.parse(list.get(2), FORMATTER);
        return new Person(name, gender, date);
    }
}
