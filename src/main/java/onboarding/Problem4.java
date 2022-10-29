package onboarding;

public class Problem4 {
    public static String solution(String word) {


        return Result(word);
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
    public static char ChangeWord(char ch){
        int chge =0;
        if('A' <= ch && ch <= 'Z'){                                      // 대문자일때
            chge = 155 - (int)ch;
        }
        else {
            chge = 219 - (int)ch;                                          // 소문자일때
        }
        return (char) chge;
    }

    public static String Result(String word){
        StringBuilder answer = new StringBuilder();
        char[] ch = word.toCharArray();

        for(int i=0; i<ch.length; i++){
            if(MessageCheck(ch[i])){
                answer.append(ChangeWord(ch[i]));
            }else{
                answer.append(ch[i]);
            }
        }
        return answer.toString();

    }


}
