package onboarding;

public class Problem2 {
    /*
    * 1. 중복 문자들을 체크 후 제거
    * 2. 더 이상 중복된 문자들이 없는지 확인
    * 3. 더 이상 중복된 문자들이 없을때까지 반복
    * */

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = CheckDuplicate(cryptogram);
        return answer;
    }

    private static String  CheckDuplicate(String str) {
        while(isDuplicate(str.toCharArray())) {
            char[] arr = str.toCharArray();
            String res = "";
            for (int i = 0; i < arr.length; i++) {
                int curr = i;
                while (curr < arr.length -1) {
                    if (arr[curr] != arr[curr + 1])
                        break;
                    curr++;
                }
                if (curr == i) res += arr[i];
                else{
                    i = i + (curr-i)+1;
                    if(i < arr.length) res += arr[i];
                }
            }
            str = res;
        }
        return str;
    }

    private static boolean isDuplicate(char[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]) return true; //중복문자가 있을경우 true 리턴
        }
        return false; //중복문자가 없을 경우 false 리턴턴
    }
}