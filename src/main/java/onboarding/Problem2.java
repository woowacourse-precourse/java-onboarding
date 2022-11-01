package onboarding;

import onboarding.problem2.Decoder;

/**
 * Problem 2 기능 목록
 * 1. Text 를 Queue 로 변환한다.
 * 2. Queue 의 각 원소를 확인하면서 중복값인지 확인한다.
 * 3. 중복값이면 제거하고 아니면 queue 에 다시 넣는다.
 * 4. 2-3을 반복하다가 변경이 더 없으면 문자 원소들을 문자열로 변환하여 반환한다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return decoder.decode();
    }
}
