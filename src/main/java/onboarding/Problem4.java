package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] st = word.toCharArray();
        for(int i=0;i<st.length;i++) {
            int changeNum = st[i];
            //대문자인경우
            if (st[i] >= 65 && st[i] <= 90) {
                if (st[i] > 77) {
                    changeNum = st[i] - 77;
                    changeNum = 78 - changeNum;
                } else {
                    changeNum = st[i] - 65;
                    changeNum = 90 - changeNum;
                }
            } else if (st[i] >= 97 && st[i] <= 122) {
                //소문자인경우
                if (st[i] > 109) {
                    changeNum = st[i] - 109;
                    changeNum = 110 - changeNum;
                } else {
                    changeNum = st[i] - 97;
                    changeNum = 122 - changeNum;
                }
            }
            st[i] = (char) changeNum;
        }
        StringBuffer sb = new StringBuffer();
        for(char c:st)
        {
            sb.append(c);
        }
        return sb.toString();
    }
}
