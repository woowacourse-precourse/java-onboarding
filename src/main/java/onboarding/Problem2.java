package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] a = cryptogram.split("");
        boolean ch = true;
        String tmp = "";
        while(true) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].equals(a[i+1])) {
                    ch = false;
                    i++;
                    if(i == a.length - 1){
                        break;
                    }
                    if(i + 1 == a.length - 1){
                        tmp += a[i+1];
                        break;
                    }
                    continue;
                }
                tmp += a[i];
                if(!(a[i].equals(a[i+1])) && (i == a.length - 2)){
                    tmp += a[i+1];
                    break;
                }

            }
            if(ch){
                break;
            }
            a = tmp.split("");
            tmp = "";
            ch = true;
        }
        return tmp;
    }
}
