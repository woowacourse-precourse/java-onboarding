package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCnt = 0;

        for(int i = 1; i <= number; i++){
            if(includeNum(i)){
                clapCnt += cntNum(i);
            }
        }

        return clapCnt;
    }

    /**
     * 3,6,9가 들어가는지 여부
     */
    public static Boolean includeNum(int number){
        while(number > 0){
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9){
                return true;
            }else{
                number /= 10;
            }
        }
        return false;
    }

    /**
     * 수의 3,6,9 의 갯수
     */
    public static int cntNum(int number){
        int cnt = 0;

        while(number > 0){
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9){
                cnt++;
                number /= 10;
            }else{
                number /= 10;
            }
        }
        return cnt;
    }
}
