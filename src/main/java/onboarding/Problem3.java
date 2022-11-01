package onboarding;

public class Problem3 {
    public static int calNum(int num){
        // 각 숫자에 따라 3,6,9 가 포함되어있는지 계산
        int count = 0;
        while (num >0)
        {
            int oneDigit = num%10;
            if (oneDigit ==3 || oneDigit ==6 || oneDigit ==9)
                count++;
            num= num/10;
        }
        return count;
    }
    public static int solution(int number)
    {
        // 1부터 number 까지 3,6,9 개수 계산.
        int answer = 0;
        for (int i = 1 ; i<= number ; i++) {
            answer += calNum(i);
        }
        return answer;
    }
}
