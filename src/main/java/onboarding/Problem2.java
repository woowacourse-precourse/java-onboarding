package onboarding;

/*
========================================Problem2 기능 목록========================================
- 중복 문자를 찾아서 제거를 위한 임의의 문자로 치환하는 기능
- 임의의 문자를 제거하는 기능
- 문자열에 연속된 문자가 없는지 확인하는 기능
 */

public class Problem2 {
    public static String findSerialString(String str){
        if(str.equals(""))
            return "";

        String[] strArray = str.split("");
        int len = strArray.length;

        for(int i = 0;i < len - 1;i++){
            int cur = i;

            for(int j = i + 1;j < len;j++){
                int nxt = j;
                if(!(strArray[cur].equals(strArray[nxt]))){
                    i = cur;
                    break;
                }
                strArray[cur] = "=";
                strArray[nxt] = "=";
                cur = nxt;
            }
        }
        return String.join("", strArray);
    }

    public static String removeSerialString(String str){
        return str.replaceAll("={2,}", "");
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        String tempString;
        answer = cryptogram;

        for(;;){
            tempString = findSerialString(answer);
            if(answer.equals(tempString)) break;

            answer = removeSerialString(tempString);
        }
        return answer;
    }
}
