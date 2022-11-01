package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int count = i;

            while(count > 0){
                int clap = count % 10;
                if(clap == 3 || clap == 6 || clap == 9){
                    answer++;
                }
                count /= 10;
            }
        }
        return answer;
    }
}

