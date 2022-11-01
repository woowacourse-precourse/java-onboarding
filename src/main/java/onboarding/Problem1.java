package onboarding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import onboarding.problem1.Person;

class Problem1 {

    private static final int firstPageNumber = 0;
    private static final int lastPageNumber = 401;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static final Map<String, Integer> returnMenu =
            Map.of("pobi", 1, "crong", 2, "draw", 0, "exception", -1);

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Person[] personList = {
                new Person("pobi", pobi.get(LEFT), pobi.get(RIGHT)),
                new Person("crong", crong.get(LEFT), crong.get(RIGHT))
        };

        for (Person person : personList) {
            int leftPageNumber = person.getLeftPageNumber();
            int rightPageNumber = person.getRightPageNumber();

            if (isOutRange(leftPageNumber) || isOutRange(rightPageNumber)) {
                return returnMenu.get("exception");
            }

            if (!isOddNumber(leftPageNumber)) {
                return returnMenu.get("exception");
            }

            if (!isEvenNumber(rightPageNumber)) {
                return returnMenu.get("exception");
            }

            if (rightPageNumber-leftPageNumber != 1) {
                return returnMenu.get("exception");
            }

            int[] leftDegitList = getDigitList(leftPageNumber);
            int[] rightDegitList = getDigitList(rightPageNumber);

            int leftScore = Math.max(getPlusScore(leftDegitList), getMultiplyScore(leftDegitList));
            int rightScore = Math.max(getPlusScore(rightDegitList), getMultiplyScore(rightDegitList));
            person.setMaxScore(Math.max(leftScore, rightScore));
        }

        Person winner = Stream.of(personList).max(Comparator.comparingInt(Person::getMaxScore)).get();

        if (Stream.of(personList).filter(p->p.getMaxScore()==winner.getMaxScore()).count() > 1)
            return returnMenu.get("draw");

        return returnMenu.get(winner.getName());
    }

    public static boolean isOutRange(int number) {
        return number <= firstPageNumber || number >= lastPageNumber;
    }

    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public static int[] getDigitList(int number) {
        return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getPlusScore(int[] digitList) {
        return Arrays.stream(digitList).reduce(0, (a, b) -> a + b);
    }

    public static int getMultiplyScore(int[] digitList) {
        return Arrays.stream(digitList).reduce(1, (a, b) -> a * b);
    }

}