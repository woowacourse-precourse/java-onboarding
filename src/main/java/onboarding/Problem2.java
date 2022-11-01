package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String compareToAnswer = "";
//      CompareToAnswer를 통해 무한히 루프하는 while문 내에서
//      answer과 매 루프마다 비교하며 이전 루프의 compareToAnswer값과
//      이번 루프의 answer 값이 같다면 더 이상 중복인 문자가 없다고 판단, 그값을 return
        char[] chars = cryptogram.toCharArray();
//
        while(true) {
            answer = "";
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] != chars[i + 1]) {
                    answer += chars[i];
                    if (i == chars.length - 2) {
                        answer += chars[chars.length - 1];
                    }
                }
                else if (chars[i] == chars[i + 1]){
                    if (i == chars.length - 3) {
                        answer += chars[chars.length - 1];
                    }
//                  browoon -> brown으로 가는 단계에서 oo 때문에 n이 누락되는 오류 발견 -> 수정완료
                    i += 1;
                }
            }
            chars = answer.toCharArray();

            if(compareToAnswer.equals(answer)){
                break;
            }
            compareToAnswer = answer;
        }

        return answer;
    }
}
