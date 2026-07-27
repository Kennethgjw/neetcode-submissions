# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(root):
            if not root:
                return [True, 0]
            
            left = dfs(root.left)
            right = dfs(root.right)
            
            left_balanced = left[0]
            right_balanced = right[0]

            height_difference_ok = abs(left[1] - right[1]) <= 1

            balanced = left_balanced and right_balanced and height_difference_ok

            return [balanced, 1 + max(left[1], right[1])]

        return dfs(root)[0]