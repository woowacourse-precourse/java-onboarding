package onboarding;

public class Problem3 {
    /**
     * 요구사항
     * n이 주어질때 1부터 n까지 3,6,9가 들어가는 횟수를 찾아라.
     * 1<=number<=10000
     *
     */
    public static int solution(int number) {
        int answer = 0;
        // number까지 i번 반복
        for(int i = 1 ; i <= number ; i++)
            answer += getResult(i);
        return answer;
    }
    // getResult : 입력 받은 숫자의 손뼉횟수를 리턴한다. (3이면 1, 33이면 2)
    public static int getResult(int num){
        int result = 0;
        while(num > 0){
            if (num%10==3||num%10==6||num%10==9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }

}
