package onboarding;

public class Problem4 {
    public static char change(char input){
        int code = input;
        char output='a';
        if(input == ' '){
            return ' ';
        }else{
            if(code>90){
                output = (char) (219-code);
            }else{

                output=(char)(155-code);
            }
            return output;
        }

    }

    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i<word.length();i++){
            answer+=change(word.charAt(i));
        }
        return answer;
    }
}
