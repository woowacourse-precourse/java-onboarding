package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 임의로 저장할 문자열
        String str = cryptogram;

        // 임의로 새롭게 저장할 문자열
        String temp = "";

        while (true) {
            // 중복 알파벳 기억
            char same = '0';

            // input 문자열 길이에서 반복
            for (int i = 0; i < str.length(); i++) {

                // 마지막 인덱스일 경우
                if (i == str.length() - 1) {

                    // 마지막 인덱스의 알파벳이 이전 알파벳과 같을 경우
                    if (same == str.charAt(i)) {
                        break;
                    }
                    temp += str.charAt(i);
                }

                // 인덱스 i 알파벳과 i+1 알파벳이 동일하지 않을 경우
                else if (str.charAt(i) != str.charAt(i + 1)) {

                    // 해당 알파벳이 이전 알파벳과 같으면 건너뜀
                    if (str.charAt(i) == same) {
                        continue;
                    }
                    temp += str.charAt(i);
                    same = '0';
                }

                // 인덱스 i 알파벳과 i+1 알파벳이 동일할 경우
                else if (str.charAt(i) == str.charAt(i + 1)) {
                    same = str.charAt(i);
                }
            }

            // 더 이상 변화가 없는 경우 종료
            if (str.equals(temp)) {
                break;
            }
            str = temp;
            temp = "";
        }

        // 정답
        answer = temp;
        return answer;
    }
}
