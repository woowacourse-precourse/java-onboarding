package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count =0;
        System.out.println("함수시작");
        for (int i = 1; i <= number; i++) {
            int tmp=i;
            while(tmp>0){
                if(tmp%10==3||tmp%10==6||tmp%10==9){
                    count++;
                }
                tmp = tmp/10;
            }
        }

        return count;
    }
}
