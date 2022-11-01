package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int[] removeFlag = new int[cryptogram.length()];
        int before = 0;

        for (int cur = 1; cur < cryptogram.length(); cur++) {
            before = cur - 1;

            while (cryptogram.charAt(before) == cryptogram.charAt(cur) && removeFlag[before] == 0 && removeFlag[cur] == 0) {
                removeFlag[before] = 1;
                removeFlag[cur] = 1;
                while (before > 0 && removeFlag[before] == 1) before--;
                while (cur < cryptogram.length() - 1 && removeFlag[cur] == 1) cur++;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (removeFlag[i] == 0) { // 지워지지 않았다면 sb에 append
                sb.append(cryptogram.charAt(i));
            }
        }
        answer = sb.toString();
        return answer;
    }
}

