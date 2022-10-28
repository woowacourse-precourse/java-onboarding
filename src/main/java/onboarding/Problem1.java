package onboarding;

import java.util.List;
import java.util.Map;
import onboarding.problem1.Person;

class Problem1 {

    private static final int firstPageNumber = 0;
    private static final int lastPageNumber = 401;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static final Map<String, Integer> scoreMenu =
            Map.of("pobi", 1, "crong", 2, "draw", 0, "exception", -1);

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        List<Person> personList = List.of(
                new Person("pobi", pobi.get(LEFT), pobi.get(RIGHT)),
                new Person("crong", crong.get(LEFT), crong.get(RIGHT))
        );

        // 1. [예외처리] 페이지 번호 입력
        for (Person person: personList) {
            int leftPageNumber = person.getLeftPageNumber();
            int rightPageNumber = person.getRightPageNumber();

            // 시작면(0) 또는 마지막면(401) 입력한 경우
            if (isOutRange(leftPageNumber) || isOutRange(rightPageNumber))
                return scoreMenu.get("exception");

            // 왼쪽페이지가 홀수가 아닌 경우
            if (!isOddNumber(leftPageNumber))
                return scoreMenu.get("exception");

            // 오른쪽페이지가 짝수가 아닌 경우
            if (!isEvenNumber(rightPageNumber))
                return scoreMenu.get("exception");

        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 책의 시작 면이나 마지막 면이 있는지 확인하는 메서드
    public static boolean isOutRange(int number) {
        return number==firstPageNumber || number==lastPageNumber;
    }

    // 홀수인지 확인하는 메서드
    public static boolean isOddNumber(int number) {
        return number%2!=0;
    }

    // 짝수인지 확인하는 메서드
    public static boolean isEvenNumber(int number) {
        return number%2==0;
    }


}