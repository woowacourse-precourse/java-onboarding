package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();
        String answer = "answer";
        boolean isOK = true;
        while(isOK){
            int length = cryptogram.length();
            for(int i=0; i< cryptogram.length()-1; i++) {
                String sameWords = problem2.sameWord(cryptogram);
                cryptogram=cryptogram.replace(sameWords,"");  // 같은 문자 나왔을 때 없애줌
                i -= 1;     // 없애줬으니 1칸 뒤로
                break;
            }
            if(length == cryptogram.length()) break;            // 처음 문자와 길이가 같다 => 변화가 없다 => 암호 해독 끝났다
        }

        answer = cryptogram;
        return answer;
    }
    // 같은 문자가 연속되는 문자열을 검출해서 반환해주는 역할
    public String sameWord(String words) {
        String result="";
        for(int i=0; i<words.length()-1; i++) {
            if(words.charAt(i)==words.charAt(i+1)){
                result+= (char)words.charAt(i);
            }
        }
        return result;
    }
}
