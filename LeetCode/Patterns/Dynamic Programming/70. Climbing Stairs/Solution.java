class Solution {
    public int climbStairs(int n) {
       // Base cases: 
        // If there's 1 step, there's only 1 way to climb
        if (n == 1) return 1;
        
        // If there are 2 steps, there are 2 ways to climb: [1 + 1] or [2]
        if (n == 2) return 2;

        // 'first' represents the number of ways to reach the first step
        // 'second' represents the number of ways to reach the second step
        int first = 1, second = 2;

        // Variable to store the total number of ways to reach the current step
        int current = 0;

        // Loop starts from step 3 up to step 'n'
        for (int i = 3; i <= n; i++) {
            // The number of ways to reach the current step is the sum of
            // ways to reach the previous step and the step before that
            current = first + second;

            // Move one step ahead: 
            // 'first' now becomes 'second'
            first = second;

            // 'second' now becomes 'current'
            second = current;
        }

        // At the end, 'second' will contain the number of ways to climb 'n' stairs
        return second;

        
    }
}