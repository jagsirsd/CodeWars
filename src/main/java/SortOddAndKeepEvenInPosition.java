import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortOddAndKeepEvenInPosition {
    public static int[] sortArray(int[] array) {
        int[] oddOnly = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddOnly[i] = array[i];
            } else {
                oddOnly[i] = Integer.MAX_VALUE;
            }
            System.out.println(i + ":" + array[i]);
        }
        System.out.println("");
        Arrays.sort(oddOnly);

//        // Sort the odd numbers only
//        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = oddOnly[j];
                j++;
            }
            System.out.println(i + ":" + array[i]);
        }
        return array;
    }

    public static boolean isPrime(int num) {

        if (num <= 1 || num % 2 == 0) {
            return false;
        }

        int max = (int) Math.sqrt(num);

        for (int i = 3; i <= max; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static String[] wrapLines1(String[] words, int limit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append("-");
        }

        String allStr = sb.toString();
        allStr = allStr.substring(0, allStr.length() - 1);

        System.out.println("Words: " + allStr);


        ArrayList
                <String> result = new ArrayList<>();

        int index = 0;
        int endIndex = 0;
        int indexH = 0;

        while (indexH >= 0) {
            indexH = allStr.indexOf("-", indexH);
            //System.out.println(indexH);
            if (!(indexH < 0) && indexH - index < limit) {
                endIndex = indexH;
                indexH += 1;
            } else {
                result.add(allStr.substring(index, endIndex));
                //System.out.println(allStr.substring(index, endIndex));
                index = endIndex + 1;
            }
        }

        return result.toArray(new String[result.size()]);
    }

    static String[] wrapLines(String[] words, int limit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append("-"); //Keep the last hyphen
        }

        String allStr = sb.toString();
        allStr = allStr.substring(0, allStr.length());

        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        int endIndex = 0;
        int indexH = 0;

        while (indexH >= 0) {
            indexH = allStr.indexOf("-", indexH);

            if (!(indexH < 0) && indexH - index <= limit) {
                endIndex = indexH;
                indexH += 1;
            } else {
                result.add(allStr.substring(index, endIndex));
                System.out.println(allStr.substring(index, endIndex));
                index = endIndex + 1;
            }
        }

        return result.toArray(new String[0]);
    }


    static String[] wrapLines3(String[] words, int limit) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb. append(words[i]);
            inner:for(int j = i+1; j < words.length; ) {
                String next = words[j];
                if (sb.length() + 1 + next.length() <= limit) {
                    sb.append("-").append(next);
                    i++; j++;
                } else {
                    result.add(sb.toString());
                    sb = null;
                    break inner;
                }
            }
            if(sb != null) {
                result.add(sb.toString());
            }
        }

        return result.toArray(new String[0]);
    }
    public static String rgb(int r, int g, int b) {
        r = (r > 0) ? r : 0;
        g = (g > 0) ? g : 0;
        b = (b > 0) ? b : 0;
        r = (r < 255) ? r : 255;
        g = (g < 255) ? g : 255;
        b = (b < 255) ? b : 255;
        return String.format("%02X%02X%02X", r, g, b);
    }

    static int minSwaps(int [] src) {
        Stack<Integer> stack = new Stack<>();
        int swaps = 0;
        for (int i = 0; i < src.length; i++) {
            if (src[i] != i+1) {
                swaps++;
            } else {
                System.out.println(src[i] + " at src["+ i +"]");
            }
        }
        return swaps -1;
    }
    static int minSwapsS(int [] src) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        int swaps = 0;
        for(int i = 0; i < src.length; i++) {
            stack = isElementInPlace(src, i, stack, visited);
            swaps += performSwaps(src, stack);
        }
        return swaps;
    }

    private static int performSwaps(int[] src, Stack<Integer> stack) {
        int swaps = 0;
        while(!stack.empty() && stack.size() > 1) {
            int top = stack.pop();
            int topMinus1 = stack.peek();
            swapS(src, top, topMinus1);
            swaps++;
        }
        if(!stack.empty()) {
            System.out.println("stack is not empty." + stack.size()+ ", "  + stack.pop());
        }
        return swaps;
    }

    private static void swapS(int[] src, int top, int topMinus1) {
        int temp = src[top];
        src[top] = src[topMinus1];
        src[topMinus1] = temp;
    }

    private static Stack<Integer> isElementInPlace(int[] src, int i, Stack<Integer> stack, Set<Integer> visited) {
        if(src[i] == i+1) {
            return stack;
        } else {
            if(visited.contains(i)) {
                return stack;
            }
            stack.push(i);
            visited.add(i);
            return isElementInPlace(src, src[i] - 1, stack, visited);
        }
    }


    public static void main(String[] argv) {
        int[] src = Arrays.stream("2 31 1 38 29 5 44 6 12 18 39 9 48 49 13 11 7 27 14 33 50 21 46 23 15 26 8 47 40 3 32 22 34 42 16 41 24 10 4 28 36 30 37 35 20 17 45 43 25 19".split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minSwaps(src) + " \n\n\n");
        System.out.println(minSwapsS(src));


        int[] perfectPower = isPerfectPower(8);
        System.out.println(rgb(0, 0, 0));
        System.out.println(rgb(15, 128, 255));
        System.out.println(rgb(-20, 128, 255));
        System.out.println(rgb(-20, 128, 275));

        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};
        String[] words2 = {"Hello"};
        String[] words3 = {"Hello", "Hello"};
        String[] words4 = {"Well", "Hello", "world"};
        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        String[] words6 = {"a", "b", "c", "d"};

        String[] wrappedWords = wrapLines(words1, 13);
        System.out.println("13: " + Arrays.toString(wrappedWords));
        wrappedWords = wrapLines(words1, 20);
        System.out.println("20: " + Arrays.toString(wrappedWords));
        System.out.println();
        System.out.println();
        System.out.println();
        String[] wrappedWords3 = wrapLines3(words1, 13);
        System.out.println("13: " + Arrays.toString(wrappedWords3));
        wrappedWords3 = wrapLines3(words1, 20);
        System.out.println("20: " + Arrays.toString(wrappedWords3));
    }

    public static boolean scramble(String str1, String str2) {


        Map<Character, Integer> hist1 = getCharHist(str1);
        Map<Character, Integer> hist2 = getCharHist(str2);

        for (Map.Entry<Character, Integer> entry : hist2.entrySet()) {
            Integer count = hist1.get(entry.getKey());
            if (count == null || (count < entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharHist(String str1) {
        Map<Character, Integer> hist = new HashMap<>();

        for (Character c : str1.toCharArray()) {
            if (hist.containsKey(c)) {
                hist.put(c, hist.get(c) + 1);
            } else {
                hist.put(c, 1);
            }
        }
        return hist;
    }

    static class CharToProcessed {
        public char c;
        public boolean isProcessed;

        CharToProcessed(int c) {
            this.c = (char) c;
            this.isProcessed = false;
        }

        @Override
        public String toString() {
            return "CharToProcessed{" +
                    "c=" + c +
                    ", isProcessed=" + isProcessed +
                    '}';
        }
    }

    public static String rot13(String message) {
        Stream<CharToProcessed> charStream = message.chars().mapToObj(CharToProcessed::new);
        String returnString = charStream.map(c -> {
            if (!c.isProcessed) {
                if((c.c >='A' && c.c<'A'+13) || (c.c >= 'a' && c.c < 'a' + 13)) {
                    c.c = (char)(c.c + 13);
                    System.out.println("plus to " + c);
                    c.isProcessed = true;
                }
            }
            return c;
        }).map(c -> {
            if (!c.isProcessed) {
                if((c.c >='A'+13 && c.c<'A'+26) || (c.c >= 'a'+13 && c.c < 'a' + 26)) {
                    c.c = (char)(c.c - 13);
                    System.out.println("subt fr " + c);
                    c.isProcessed = true;
                }
            }
            return c.c;
        }).collect(
                StringBuilder :: new,
                StringBuilder :: appendCodePoint,
                StringBuilder :: append).toString();

//        charStream.forEach(c -> {
//            if (!c.isProcessed) {
//                if((c.c >'A' && c.c<'A'+13) || (c.c > 'a' && c.c < 'a' + 13)) {
//                    c.c = (char)(c.c + 13);
//                    c.isProcessed = true;
//                    System.out.println("plus to " + c);
//                }
//            }
//        });
//        charStream.forEach(c -> {
//            if (!c.isProcessed) {
//                if((c.c >'A'+13 && c.c<'A'+26) || (c.c > 'a'+13 && c.c < 'a' + 26)) {
//                    c.c = (char)(c.c - 13);
//                    c.isProcessed = true;
//
//                    System.out.println("subt fr " + c);
//                }
//            }
//        });
        return returnString;
    }

    public static String rot13_2(String message) {
        Stream<CharToProcessed> charStream = message.chars().mapToObj(CharToProcessed::new);
        String returnStr = charStream.map(c -> {
                    if (!c.isProcessed) {
                        if((c.c >='A' && c.c<'A'+13) || (c.c >= 'a' && c.c < 'a' + 13)) {
                            c.c = (char)(c.c + 13);
                            //System.out.println("plus to " + c);
                            c.isProcessed = true;
                        }
                    }
                    return c;
                }).map(c -> {
                    if (!c.isProcessed) {
                        if((c.c >='A'+13 && c.c<'A'+26) || (c.c >= 'a'+13 && c.c < 'a' + 26)) {
                            c.c = (char)(c.c - 13);
                            //System.out.println("subt fr " + c);
                            c.isProcessed = true;
                        }
                    }
                    return c.c;
                }).collect(
                        StringBuilder :: new,
                        StringBuilder :: appendCodePoint,
                        StringBuilder :: append
                )
                .toString() ;

//        charStream.forEach(c -> {
//            if (!c.isProcessed) {
//                if((c.c >'A' && c.c<'A'+13) || (c.c > 'a' && c.c < 'a' + 13)) {
//                    c.c = (char)(c.c + 13);
//                    c.isProcessed = true;
//                    System.out.println("plus to " + c);
//                }
//            }
//        });
//        charStream.forEach(c -> {
//            if (!c.isProcessed) {
//                if((c.c >'A'+13 && c.c<'A'+26) || (c.c > 'a'+13 && c.c < 'a' + 26)) {
//                    c.c = (char)(c.c - 13);
//                    c.isProcessed = true;
//
//                    System.out.println("subt fr " + c);
//                }
//            }
//        }
        System.out.println(returnStr);
        return returnStr;
    }

    static String rot13_6(String message) {
        return message.chars().mapToObj(c -> "" + (char) c)
                .map(c -> "" + (char) (c.charAt(0) + (c.matches("(?i)[A-M]") ? 13 : c.matches("(?i)[N-Z]") ? -13 : 0)))
                .collect(Collectors.joining());
    }

    static String rot13_4(String message) {
        String in = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String out = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            int i = in.indexOf(c);
            if (i >= 0) {
                c = out.charAt(i);
            }
            encoded.append(c);
        }
        return encoded.toString();
    }

    private static final Map<String, String> CHAR_MAPPING = new HashMap<>();

    static {
        IntStream.rangeClosed('A', 'M').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('N', 'Z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
        IntStream.rangeClosed('a', 'm').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('n', 'z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
    }

    public static String rot13_5(String message) {
        return Arrays.stream(message.split("")).map(key -> CHAR_MAPPING.getOrDefault(key, key)).collect(Collectors.joining());

    }

    public static String testToCharArray(String msg)  {
//        // Example Stream of characters
//        Stream<Character> charStream = Stream.of('a', 'b', 'c', 'd', 'e');
//
//        // Convert the Stream<Character> to char[]
//        char[] charArray = charStream
//                .map(c -> c.charValue())
//                .toArray(size -> new char[size]);
//
//        // Print the char array
//        System.out.println(charArray); // This will print: abcde


        // Example Stream of characters
        Stream<Character> charStream2 = msg.chars().mapToObj(c-> (char)c);
        // Convert the Stream<Character> to char[]
        Character[] charArray2 = charStream2
                .mapToInt(c -> c)
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        // Print the char array
        System.out.println(charArray2);
        return String.valueOf(charArray2);
    }

    public static int[] allFactors(final int n ) {
        int max = (int)Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if(n%i == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static int[] isPerfectPower(int n) {
        if(n <=1) {
            return null;
        }
        int mantissa = (int)Math.sqrt(n);
        if(mantissa*mantissa == n) {
            return new int[]{mantissa, 2};
        }
        int[] factors = allFactors(n);
        for (int i = 0; i < factors.length; i++) {
            int count = 1;
            long j = factors[i];
            for(; j <= n; ) {
                j*=factors[i];
                if(j <= n) {
                    count++;
                }
            }
            j/=factors[i];
            if(j == n) {
                return new int[]{ factors[i], count};
            }
        }
        return null;
    }
    public static int[] isPerfectPower_Tricky(int n) {
        List<int[]> list = IntStream.range(2, (int) Math.sqrt(n) + 1)
                .filter(i -> n % i == 0)
                .mapToObj(i -> new int[] {i, (int)(Math.log(n) / Math.log(i) + 0.00000001)})
                .filter(i -> Math.pow(i[0], i[1]) == n)
                .limit(1)
                .collect(Collectors.toList());

        return list.size() == 0 ? null : list.get(0);
    }
}
