package onboarding;

import java.util.ArrayList;
import java.util.Collections;

public class Problem3 {
    public static int solution(int number) {
        checkNumberCorrect(number);

        return getResult(number);
    }

    /**
     * 올바른 숫자가 입력되었는지 확인
     * @param number 숫자
     * @throws RuntimeException 오류 메세지
     */
    private static void checkNumberCorrect(int number) {
        if (number < 1 || number > 10_000) {
            throw new RuntimeException("1 ~ 10,000 숫자가 입력되어야 합니다.");
        }
    }

    /**
     * 해당 숫자까지의 박수 횟수 가져오기
     * @param number 숫자
     * @return 박수 횟수
     */
    private static int getResult(int number) {
        int countClap = 0;

        for(int i = 1; i <= number; i++) {
            countClap += getClapCount(i);
        }

        return countClap;
    }

    /**
     * 해당 숫자의 박수 횟수 가져오기
     * @param number 숫자
     * @return 박수 횟수
     */
    private static int getClapCount(int number) {
        int[] oneLetterNumbers = getOneLetterNumbers(number);
        int countClap = 0;

        for (int oneLetterNumber : oneLetterNumbers) {
            if (oneLetterNumber == 3 || oneLetterNumber == 6 || oneLetterNumber == 9) {
                countClap++;
            }
        }

        return countClap;
    }

    /**
     * 숫자를 한글자씩 분할
     * @param number 숫자
     * @return 분할된 숫자
     */
    private static int[] getOneLetterNumbers(int number) {
        ArrayList<Integer> arrayNumber = new ArrayList<>();

        while (number > 0) {
            arrayNumber.add(number % 10);
            number /= 10;
        }

        Collections.reverse(arrayNumber);

        return arrayNumber.stream().mapToInt(i -> i).toArray();
    }

}
