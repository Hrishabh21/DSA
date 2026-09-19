class Solution {

    private static final long BASE = 101;
    private static final long MOD = 1_000_000_007;

    public int repeatedStringMatch(String a, String b) {

        int n = a.length();
        int m = b.length();

        // Minimum number of repetitions needed
        int count = (m + n - 1) / n;

        // Check count and count + 1 repetitions
        if (contains(a, b, count)) {
            return count;
        }

        if (contains(a, b, count + 1)) {
            return count + 1;
        }

        return -1;
    }

    private boolean contains(String a, String b, int count) {

        int n = a.length();
        int m = b.length();

        int textLength = n * count;

        // Hash of pattern
        long patternHash = 0;

        // Hash of first window
        long windowHash = 0;

        // BASE^(m-1)
        long power = 1;

        for (int i = 0; i < m; i++) {
            patternHash =
                (patternHash * BASE + b.charAt(i)) % MOD;

            if (i < m - 1) {
                power = (power * BASE) % MOD;
            }
        }

        // First window
        for (int i = 0; i < m; i++) {
            char c = a.charAt(i % n);

            windowHash =
                (windowHash * BASE + c) % MOD;
        }

        // Check first window
        if (windowHash == patternHash &&
            matches(a, b, 0, count)) {
            return true;
        }

        // Rolling hash
        for (int i = m; i < textLength; i++) {

            char oldChar = a.charAt((i - m) % n);
            char newChar = a.charAt(i % n);

            // Remove old character
            windowHash =
                (windowHash - oldChar * power) % MOD;

            if (windowHash < 0) {
                windowHash += MOD;
            }

            // Shift left and add new character
            windowHash =
                (windowHash * BASE + newChar) % MOD;

            int start = i - m + 1;

            if (windowHash == patternHash &&
                matches(a, b, start, count)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(String a, String b, int start, int count) {

        int n = a.length();
        int m = b.length();

        for (int j = 0; j < m; j++) {
            if (a.charAt((start + j) % n) != b.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}