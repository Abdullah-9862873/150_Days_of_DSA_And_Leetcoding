/*
Problem Statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT(I-1] - HEIGHTj-1]). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[1] <= 1000 •
Time limit: 1 sec


Sample Input 1:
2
4
10 20 30 10
3
10 50 10

Smaple Output 1:
20
0

https://www.codingninjas.com/studio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

*/
//_____________________________________________________________________________

//__________________________Simple Recursion____________________________________
// public class Video_03_Frog_Jump {
//     public static void main(String[] args) {
// int[] arr = {30,10,60,10,60,50};
// int min = Integer.MAX_VALUE;
// int initialStep = 0;
// int finalStep = arr.length-1;
// int answerSoFar = 0;

//         int ans = getAns(initialStep,finalStep,min,answerSoFar,arr);
//         System.out.println(ans);
//     }
//     public static int getAns(int initialStep, int finalStep, int min,int answerSoFar, int[] arr){
//         if(initialStep >= finalStep){
//             if(initialStep == finalStep){
//                 min = Math.min(min, answerSoFar);
//             }
//             return min;
//         }
//         int min1= getAns(initialStep+1, finalStep, min, initialStep+1 <= finalStep ? answerSoFar + Math.abs(arr[initialStep+1]-arr[initialStep]) : answerSoFar, arr);
//         int min2 = getAns(initialStep+2, finalStep, min, initialStep+2 <= finalStep ? answerSoFar + Math.abs(arr[initialStep+2]-arr[initialStep]) : answerSoFar, arr);

//         return Math.min(min1,min2);
//     }
// }

//__________________________Using Memoization____________________________________
// import java.util.*;

// public class Video_03_Frog_Jump {
//     public static void main(String[] args) {
//         int[] arr = { 30, 10, 60, 10, 60, 50 };
//         int initialStep = 0;
//         int finalStep = arr.length - 1;
//         int[] memo = new int[arr.length];
//         Arrays.fill(memo, -1);

//         int ans = getAns(initialStep, finalStep, arr, memo);
//         System.out.println(ans);
//     }

//     public static int getAns(int initialStep, int finalStep, int[] arr, int[] memo) {
//         if (initialStep >= finalStep) {
//             if (initialStep == finalStep) {
//                 return 0;
//             }
//             return Integer.MAX_VALUE;
//         }

//         if (memo[initialStep] != -1) {
//             return memo[initialStep];
//         }

//         int min1 = Integer.MAX_VALUE;
//         if (initialStep + 1 <= finalStep) {
//             min1 = getAns(initialStep + 1, finalStep, arr, memo) + Math.abs(arr[initialStep + 1] - arr[initialStep]);
//         }

//         int min2 = Integer.MAX_VALUE;
//         if (initialStep + 2 <= finalStep) {
//             min2 = getAns(initialStep + 2, finalStep, arr, memo) + Math.abs(arr[initialStep + 2] - arr[initialStep]);
//         }

//         return memo[initialStep] = Math.min(min1, min2);
//     }
// }

//__________________________Using Tabulation___________________________________
import java.util.*;

public class Video_03_Frog_Jump {
    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        int min = getMinCost(arr);
        System.out.println(min);
    }

    public static int getMinCost(int[] arr) {
        int n = arr.length;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(arr[i - 1] - arr[i]),
                    i - 2 >= 0 ? dp[i - 2] + Math.abs(arr[i - 2] - arr[i]) : Integer.MAX_VALUE);
        }

        return dp[n - 1];
    }
}
