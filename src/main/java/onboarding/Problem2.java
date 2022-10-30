package onboarding;

public class Problem2 {
    public static String Calculator(String Strdata) {
        // 1) 첫 문자를 디폴트 값으로 넣는다.
        String ReturnString = Strdata.substring(0, 1);
        int Check = 0;
        // 2) 두 번째 문자부터 진행한다.
        for (int i=1; i<Strdata.length();i+=1) {
            // 3) 중복이라면 check를 지정한다. (체크 지정될 시 문자 기억 X) mmm같은 연속 3개 이상의 문자 방지 가능
            if (ReturnString.charAt(ReturnString.length() - 1) == Strdata.charAt(i)) {
                Check=1;
            }
            else {
                // 4-1) 중복 값이 나왔을 시에는 이전 문자 제거한다.
                if (Check==1) {
                    ReturnString = ReturnString.substring(0, ReturnString.length() - 1);
                    Check=0;
                }
                // 4-2) 문자를 저장한다.
                ReturnString += Strdata.charAt(i);
            }
        }
        // 5) 중복 값이 있는지 확인한다
        if (Check==1) {
            ReturnString = ReturnString.substring(0, ReturnString.length() - 1);
        }
        return ReturnString;
    }
    public static String solution(String cryptogram) {
        String CompareValue;
        // 1) 무한루프를 돌면서 중복 문자열 있는지 확인한다.
        while (true) {
            // 2) 중복을 제거한 문자열을 받는다.
            CompareValue = Calculator(cryptogram);
            // 3) 제거된 문자열과 입력값의 문자열과 비교한다.
            if (cryptogram.equals(CompareValue) || CompareValue.isEmpty()) break;
            // 3-1) 다르다면 입력문자열을 제거된 문자열로 교체한다.
            cryptogram = CompareValue;
        }
        // 3-2) 같다면 제거된 문자열을 answer로 지정하여 리턴한다.
        String answer = CompareValue;
        return answer;
    }

}
