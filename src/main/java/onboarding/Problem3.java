package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer=clapcount(number);
        return answer;
    }
    public static int clapcount(int number){
        int count=0;
        for(int i=1;i<=number;i++) {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                count++;
                i /= 10;
            }
        }
        return count;
    }
}
