package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            if(cryptogram.length() < 2) break;

            boolean check = false;
            StringBuilder sb = new StringBuilder(""+cryptogram.charAt(0));
            for(int i=1; i<cryptogram.length(); i++) {
                char now = sb.charAt(sb.length()-1);
                if(now == cryptogram.charAt(i)) {
                    check = true;
                    while(i < cryptogram.length() && now == cryptogram.charAt(i)) {
                        i++;
                    }
                    i--;
                    sb.deleteCharAt(sb.length()-1);
                } else {
                    sb.append(cryptogram.charAt(i));
                }
            }
            cryptogram = sb.toString();
            if(!check) break;
        }

        return cryptogram;
    }
}
