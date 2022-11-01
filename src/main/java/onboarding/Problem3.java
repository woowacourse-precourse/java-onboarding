package onboarding;

/**
 * 기능 목록
 * 1. 한 숫자에 대해 3, 6, 9 각각의 개수를 세는 기능  —> countNumber()
 *     : 한 숫자 내에서 숫자의 길이만큼 반복문을 돌려 charAt을 사용해 3,6,9와 같은지 판별
 * 2. 모든 숫자에 대한 3,6,9 개수를 합산하는 기능 —> solution()
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 0; i <= number; i++) {
            answer += countNumber(Integer.toString(i));
        }
        return answer;
    }

    private static int countNumber(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char iCypher = number.charAt(i); //iCyper : i번째 자릿수 (예 35의 2번째 자릿수는 5이다.)
            if (iCypher == '3' || iCypher == '6' || iCypher == '9') {
                count++;
            }
        }
        return count;
    }
}
