package cacheline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSuppliesForEach() {
        for (Supply supply : supplies) {
            if(supply.isContaminated().isClean) {
                supplies.remove(supply);
            }
        }
    }
    void disposeContaminatedSuppliesIterator() {
        Iterator<Supply> iterator = supplies.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().isContaminated().isClean) {
                iterator.remove();
            }
        }
    }
}
