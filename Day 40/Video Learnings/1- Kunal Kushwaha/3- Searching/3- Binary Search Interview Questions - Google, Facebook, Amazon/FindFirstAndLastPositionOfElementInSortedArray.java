package old;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10 };
        int target = 11;

        int[] ans = { -1, -1 };
        int startIndex = search(nums, target, true);
        int endIndex = search(nums, target, false);

        ans[0] = startIndex;
        ans[1] = endIndex;

        System.out.println(Arrays.toString(ans));

    }

    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential answer found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
