package onboarding;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println(solution("I Love you"));
    }

    public static String solution(String word) {
        String sonWords = "";

        for (int i = 0; i < word.length(); i++) {
            char preWord = word.charAt(i);

            if (!('a' <= preWord && preWord <= 'z' || 'A' <= preWord && preWord <= 'Z')) {
                sonWords += preWord;
            } else if (Character.isLowerCase(preWord)) {
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
