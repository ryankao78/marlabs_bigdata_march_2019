public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[]{-1, -1};

    HashMap<Integer, Integer> visited = new HashMap<>();
    for (int i =0; i < nums.length; i++) {
        if (visited.containsKey(target - nums[i])) {
            result[0] = visited.get(target - nums[i]);
            result[1] = i;
            return result;
        }
        visited.put(nums[i], i);
    }
    return result;
