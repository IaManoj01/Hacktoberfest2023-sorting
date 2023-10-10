public class SearchRange {

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Example 1: " + Arrays.toString(result1));

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Example 2: " + Arrays.toString(result2));

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Example 3: " + Arrays.toString(result3));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Search for the starting position
        result[0] = binarySearch(nums, target, true);

        // If the starting position is found, search for the ending position
        if (result[0] != -1) {
            result[1] = binarySearch(nums, target, false);
        }

        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean findStart) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;

                if (findStart) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
