package onboarding;

public class Problem4 {

    public static final int lowerCase=1;
    public static final int upperCase=2;
    public static final int etc=3;
    public static StringBuilder sb;

    public static String solution(String word) {

        String answer = "";
        letterRound(word);
        return answer;
    }

    static int letterCheck(char a){
        if('a'<=a&&a<='z')return lowerCase;
        else if('A'<=a&&a<='Z')return upperCase;
        else return etc;
    }

    static String letterRound(String word){
        sb=new StringBuilder();
        
        for(int i=0;i<word.length();i++){
            if(letterCheck(word.charAt(i))==lowerCase){

            }
            else if(letterCheck(word.charAt(i))==upperCase){

            }
            else{
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
