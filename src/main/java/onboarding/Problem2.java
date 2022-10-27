package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isChanged;
        do {
            isChanged = false;
            if(cryptogram.length() <= 1) break;
            String tmp = deleteDuplicatedChars(cryptogram);
            if(!cryptogram.equals(tmp)){
                isChanged = true;
                cryptogram = tmp;
            }
        } while(isChanged);
        answer = cryptogram;
        return answer;
    }

    public static String deleteDuplicatedChars(String cryptogram){
        StringBuilder sb = new StringBuilder();
        int cryptogramLen = cryptogram.length();
        if(cryptogram.charAt(0) != cryptogram.charAt(1))
            sb.append(cryptogram.charAt(0));
        for(int i = 1; i < cryptogramLen - 1; ++i){
            char curChar = cryptogram.charAt(i);
            char leftChar = cryptogram.charAt(i - 1);
            char rightChar = cryptogram.charAt(i + 1);
            if(curChar != leftChar && curChar != rightChar)
                sb.append(curChar);
        }
        if(cryptogram.charAt(cryptogramLen - 1) != cryptogram.charAt(cryptogramLen - 2))
            sb.append(cryptogram.charAt(cryptogramLen - 1));
        return sb.toString();
    }
}
