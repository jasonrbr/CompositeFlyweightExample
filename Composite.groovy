import java.lang.RuntimeException
import java.util.ArrayList

public abstract class Product {
    public abstract float GetPrice();

    public void AddItem(Product p) throws RuntimeException {
        throw new RuntimeException("AddItem not allowed on class ${this.class.name}")
    }

    public void RemoveItem(Product p) throws RuntimeException {
        throw new RuntimeException("RemoveItem not allowed on class ${this.class.name}")
    }
}

public class Receipt extends Product {

    private ArrayList<String> items;

    public Receipt(ArrayList<String> aItems) {
        items = aItems
    }

    public float GetPrice() {
        0
    }
}

public class FoamPeanuts extends Product {
    public float GetPrice() {
        0
    }
}

public class Phone extends Product {
    public float GetPrice() {
        699
    }
}

public class PhoneCase extends Product {
    public float GetPrice() {
        40
    }
}

public class Box extends Product {
    private products = []
    
    public float GetPrice() {
        this.products.sum{it.GetPrice()}
    }

    public void AddItem(Product p) {
        products.add(p)
    }

    public void RemoveItem(Product p) {
        products.removeElement(p)
    }
}

def receipt = new Receipt(["phone", "phone case"])
def phone = new Phone()
def phone2 = new Phone()
def phoneCase = new PhoneCase()
def packingChips = new FoamPeanuts()
def box = new Box()
box.AddItem(phone)
box.AddItem(phoneCase)
def box2 = new Box()
box2.AddItem(box)
box2.AddItem(receipt)
box2.AddItem(packingChips)
println(box2.GetPrice())