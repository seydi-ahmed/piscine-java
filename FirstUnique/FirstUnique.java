import java.util.HashMap;

public class FirstUnique {
    public char findFirstUnique(String s) {
        // Create a hash map to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // First pass: Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Second pass: Find the first character with a frequency of 1
        for (char c : s.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        // If no unique character is found, return '_'
        return '_';
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique();

        // Test case 1
        String s1 = "leetcode";
        System.out.println("First unique character: " + firstUnique.findFirstUnique(s1)); // Expected output: 'l'

        // Test case 2
        String s2 = "loveleetcode";
        System.out.println("First unique character: " + firstUnique.findFirstUnique(s2)); // Expected output: 'v'

        // Test case 3
        String s3 = "aabbcc";
        System.out.println("First unique character: " + firstUnique.findFirstUnique(s3)); // Expected output: '_'
    }
}
