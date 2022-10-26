package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 공백으로 단어 구분
        String[] strings = word.split(" ");
        for(int i=0;i<strings.length;i++){
            strings[i]=changeAlpha(strings[i]);
        }
        // join 함수를 통해 배열 전환했던 문자열을 통합
        return String.join(" ",strings);
    }
    public static String changeAlpha (String w){
        char[] chars=w.toCharArray();
        // casting 으로 intToChar or charToInt 가능
        int upper=(int)'A'+(int)'Z';
        int lower=(int)'a'+(int)'z';
        for(int i=0; i<chars.length; i++){
            // 대소문자 판별
            if(Character.isUpperCase(chars[i]))chars[i]=(char)(upper-(int)chars[i]);
            else{
                chars[i]=(char)(lower-(int)chars[i]);
            }
        }
        // char 형 배열을 string 으로 변환
        return String.valueOf(chars);
    }
}
