package onboarding;
public class Problem3 {
    public static int[] memo = new int[10001];
    private static int count369(int number)
    {
        int tmp = number;
        int count = 0;

        while(tmp != 0)
        {
            int remain = tmp % 10;
            if(remain == 3 || remain == 6 || remain == 9) count++;
            tmp /= 10;
        }

        return count;
    }
    public static int solution(int number) {

        if(memo[number] != 0) return memo[number];

        int answer = 0;
        int i = 0;
        while(i <= number)
        {
            answer += count369(i);
            if(memo[answer] == 0) memo[i] = answer;
            i++;
        }

        return answer;
    }
}
