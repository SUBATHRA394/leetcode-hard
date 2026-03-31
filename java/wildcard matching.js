/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let sIdx = 0, pIdx = 0;
    let starIdx = -1, sTmpIdx = -1;

    while (sIdx < s.length) {
        // 1. If characters match or pattern has '?'
        if (pIdx < p.length && (p[pIdx] === '?' || p[pIdx] === s[sIdx])) {
            sIdx++;
            pIdx++;
        } 
        // 2. If pattern has '*', record the star position and current s position
        else if (pIdx < p.length && p[pIdx] === '*') {
            starIdx = pIdx;
            sTmpIdx = sIdx;
            pIdx++; // Move pattern pointer to next character after '*'
        } 
        // 3. If no match and no current '*', but a previous '*' was found
        else if (starIdx !== -1) {
            pIdx = starIdx + 1; // Backtrack pattern to after the star
            sTmpIdx++;          // Use '*' to cover one more character in s
            sIdx = sTmpIdx;     // Move s pointer to new starting point
        } 
        // 4. No match possible
        else {
            return false;
        }
    }

    // Check if remaining characters in pattern are all '*'
    while (pIdx < p.length && p[pIdx] === '*') {
        pIdx++;
    }

    return pIdx === p.length;
};

// --- Test Cases ---
console.log(isMatch("aa", "a"));    // Output: false
console.log(isMatch("aa", "*"));    // Output: true
console.log(isMatch("cb", "?a"));   // Output: false
console.log(isMatch("adceb", "*a*b")); // Output: true
