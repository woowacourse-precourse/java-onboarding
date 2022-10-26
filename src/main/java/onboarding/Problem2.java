package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplicated(cryptogram);

        while(!cryptogram.equals(answer)){
            cryptogram = answer;
            if(cryptogram.length()<1) break;
            answer = removeDuplicated(cryptogram);
        }

        return answer;
    }

    public static String removeDuplicated(String cryptogram){
        boolean[] isDuplicated = new boolean[cryptogram.length()];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int cryptogramLen = cryptogram.length();
        for(int j = 1;j<cryptogramLen;i++,j++){
            char currentChar = cryptogram.charAt(i);
            char nextChar = cryptogram.charAt(j);
            if(currentChar==nextChar){
                isDuplicated[i] = true;
                isDuplicated[j] = true;
            }
            if(!isDuplicated[i]) sb.append(cryptogram.charAt(i));
        }
        if(!isDuplicated[cryptogramLen-1]) sb.append(cryptogram.charAt(cryptogramLen-1));
        return sb.toString();
    }

}
