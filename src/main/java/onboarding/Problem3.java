package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int calcNum(int num){
        int result = 0;
        int temp = 0;
        while (num != 0) {
            temp = num % 10;
            if(temp == 3 || temp == 6 || temp == 9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }
    // 수를 받았을 때 박수를 몇번 치는지 계산

}
