package onboarding;

/**
 * 기능 사항
 * a. 주어진 수의 3, 6, 9의 개수를 리턴
 */
public class Problem3 {

    /**
     * a. 주어진 수의 3, 6, 9의 개수를 리턴
     * @param number
     * @return 3, 6, 9 개수 리턴
     */
    static int counting(int number){
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

        for(int i=1; i<=number; i++){
            answer += counting(i);
        }

        return answer;
    }
}