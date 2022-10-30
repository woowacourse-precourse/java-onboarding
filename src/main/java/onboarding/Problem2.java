package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while(true) {
            char[] charArrays = cryptogram.toCharArray();
            String eliminateDuplicate = eliminateDuplicate(charArrays);

            if(cryptogram.equals(eliminateDuplicate)) {
                break;
            }
            cryptogram = eliminateDuplicate;
        }
        return cryptogram;

    }


    public static String eliminateDuplicate(char[] charArray) {
        StringBuffer sb = new StringBuffer();
        char tmp = ' ';
        for(char c : charArray) {
            if(tmp != c) {
                tmp = c;
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
