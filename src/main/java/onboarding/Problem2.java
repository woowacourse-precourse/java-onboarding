package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int previousLength = 0;

        // 연속된 중복 문자들이 없을때 까지 반복
        while (answer.length() > 0) {
            previousLength = answer.length();
            answer = removeDuplication(answer);
            if (answer.length() == previousLength) {
                break;
            }
        }

        return answer;
    }

    // 연속하는 중복 문자 삭제하는 함수
    static String removeDuplication(String cryptogram) {
        String result = "";
        int current = 0;
        char currentChar;

        while (current < cryptogram.length()) {
            // 연속된 두 문자가 같은 문자가 아닐 경우 문자열에 추가
            if (current == cryptogram.length() - 1 ||
                    cryptogram.charAt(current) != cryptogram.charAt(current + 1)) {
                result += cryptogram.charAt(current);
                current++;
            } else {
                currentChar = cryptogram.charAt(current);
                // 같은 문자가 나오지 않을 때 까지 문자 위치 다음으로 이동
                while (currentChar == cryptogram.charAt(current)) {
                    current++;
                    // 문자열 끝에 도달하면 종료
                    if (current == cryptogram.length()) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
