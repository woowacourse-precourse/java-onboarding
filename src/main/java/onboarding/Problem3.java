package onboarding;

public class Problem3 {
    /*
        1부터 number까지 for문을 돌려 i라는 숫자에 3,6,9의 숫자가 포함되는지 while 반복문을 통해 자리수 별로 확인
     */
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int num = i;
            while (num!=0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }
}
