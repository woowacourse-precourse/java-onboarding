package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int cnt = 0;
        int i = 0;
        int j = 1;
        StringBuffer sb_cryptogram = new StringBuffer(cryptogram);
        outer:
        while (true) {
            for (i = 0; i < sb_cryptogram.length(); i++) {
                j = 1;
                while (i + j < sb_cryptogram.length() && sb_cryptogram.charAt(i) == sb_cryptogram.charAt(i + j) && sb_cryptogram.charAt(i)!= 'X') {
                    cnt += 1;
                    j++;
                }
                if (j > 1) {
                    sb_cryptogram.replace(i, i + j, "X");   //중복된 문자열을 X로 바꿈
                }
            }
            cryptogram = sb_cryptogram.toString().replaceAll("X", "");  //X를 전부 제거
            sb_cryptogram = new StringBuffer(cryptogram);

            if (cnt == 0) {
                answer = sb_cryptogram.toString();
                break outer;
            }
            cnt = 0;
        }
        return answer;
    }
}
