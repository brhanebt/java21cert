package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class IntegerPairsAddingToN {
	public static void main(String[] args) {
		//Given array of integers return pairs that add up to give integer
		int[] n = {20,40,50,60,80,90};
		List<int[]> pairs = findPairsAddingToTarget(n,100);
		for(int[] i: pairs) {
			System.out.print(i[0]);
			System.out.print(", ");
			System.out.println(i[1]);
		}
		System.out.println();
		

		pairs = findPairsWithSum(n,100);
		for(int[] i: pairs) {
			System.out.print(i[0]);
			System.out.print(", ");
			System.out.println(i[1]);
		}
		System.out.println();
	}

	private static List<int[]> findPairsAddingToTarget(int[] n, int target) {
		Set<Integer> seen = new HashSet<>();
	    Set<String> used = new HashSet<>();
	    List<int[]> pairs = new ArrayList<>();
	    
	    for (int num : n) {
	        int complement = target - num;
	        if (seen.contains(complement)) {
	            int[] pair = {Math.min(num, complement), Math.max(num, complement)};
	            String key = pair[0] + "," + pair[1];
	            if (!used.contains(key)) {
	                pairs.add(pair);
	                used.add(key);
	            }
	        }
	        seen.add(num);
	    }
	    return pairs;
	}
	
	public static List<int[]> findPairsWithSum(int[] arr, int targetSum) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> numCounts = new HashMap<>();

        // Populate the map with counts of each number in the array
        for (int num : arr) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array to find pairs
        for (int num1 : arr) {
            int num2 = targetSum - num1;

            // Check if num2 exists in the map
            if (numCounts.containsKey(num2)) {
                // Handle cases where num1 and num2 are the same (e.g., finding pairs for 50 in target 100)
                if (num1 == num2) {
                    if (numCounts.get(num1) >= 2) {
                        result.add(new int[]{num1, num2});
                        // Decrement count to avoid duplicate pairs if the same number appears multiple times
                        numCounts.put(num1, numCounts.get(num1) - 2);
                    }
                } else {
                    if (numCounts.get(num1) >= 1 && numCounts.get(num2) >= 1) {
                        result.add(new int[]{num1, num2});
                        // Decrement counts to avoid adding the same pair again
                        numCounts.put(num1, numCounts.get(num1) - 1);
                        numCounts.put(num2, numCounts.get(num2) - 1);
                    }
                }
            }
        }
        return result;
    }
	
	

}
