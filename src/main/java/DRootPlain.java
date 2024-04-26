import java.util.Arrays;

public class DRootPlain {
    public static int digital_root(int n) {
        int number = n;
        while (number / 10 >= 1) {
            int sum = 0;
            while(number / 10 >= 1) {
                sum += number %10;
                number = (int) number/10;
            }
            sum += number;
            number = sum;
        }
        return number;
    }

    public static int[] parse(String data) {
        int index = 0;
        int[] out = new int[data.length()];
        Integer num = 0;
        for(char c : data.toCharArray()) {
            switch(c) {
                case 'i':
                    num++;
                    break;
                case 'd':
                    num--;
                    break;
                case 's':
                    num *=num;
                    break;
                case 'o':
                    out[index++] = num;
                    break;
                default:
                    break;
            };

        }
        return Arrays.copyOf(out, index);
    }
}