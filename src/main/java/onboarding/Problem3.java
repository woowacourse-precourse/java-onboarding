package onboarding;

import java.util.List;

public class Problem3 {

    private static final List<String> criteriaList = List.of(
            new String("3"),
            new String("6"),
            new String("9")
    );

    public static int solution(int number) {
        /*  [요구] 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수 구하기 */
        return getGameResult(number);
    }

    //숫자에 3,6,9가 들어갈 때 3,6,9의 개수를 구하는 메서드
    public static int getClapCount(int number) {
        int cnt = 0;
        for (String s : String.valueOf(number).split("")) {
            if (criteriaList.contains(s)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    //  1부터 number까지 손뼉 치는 횟수 구하는 메서드
    public static int getGameResult(int endNumber) {
        int result = 0;
        /* [요구] 숫자에 3,6,9가 들어갈 때 3,6,9의 개수만큼 손뼉을 친다. */
        for (int number=1;number<=endNumber;number++){
            result += getClapCount(number);
        }
        return result;
    }

}