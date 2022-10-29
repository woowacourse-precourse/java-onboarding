package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while(number > 2){
            int i = number;
            while(i > 2){
                if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                    answer++;
                }
                i = i/10;
            }
            number--;
        }
        return answer;
    }
}
