package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int prevLength = 0;
        while(true){
            prevLength = cryptogram.length();
            cryptogram = overlapHandler(cryptogram);
            if(prevLength == cryptogram.length())
                break;
        }
        answer = cryptogram;

        return answer;
    }
    static String overlapHandler(String cryptogram) {
        if(cryptogram.length()==1)
            return cryptogram;
        else if(cryptogram.length()==2)
        {
            if(cryptogram.charAt(0)== cryptogram.charAt(1))
                return "";
            else
                return cryptogram;
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cryptogram.length(); i++) {
                if ((i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) ||
                        (i != 0 && cryptogram.charAt(i) == cryptogram.charAt(i - 1)))
                    continue;
                sb.append(cryptogram.charAt(i));
            }
            return sb.toString();
        }
    }

}
