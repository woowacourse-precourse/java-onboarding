package onboarding;

public class Problem3 {
    private static boolean is_369(int num){
        while(num > 0){
            if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9) return true;
            num/=10;
        }

        return false;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            if(is_369(i)) {
                int j=i;
                while(j > 0){
                    if(j % 10 == 3 || j % 10 == 6 || j % 10 == 9) answer ++;
                    j/=10;
                }
            }
        }

        return answer;
    }
}
