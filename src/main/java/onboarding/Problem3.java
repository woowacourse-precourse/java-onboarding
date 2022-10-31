package onboarding;

public class Problem3 {
    public static int solution(int number) {


        int cnt = 0;
        // 1부터 number까지 3 , 6 , 9를 포함하고 있으면 cnt을 1씩증가시킨다.
        for (int i = 1; i <= number; i ++){
            int a = i;
            while(a !=0){

                if(a % 10 == 3 || a % 10 == 6 || a % 10 == 9) {
                    cnt += 1;
                }
                a = a/10;

            }
        }


        return cnt;


    }


}
