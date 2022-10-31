package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            answer += checkCountOfClaps(i);
        }

        return answer;
    }

    private static int checkCountOfClaps(int number){
        int count = 0;
        while(number > 0){
            int tmp = number%10;
            if(tmp != 0 && tmp%3 == 0){
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
