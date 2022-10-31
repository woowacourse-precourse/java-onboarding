package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sbWord = new StringBuilder(word);

        for (int k = 0; word.length() > k; k++){
            char wordChar = sbWord.charAt(k);

            if (65 <= (int)wordChar && (int)wordChar <= 90){
                sbWord.setCharAt(k,(char)(155 - (int)wordChar));
            }

            if (97 <= (int)wordChar && (int)wordChar <= 122){
                sbWord.setCharAt(k,(char)(219 - (int)wordChar));
            }
        }

        String answer = String.valueOf(sbWord);
        return answer;
    }
}
