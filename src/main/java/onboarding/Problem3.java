package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++){
            int term = i;
            while(term > 0) {
                if ((term % 10) != 0 && (term % 10) % 3 == 0) {
                    answer++;
                }
                term /= 10;
            }
        }

        return answer;
    }
}
