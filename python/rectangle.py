class Solution:
    def largestRectangleArea(self, heights):
        stack = []
        max_area = 0
        heights.append(0)
        
        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                height = heights[stack.pop()]
                width = i if not stack else i - stack[-1] - 1
                current_area = height * width
                if current_area > max_area:
                    max_area = current_area
            stack.append(i)
            
        heights.pop()
        return max_area
