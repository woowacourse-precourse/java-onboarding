package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String sonWords = "";

        for (int i = 0; i < word.length(); i++) {
            char preWord = word.charAt(i);

            // 소문자인 경우 대문자로 변환 후 메서드 실행. 반환값을 다시 대문자로 변환
            if (Character.isLowerCase(preWord)) {
                preWord -= 32;
                preWord = (char) (convertWords(preWord) + 32);
                sonWords += preWord;
            } else {
                sonWords += convertWords(preWord);
            }
        }

        return sonWords;
    }

    public static char convertWords(char preWord) {
        char[] DictionaryOfWords = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M'
                , 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        // 빈칸인 경우 빈칸을 그대로 반환
        if (preWord == ' ') {
            return ' ';
        }

        int idx = preWord - 65;

        return DictionaryOfWords[idx];
    }
}
