package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        char  firstLetter = 'A';
        char  lastLetter = 'Z';

        while (idx < word.length()){
            if (Character.isLowerCase(word.charAt(idx))){
                firstLetter = 'a';
                lastLetter = 'z';
            }
            if (Character.isLetter(word.charAt(idx))){
                sb.append(Character.toChars(lastLetter - (word.charAt(idx) - firstLetter)));
            }
            else{
                sb.append(word.charAt(idx));
            }
            idx++;
        }
        answer = String.valueOf(sb);
        return answer;
    }
}
