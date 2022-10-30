package onboarding.problem4;

public class Word {

    // 입력된 문자열 유효성 검증 기능 추가
    public static void validate(String word){
        isLengthBetween(word);
    }

    // word는 길이가 1 이상 1,000 이하인 문자열이다.
    public static void isLengthBetween(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("입력된 문자열의 길이는 1 이상 1,000 이하여야 합니다.");
        }
    }

}
