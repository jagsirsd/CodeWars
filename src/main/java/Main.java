public class Main {
    static char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};

    public static String disemvowelT(String Z) {
        return Z.replaceAll("(?i)[aeiou]" , "");
    }
    public static String disemvowel(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(isAVowel(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isAVowel(char c) {
        for(char v: vowels) {
            if(c == v) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}