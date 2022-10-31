package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += cnt369(i);
        }
        return answer;
    }

    static int cnt369(int number){
        int remain = 0;
        int count = 0;

        while(number > 0){
            remain = number % 10;
            if (remain % 3 == 0 && remain != 0)
                count++;
            number /= 10;
        }
        return count;
    }
}
