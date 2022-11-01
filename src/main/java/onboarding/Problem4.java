package onboarding;

public class Problem4 {
    /*
        check_alpha
        % input  : char a
        % output : boolean

        when char a is alphabet return true, when not return false
     */
    public static boolean check_alpha(char a){
        return a >= 65 && a <= 90 || a >= 97 && a <= 122;
    }
    public static String solution(String word) {


        /*
            Dictionary is structured by reversed alphabet.
            Modify String to char and change with ASCII code
         */
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if (!check_alpha(word.charAt(i))) { answer.append(word.charAt(i)); continue;}
            answer.append(word.charAt(i) > 96 ?
                    String.valueOf((char) (122 - word.charAt(i) + 97)) :
                    String.valueOf((char) (90 - word.charAt(i) + 65)));
        }
        return answer.toString();
    }
}
