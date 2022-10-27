package onboarding;

/*
 * # 기능 정리
 * [O] 변환하는 문자인지 검증
 * [X] 대문자/소문자 변환 메서드
 * [O] 반대 문자 변환 메서드
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char currentLetter = word.charAt(i);
            if(isLetter(currentLetter)) {
                char transformChar = currentLetter;
                transformChar = getOppositeLetter(currentLetter);

                System.out.println(currentLetter);
                System.out.println(transformChar);
            }
        }

        return answer;
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
