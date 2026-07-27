class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closeToOpen = { ")" : "(", "]" : "[", "}" : "{" }

        for c in s:
            if c in closeToOpen: # If the character is a closing bracket
                if stack and stack[-1] == closeToOpen[c]:  # Check if top of stack matches the opening bracket
                    stack.pop() # If it matches, pop the opening bracket from the stack
                else:
                    return False # If it doesn't match, return False (invalid string)
            else: # If it's an opening bracket
                stack.append(c)  # Push it onto the stack
            
        return True if not stack else False # If the stack is empty, all brackets matched; otherwise, return False
