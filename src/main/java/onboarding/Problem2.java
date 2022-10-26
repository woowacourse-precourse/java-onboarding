package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        /*
        * 2연속으로 중복되는 문자가 있는지 확인하여 제거한다.
        * 없으면(길이 변화가 없다면), 반복을 그만한다.
        * */
        while (true){
            String tmp = decryption(cryptogram);
            if(cryptogram.length() == tmp.length()) break;
            else cryptogram = tmp;
        }

        return cryptogram;
    }

    /*
    * 현재 위치 i와 다음 위치인 i+1의 문자를 비교하여 같은지 확인한다.
    * 같으면 i와 i+1을 제외한 문자를 subString으로 제거한다.
    * */
    private static String decryption(String str) {
        char[] strToChar = str.toCharArray();
        int n = strToChar.length;

        String left=str;
        String right="";
        for(int i=0; i<n-1; i++) {
            if(strToChar[i] == strToChar[i+1]){
                left = str.substring(0, i);
                if(i+2<n) right = str.substring(i+2, n);
                break;
            }
        }
        return left + right;
    }
}
