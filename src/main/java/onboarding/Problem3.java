package onboarding;

public class Problem3 {
    /**
     * 3,6,9 갯수 세는 함수
     */
    public static int solution(int number) {
        return count(number);
    }

    /*
     *3,6,9 갯수 세는 함수
     */
    static int count(int number){
        int answer = 0;
        for(int i=1;i<=number;i++) {
            int num = i;
            while (num != 0) {
                int result = num % 10;
                num = num/10;
                if (result>0 && result % 3 == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
