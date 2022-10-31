package onboarding;

public class Problem3 {
    private static final int MIN_NUMBER_PLACE = 1;
    private static final int MAX_NUMBER_PLACE = 4;

    public static int solution(int number) {
        int answer = 0;

        for (int i = MIN_NUMBER_PLACE - 1; i <= MAX_NUMBER_PLACE - 1; i++) {
            answer += countClapOnPlace(number , i);
        }

        return answer;
    }

    private static int countClapOnPlace(int number, int place) {
        int count = 0;
        int checkNum;
        int maxFrontPlace = calculateMaxFrontPlace(place);
        for (checkNum = 3; checkNum <= 9; checkNum += 3) {
            //천의 자리면 9*0 -> 1 * 0 : 0번 자리
            //백의 자리면 9*1 -> 1 * 1 : 1번 자리
            //십의 자리면 9*11 -> 1 * 11 : 2번 자리
            //일의 자리면 9*111 -> 1 * 111 : 3번 자리 -> 자리 수 만큼 1이 붙는다

            //천의 자리면 frontPlace*10000 + i * 1000 + 999 -> 0 번 자리 10^4
            //백의 자리면 frontPlace*1000 + i * 100 + 99 -> 1번 자리 10^3
            //십의 자리면 frontPlace*100 + i * 10 + 9 -> 2번 자리 10^2
            //일의 자리면 frontPlace*10 + i * 1 -> 3번 자리
            count += countNowCheckNum(checkNum, place, number, maxFrontPlace);
        }
        return count;
    }

    private static int countNowCheckNum(int checkNum, int place, int number, int maxFrontPlace) {
        int frontPlace;
        int thisNumber;
        int count = 0;

        for (frontPlace = 0; frontPlace <= maxFrontPlace; frontPlace++) {
            thisNumber = calculateThisNumber(place, frontPlace, checkNum);
            int thisNumberClapCount = checkThisNumberCount(thisNumber, number, place);
            if (thisNumberClapCount == -1) {
                break;
            }
            count += thisNumberClapCount;
        }
        return count;
    }

    private static int calculateMaxFrontPlace(int place) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i <= place; i++) {
            sb.append("1");
        }
        int maxNumber = Integer.parseInt(sb.toString());
        maxNumber *= 9;
        return maxNumber;
    }

    private static int calculateThisNumber(int place, int frontPlace, int nowCheckNum) {
        int frontNumber = calculateFrontNumber(place, frontPlace);
        int midNumber = nowCheckNum * calculateDigit(place);
        int lastNumber = calculateMaxFrontPlace(3 - place);

        int thisNumber = frontNumber + midNumber + lastNumber;
        return thisNumber;
    }

    private static int calculateDigit(int place) {
        int digit = (int)Math.pow(10, 3 - place);
        return digit;
    }

    private static int checkThisNumberCount(int thisNumber, int number, int place) {
        int digit = calculateDigit(place);
        int count = -1;
        if (thisNumber <= number) {
            count = digit;
            return count;
        }
        if (isFrontNumberSame(thisNumber, number, digit)) {
            int possibleCount = number % digit;
            count = possibleCount + 1;
            return count;
        }
        return count;
    }

    private static Boolean isFrontNumberSame(int thisNumber, int number, int digit) {
        int thisFrontNumber = thisNumber / digit;
        int frontNumber = number / digit;
        if (thisFrontNumber == frontNumber) {
            return true;
        }
        return false;
    }

    private static int calculateFrontNumber(int place, int frontPlace) {
        int leadingDigit = (int)Math.pow(10, (4 - place));
        int frontNumber = frontPlace * leadingDigit;
        return frontNumber;
    }

}
