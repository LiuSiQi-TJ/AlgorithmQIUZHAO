/*https://leetcode-cn.com/problems/rotate-array/
旋转数组，简单
明确题意：k会不会大于n
思路：
1.暴力法，旋转k次，每次把数组的最后一个移动到最前面去
时间复杂度 o(n*k)，每次要循环n次，为了移动数组，一共旋转k次
空间复杂度 o(1)，没有使用额外的数组空间
2.额外数组，按照顺序，把原数组中相关元素插入新数组中
时间复杂度：o(n)，只需要遍历一遍数组
空间复杂度：o(n)，多出来了一个，一摸一样的数组
3.对数组进行反转：首先反转整个数组，随后反转前k个，然后反转后面n-k个，
时间复杂度 o(n)
空间复杂度 o(1)
最优解法
*/

// 思路3
class Solution {
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	reverse(nums,nums.length-1,0);
    	reverse(nums,k-1,0);
    	reverse(nums,nums.length-1,k);
    }
    public void reverse(int[] nums, int end, int start){
    	int temp;
    	while(start<end){
    		temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start ++;
    		end --;
    	}
    }
}
