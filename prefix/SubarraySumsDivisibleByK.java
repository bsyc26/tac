/** Return the num of non-empty sub arr whose sum divisible by k */

// leetcode 974
// prefix:pre-sum + hash-map + modular
// T: O(N+K)
// S: O(K)

import java.util.HashMap;

public class Solution {
    // core method
    public int subarraysDivByK(int[] nums, int k) {
        // const
        int N = nums.length;
        int[] arr = nums;
        int K = k; // divisor
        // res
        int cnt = 0;
        // DS
        HashMap<Integer, Integer> rmdrToCnt = new HashMap<>(); // reminder: count
        rmdrToCnt.put(0, 1); // for one elem sub arr divisible by K
        int[] preSum = new int[N+1];
        preSum[0] = 0;
        // built pre-sum && update res
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i-1] + arr[i-1];
            int curRmdr = preSum[i] % K;
            curRmdr = (curRmdr < 0) ? curRmdr+K : curRmdr; // adjust negative reminder
            // look up hash-map
            if (rmdrToCnt.containsKey(curRmdr)) // if same rmdr exists before i
                cnt += rmdrToCnt.get(curRmdr); // update res
            // update hash-map
            rmdrToCnt.put(curRmdr, rmdrToCnt.getOrDefault(curRmdr,0)+1);
        }
        // return res
        return cnt;
    }
}
