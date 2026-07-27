class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buyDay = 0
        sellDay = 1
        max_profit = 0

        while sellDay < len(prices):
            if prices[sellDay] > prices[buyDay]:
                max_profit = max(max_profit, prices[sellDay] - prices[buyDay])
            else:
                buyDay = sellDay
            sellDay += 1
        return max_profit
        