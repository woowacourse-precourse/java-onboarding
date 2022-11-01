package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // answer의 길이가 0이 되면 종료
        while (answer.length() != 0) {

            char pre = answer.charAt(0);
            String temp = pre + "";
            // 반복문을 돌면서 연속되는 문자 확인
            for(int i = 1; i < answer.length(); i++) {
                if(pre == answer.charAt(i)) {
                    temp += pre;
                    continue;
                }

                //
                if(pre != answer.charAt(i)) {
                    if(temp.length() < 2) {
                        pre = answer.charAt(i);
                        temp = String.valueOf(pre);
                        continue;
                    } else {
                        answer = answer.replaceFirst(temp, "");
                        break;
                    }
                }
            }

            if(temp.length() >= 2) {
                answer = answer.replaceFirst(temp, "");
            }

            // 더 이상 연속으로 중복되는 문자가 없으면 종료
            if(temp.length() < 2) {
                break;
            }
        }
        return answer;
    }
}
