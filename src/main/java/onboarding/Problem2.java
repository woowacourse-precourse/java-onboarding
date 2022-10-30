package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String compareToAnswer = "";

//        1. 1차적으로 중복되는 문자들을 모두 삭제
//        2. while 문을 씌워 연속되는 중복문자들이 없을 때까지 실행
//          2-1. 이전 루프의 결과값 compareToAnswer과 비교하였을때
//               이번 루프에서의 결과값 answer이 동일하다면 while문 종료, answer 반환

        char[] chars = cryptogram.toCharArray();
        while(true) {
            answer = "";
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] != chars[i + 1]) {
                    answer += chars[i];
                    if (i == chars.length - 2) {
                        answer += chars[chars.length-1];
                    }
                }
                else {
                    if (i == chars.length - 2) {
                        continue;
                    }else{
                        i += 1;
                    }
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

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        System.out.println(solution(cryptogram));
    }
}
