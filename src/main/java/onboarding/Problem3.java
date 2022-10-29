package onboarding;

public class Problem3 {
    private static int count_369(int num){
        int count = 0;
        while(num >= 1){
            if (num%10 == 3 || num%10 == 6 || num%10 == 9){
                count += 1;
            }
            num /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int count = 0;
        for(int i = 1; i<=number; i++){
            count += count_369(i);
        }

        return count;
    }
}
