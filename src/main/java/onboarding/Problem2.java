package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) { // 중복된 문자를 찾아서 자신을 두번 제거하는 방식으로
        StringBuilder duplicate = new StringBuilder(cryptogram); // 조작이 불가능한 String을 대신해서 사용 deleteCharAt 메서드 사용하기 위해서
        int cryptoLen = cryptogram.length();
        int i;

        for (i = 0; i < cryptoLen; i++) // 전체 문자열을 돌면서 인접한 문자와 중복한 위치 찾기
        {
            if (i + 1 < cryptoLen) // 두개씩 검사하므로 뒤의 문자가 cryptogram의 길이보다 작게
            {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) // 인접한 문자와 중복문자인지 검사
                {
                    duplicate.deleteCharAt(i); //연속된 중복문자 제거를 위해 두번 제거
                    duplicate.deleteCharAt(i);
                    String res = duplicate.toString(); //우선 제거된 문자열을 갖고 중복 문자열이 나오지 않을 때까지 재귀함수를 돌기 위해 for문 내부에서 선언
                    return solution(res);
                }
            }
        }
        return duplicate.toString();
    }
}
