package onboarding;

public class Problem4 {
    static char[] upper = new char[27];
    static char[] lower = new char[27];

    //대문자와 소문자의 각 문자에 대한 변환될 문자를 배열에 미리 저장해준다.
    public static void saveReverse(){
        for(int i=0; i<26; i++) {
            upper[i] = (char)(90-i);
            lower[i] = (char)(122-i);
        }
    }

    //현재 문자열에서 끝에 특정 문자를 붙인 문자열을 재구성해서 반환한다.
    public static String concatString(String cur, int index, char type){
        if('A'<=type && type<='Z'){
            return cur.concat(String.valueOf(upper[(int)(type-'A')]));
        }
        else if('a'<=type && type<='z'){
            return cur.concat(String.valueOf(lower[(int)(type-'a')]));
        }
        else{
            return cur.concat(String.valueOf(type));
        }
    }

    public static String solution(String word) {
        saveReverse();
        String result = "";
        for(int i=0; i<word.length(); i++) {
            result = concatString(result, i, word.charAt(i));
        }
        return result;
    }
}

