package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] ch = word.toCharArray();   // string builder 쓰자
        for(int i=0; i<ch.length; i++){
            if(MessageCheck(ch[i])){
                answer += change(ch[i]);
            }else{
                answer += ch[i];
            }
        }


        return answer;
    }
    public static boolean LengthCheck(char[] ch) {
        if (ch.length >= 1 && ch.length <= 1000) {                               //문자 길이
            return true;
        } else {
            return false;
        }
    }
    public static boolean MessageCheck(char ch){                                        //알파벳인지 판별
        if('A' <= ch && ch <= 'Z' ){                                        // ? 이게 맞나 다시 생각
            return true;
        }else if((int)ch >= 'a' && (int)ch <= 'z'){
            return true;
        }
        else{
            return false;
        }
    }

    public static char change(char ch){
        int chge =0;
        if('A' <= ch && ch <= 'Z'){                                      // 대문자일때
            chge = 155 - (int)ch;
        }
        else {
            chge = 219 - (int)ch;                                          // 소문자일때
        }
        return (char) chge;
    }


}
