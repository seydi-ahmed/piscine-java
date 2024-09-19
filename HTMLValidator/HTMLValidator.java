import java.util.Stack;

public class HTMLValidator {

    public boolean validateHTML(String html) {
        // List of valid tags
        String[] validTags = {"html", "body", "div", "p", "b", "i", "h1", "h2"};
        
        // Stack to keep track of opening tags
        Stack<String> tagStack = new Stack<>();
        
        // Parsing the HTML string
        int i = 0;
        while (i < html.length()) {
            if (html.charAt(i) == '<') {
                // Find the closing '>'
                int j = html.indexOf('>', i);
                if (j == -1) {
                    return false;  // Invalid HTML if no closing '>'
                }

                // Extract the tag (excluding the '<' and '>')
                String tag = html.substring(i + 1, j).trim();
                
                // Check if it's a closing tag
                if (tag.startsWith("/")) {
                    // It's a closing tag, get the tag name without '/'
                    String closingTag = tag.substring(1);
                    
                    // Stack should not be empty and the tag should match the last opened tag
                    if (tagStack.isEmpty() || !tagStack.peek().equals(closingTag)) {
                        return false;
                    }
                    tagStack.pop();  // Pop the matching opening tag
                } else {
                    // It's an opening tag, validate it
                    boolean isValidTag = false;
                    for (String validTag : validTags) {
                        if (validTag.equals(tag)) {
                            isValidTag = true;
                            break;
                        }
                    }

                    if (!isValidTag) {
                        return false;  // Invalid tag found
                    }

                    // Push the opening tag onto the stack
                    tagStack.push(tag);
                }

                // Move index to the next character after the current tag
                i = j;
            }
            i++;
        }

        // In the end, the stack should be empty if all tags were properly closed
        return tagStack.isEmpty();
    }

    public static void main(String[] args) {
        HTMLValidator validator = new HTMLValidator();

        // Test case 1: Valid HTML
        String html1 = "<html><body><h1>Hello, World!</h1></body></html>";
        System.out.println("Is HTML valid? " + validator.validateHTML(html1)); // Expected output: true

        // Test case 2: Invalid HTML (missing closing tag)
        String html2 = "<html><body><h1>Hello, World!</body></html>";
        System.out.println("Is HTML valid? " + validator.validateHTML(html2)); // Expected output: false

        // Test case 3: Invalid HTML (incorrect nesting)
        String html3 = "<html><body><h1><div>Hello, World!</h1></div></body></html>";
        System.out.println("Is HTML valid? " + validator.validateHTML(html3)); // Expected output: false

        // Test case 4: Valid HTML with multiple tags
        String html4 = "<html><body><div><p>This is a <b>bold</b> word and this is <i>italic</i>.</p></div></body></html>";
        System.out.println("Is HTML valid? " + validator.validateHTML(html4)); // Expected output: true
    }
}
