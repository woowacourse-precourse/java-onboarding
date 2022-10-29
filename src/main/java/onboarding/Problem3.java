package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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
        return 0;
    }
}
