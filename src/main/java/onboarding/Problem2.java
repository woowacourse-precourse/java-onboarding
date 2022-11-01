package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (!isUnique(answer)) {
            System.out.println(answer);
            answer = forUnique(answer);
        }
        return answer;
    }

    //문자열에 중복이 포함되는지 확인하는 기능
    static boolean isUnique(String str){
        if(str.length() == 1 || str.length() == 0)return true;
        char before = str.charAt(0);
        for (int i = 1; i<str.length(); i++){
            if(before == str.charAt(i)) return false;
            before = str.charAt(i);
        }
        return true;
    }

    //중복 문자열을 삭제하는 기능
    static String forUnique(String str) {
        StringBuffer strBuf = new StringBuffer();
        char before = str.charAt(0);
        boolean flag = false;
        strBuf.append(before);
        for (int i = 1; i < str.length(); i++) {
            if(before == str.charAt(i)){
                flag = true;
                continue;
            }
            if(before != str.charAt(i)){
                if(flag){
                    flag = false;
                    before = str.charAt(i);
                    strBuf.deleteCharAt(strBuf.length() - 1);
                    strBuf.append(before);
                }
                else{
                    before = str.charAt(i);
                    strBuf.append(before);
                }
            }
        }
        if(flag) strBuf.deleteCharAt(strBuf.length() - 1);
        return strBuf.toString();
    }

}
