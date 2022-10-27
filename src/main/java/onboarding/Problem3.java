package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=3; i<= number; i++){
            answer += count369(i);
        }

        return answer;
    }
    static public int count369(int num){
        int count =0;
        while (num>0){
            if(num%10==3|| num%10==6|| num%10==9){
                count += 1;
            }
            num /= 10;
        }
        return count;
    }
}
