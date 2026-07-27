class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        stack = [] # Stack to store indices of temperatures

        for i, temp in enumerate(temperatures):
            # While the stack is not empty and the current temperature is higher
            # than the temperature at the index stored in the stack:
            while stack and temperatures[stack[-1]] < temp:
                index = stack.pop()  # Pop the index of the cooler temperature
                print(index)
                result[index] = i - index  # Calculate the number of days until a warmer day
            
            stack.append(i)  # Push the current index onto the stack
        return result