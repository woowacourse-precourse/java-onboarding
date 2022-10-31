package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = change(word);

        return answer;
    }

    // 문자를 요구사항에 맞게 변화시키는 메서드
    static String change(String str){
        String result = ""; // 반환할 문자열
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 문자가 빈칸이면 그냥 더해준다.
            if(c == ' '){
                result += c;
            }
            // 문자가 대문자라면 요구사항에 맞는 대문자로 변환한 후 더해준다.
            else if(upper_lower(c)){
                char c_change = change_upper(c);
                result += c_change;
            }
            // 문자가 소문자라면 요구사항에 맞는 소문자로 변환한 후 더해준다.
            else{
                char c_change = change_lower(c);
                result += c_change;
            }
        }

        return result;
    }

    // 대문자를 주어진 요구사항에 맞게 청개구리식으로 변환하는 메서드
    static char change_upper(char c){
        int num = c - 'A';
        // 알파벳은 총 26개, index적인 접근을 위하여 1을 추가로 뺀다.
        int reverse = 26 - num - 1;
        char ch = (char) (reverse + 'A');

        return ch;
    }

    // 소문자를 주어진 요구사항에 맞게 청개구리식으로 변환하는 메서드
    static char change_lower(char c){
        int num = c - 'a';
        // 알파벳은 총 26개, index적인 접근을 위하여 1을 추가로 뺀다.
        int reverse = 26 - num - 1;
        char ch = (char) (reverse + 'a');

        return ch;
    }

    // 대문자인가 소문자인가 판단하는 메서드
    // flag == true : 대문자, flag == false : 소문자
    static boolean upper_lower(char c){
        boolean flag = true;
        int num = c;

        // 대문자 : ascii 65~90
        if(num <= 90){
            flag = true;
        }
        // 소문자 : ascii 97~122
        else{
            flag = false;
        }

        return flag;
    }
}
