import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            
            // Greedy: Find how many words can fit in the current line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            int gaps = numWords - 1;
            
            // Case 1: Last line or a line with only one word -> Left Justified
            if (j == n || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                // Pad remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: Middle line with multiple words -> Fully Justified
            else {
                // Calculate total spaces to distribute among gaps
                int totalSpaces = maxWidth - (lineLength - gaps); 
                int baseSpaces = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Append base spaces
                        for (int s = 0; s < baseSpaces; s++) {
                            sb.append(" ");
                        }
                        // Distribute extra spaces to the left slots
                        if (k - i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j; // Move to the next line's starting word
        }
        
        return result;
    }
}
