package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] ch = word.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(check2(ch[i])){
                answer += change(ch[i]);
            }else{
                answer += ch[i];
            }
        }

        return answer;
    }
    public static boolean check1(char[] ch) {
        if (ch.length >= 1 && ch.length <= 1000) {                               //문자 길이
            return true;
        } else {
            return false;
        }
    }
    public static boolean check2(char ch){                                        //알파벳인지 판별
        if(65 <= (int)ch && (int)ch <=90 ){                                        // ? 이게 맞나 다시 생각
            return true;
        }else if((int)ch >= 97 && (int)ch <=122){
            return true;
        }
        else{
            return false;
        }
    }

    public static char change(char ch){
        int chge =0;
        if(65 <= (int)ch && (int)ch <= 90){                                      // 대문자일때
            chge = 155 - (int)ch;
        }
        else {
            chge = 219 - (int)ch;                                          // 소문자일때
        }
        return (char) chge;
    }


}
