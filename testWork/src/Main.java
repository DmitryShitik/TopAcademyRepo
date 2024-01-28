import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        HashSet<Fish> fishes = new HashSet<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("trout", 2.2, 150));
        System.out.println("Collection:" + fishes);
        System.out.println("Collection's size:" + fishes.size());
        System.out.println("before:");
        fishes.forEach(f -> System.out.println(f));
        fishes.stream()
                .filter(f -> f.getPrice() > 100)
                .forEach(f -> f.setPrice(f.getPrice() * 0.9));
        System.out.println("after");
        fishes.forEach(f -> System.out.println(f));
        List<Fish> selected = fishes.stream()
                .filter(f -> f.getPrice() > 100)
                .collect(Collectors.toList());

        System.out.println("after");
        selected.forEach(f -> System.out.println(f));

        Stream.of("Argentina", "Bulgaria",
                        "Canada","Denmark","Ukraine","USA")
                .filter((c)->c.startsWith("U"))
                .forEach(c->System.out.println(c));

        
    }
}
