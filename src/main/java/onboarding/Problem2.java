package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String erase(String cryptogram, char target, int len){
        String targetString = Character.toString(target);
        targetString = targetString.repeat(len);
        cryptogram = cryptogram.replaceFirst(targetString, "");

        return cryptogram;
    }

    public static int countDuplicate(String str, int target){
        int len = 1;
        for (int i = target; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                len++;
            } else {
                break;
            }
        }

        return len;
    }

    public static String loopErase(String str){
        boolean flag = true;

        while (flag) {
            int i = 0, len;
            flag = false;
            while(i < str.length() - 1){
                len = 0;
                if (str.charAt(i) == str.charAt(i + 1)) {
                    len = countDuplicate(str, i);
                    str = erase(str,str.charAt(i),len);
                    flag = true;
                } else{
                    i++;
                    len = 0;
                }
            }
        }

        return str;
    }
}
