import java.util.ArrayList;
import java.util.HashSet;

public class Storage {
    private HashSet<String> provider = new HashSet<>();
    private ArrayList<String> product = new ArrayList<>();

    public void newProduct(String provider, String product) throws Exception {
        if (product == null || provider == null) throw new Exception("Delivery note cannot be empty");
        this.provider.add(provider);
        this.product.add(product);

    }

    public void showProviders() {
        System.out.println("Providers: " + this.provider);
    }

    public void showProducts() {
        System.out.println("Products: " + this.product);
    }

    public int findAddressProduct(String s) {
        return this.product.indexOf(s);
    }
}
