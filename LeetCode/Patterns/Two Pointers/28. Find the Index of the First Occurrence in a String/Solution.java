class Solution {
    public int strStr(String haystack, String needle) {
        //if needle is empty return 0
        if (needle == ""){
            return 0;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        //iterate through haystack to find first occurrence of needle
        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            //check character by character for a match
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;//if mismatch break and check next position
                }
            }
            //if entire needle matches return index
            if (j == nLen) {
                return i;
            }
        }
        //if no match is found return -1
        return -1;
    }
}