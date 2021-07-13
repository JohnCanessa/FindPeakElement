import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class FindPeekElement {


    /**
     * A peak element is an element that is strictly greater than its neighbors.
     * Given an integer array nums, find a peak element, and return its index. 
     * If the array contains multiple peaks, return the index to any of the peaks.
     * You may imagine that nums[-1] = nums[n] = -∞.
     * You must write an algorithm that runs in O(log n) time.
     */
    static int findPeakElement(int[] nums) {
       
        // **** initialization ***
        int left    = 0;
        int right   = nums.length - 1;

        // **** binary search ****
        while (left < right) {

            // **** compute mid ****
            int mid = left + (right - left) / 2;

            // **** go right (line slope is positive) ****
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;

            // **** go left (line slope is negative) ****
            else
                right = mid;
        }

        // **** return peek index (left == right) ****
        return left;        // or right;
    }


    /**
     * Test code.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
       
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read nums int[] array ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** call function of interest and display result ****
        System.out.println("main <<<  findPeakElement: " + findPeakElement(nums));
    }
}