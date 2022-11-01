package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        return removeDuplicated(cryptogram);

    }

    private static String removeDuplicated(String str){

        // cryptogram은 길이가 1이상 1000이하인 문자열이다.
        if (1 > str.length() || 1000 < str.length()) {
            return "failed";
        }

        int str_num = str.length(); // cryptogram의 수 만큼 비교하기 위하여 따로 선언
        for (int i = 0; i < str_num; i++) {
            for (int j = 0; j < str.length()-1; j++) {
                if (str.charAt(j) == str.charAt(j + 1)) {
                    str = str.substring(0, j) + str.substring(j + 2);
                }
            }
        }
        return str;
    }
}

