package onboarding;

/*
1. 대문자 소문자 컨버팅
2. 규칙에 맞게 반대 케이스로 컨버팅
3. 두 규칙을 모두 적용한 컨버터 메서드 작성
4. String의 각 character 마다 변환 및 최종 string 구현
*/

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char character :
                word.toCharArray()) {
            if (Character.isLetter(character)) {
                caseConverter(character);
            }
        }
        return answer;
    }

    public static char caseConverter(char character) {
        if (Character.isUpperCase(character)) {
            return Character.toLowerCase(character);
        } else
            return Character.toUpperCase(character);
    }

    public static char reverseConverter(char character) {
        if (Character.isUpperCase(character)) {
            return (char) (155 - character);
        } else {
            return (char) (219 - character);
        }
    }
}
