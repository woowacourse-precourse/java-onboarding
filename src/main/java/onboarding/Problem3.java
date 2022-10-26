package onboarding;

/**
 * 기능 사항
 * 1. 해당 수의 369의 개수를 리턴하는 함수
 */
public class Problem3 {

    /**
     * 해당 수의 369를 리턴하는 함수 
     * @param number
     * @return 369 개수 리턴
     */
    static int count(int number){
        int res = 0;
        while(number != 0){
            int tmp = number%10;
            if(tmp == 3 || tmp == 6 || tmp == 9)
                res++;
            number/=10;
        }
        return res;

    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
