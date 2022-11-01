package onboarding;
/*
 * 기능구현
 * 1. 범위 체크 함수
 * 2. 3,6,9의 수 세는 함수
 * 3. 수를 더하는 함수
 * */
public class Problem3 {

    static final int EXCEPTION = -1;
    public static int solution(int number) {

        if (!inRange(number)){
            return EXCEPTION;
        }


        return addNum(number);
    }
    public static boolean inRange(int number) {
        return number >= 1 && number <= 10000;
    }

    public static int addNum(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            answer += getNum(i);
        }
        return answer;
    }

    public static int getNum(int num){
        String[] numStr = String.valueOf(num).split("");
        int flag = 0;
        for (String s : numStr){
            if (Integer.parseInt(s) % 3 == 0 && Integer.parseInt(s) != 0){
                flag += 1;
            }
        }
        return flag;
    }
}
