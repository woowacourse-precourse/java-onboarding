package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(CheckInput(number)){
            return Count369(number);
        }
        throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 예외 확인 */
    private static boolean CheckInput(int number){
        if(number > 0 && number <10000) return true;
        return false;
    }

    /* 기능2 : 3,6,9 개수 세기 */
    private static int Count369(int number){
        int count = 0;
        while(number != 0){
            int tmp = number % 10;
            if(tmp ==3 || tmp == 6 || tmp ==9){
                count += 1;
                number /= 10;
            }
        }return count;
    }
}
