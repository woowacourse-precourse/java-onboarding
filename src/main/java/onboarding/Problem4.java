package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //대문자 문자 저장
        char[] upArr=new char[26];
        //소문자 문자 저장
        char[] lowArr=new char[26];

        for(int i=0;i<upArr.length;i++){
            upArr[i]=(char)('Z'-i);
        }
        for(int i=0;i<lowArr.length;i++){
            lowArr[i]=(char)('z'-i);
        }

        StringBuilder sb=new StringBuilder();
        for(Character c:word.toCharArray()){
            if(Character.isUpperCase(c)){
                //해당 문자위치의 문자 추가
                sb.append(upArr[c-'A']);
            }
            if(Character.isLowerCase(c)){
                //해당 문자위치의 문자 추가
                sb.append(lowArr[c-'a']);
            }
            if(c==' '){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
