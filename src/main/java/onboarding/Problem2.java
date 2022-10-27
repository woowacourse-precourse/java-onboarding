package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isChanged;
        do {
            if(cryptogram.length() <= 1) break;
            deleteDuplicatedChars(cryptogram);
        } while(true);
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
        return sb.toString();
    }
}
