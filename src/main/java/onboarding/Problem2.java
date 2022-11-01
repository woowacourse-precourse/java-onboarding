package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String crypted = cryptogram;

        return crypted;
    }

    private static String deleteDuplicate(String origin){
        String result = "";
        for(int i=0; i<origin.length(); i++){
            if(i == origin.length() - 1){
                if(!origin.substring(i-1, i).equals(origin.substring(i, i+1))) {
                    result += origin.substring(i, i + 1);
                    continue;
                }
            }

            String nowStr = origin.substring(i, i+1);
            String nextStr = origin.substring(i+1, i+2);

            if(!nowStr.equals(nextStr)){
                result += nowStr;
            }
            else {
                int sameStrEnd = i+1;
                for(; sameStrEnd<origin.length() - 1; sameStrEnd++){
                    nextStr = origin.substring(sameStrEnd+1, sameStrEnd+2);
                    if(!nowStr.equals(nextStr))
                        break;
                }
                i = sameStrEnd;
            }
        }

        return result;
    }
}
