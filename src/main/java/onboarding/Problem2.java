package onboarding;

public class Problem2 {

    // 중복 글자 제거 함수
    public static String remove(String crypto) {
        String result = "";

        // 빈 문자열일 경우 그대로 return
        if (crypto == "") {
            return result;
        }

        char dupliString = crypto.charAt(0);
        int cnt = 1;
        for (int i = 1; i < crypto.length(); i++) {
            if (dupliString == crypto.charAt(i)) {      // 이전 문자와 같을 경우 cnt++
                cnt += 1;
            } else {
                if (cnt == 1) {
                    result += dupliString;              // 중복되지 않은 문자일 경우 result에 추가
                }
                dupliString = crypto.charAt(i);
                cnt = 1;
            }
        }

        // 마지막 문자 체크
        if (cnt == 1) {
            result += dupliString;
        }

        return result;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (true) {
            String temp = remove(answer);
            if (temp.equals(answer)) {                  // 중복 제거한 문자열이 이전 문자열과 같을 경우 종료(더 이상 제거할 문자열이 없을 경우 종료)
                break;
            } else {
                answer = temp;
            }
        }

        return answer;
    }
}