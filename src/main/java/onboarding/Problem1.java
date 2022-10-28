package onboarding;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import onboarding.problem1.Person;

class Problem1 {

    private static final int firstPageNumber = 0;
    private static final int lastPageNumber = 401;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static final Map<String, Integer> scoreMenu =
            Map.of("pobi", 1, "crong", 2, "draw", 0, "exception", -1);

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Person[] personList = {
                new Person("pobi", pobi.get(LEFT), pobi.get(RIGHT)),
                new Person("crong", crong.get(LEFT), crong.get(RIGHT))
        };

        for (Person person : personList) {
            /* [예외처리] 페이지 번호 입력 */
            int leftPageNumber = person.getLeftPageNumber();
            int rightPageNumber = person.getRightPageNumber();

            // 시작면(0) 또는 마지막면(401) 입력한 경우
            if (isOutRange(leftPageNumber) || isOutRange(rightPageNumber)) {
                return scoreMenu.get("exception");
            }

            // 왼쪽페이지가 홀수가 아닌 경우
            if (!isOddNumber(leftPageNumber)) {
                return scoreMenu.get("exception");
            }

            // 오른쪽페이지가 짝수가 아닌 경우
            if (!isEvenNumber(rightPageNumber)) {
                return scoreMenu.get("exception");
            }

            /* [요구] 가장 큰 수 구하기  */
            // 왼쪽, 오른쪽 페이지 번호 자릿수 구하기
            int[] leftDegitList = getDigitList(leftPageNumber);
            int[] rightDegitList = getDigitList(rightPageNumber);

            for (int i = 0; i < 2; i++) {
                // (1). 왼쪽 페이지 번호 자릿수 모두 더한 값, 모두 곱한 값 중 가장 큰 수 구하기
                int leftScore = Math.max(getPlusScore(leftDegitList), getMultiplyScore(leftDegitList));
                // (2). 오른쪽 페이지 번호 자릿수 모두 더한 값, 모두 곱한 값 중 가장 큰 수 구하기
                int rightScore = Math.max(getPlusScore(rightDegitList), getMultiplyScore(rightDegitList));
                // (3). (1)과 (2) 중 가장 큰 수를 본인 점수로 한다.
                person.setMaxScore(Math.max(leftScore, rightScore));
            }
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 책의 시작 면이나 마지막 면이 있는지 확인하는 메서드
    public static boolean isOutRange(int number) {
        return number == firstPageNumber || number == lastPageNumber;
    }

    // 홀수인지 확인하는 메서드
    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    // 짝수인지 확인하는 메서드
    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    // 페이지 번호 자릿수 구하는 메서드
    public static int[] getDigitList(int number) {
        return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
    }

    // 페이지 번호 자릿수 모두 더한 값 구하는 메서드
    public static int getPlusScore(int[] digitList) {
        return Arrays.stream(digitList).reduce(0, (a, b) -> a + b);
    }

    // 페이지 번호 자릿수 모두 곱한 값 구하는 메서드
    public static int getMultiplyScore(int[] digitList) {
        return Arrays.stream(digitList).reduce(1, (a, b) -> a * b);
    }


}