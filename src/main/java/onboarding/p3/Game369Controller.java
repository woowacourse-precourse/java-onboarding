package onboarding.p3;

public class Game369Controller {
    // 1. 1부터 number 까지 손뼉을 쳐야하는 횟수 반환
    public static int getTotalNumberOfClap(int number){
        int count = 0;
        for (int i = 3; i < number + 1; i++) {
            count += getClapCount(i);
        }
        return count;
    }

    // 2. 주어진 자연수에서 손뼉을 쳐야하는 횟수 반환
    public static int getClapCount(int num) {
        int count = 0;
        char[] numberArray = String.valueOf(num).toCharArray();
        for (char c : numberArray) {
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }
}
