package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; ++i)
            for(int j = i, k; j > 0; j /= 10){
                k = j % 10;
                if(k == 3 || k == 6 || k == 9)
                    ++answer;
            }

        return answer;
    }
}