package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int num = 3;
        int cnt = 0;

        /* 3부터 입력된 숫자까지 +1씩 증가시키며 반복 */
        while(num <= number){
            cnt += count369(num);
            num++;
        }

        return cnt;
    }

    /*3 6 9가 들어간 횟수를 반환하는 메소드*/
    private static int count369(int num){
        int count = 0;
        int countedNum;
        while(num > 0){
            countedNum = num % 10;
            if(countedNum !=0 && countedNum % 3 == 0) {
                count += 1;
            }
            num /= 10;
        }

        return count;
    }
}
