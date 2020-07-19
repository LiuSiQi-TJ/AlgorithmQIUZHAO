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