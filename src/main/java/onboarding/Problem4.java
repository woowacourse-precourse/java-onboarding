package onboarding;

public class Problem4 {
    public static String convertWord(String word){
        String newWord="";
        for(int i=0;i< word.length();i++){
            int now = word.charAt(i);
            int tmp;
            if(now==32){
                tmp=now;
            }
            else if(now<97){
                //대문자
                tmp = (25 - (now - 65))+65;
            }else{
                //소문자
                tmp = (25 - (now - 97))+97;
            }

            newWord=newWord+(char)tmp;
        }
        return newWord;
    }
    public static String solution(String word) {

        String answer = String.join("",convertWord(word));
        return answer;
    }
}
