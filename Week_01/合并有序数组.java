/*https://leetcode-cn.com/problems/merge-sorted-array/
合并两个有序数组，简单
明确题意：两个数组nums1 nums2,元素数量为m，n；nums1有充足空间
思路：
1.暴力法，把两个数组合并，然后排序
时间复杂度：o(n+m*log(n+m))，java排序算法sort，时间复杂度是nlogn
空间复杂度：o(n+m)
2.双指针，i对nums1进行循环，j对nums2进行循环，把两者中，小的那个，放入结果数组中。放到结果数组中的指针+1，不放到结果中的指针不变，如此循环，直到两者尽头
这种方法，首先要对nums1进行备份
这种方法，利用了两个数组的有序性
时间复杂度：o(m+n)
空间复杂度：o(m)
*/
// 思路1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	System.arraycopy(nums2,0,nums1,m,n);
    	Arrays.sort(nums1);
    }
}
// 思路2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int [] nums1_copy = new int[m];
    	System.arraycopy(nums1,0,nums1_copy,0,m);
    	int i = 0;
    	int j = 0;
    	while (i < nums1_copy.length && j < nums2.length){
    		if(nums1_copy[i] <= nums2[j]){
    			nums1[i+j] = nums1_copy[i];
    			i++;
    		}
    		else{
    			nums1[i+j] = nums2[j];
    			j++;
    		}
    	}
    	if(i<m){
    		System.arraycopy(nums1_copy,i,nums1,i+j,m-i);
    	}
    	if(j<n){
    		System.arraycopy(nums2,j,nums1,i+j,n-j);
    	}	
    	}
    }