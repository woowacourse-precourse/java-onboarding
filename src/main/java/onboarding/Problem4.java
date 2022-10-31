package onboarding;


public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        String answer = "";
        for (char c: chars){
            int charNum = c;
            if (charNum >= 97 && charNum <= 122){
                charNum = 97 + 122 - charNum;
            }
            else if (charNum >= 65 && charNum <= 90){
                charNum = 65 + 90 - charNum;
            }
            c = (char)charNum;
            answer += c;
        }


        return answer;
    }

}
