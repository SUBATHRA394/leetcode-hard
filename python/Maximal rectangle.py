class Solution:
    def maximalRectangle(self, matrix):
        if not matrix or not matrix[0]:
            return 0
            
        cols = len(matrix[0])
        heights = [0] * (cols + 1)
        max_area = 0
        
        for row in matrix:
            for i in range(cols):
                heights[i] = heights[i] + 1 if row[i] == "1" else 0
                
            stack = []
            for i in range(len(heights)):
                while stack and heights[stack[-1]] > heights[i]:
                    height = heights[stack.pop()]
                    width = i if not stack else i - stack[-1] - 1
                    current_area = height * width
                    if current_area > max_area:
                        max_area = current_area
                stack.append(i)
                
        return max_area
