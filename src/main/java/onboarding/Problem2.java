package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        while (true) {
            if(sb.length() <= 1) break;
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if( i == sb.length()-1) {
                    if(sb.charAt(i) != sb.charAt(i-1)) sb2.append(sb.charAt(i));
                }
                else {
                    if (sb.charAt(i) == sb.charAt(i + 1)) { // 이거 끝까지 탐색해야됨.
                        int cnt = 1;
                        for(int j = i +2; j < sb.length(); j++) {
                            if(sb.charAt(i) == sb.charAt(j)) cnt++;
                            else break;
                        }
                        i += cnt;
                    } else {
                        sb2.append(sb.charAt(i));
                    }
                }
            }
            if(sb2.length()==sb.length()) break;
            sb = sb2;
        }
        return sb.toString();
    }
}
