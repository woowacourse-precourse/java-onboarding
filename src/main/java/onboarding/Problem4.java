package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordSplit = word.toCharArray();
        for(int i=0;i<wordSplit.length;i++){
            wordSplit[i] = changeWord(wordSplit[i]);
        }

        String answer = new String(wordSplit, 0, wordSplit.length);

        return answer;
    }
    
    //주어진 문자와 반대되는 문자열 반환하는 함수
    private static Character changeWord(Character c){
        //소문자인 경우
        if(c>='a' && c<='z'){
            return (char)(('z'-c)+'a');
        }
        //대문자인 경우
        else if(c>='A' && c<='Z'){
            return (char)(('Z'-c)+'A');
        }
        else{
            return c;
        }
    }
}
