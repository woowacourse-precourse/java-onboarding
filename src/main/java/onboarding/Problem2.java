package onboarding;

public class Problem2 {
    //중복되는 문자열을 재귀 vs while 반복문으로 없애봐도 좋을 것 같아.
    //바로 이전에 저장한 값이랑 같으면, 넣지 않기, 빈 값이면 다시 넣어보기

    public static char[] changeStringToArray(String str){
        char[] charArray = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }

    public static String isItDuplicated(String str) {
        String value = "";
        int count = 0;

        char[] charArray = changeStringToArray(str);
        for(int i = 0; i < charArray.length; i++) {
            if(i > 0) {
                if(charArray[i - 1] == charArray[i]) {
                    count += 1;
                    value = value.substring(0, value.length() - 1);
                    continue;
                };
            };
            value = value + charArray[i];
        }

        if(count == 0) {
            return value;
        } else {
            return isItDuplicated(value);
        }
    };
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = isItDuplicated(cryptogram);
        return answer;
    }
}
