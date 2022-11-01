package onboarding;

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
