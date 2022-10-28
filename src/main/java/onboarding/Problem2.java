package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String str = cryptogram;

        while(true){

            String changeStr = removeDuplication(str);

            if(str.equals(changeStr)){
                answer = str;
                break;
            }
            str = changeStr;
        }

        return answer;
    }

    public static String removeDuplication(String str)
    {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }

        char[] chars = str.toCharArray();

        int idx, inputIdx = 0;

        for (idx = 1; idx < chars.length; idx++) {

            if (chars[idx - 1] != chars[idx]) {

                chars[inputIdx++] = chars [idx -1];

            }else {

                while (idx < chars.length && chars[idx - 1] == chars[idx]) {  idx++;  }

            }
        }

        try{    //중복된 문자열들이 없어지면, 빈 문자열이 되는 경우 처리
            chars[inputIdx++] = chars[idx - 1];
        }catch (ArrayIndexOutOfBoundsException e){
            return "";
        }

        return new String(chars).substring(0, inputIdx);
    }

}
