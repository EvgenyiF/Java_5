import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] n1 = new int[]{4, 9, 5};
        int[] n2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(n1, n2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int n : nums1) {
            m1.put(n, m1.getOrDefault(n, 0) + 1);
        }

        int cnt = 0;
        for (int n : nums2) {
            if (m1.containsKey(n)) {
                m2.put(n, m2.getOrDefault(n, 0) + 1);
                cnt++;
                m1.put(n, m1.get(n) - 1);
                if (m1.get(n) == 0) m1.remove(n);
            }
        }
        int[] res = new int[cnt];
        int idx = 0;
        for (int n : m2.keySet()) {
            for (int i = 0; i < m2.get(n); i++) {
                res[idx++] = n;
            }
        }
        return res;


    }
}
