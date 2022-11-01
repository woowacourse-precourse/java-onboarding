package onboarding;

public class Problem3 {
    private static int GetClapNum(int number){
        int res = 0;

        while (number > 0) {
            int rest = number % 10;
            if (rest == 3 || rest == 6|| rest == 9)
                res++;
            number /= 10;
        }
        return res;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++){
            int clap = GetClapNum(i);
            answer += clap;
        }
        return answer;
    }
}
