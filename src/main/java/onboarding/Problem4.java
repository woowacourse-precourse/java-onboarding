package onboarding;

public class Problem4 {
    public static char[] stringtochar;

    public static void splitWord(){
        for(int i=0;i<stringtochar.length;i++){
            char splitingword=stringtochar[i];
            stringtochar[i]=changeWord(splitingword);
        }

    }

    public static char changeWord(char word){
        int newword=(int)word;
        if(newword>64&&newword<97){
            newword=155-(int)word;
        }
        if(newword>96&&newword<123){
            newword=219-(int)word;
        }
        return (char)newword;
    }

    public static String solution(String word) {
        stringtochar=word.toCharArray();
        splitWord();
        String answer = String.valueOf(stringtochar);
        return answer;
    }
}
