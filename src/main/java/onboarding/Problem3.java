package onboarding;

public class Problem3 {
    public static int count_clap(int number){
        int count = 0;
        int remainder;

        while (number!=0){
            remainder = number %10;
            if (remainder == 3 || remainder == 6 || remainder == 9){
                count+=1;
            }
            number/=10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++){
            answer += count_clap(i);
        }
        return answer;
    }

}
