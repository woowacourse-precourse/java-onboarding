package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //아스키 코드 A = 65, Z = 90, a = 97, z = 122
        String answer = "";
        answer = treeFrog(word);
        return answer;
    }
    public static String treeFrog(String word){
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i+1);
            answer = alphabetChange(answer, s);
        }
        return answer;
    }
    public static String alphabetChange(String answer, String s){
        if (s.equals(" ")) {
            answer += " ";
        }
        if (Character.isLowerCase(s.charAt(0))) {
            int temp = (int)s.charAt(0)-97;
            answer += (char)(122 - temp);
        }
        if (Character.isUpperCase(s.charAt(0))){
            int temp = (int)s.charAt(0)-65;
            answer += (char)(90 - temp);
        }
        return answer;
    }

}
