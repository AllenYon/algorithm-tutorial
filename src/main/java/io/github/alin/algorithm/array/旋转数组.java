package io.github.alin.algorithm.array;

/**
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 旋转数组 {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7};
        旋转数组 a = new  旋转数组();
        a.rotate(nums,3);
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            int index = (i + k) % length;
            nums[index] = temp[i];
        }
        printArray(nums);
    }

    private void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
