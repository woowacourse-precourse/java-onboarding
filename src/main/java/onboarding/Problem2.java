package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Boolean isNoDuplicate = false;

        String input = cryptogram;
        String answer = "";

        while(!isNoDuplicate) {
            String temp = deleteDuplicate(input);
            //중복이 없거나, 빈문자열인 경우 종료
            if(temp.length() == input.length() || temp.length() == 0) {
                isNoDuplicate = true;
            } else {
                input = temp;
            }
        }
        return answer;
    }

    private static String deleteDuplicate(String str) {
        boolean wasDuplicated = false;
        StringBuilder sb = new StringBuilder();
        char before = str.charAt(0);
        int len = str.length();
        for(int i = 1; i < len; i++) {
            char now = str.charAt(i);
            if(before != now) {
                if(!wasDuplicated) sb.append(before);
                wasDuplicated = false;
                before = now;
                if(i == len - 1) sb.append(now);
            } else {
                wasDuplicated = true;
            }
        }
        return sb.toString();
    }
}
