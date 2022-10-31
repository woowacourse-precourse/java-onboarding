package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int index=0;
        StringBuilder sbLower = new StringBuilder();
        for(char c='a';c<='z';c++) sbLower.append(c);
        String strLower = sbLower.toString();
        String sbLowerReverse = sbLower.reverse().toString();

        StringBuilder sbUpper = new StringBuilder();
        for(char c='A';c<='Z';c++) sbUpper.append(c);
        String strUpper = sbUpper.toString();
        String sbUpperReverse = sbUpper.reverse().toString();

        for(char c:word.toCharArray()){
            if(Character.isUpperCase(c)){
                index = strUpper.indexOf(Character.toString(c));
                answer += sbUpperReverse.charAt(index);
            }
            else if(Character.isLowerCase(c)){
                index = strLower.indexOf(Character.toString(c));
                answer += sbLowerReverse.charAt(index);
            }
            else answer += c;
        }
        return answer;
    }
}
