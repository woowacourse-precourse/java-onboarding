package onboarding;

public class Problem4 {
    public static String answer = "";

    public static String solution(String word) {
        return changeFrogWord(word);
    }

    // 각각의 문자를 순서대로 호출
    public static String changeFrogWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            findUpperCase(word, i);
            findLowerCase(word, i);
            findElseCase(word, i);
        }
        return answer;
    }

    // 대문자인지 판별 후 answer에 저장
    public static void findUpperCase(String word, int i) {
        if (65 <= word.charAt(i) && word.charAt(i) <= 90) {
            for (int j = 65; j <= 90; j++) {
                if ((char) j == word.charAt(i)) {
                    answer += (char) (90 - (j - 65));
                    break;
                }
            }
        }
    }

    // 소문자인지 판별 후 answer에 저장
    public static void findLowerCase(String word, int i) {
        if (97 <= word.charAt(i) && word.charAt(i) <= 122) {
            for (int k = 97; k <= 122; k++) {
                if ((char) k == word.charAt(i)) {
                    answer += (char) (122 - (k - 97));
                    break;
                }
            }
        }
    }

    // 그 외 문자인지 판별 후 answer에 저장
    public static void findElseCase(String word, int i) {
        if (word.charAt(i) <= 64 || 123 <= word.charAt(i) || 91 <= word.charAt(i) && word.charAt(i) <= 96) {
            answer += word.charAt(i);
        }
    }
}