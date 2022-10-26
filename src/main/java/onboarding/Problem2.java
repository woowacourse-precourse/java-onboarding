package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true){
            char[] chArray = cryptogram.toCharArray();
            int idx = 0;
            char prev = '\0';
            for(char ch : chArray){
                if(prev != ch){
                    chArray[idx++] = ch;
                    prev = ch;
                }else{
                    idx--;
                }
            }
            cryptogram = new String(chArray).substring(0, idx);
            if(chArray.length == idx){
                break;
            }
        }

        answer = cryptogram;
        return answer;
    }
}
