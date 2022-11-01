package onboarding;

public class Problem3 {

    public int countClap(int num) {
        int count = 0;
        while(num>0) {
            if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
                count++;
            num /= 10;
        }

        return count;
    }
    public static int solution(int number) {
        Problem3 prob = new Problem3();
        int answer = 0;

        for (int i = 1; i<=number; i++)
            answer += prob.countClap(i);

        return answer;
    }
}
