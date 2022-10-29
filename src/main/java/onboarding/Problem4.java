package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String tableUpperUp = "ABCDEFGHIJKLM";
        String tableUpperDown = "NOPQRSTUVWXYZ";
        String tableLowerUp = "abcdefghijklm";
        String tableLowerDown = "nopqrstuvwxyz";

        StringBuffer sbUpper = new StringBuffer(tableUpperDown);
        StringBuffer sbLower = new StringBuffer(tableLowerDown);

        tableUpperDown = sbUpper.reverse().toString();
        tableLowerDown = sbLower.reverse().toString();

        for (int i=0; i<word.length(); i++){
            if ('A' <= word.charAt(i) && word.charAt(i) <='M'){
                answer += tableUpperDown.charAt(tableUpperUp.indexOf(word.charAt(i)));
            }
            else if ('N' <= word.charAt(i) && word.charAt(i) <='Z'){
                answer += tableUpperUp.charAt(tableUpperDown.indexOf(word.charAt(i)));
            }
            else if ('a' <= word.charAt(i) && word.charAt(i) <='m'){
                answer += tableLowerDown.charAt(tableLowerUp.indexOf(word.charAt(i)));
            }
            else if ('n' <= word.charAt(i) && word.charAt(i) <='z'){
                answer += tableLowerUp.charAt(tableLowerDown.indexOf(word.charAt(i)));
            }
            else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}
