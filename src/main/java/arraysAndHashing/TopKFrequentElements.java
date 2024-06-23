package arraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    static class Node implements Comparable<Node> {

        int el;
        int count;
        Node(int el, int count) {
           this.el = el;
           this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
            // o.count = 2, this.count = 1
            // this.count - o.count = 1 - 2 = -1
            // o.count - this.count = 2 - 1 = 1
        }
    }

    // Find the
    public static int[] topKFrequent(int[] nums, int k) {
        int[] toRet = new int[k];
        Map<Integer, Integer> map = new HashMap<>(); // Why a tree map? we want to return the Top K elements. Treemap will keep these in sorted order...

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
           map.put(num, map.get(num) + 1);
        }

        // Build a heap of the values....
        Queue<Node> q = new PriorityQueue<>();
        for (int key : map.keySet()) {
            q.offer(new Node(key, map.get(key))); // Each offer operation is log(n)
        }

        for (int i = 0; i < k; i++) {
            if (q.peek() != null) {
                toRet[i] = q.poll().el;
            }
        }

        return toRet;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3, 1, 1, 1, 4};
        int k = 1;
        int[] out = topKFrequent(nums, k);

        System.out.printf("Output: %s",  List.of(out) );
    }
}


