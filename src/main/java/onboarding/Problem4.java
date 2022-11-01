package onboarding;

/*
기능목록
아스키코드를 이용해서 구한다.
1. 알파벳인지 아닌지 확인하는 기능
    1-1. 알파벳이면 변환
    1-2. 알파벳이 아니면 그대로
2. 문자 반대로 변환하는 기능
    2-1. 소문자인지 대문자인지 확인
    2-2. 대문자는 (원래문자)+(반대문자)=155
    2-3. 소문자는 (원래문자)+(반대문자)=219
 */
public class Problem4 {
    //알파벳인지 아닌지 확인하는 기능
    public static boolean isAlpha(char c){
        if((c>=65 && c<=90) || (c>=97 && c<=122)){ //대문자일때 또는 소문자일때 true 반환, 그렇지 않으면 false 반환
            return true;
        }
        return false;
    }
    //알파벳이 대문자인지 소문자인지 확인하는 기능
    public static String changeWord(String word){
        String newWord="";
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            if(isAlpha(c)){ //알파벳인지 확인
                if(Character.isUpperCase(c)){ //대문자인 경우
                    newWord+=(char)(155-c);
                }else if(Character.isLowerCase(c)) { //소문자인 경우
                    newWord += (char) (219 - c);
                }
            }else{
                newWord+=c;
            }
        }
        return newWord;
    }
    public static String solution(String word) {
        String answer = "";
        answer=changeWord(word);
        return answer;
    }
}
