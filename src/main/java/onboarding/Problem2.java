package onboarding;

/**
 * 구현 순서
 * 1. 문자열을 한 번 순회하면서 중복 문자열을 제거하는 함수
 * 2. (1.)함수의 인풋과 아웃풋이 같아질 때 까지 반복 호출
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String curr = cryptogram;
        String next = "";
        while (true) {
            next = removeDup(curr);
            if (curr.equals(next))
                break;
            curr = next;
        }
        return next;
    }

    /**
     * 주어진 문자열에서 중복 문자를 제거한 문자열을 반환합니다.
     * 
     * @param str
     * @return 중복 문자가 제거된 문자열
     */
    private static String removeDup(String str) {
        StringBuilder pattern = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'z') {
                pattern.append(c + "{2,}");
                break;
            }
            pattern.append(c + "{2,}|");
        }
        return str.replaceAll(pattern.toString(), "");
    }
}

/**
 * 배운점
 * String.concat() vs StringBuilder.append()
 * - String.concat()는 합쳐진 새로운 객체를 반환한다.
 * - StringBuilder.append() 는 기존 객체에 값을 추가하고 toString() 으로 String으로 변환한다.
 * - '+' 연산은 내부적으로 StringBuilder.append()를 사용한다. (1.5버전 이후)
 *
 * 정규표현식
 * - 문자열의 패턴을 찾는 문제에서는 정규표현식을 활용하여 간단하게 문제해결이 가능하다.
 */