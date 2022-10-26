package onboarding;

// <기능 목록>
// 1. 암호문 해독
//  a. cipher(n) == cipher(n+1)일 때까지 탐색
//  b. cipher(n) != cipher(n+m)일 때까지 탐색
//  c. cipher(n) ~ cipher(n+m-1)을 제거한 문장으로 cipher 초기화
//  d. cipher(n+1)부터 다시 탐색 시작 -> 문장이 끝날때까지
// 2. 1번 반복
//  반복문 break 조건 : 연속하는 중복문자가 없었을 때, string length < 2

public class Problem2 {
    static boolean isRemoved = true;  // decrypthion이 실행되는 동안 중복문자를 지웠는지 확인
    // 2번의 while문 첫 동작이 실행되기 위해 true로 초기화

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 2. 1번 반복
        //  반복문 break 조건 : 연속하는 중복문자가 없었을 때 (isRemoved==false), string length < 2
        while (isRemoved) {
            if (answer.length() < 2) {
                break;
            }
            answer = decryption(answer);
        }

        return answer;
    }

    // 1. 암호문 해독
    public static String decryption(String cipher) {
        isRemoved = false;

        for (int i = 0; i < cipher.length() - 1; i++) {
            // 1-a. cipher(n) == cipher(n+1)일 때까지 탐색
            if (cipher.charAt(i) == cipher.charAt(i + 1)) {
                isRemoved = true;   // 제거된 중복문장 있음
                int j = 2;

                // 1-b. cipher(n) != cipher(n+m)일 때까지 탐색
                for (j = 2; j < cipher.length(); j++) {
                    if (cipher.charAt(i) != cipher.charAt(i + j)) {
                        break;
                    }
                }

                // 1-c. cipher(n) ~ cipher(n+m-1)을 제거한 문장으로 cipher 초기화
                cipher = cipher.substring(0, i) + cipher.substring(i + j);
            }
            // 1-d. cipher(n+1)부터 다시 탐색 시작 -> 문장이 끝날때까지
        }
        return cipher;
    }
}
