package onboarding.problem3;

public class Game {

    public static int playGame(int num) {
        Number.validate(num);
        return countClap(num);
    }

    // 1부터 해당 숫자까지 손뼉치는 횟수를 구하는 메서드
    public static int countClap(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            count += Number.hasThreeSixNine(i);
        }
        return count;
    }

}
