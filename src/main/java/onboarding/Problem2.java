package onboarding;

/**
 * 기능목록
 * 1. 동일 문자 있는지 확인하는 메서드 구현, 동일 문자열가 있었다면 true를 리턴, 없었다면 false를 리턴
 * 2. 동일 문자를 지우는 메서드 구현
 * 3. 동일 문자를 반복해서 지우고 만약 없다면 answer 반환 구현
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        //기능3. 동일 문자를 반복해서 지우고 만약 없다면 answer 반환 구현
        while (checkDuplicate(cryptogram)) {
            cryptogram = removeDuplicate(cryptogram);
        }
        return cryptogram;
    }

    //기능1 동일 문자 있는지 확인하는 메서드 구현, 동일 문자열가 있었다면 true를 리턴, 없었다면 false를 리턴
    private static boolean checkDuplicate(String input) {
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length - 1; i++) {
            if (inputArr[i] == inputArr[i + 1]) return true;
        }
        return false;
    }

    //기능2. 동일 문자를 지우는 메서드 구현
    private static String removeDuplicate(String input) {
        char[] inputArr = input.toCharArray();
        char before = inputArr[0];
        boolean sameFlag = false;

        String afterRemoveStr = "";
        for (int i = 1; i < inputArr.length; i++) {
            if (before != inputArr[i]) {
                if (!sameFlag) afterRemoveStr += before; //이전에 같은 문자열이 나오지 않은 경우에만 붙힌다.(같은경우는 제거)
                sameFlag = false;
            } else {
                sameFlag = true; //같은 문자가 나온경우
            }
            before = inputArr[i];
        }

        if (!sameFlag) afterRemoveStr += before; //마지막 문자가 이전에 나오지 않은 문자열이라면
        return afterRemoveStr;
    }

}
