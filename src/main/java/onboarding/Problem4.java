package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer="";
        if(!err_check(word)) return answer;
        word = Change(word);
        return word;
    }

    private static boolean err_check(String word){
        //first constraint
        if(word.length() < 1 || word.length() > 1000) return false;
        //second constraint is not in here, check at another method
        return true;
    }

    private static String Change(String word){
        String answer ="";
        //A:65, Z:90, a:97, z:122
        //with second & third constraint
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            //uppercase
            if(ch < 'M' && ch >= 'A'){
                ch = (char)(90 - (ch - 65));
                answer += ch;
                //word.substring(0, i - 1) + ch + word.substring(i+1);
            }
            else if(ch <= 'Z' && ch >= 'M'){
                ch = (char)(65 + (ch - 90));
                answer += ch;
                //word = word.substring(0, i - 1) + ch + word.substring(i+1);
            }
            //lowercase
            else if(ch <= 'z' && ch >= 'a'){
                ch = (char)(122 - (ch - 97));
                answer += ch;
                //word = word.substring(0, i - 1) + ch + word.substring(i+1);
            }
            else{
                answer += word.charAt(i);
            }
            //second constraint
        }
        return answer;
    }
}