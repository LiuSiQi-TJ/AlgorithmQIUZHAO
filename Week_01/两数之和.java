/*https://leetcode-cn.com/problems/two-sum/
两数之和，简单
明确题意：每种输入只对应于一个答案，数组中，同一个元素不能使用两边
思路：
1.暴力法，对数组进行双重循环，但是循环的时候保证第一层和第二层的元素不重复，然后加起来，判断是否等于target
时间复杂度o(n^2)
空间复杂度o(1)
2.哈希表，以空间换取时间，对数组进行循环取数时，时间复杂度为n，但是利用哈希表，时间复杂度为1，代价是空间复杂度为n
将数组元素存在哈希表中，然后对数组进行一次遍历，每个元素寻找，target-元素的值，是否存在在数组中
时间复杂度o(n)
空间复杂度o(n)
*/
// 思路1
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	for(int i = 0; i < nums.length-1; i++){
    		for(int j = i + 1; j < nums.length; j ++){
    			if (nums[i] + nums[j] == target){
    				return new int [] {i,j};
    			}
    		}
    	}
		throw new IllegalArgumentException("no such num!");
	}
}
// 思路2
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer,Integer> map = new HashMap<>();
    	for (int i = 0; i<nums.length;i++){
    		map.put(nums[i],i);
    	}
    	for(int i = 0; i<nums.length;i++){
    		int result = target - nums[i];
    		if(map.containsKey(result)&&map.get(result)!=i){
    			return new int [] {i,map.get(result)};
    		}	
    	}
    	throw new IllegalArgumentException("no such nums!");
	}	
}
