package onboarding;

import onboarding.pkgProblem2.decryptionService;

import java.util.Stack;

/**
 * 중복문자를 이용한 암호문을 복호화하는 문제
 * @author 유지웅
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        decryptionService decryptionService = new decryptionService();
        return decryptionService.decryption(cryptogram);
    }
}
