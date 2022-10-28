package onboarding;

public class Problem4 {

    //A = 65, Z = 90, a = 97, z = 122
    public static String solution(String word) {
        String answer = "";

        final String alpha = "abcdefghijklmnopqrxtuvwxyz";

        char[] ch = word.toCharArray();

        for (char c : ch) {
            //대문자
            if (c >= 'A' && c <= 'Z') {
                answer += (char)('Z' - alpha.toUpperCase().indexOf(c));
            //소문자    
            }else if(c >= 'a' && c <= 'z') {
                answer += (char) ('z' - alpha.indexOf(c));
            //공백
            }else {
                answer += c;
            }
        }

        System.out.println(answer);


        






        return answer;
    }
}
