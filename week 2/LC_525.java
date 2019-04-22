public static int findMaxLength(int[] nums) {
    if (nums == null || nums.length < 2) {
        return 0;
    }

    HashMap<Integer, Integer> pos = new HashMap<>();
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += (nums[i] > 0) ? 1 : -1;
        if (sum == 0) {
            ans = i + 1;
        }
        else if (pos.containsKey(sum)) {
            ans = Math.max(ans, i - pos.get(sum));
        }
        else {
            pos.put(sum, i);
        }
    }
    return ans;
}
