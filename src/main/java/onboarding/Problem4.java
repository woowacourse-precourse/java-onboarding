package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer=changeChar(word);
        return answer;
    }

    public static String changeChar(String word) {
        String saveChar = "";
        for (int i = 0; i < word.length(); i++) {
            int temp = word.charAt(i);
            if (temp >= 65 && temp <= 90) {
                temp = 155 - temp;
                saveChar += (char)temp;
            } else if (temp >= 97 && temp <= 122) {
                temp = 219 - temp;
                saveChar += (char)temp;
            } else
                saveChar += (char)temp;
        }
        return saveChar;
    }
}
