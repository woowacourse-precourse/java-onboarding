package onboarding;

/*
1. 규칙에 맞게 반대 케이스로 컨버팅
2. 두 규칙을 모두 적용한 컨버터 메서드 작성
3. String의 각 character 마다 변환 및 최종 string 구현
*/

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char character :
                word.toCharArray()) {
            if (Character.isLetter(character)) {
                character = reverseConverter(character);
            }
            sb.append(character);
        }
        return sb.toString();
    }

    public static char reverseConverter(char character) {
        if (Character.isUpperCase(character)) {
            return (char) (155 - character);
        } else {
            return (char) (219 - character);
        }
    }
}
