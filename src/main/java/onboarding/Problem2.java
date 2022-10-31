package onboarding;

public class Problem2 {

    // 반복되는 문자의 index 찾기
    // 반복되는 문자가 없을 경우 -1 return
    public static int checkDupl(int startIdx, StringBuilder str) {
        int strLen = str.length();
        char tmp = '0';
        int res = -1;

        for (int i = startIdx; i < strLen; i++) {
            if (str.charAt(i) == tmp) {
                res = i-1;
                break;
            }
            tmp = str.charAt(i);
        }

        return res;
    }
    public static String solution(String cryptogram) {
        String answer = "";

        // 변경이 가능하도록 StringBuilder로 형변환
        StringBuilder cryp = new StringBuilder(cryptogram);

        int dupIdx = 0;

        // 반복되는 index, index+1 번째 delete
        // 삭제한 index-1부터 check 시작
        while (dupIdx >= 0) {
            dupIdx = checkDupl(dupIdx, cryp);

            if (dupIdx >= 0) {
                cryp.delete(dupIdx, dupIdx+2);
                dupIdx -= 1;
            }
        }

        // StringBuilder를 다시 String으로 형변환
        answer = cryp.toString();

        return answer;
    }
}
