package onboarding;

class Solve{
    public static String removeDuplicate(String str){
        String s = str;
        while (true){
            int cnt = 0;

            for (int i=0;i<s.length()-1;i++){
                boolean flag = false;
                if (s.charAt(i)==s.charAt(i+1)){
                    cnt+=1;
                    for (int j=i+1;j<s.length();j++) {
                        if (j==s.length()-1){
                            if (s.charAt(i)==s.charAt(j)){
                                s=s.substring(0,i);
                                break;
                            }
                            else{
                                s=s.substring(0,i)+s.substring(j);
                                break;
                            }
                        }
                        if (s.charAt(i) != s.charAt(j)) {
                            flag = true;
                            s = s.substring(0, i) + s.substring(j);
                            break;
                        }
                    }
                }
                if (flag) break;
            }


            if (cnt ==0){
                break;
            }
        }

        return s;
    }
}
public class Problem2 {
    /*
    * 기능 구현 목룍
    * 1. 인접한 문자열이 같은 경우, 없애는 로직
    * 2. 이걸 모든 인접한 문자열이 다를때까지 진행
    * */
    public static String solution(String cryptogram) {
        String answer = "";

        String s =cryptogram;

        if (s.length()==1 || s.length()==0){
            return s;
        }

        answer = Solve.removeDuplicate(cryptogram);
        return answer;
    }
}
