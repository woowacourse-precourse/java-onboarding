package onboarding.problem3.objects;

import java.util.Arrays;

public class Clap {

    /*
     *  숫자를 문자열 배열로 만든다.
     *  게임 룰 값과 문자열 배열에 들어 있는 원소와 비교하여 같은 것만 카운트 한다.
     */
    public int getClapCount(int number) {
        String numberToString = String.valueOf(number);

        return (int) Arrays.stream(numberToString.split(""))
                .flatMap(data ->
                        Arrays.stream(RuleValue.values())
                                .filter(ruleValue -> ruleValue.getValue().equals(data)))
                .count();
    }
}
