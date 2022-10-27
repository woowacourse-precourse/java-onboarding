package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = getClapCount(number);
        return answer;
    }

    /**
     * 1부터 입력받은 숫자에 대해 박수를 쳐야되는 총 횟수를 반환환다.
     * @param num
     * @return int: 1부터 num까지 박수를 친 횟수
     */
    private static int getClapCount(int num){
        int result = 0;
        for(int i=1;i<=num;i++){
            result += calcClapCount(i);
        }
        return result;
    }

    /**
     * 입력받은 숫자에 대해 박수를 쳐야되는 횟수를 반환한다.
     * @param num
     * @return int: num에 대해 박수를 친 횟수
     */
    private static int calcClapCount(int num) {
        int result = 0;
        while(num > 0){
            switch (num % 10){
                case 3:
                case 6:
                case 9:
                    result++;
                    break;
            }
            num /= 10;
        }

        return result;
    }


}
