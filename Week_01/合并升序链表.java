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
