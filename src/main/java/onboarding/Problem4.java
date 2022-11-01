package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder strBuildWord = new StringBuilder();
        for (int i=0; i<word.length(); i++){
            //System.out.println((int)word.charAt(i));
            int rev;
            if(word.charAt(i)>='A' && word.charAt(i)<='z') {
                if ((word.charAt(i) <= 'Z'))
                    rev = 'A' + 'Z' - word.charAt(i);
                else
                    rev = 'a' + 'z' - word.charAt(i);
                strBuildWord.append((char) rev);
            }
            else
                strBuildWord.append(word.charAt(i));
        }
        answer = strBuildWord.toString();
        return answer;
    }
}
