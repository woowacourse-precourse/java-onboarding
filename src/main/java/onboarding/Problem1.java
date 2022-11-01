package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능목록
 * 1.각자리의 숫자를 구한다.
 * 2.각자리의 숫자의 합을 구한다.
 * 3.각자리의 숫자의 곱을 구한다.
 * 4.비교한다.
 *
 * 5.점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6.시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다. (예외처리)
 */
class Problem1 {

    private boolean checkException(int page) {
        if (page == 1 && page == 399) {
            return false;
        }
        return true;
    }

    private boolean checkDifferenceIsOne(List<Integer> list) {
        if ((list.get(1) - list.get(0)) != 1) {
            return false;
        }
        return true;
    }

    public boolean checkPagesIsNotFirstOrLast(List<Integer> pobi, List<Integer> crong) {
        if (checkException(pobi.get(0)) == false || checkException(crong.get(0)) == false) {
            return false;
        }
        if (checkDifferenceIsOne(pobi) == false || checkDifferenceIsOne(crong) == false) {
            return false;
        }
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p1 = new Problem1();
        if (!(p1.checkPagesIsNotFirstOrLast(pobi, crong))) {
            return -1;
        }
        int pobiAnswer = p1.getLargeValueOnePerson(pobi);
        int crongAnswer = p1.getLargeValueOnePerson(crong);

        return p1.getAnswer(pobiAnswer, crongAnswer);
    }

    public int getAnswer(int pobiAnswer, int crongAnswer) {
        if (pobiAnswer > crongAnswer) {
            return 1;
        } else if (pobiAnswer < crongAnswer) {
            return 2;
        }
        return 0;
    }

    public int getLargeValueOnePerson(List<Integer> list) {
        return getLargeInt(getLargeValueOneSide(list, 0), getLargeValueOneSide(list, 1));
    }

    private int getLargeValueOneSide(List<Integer> list, int index) {
        List<Integer> eachDigit = getEachDigit(list.get(index));
        return getLargeInt(getTotalByAdd(eachDigit), getTotalByMultiply(eachDigit));
    }

    private int getLargeInt(int a, int b) {
        return a > b ? a : b;
    }

    private int getTotalByAdd(List<Integer> eachDigit) {
        int total = 0;
        for (Integer num : eachDigit) {
            total += num;
        }
        return total;
    }

    private int getTotalByMultiply(List<Integer> eachDigit) {
        //곱셈은 1이 기본값.
        int total = 1;
        for (Integer num : eachDigit) {
            total = total * num;
        }
        return total;
    }

    private List<Integer> getEachDigit(int num) {
        List<Integer> eachDigit = new ArrayList<>();
        String stringNum = changeIntegerToString(num);
        for (int i = 0; i < stringNum.length(); i++) {
            //char 형을 int 값으로 가져오는 법.
            //Character.getNumericValue(stringNum.charAt(i));
            int digit = stringNum.charAt(i) - '0';
            eachDigit.add(digit);
        }
        return eachDigit;
    }

    private String changeIntegerToString(int value) {
        return String.valueOf(value);
    }

}