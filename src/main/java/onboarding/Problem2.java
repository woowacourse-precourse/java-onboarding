package onboarding;
/*기능구현
1. 중복되는 연속적인 인덱스 2개 찾기 (처음으로 중복되기 시작하는 인덱스를 중심으로 찾기)
1-1. 처음으로 중복되기 시작한 인덱스(i)의 주변
2. 위의 함수가 더이상 작동하지 않을 때(즉, length() == 0 이거나 중복되는 것이 없을 경우) 정답을 반환
* */
public class Problem2 {
    private static String delDuplicate(String cryptogram){
        // while문 탈출 조건을 만들기 위해
        int flag = 1;

        // 삭제할 것이 없는 입력이라면 공백 출력
        if (cryptogram.length() == 0) {
            return "";
        }
        while(flag >= 1) {
            // while문에 들어오기 위해 초기화한 flag값을 0으로 만들고 중복이 있다면 2를 더한다.
            flag = 0;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    // 중복되는 부분을 제외한 부분을 다시 cryptogram으로 갱신
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);

                    // 중복되는 것이 있다면 2 더해주기, while문에 걸리기 위해
                    flag += 2;
                }
            }
        }
        return cryptogram;
    }
    public static String solution(String cryptogram) {
        String answer = delDuplicate(cryptogram);

        return answer;
    }
}
