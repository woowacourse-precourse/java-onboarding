package onboarding;

public class Problem2 {

    static int countOverLap;
    public static String solution(String cryptogram) {
        String answer = "answer";
        countOverLap = Integer.MAX_VALUE;
        return answer;
    }

    static String removeOverlap(String cryptogram) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        countOverLap = 0;

        //시작포인터를 움직이는 for 문
        MoveStartNumber:
        for (int start = 0; start < cryptogram.length() - 1; start++) {
            for (int end = start + 1; end < cryptogram.length(); end++) {
                //만약 시작포인터의 문자와 종료포인터의 문자가 다를경우
                if (cryptogram.charAt(start) != cryptogram.charAt(end)) {

                    //end == start +1의 경우 중복이 없음을 의미하고, 아닌경우 중복된 문자가 하나이상있음을 의미한다
                    //각각의 경우에 대해 다른 처리를 해준다
                    if (end == start + 1) sb.append(cryptogram.charAt(start));
                    else countOverLap++;

                    start = end - 1;
                    if (end == cryptogram.length() - 1) sb.append(cryptogram.charAt(end));
                    continue MoveStartNumber;
                }
            }
        }
        return sb.toString();

    }
}
