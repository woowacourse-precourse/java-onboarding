package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while(number > 0){
            int temp = number;

            while(temp > 0){
                int clap = temp%10;
                if(clap == 3 || clap == 6 || clap == 9)
                    answer++;
                temp /= 10;
            }

            number--;
        }

        return answer;
    }
}
