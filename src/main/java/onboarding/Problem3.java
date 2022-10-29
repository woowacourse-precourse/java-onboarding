package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; number >= i; i++){
            answer += checkNumber(i);
        }

        return answer;
    }

    /**
     * @param number : 자연수
     * @return 3, 6, 9의 총 개수
     */
    private static int checkNumber(int number) {
        int count = 0;

        while(number != 0){
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9){
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
