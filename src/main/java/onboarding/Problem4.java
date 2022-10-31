package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = translate(word);

        return answer;
    }
    //청개구리 언어로 번역
    public static String translate(String str){
        char[] chars = str.toCharArray();
        int temp;
        for(int i=0; i<str.length(); i++) {
            //대문자인 경우
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                temp = chars[i];
                temp = 90 + ('A' - temp);
                chars[i] = ((char) temp);
            }
            //소문자인 경우
            else if(chars[i] >= 'a' && chars[i] <= 'z') {
                    temp = chars[i];
                    temp =  122 + ('a' - temp);
                    chars[i] = ((char)temp);
                }
            }
        str = String.valueOf(chars);

        return str;
    }

}
