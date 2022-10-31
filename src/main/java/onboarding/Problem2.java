package onboarding;

public class Problem2 {

    static String removeDuplicate(String s){

        if(s.length() == 0) return s;
        else if(s == null) return "";

        char[] tmp = s.toCharArray();

        int nxtIdx = 0;
        int i = 1;
        for(; i < tmp.length; i++){
            if(tmp[i-1] != tmp[i]){
                tmp[nxtIdx] = tmp[i-1];
                nxtIdx++;
            }else{
                while(i < tmp.length && tmp[i] == tmp[i-1] )
                    i++;
            }
        }
        tmp[nxtIdx] = tmp[tmp.length-1];
        if(i != 1)
            nxtIdx++;

        String res = new String(tmp).substring(0, nxtIdx);
        if(nxtIdx != tmp.length){
            return removeDuplicate(res);
        }else return res;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = removeDuplicate(cryptogram);
        return answer;
    }
}
