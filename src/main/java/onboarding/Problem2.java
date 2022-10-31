package onboarding;

public class Problem2 {
    public static String deletWord(String str){
        String result="";

        for(int i=0;i<str.length();i++){
            if(i!=str.length()-1 && str.charAt(i)==str.charAt(i+1))
                continue;
            if(i!=0 && str.charAt(i-1)==str.charAt(i))
                continue;
            result+=str.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(true){
            String deletedWord=deletWord(answer);

            if(deletedWord.equals(answer)) //삭제 전 후가 같다면 
                break;
            answer=deletedWord;
        }

        return answer;
    }
}
