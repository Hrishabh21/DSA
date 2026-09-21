# 📝 1508. Longest Happy Prefix (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/longest-happy-prefix/)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
String, Rolling Hash, String Matching, Hash Function, Z Algorithm, Knuth–Morris–Pratt Algorithm

### 🚀 Performance
- **Runtime:** 10 ms
- **Memory:** 47.6 MB

---

### 📜 Problem Description

A string is called a  **happy prefix**  if it is a  **non-empty**  prefix which is also a suffix (excluding itself).

Given a string  `s` , return  *the  **longest happy prefix**  of*   `s` . Return an empty string  `""`  if no such prefix exists.

**Example 1:**

```
Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

```

**Example 2:**

```
Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.

```

**Constraints:**

	
- `1 <= s.length <= 105`
	
- `s`  contains only lowercase English letters.