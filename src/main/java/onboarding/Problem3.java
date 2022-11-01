package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = count(number);
        return answer;
    }

    private static  int count(int number) {
        int[] unit = {3, 6, 9};
        int cnt = 0;
        for(int i = 1; i <= number; i++) {
            int j = i;
            while(j > 0){
                if(j%10==3||j%10==6||j%10==9){
                    cnt += 1;
                }
                j=j/10;
            }
        }
        return cnt;
    }
}
