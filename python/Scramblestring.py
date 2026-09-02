class Solution:
    def isScramble(self, s1, s2):
        memo = {}

        def check(str1, str2):
            if (str1, str2) in memo:
                return memo[(str1, str2)]
            
            if str1 == str2:
                return True
                
            if sorted(str1) != sorted(str2):
                return False
                
            n = len(str1)
            for i in range(1, n):
                if (check(str1[:i], str2[:i]) and check(str1[i:], str2[i:])) or \
                   (check(str1[:i], str2[n-i:]) and check(str1[i:], str2[:n-i])):
                    memo[(str1, str2)] = True
                    return True
                    
            memo[(str1, str2)] = False
            return False

        return check(s1, s2)
