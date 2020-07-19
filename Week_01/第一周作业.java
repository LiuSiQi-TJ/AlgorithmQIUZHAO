/*
做题四步骤：
1.确认题意，明确题目中，并未提到的条件，例如字符串对大小写是否敏感，是否可以使用额外的数组空间、数组是否有序等
2.思考所有的解决思路，依据时空复杂度，选择最优的
3.code
4.test
*/

/*第一周作业*/

/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
删除数组中的重复项，简单
思路：
1.双指针：一个指针i，从0开始遍历；一个指针j，从i开始遍历至数组结尾。若存在nums[i]!=nums[j]的情况，则首先令i+1，然后令nums[i]=nums[j]，相当于将每次找到的不一样的元素放到最前面，这样最后i的值+1，就是数组中不重复的元素个数
因为本题无需考虑数组中，超出新元素长度后面的元素，而且，不让使用额外的数组空间，而且本体中，数组是有序的
时间复杂度：o(n)，这种思路进行处理，其实没有进行嵌套循环，两个指针都是最多从头走到尾
2.双指针，一个指针i，从0开始，到数组结尾；一个指针j，从j开始，到数组结尾。如果发现，nums[i]!=nums[j]则把nums[j]替换为‘a’这个字符串。最后，把数组中所有的字符串'a'直接删掉
时间复杂度：o(n^2)，因为，这个思路是嵌套循环两次，i循环n次，j相应的循环n-1、n-2、等等，总时间复杂度还是n^2
*/

// 思路1
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1 ; j <nums.length ; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
    return i+1;
    }
}


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

/*https://leetcode-cn.com/problems/rotate-array/
将两个升序链表合并为一个新的 升序 链表并返回。，简单
思路：
1.递归算法。对于两个升序链表，我每次只判断二者的头节点的大小，链表1的头节点大，则让链表2的头节点指向后面排好序的链表；链表2的头节点大，则让链表1的头节点指向后面排好序的链表
递归终止条件：两个链表都为空
链表1中元素个数:m，链表2中元素个数:n。
时间复杂度：o(m+n)，对于递归来说，时间复杂度=递归操作次数*每次递归的时间复杂度。本题中，递归操作次数为m+n，就是相当于把两个链表都遍历一遍。每次采取一次next操作，时间
复杂度为o(1)
空间复杂度：o(m+n)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null){
    		return l2;
    	}
    	if(l2 == null){
    		return l1;
    	}
    	if(l1.val < l2.val){
    		l1.next = mergeTwoLists(l1.next,l2);
    		return l1;
    	}
    	else{
    		l2.next = mergeTwoLists(l1,l2.next);
    		return l2;
    	}
    }
}

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