class Solution {
    public int repeatedStringMatch(String a, String b) {
         StringBuilder sb = new StringBuilder();

        int count = 0;

        // Keep adding a until length >= b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check after reaching b's length
        if (sb.indexOf(b) != -1) {
            return count;
        }

        // b might need one additional copy of a
        sb.append(a);
        count++;

        if (sb.indexOf(b) != -1) {
            return count;
        }

        return -1;
    }
}