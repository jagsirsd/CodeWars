
// using streams()

import java.util.ArrayList;
import java.util.List;

class GFG {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        // ArrayList to Array Conversion
        int[] arr = al.stream().mapToInt(i -> i).toArray();

        for (int x : arr)
            System.out.print(x + " ");
    }
}
