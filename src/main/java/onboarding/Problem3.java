package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int j = i;
            do{
                if(j%10 == 3){
                    clapCount++;
                    continue;
                }
                if(j%10 == 6){
                    clapCount++;
                    continue;
                }
                if(j%10 == 9){
                    clapCount++;
                    continue;
                }
            } while((j/=10) > 0);
        }

        return clapCount;
    }
}
