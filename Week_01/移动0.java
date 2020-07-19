/*https://leetcode-cn.com/problems/move-zeroes/
移动0，简单
明确题意：必须在原数组上操作，不能拷贝额外的数组；尽量减少操作次数
思路：
1.循环统计0的个数，非0元素前移，
2.重新定义一个新数组，非0元素往新数组前面放
3.数组中进行index操作

*/

class Solution {
    public void moveZeroes(int[] nums) {
    	int j = 0;
    	for(int i = 0; i<nums.length;i++){
    		if(nums[i] != 0){
    			nums[j] = nums[i];
    			if (i != j){
    				nums[i] = 0;
    			}
    			j++;
    		}
    	}
    }
}