public class RevizCheck {
    public String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if (prefix.isEmpty()){
                return "";
            }
        }

        return prefix;
    }


// **********************************************************************************************************************************

    public static void main(String[] args) {
        RevizCheck lcp = new RevizCheck();

        // Test case 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + lcp.findLongestCommonPrefix(strs1)); // Expected output: "fl"

        // Test case 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix: " + lcp.findLongestCommonPrefix(strs2)); // Expected output: ""

        // Test case 3
        String[] strs3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("Longest common prefix: " + lcp.findLongestCommonPrefix(strs3)); // Expected output: "inters"
    }
}
