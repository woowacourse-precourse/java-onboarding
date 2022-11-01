package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length();i++){
            int a = ((int)word.charAt(i));
            if ( (65 <= a) && (a <= 90 ) ){
                if (a <= 77){
                    a = 78 + (77 - a);
                }
                else{
                    a = 77 - (a - 78);
                }
                StringBuilder newString = new StringBuilder(word);
                newString.setCharAt(i,(char)a);
                word = String.valueOf(newString);
            } else if ( (97 <= a) && (a <= 122) ){
                if (a <= 109){
                    a = 110 + (109 - a);
                }
                else{
                    a = 109 - (a - 110);
                }
                StringBuilder newString = new StringBuilder(word);
                newString.setCharAt(i,(char)a);
                word = String.valueOf(newString);
            } else{
                continue;
            }
        }
        answer = word;
        return answer;
    }
}
