package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return 1;
    }
    public static int start_game(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            count += counting_369(i);
        }
        return count;
    }
    public static int counting_369(int num){
        int count = 0;
        for(int n; num != 0; num /= 10){
            n = num % 10;
            if(n == 3 || n == 6 || n == 9) {
                count++;
            }
        }
        return count;
    }
}
