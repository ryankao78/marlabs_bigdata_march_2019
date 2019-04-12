public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    Arrays.sort(nums);

    int res = 1;
    int current_streak = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            if (nums[i] - nums[i - 1] == 1) {
                current_streak++;
            }
            else {
                res = Math.max(res, current_streak);
                current_streak = 1;
            }
        }
    }
    return Math.max(res, current_streak);
}
