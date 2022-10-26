package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] memo = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            memo[i] = memo[i - 1] + countingClap(i);
        }
        return memo[number];
    }

    static int countingClap(int num){
        int count = 0;
        while(num>0){
            if(num % 10 % 3 == 0 && num % 10 != 0){
                count++;
            }
            num /= 10;
        }
        return count;
    }
}