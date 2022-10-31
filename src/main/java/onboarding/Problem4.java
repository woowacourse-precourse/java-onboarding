package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        for(Character x : word.toCharArray()){
            if(x==' ') sb.append(" ");
            else sb.append(AlphabetChange(x));
        }
        answer = sb.toString();
        return answer;
    }

    public static char AlphabetChange(char c){
        if(Character.isUpperCase(c)) return (char)('Z'-(c-'A'));
        else return (char)('z'-(c-'a'));
    }
}
