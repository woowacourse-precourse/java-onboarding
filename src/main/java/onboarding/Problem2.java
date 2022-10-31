package onboarding;

// 맵을 이용해보는게 어떨까...
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 종료 조건?
        while (answer.length() != 0) {

            char pre = answer.charAt(0);
            String temp = pre + "";
            for(int i = 1; i < answer.length(); i++) {
                if(pre == answer.charAt(i)) {
                    temp += pre;
                    continue;
                }

                if(pre != answer.charAt(i)) {
                    if(temp.length() < 2) {
                        pre = answer.charAt(i);
                        temp = String.valueOf(pre);
                        continue;
                    } else {
                        answer = answer.replace(temp, "");
                        break;
                    }
                }
            }

            if(temp.length() >= 2) {
                answer = answer.replaceFirst(temp, "");
            }

            if(temp.length() < 2) {
                break;
            }
        }
        return answer;
    }
}
