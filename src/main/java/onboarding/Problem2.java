package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = answer.replace(answer, removeAdj(cryptogram));

        return answer;
    }

    public static String removeAdj(String str) {
        if (str == null || str.length() == 0) {
            str = str.replace(str, "");
            return str;
        }

        char[] temp = str.toCharArray();
        int i, k = 0;

        for (i = 1; i < temp.length; i++) {
            if (temp[i - 1] != temp[i]) {
                temp[k++] = temp[i - 1];
            } else {
                if (i == 1 && temp.length == 2) {
                    return "";
                }
                while(i < temp.length && temp[i - 1] == temp[i]){
                    i++;
                }
            }
        }

        temp[k++] = temp[i - 1];

        String s = new String(temp).substring(0, k);

        if(k != temp.length) {
            return removeAdj(s);
        }

        return s;
    }
}
