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

            }
        }
        return duplicate.toString();
    }
}
