public class Person implements Comparable<Person> {
    private String name;

    Person(String name) {

        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
