package arrays;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = justifyText(words, maxWidth);

        // Print the justified text
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }

    public static List<String> justifyText(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                // Check if more words can be added to this line
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int numberOfWordsInLine = last - index;
            // If last line or number of words in the line is 1, left-justify
            if (last == words.length || numberOfWordsInLine == 1) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]).append(" ");
                }
                builder.deleteCharAt(builder.length() - 1); // Remove extra space
                // Fill remaining space with spaces
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } else {
                // Middle justified
                int spaces = (maxWidth - count) / (numberOfWordsInLine - 1);
                int extraSpaces = (maxWidth - count) % (numberOfWordsInLine - 1);

                for (int i = index; i < last - 1; i++) {
                    builder.append(words[i]);
                    builder.append(" "); // A single space between words
                    for (int j = 0; j < spaces + (i - index < extraSpaces ? 1 : 0); j++) {
                        builder.append(" ");
                    }
                }
                builder.append(words[last - 1]); // Last word in the line
            }

            lines.add(builder.toString());
            index = last;
        }

        return lines;
    }
}