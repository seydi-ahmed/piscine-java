import java.util.Stack;

public class RevizCheck {
    public boolean validateHTML(String html) {
        String[] validTags = {"html", "body", "div", "p", "b", "i", "h1", "h2"};
        Stack<String> tagStack = new Stack<>();

        int i = 0;
        while (i < html.length()){
            
            if (html.charAt(i) == '<'){

                int j = html.indexOf('>', i);
                if (j == -1){
                    return false;
                }

                String tag = html.substring(i+1, j).trim();

                if (tag.startsWith("/")){
                    String closingTag = tag.substring(1);

                    if (tagStack.isEmpty() || !tagStack.peek().equals(closingTag)){
                        return false;
                    }

                    tagStack.pop();
                } else {

                    boolean isValidTag = false;
                    for (String validTag : validTags){
                        if (validTag.equals(tag)){
                            isValidTag = true;
                            break;
                        }
                    }

                    if (!isValidTag){
                        return false;
                    }
                    tagStack.push(tag);
                }

                i = j;
            }


            i++;
        }
        return tagStack.isEmpty();
    }


// ************************************************************************************************************************************    

    public static void main(String[] args) {
        RevizCheck validator = new RevizCheck();

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
