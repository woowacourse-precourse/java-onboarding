package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ' ') {
                sb.append(" ");
                continue;
            }
            boolean flag = checkWord(word.charAt(i));
        }

        return answer;
    }

    // 현재 문자가 대문자인지 소문자인지 판별하는 메서드
    static boolean checkWord(char word) {
        if(Character.isLowerCase(word)) {
            return false;
        }
        return true;
    }
}
