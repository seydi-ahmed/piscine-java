import java.util.*;

public class TopFrequents {
    public List<Integer> findTopKFrequent(int[] nums, int k) {
        // Map to store frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Map to store the first index of each element
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        // Fill frequency map and index map
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            // Only set the index if it's not already set
            indexMap.putIfAbsent(num, i);
        }

        // PriorityQueue (min-heap) to store elements based on frequency and index
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> {
                // Compare by frequency first
                int frequencyComparison = Integer.compare(b.getValue(), a.getValue());
                if (frequencyComparison != 0) {
                    return frequencyComparison;
                }
                // If frequencies are the same, compare by first index of appearance
                return Integer.compare(indexMap.get(a.getKey()), indexMap.get(b.getKey()));
            }
        );

        // Add all elements to the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            // Keep only k most frequent elements in the heap
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract elements from the heap into the result list
        List<Integer> topKFrequent = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKFrequent.add(minHeap.poll().getKey());
        }
        
        // Since heap is a min-heap, the list needs to be reversed to maintain order
        Collections.reverse(topKFrequent);
        
        return topKFrequent;
    }
}
