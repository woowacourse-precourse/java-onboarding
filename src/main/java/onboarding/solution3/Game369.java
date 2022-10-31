package onboarding.solution3;

public class Game369 {
    private static int residential(int num){
        if ((num % 10) == 3 || (num % 10) == 6 || (num % 10) == 9){
            return 1;
        }
        return 0;
    }
    private static int check369(int num){
        int count = 0;
        while (num > 0){
            count += residential(num);
            num /= 10;
        }
        return count;
    }
    public static int checkTarget(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            count += check369(i);
        }
        return count;
    }
}
