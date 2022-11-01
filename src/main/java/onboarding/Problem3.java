package onboarding;

public class Problem3 {
    public static int isClip(int x){
        if(x == 3 || x == 6 || x == 9) return 1;
        else return 0;
    }
    public static int getTotalClapCount(int number){
        int count = 0;
        while(number != 0){
            count += isClip(number % 10);
            number /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int result = 0;
        for(int i=1; i<=number; i++) result += getTotalClapCount(i);
        return result;
    }
}
