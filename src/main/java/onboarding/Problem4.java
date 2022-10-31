package onboarding;

public class Problem4 {
    // 처음 아이디어
    // A-Z, B-Y, ..(대문자 조합)는 아스키 코드의 합이 모두 155이기 때문에 155-원래의 수를 가진 값이 출력될 것이다
    // a-z, b-y, ..(소문자 조합)는 아스키 코드의 합이 모두 219이기 때문에 219-원래의 수를 가진 값이 출력될 것이다
    // replace 함수 뒤에 쓰일 수 있는 함수를 생성해보자
    // **replace 함수 뒤에 콜백함수를 넣고 싶은데 제대로 안돼서 일단 for문으로 성공시켰다
    // 3가지 경우로 분리 -> if. 소문자 / else if. 대문자 / else if. 문자가 아닌 다른 친구들(ex. 공백 띄어쓰기)
    // if의 경우는 replaceLowerCase함수를, else if의 경우는 replaceUpperCase의 경우는, 나머지는 그대로 옮겨주었다
    // 그리고 입력받는 문자열의 길이만큼 for문을 반복하여 결과를 출력!

    public static Character replaceLowerCase(Character word) {
       int asciiValue = 155 - (int)word;
       return (char)asciiValue;
    }

    public static Character replaceUpperCase(Character word) {
        int asciiValue = 219 - (int)word;
        return (char)asciiValue;
    }

    public static String changeWord(String word) {
        String s = "";
        for(int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
               s += replaceLowerCase(word.charAt(i));
            } else if (Character.isLowerCase(word.charAt(i))) {
                s += replaceUpperCase(word.charAt(i));
            } else {
                s += word.charAt(i);
            }
        }
        return s;
    }

    public static String solution(String word) {
        return changeWord(word);
    }
}
