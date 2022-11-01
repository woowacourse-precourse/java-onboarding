package onboarding;

/*
 * # 기능 정리
 * [O] 변환하는 문자인지 검증
 * [O] 반대 문자 변환 메서드
 * [O] solution 작성
 * [O] 테스트 확인
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = transformWord(word).toString();
        return answer;
    }

    private static StringBuffer transformWord(String word) {
        StringBuffer transformedWord = new StringBuffer("");

        for(int i = 0; i < word.length(); i++){
            char currentLetter = word.charAt(i);

            if(isLetter(currentLetter))
                currentLetter = getOppositeLetter(currentLetter);

            transformedWord.append(currentLetter);
        }

        return transformedWord;
    }

    private static boolean isLetter(char currentLetter){
        return currentLetter >= 'A' && currentLetter <= 'Z' ||
                currentLetter >= 'a' && currentLetter <= 'z';
    }

    private static char getOppositeLetter(char currentLetter) {
        if(currentLetter <= 'Z')
            return (char) ('A' + 'Z' - currentLetter);
        return (char)('a' + 'z' - currentLetter);
    }
}
