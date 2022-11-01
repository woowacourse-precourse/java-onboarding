package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordArr = word.toCharArray();
        
        for(int i=0; i<wordArr.length; i++){
            int n = wordArr[i];
            if(64<wordArr[i] && wordArr[i]<91){
                wordArr[i] = (char)(155-n);
            }
            if(96<wordArr[i] && wordArr[i]<123){
                wordArr[i] = (char)(219-n);
            }
        }
        word = new String(wordArr);
        
        return word;
    }
}
