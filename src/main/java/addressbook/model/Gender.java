package addressbook.model;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String text;

    Gender(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Gender fromString(String text) {
        for (Gender b : Gender.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
