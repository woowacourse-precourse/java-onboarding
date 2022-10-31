package onboarding.P4;

public class GreenFrog {

    public static String WordReverse(String word){
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
    private static boolean MessageCheck(char ch){                                 //알파벳인지 판별
        if('A' <= ch && ch <= 'Z' ){
            return true;
        }else if(ch >= 'a' && ch <= 'z'){
            return true;
        }
        else{
            return false;
        }
    }
    private static char ChangeWord(char ch){
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
