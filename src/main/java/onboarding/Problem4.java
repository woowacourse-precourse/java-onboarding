package onboarding;

public class Problem4 {
    // 처음 아이디어
    // A-Z, B-Y, ..는 아스키 코드의 합이 모두 155이기 때문에 155-원래의 수를 가진 값이 출력될 것이다
    // a-z, b-y, ..는 아스키 코드의 합이 모두 219이기 때문에 219-원래의 수를 가진 값이 출력될 것이다
    // replace 함수 뒤에 쓰일 수 있는 함수를 생성해보자
    // **replace 함수 뒤에 콜백함수를 넣고 싶은데 제대로 안돼서 일단 for문으로 성공시켰다
    // 추후에 수정할것!

    public static Character replaceLowerCase(Character word) {
       int asciiValue = 155-(int) word;
       return (char)asciiValue;
    }

    public static Character replaceUpperCase(Character word) {
        int asciiValue = 219-(int)word;
        return (char)asciiValue;
    }

    public static String changeFrog(String word) {
        String s = "";
        for(int i=0; i<word.length(); i++) {
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
        return changeFrog(word);
    }
}
