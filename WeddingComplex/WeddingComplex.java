import java.util.*;

public class WeddingComplex {
    // Function to create the best couple using Gale-Shapley algorithm
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        // Map to store the final pairing (firstMap member -> secondMap member)
        Map<String, String> firstToSecond = new HashMap<>();
        Map<String, String> secondToFirst = new HashMap<>();
        
        // Map to keep track of the proposals made by members of the first map
        Map<String, Integer> proposals = new HashMap<>();
        for (String person : first.keySet()) {
            proposals.put(person, 0);  // Everyone has proposed to 0 people at the start
        }

        // While there are free members in the first group
        while (firstToSecond.size() < first.size()) {
            for (String proposer : first.keySet()) {
                // If the proposer is already matched, skip
                if (firstToSecond.containsKey(proposer)) continue;

                // Get the next person in their preference list
                int proposalIndex = proposals.get(proposer);
                String proposeTo = first.get(proposer).get(proposalIndex);

                // Increase the proposal index for the next iteration
                proposals.put(proposer, proposalIndex + 1);

                // If the person in second map is not matched yet, match them
                if (!secondToFirst.containsKey(proposeTo)) {
                    firstToSecond.put(proposer, proposeTo);
                    secondToFirst.put(proposeTo, proposer);
                } else {
                    // If the person is matched, check if they prefer the new proposer
                    String currentPartner = secondToFirst.get(proposeTo);
                    List<String> preferences = second.get(proposeTo);
                    if (preferences.indexOf(proposer) < preferences.indexOf(currentPartner)) {
                        // If they prefer the new proposer, switch partners
                        firstToSecond.remove(currentPartner);
                        firstToSecond.put(proposer, proposeTo);
                        secondToFirst.put(proposeTo, proposer);
                    }
                }
            }
        }

        return firstToSecond;
    }
}
