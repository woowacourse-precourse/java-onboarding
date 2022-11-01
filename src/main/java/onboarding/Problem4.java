package onboarding;

public class Problem4 {
    // TODO 문자열을 변환하는 메서드
    public static char convert(char chr) {
        String upperStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerStr = upperStr.toLowerCase();
        char result = ' ';
        if (Character.isUpperCase(chr))
            result = upperStr.charAt(25 - upperStr.indexOf(chr));
        else if (Character.isLowerCase(chr)) {
            result = lowerStr.charAt(25 - lowerStr.indexOf(chr));
        }
        return result;
    }


    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += convert(word.charAt(i));
        }
        return answer;
    }
}
