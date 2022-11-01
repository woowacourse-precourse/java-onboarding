package onboarding;

public class Problem4 {

    public static final int lowerCase=1;
    public static final int upperCase=2;
    public static final int ascUpperCase=155;
    public static final int ascLowerCase=219;
    public static final int etc=3;
    public static StringBuilder sb;

    public static String solution(String word) {

        String answer = "";

        answer=letterRound(word);
        return answer;
    }

    static int letterCheck(char alpa){
        if('a'<=alpa&&alpa<='z')return lowerCase;
        else if('A'<=alpa&&alpa<='Z')return upperCase;
        else return etc;
    }

    static String letterRound(String word){
        sb=new StringBuilder();

        for(int i=0;i<word.length();i++){
            if(letterCheck(word.charAt(i))==lowerCase){
                sb.append(lowerCaseConv(word.charAt(i)));
            }
            else if(letterCheck(word.charAt(i))==upperCase){
                sb.append(upperCaseConv(word.charAt(i)));
            }
            else{
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }

    static char upperCaseConv(char alpa){
        alpa=(char)(ascUpperCase-alpa);
        return alpa;
    }

    static char lowerCaseConv(char alpa){
        alpa=(char)(ascLowerCase-alpa);
        return alpa;
    }
}
