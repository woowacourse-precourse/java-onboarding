package onboarding;

public class Problem4 {
    // TODO 문자열을 변환하는 메서드
    public static String convert(String str) {
        String upperStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerStr = upperStr.toLowerCase();
        String result = "";

        for (char chr : str.toCharArray()) {
            if (Character.isUpperCase(chr)) {
                result += upperStr.charAt(25 - upperStr.indexOf(chr));
            } else if (Character.isLowerCase(chr)) {
                result += lowerStr.charAt(25 - lowerStr.indexOf(chr));
            }
        }
        return result;
    }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
