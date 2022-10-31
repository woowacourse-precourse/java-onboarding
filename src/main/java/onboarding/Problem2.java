package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        // 연속하는 중복 문자들을 전부 삭제
        answer = getAnswer(cryptogram);

        return answer;
    }

    // 연속하는 중복 문자들을 전부 삭제한 결과를 반환하는 함수
    private static String getAnswer(String cryptogram) {
        String originalText = cryptogram; // 연속 중복 문자들을 삭제한 결과를 담는 변수

        // 연속 중복 문자들을 삭제했을 때 ""이 될 때까지 & 연속하는 중복 문자들이 더 이상 없을 때까지 반복
        while (!originalText.equals("") && !isOriginalText(originalText)) {
            originalText = deleteDuplicateChar(originalText); // 연속 중복 문자들을 제거
        }
        return originalText;
    }

    // 연속하는 중복 문자들이 더 이상 없는지를 확인하는 함수
    // 연속 중복 문자들이 존재하지 않았다면 true 반환 / 연속 중복 문자들이 존재한다면 false 반환
    private static boolean isOriginalText(String originalText) {
        boolean isOriginalText = true;

        for (int i = 1; i < originalText.length(); i++) {
            char prevChar = originalText.charAt(i - 1); // 앞 문자
            char postChar = originalText.charAt(i); // 뒷 문자

            // 중복이 존재한다면 isOriginalText = false로 바꾸고 for문 멈추기
            if (prevChar == postChar) {
                isOriginalText = false;
                break;
            }
        }
        // 중복이 존재하지 않았다면 isOriginalText = true로 유지됨

        return isOriginalText;
    }

    // 연속하는 중복 문자들을 전부 삭제한 문자열을 반환하는 함수
    private static String deleteDuplicateChar(String cryptogram) {
        StringBuilder originalText = new StringBuilder(); // 중복을 제거한 문자열
        boolean isDuplicated = false; // 앞에서 중복이 존재했는지 가리키는 변수 (중복이 존재했다면 true / 중복이 존재하지 않았다면 false)

        for (int i = 1; i < cryptogram.length(); i++) {
            char prevChar = cryptogram.charAt(i - 1); // 앞 문자 (originalText에 저장되는 문자)
            char postChar = cryptogram.charAt(i); // 뒷 문자

            /*
               prevChar가 originalText에 저장되기 위해서는 아래 1, 2번이 모두 만족되어야 함
               1. 앞 문자와 뒷 문자가 다름 (중복되지 않음)
               2. 앞 문자와 그의 앞 문자(앞앞문자)에 대해서 중복이 일어나지 않았던 상태
            */

            // 앞뒤 문자가 다르며 이전에 중복이 존재하지 않았을 경우 -> prevChar를 originalText에 저장
            if (prevChar != postChar && !isDuplicated) {
                originalText.append(prevChar);
            }
            // 앞뒤 문자가 다르며 이전에 중복이 존재했을 경우 -> isDuplicated = false
            if (prevChar != postChar && isDuplicated) {
                isDuplicated = false;
            }
            // 앞뒤 문자가 달랐을 때 현재 마지막 문자를 보고 있는 중이라면 -> curChar를 originalText에 저장
            if (prevChar != postChar && i == cryptogram.length() - 1) {
                originalText.append(postChar);
            }

            // 앞뒤 문자가 같을 경우 (중복 존재) -> isDuplicated = true
            if (prevChar == postChar) {
                isDuplicated = true;
            }
        }

        return originalText.toString();
    }

}
