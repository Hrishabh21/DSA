class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

        for (int i = 1, j = 0; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int palindromeLength = lps[combined.length() - 1];

        return rev.substring(0, s.length() - palindromeLength) + s;

    }

}