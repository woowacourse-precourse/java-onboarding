package onboarding;

public class Problem3 {

    public static int findNumber(int num) {
        int sum = 0;
        int quotient = num;

        while(quotient > 9) {
            int remainder = quotient % 10;
            if(remainder == 3 || remainder == 6 || remainder == 9) sum++;
            quotient /= 10;
        }
        if(quotient == 3 || quotient == 6 || quotient == 9) sum++;
        return sum;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i <= number; i++) {
            answer += findNumber(i);
        }

        return answer;
    }
}
