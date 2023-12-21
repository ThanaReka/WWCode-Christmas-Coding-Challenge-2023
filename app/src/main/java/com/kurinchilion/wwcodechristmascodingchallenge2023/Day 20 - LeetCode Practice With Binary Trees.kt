package com.kurinchilion.wwcodechristmascodingchallenge2023

/*Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()

        if (root == null){return result}

        val stack = ArrayDeque<TreeNode>()

        stack.addFirst(root)

        while(stack.size > 0){
            val node = stack.removeFirst()
            result.add(node.`val`)
            node.right?.let{stack.addFirst(it)}
            node.left?.let{stack.addFirst(it)}
        }

        return result
    }
}