package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /*
     * 주어진 문자열에 존재하는 3, 6, 9의 개수를 반환
     * 문자열을 한 자리씩 정수로 변환해서 0이 아니고, 정수 % 3 == 0인 경우 카운트 증가
     *
     * @return int
     * */
    private static int countThreeSixNine(String number) {
        int count = 0;
        int numberLength = number.length();

        for (int index = 0; index < numberLength; index++) {
            int currentNumber = number.charAt(index) - '0';
            if (currentNumber != 0 && currentNumber % 3 == 0) {
                count++;
            }
        }

        return count;
    }
}
