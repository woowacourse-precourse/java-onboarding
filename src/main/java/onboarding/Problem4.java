package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(word);

        for(int i = 0; i<answer.length();i++){
            char temp1 = ' ';
            char temp2 = answer.charAt(i);

            if(Character.isUpperCase(temp2))
                temp1 = (char) ('A' + 'Z' - temp2);
            else if (Character.isLowerCase(temp2)) {
                temp1 = (char) ('a' + 'z' - temp2);
            }
            answer.setCharAt(i, temp1);
        }

        return answer.toString();
    }
}
