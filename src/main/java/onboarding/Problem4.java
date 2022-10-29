package onboarding;

public class Problem4 {
    public static void main(String[] args) {
        
    }
    public static String solution(String word) {
        // 1. 비교해서 변화하려는 코드표를 char 배열로 생성
        // 2-1. word를 매개변수로 받아서 char.At()을 이용해 char 배열의 원소들과 비교하는 메서드 생성
        // 2-2. 소문자와 대문자를 구분하기
        // 3. 반환값 출력

        String sonWords = "";

        for (int i = 0; i < word.length(); i++) {
            char preWord = word.charAt(i);

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
        int idx = preWord - 65;

        return DictionaryOfWords[idx];
    }
}
