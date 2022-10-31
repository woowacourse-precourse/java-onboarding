package onboarding;


public class Problem2 {
    public static boolean checkUpperCase(String str){
        char[] strarr = str.toCharArray();

        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(strarr[i]))
                return true;
        }
        return false;
    }
    public static String solution(String str) {
        String result = "answer";
        char prev = 0;
        int idx=0;
        int cnt=0;
        boolean bool = false;
        if(!checkUpperCase(str) && str.length()>=1 && str.length() <= 1000) {

            char[] arr = str.toCharArray();

            int len = arr.length;
            while (true) {
                if (bool)
                    len = len - (2 * cnt);
                prev = 0;
                bool = false;
                idx = 0;
                cnt = 0;

                for (int i = 0; i < len; i++) {
                    if (prev != arr[i]) {
                        arr[idx++] = arr[i];
                        prev = arr[i];
                    } else {
                        idx--;
                        cnt++;
                        bool = true;
                    }
                }
                if (!bool)
                    break;
            }
            result = new String(arr).substring(0, idx);
            return result;
        }

        return null;
    }
}
