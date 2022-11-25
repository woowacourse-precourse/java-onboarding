package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeStr(cryptogram);
        System.out.println(answer);
        return answer;
    }

    // 중복 문자 제거
    public static String removeStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;

        while(true) {
            if(sb.length() == 1)
                break;
            else if(sb.length() -2 == i) {
                if (sb.charAt(i) == sb.charAt(i+1))
                    sb.delete(i, i+2);
                break;
            }
            else if(sb.charAt(i) == sb.charAt(i+1)) {
                sb.delete(i, i+2);
                i = -1;
            }
            i++;
        }

        return sb.toString();
    }
}
