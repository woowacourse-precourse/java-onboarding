package onboarding;

public class Problem3 {
    public static int calNum(int num){
        int count = 0;
        while (num >0)
        {
            int oneDigit = num%10;
            if (oneDigit ==3 || oneDigit ==6 || oneDigit ==9)
            {
                count++;
            }
            num= num/10;
        }
        return count;
    }
    public static int solution(int number)
    {
        int answer = 0;
        for (int i = 1 ; i<= number ; i++) {
            answer += calNum(i);
        }
        return answer;
    }

   /* public static void main(String[] args) {
        System.out.println(solution(10000));
    }*/
}
