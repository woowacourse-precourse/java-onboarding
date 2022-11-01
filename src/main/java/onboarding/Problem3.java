package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (number < 1 || number > 10000) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
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
