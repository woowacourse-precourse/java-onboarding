package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++){
            int current = i;
            //int temp = cnt;

            while (current !=0){
                if(current %10 == 3 || current%10 == 6 || current%10 ==9){
                    cnt++;
                }
                current /= 10;
            }
        }
        return cnt;
    }
}
