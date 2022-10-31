package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(checkOverLap(cryptogram)){
            cryptogram = rmOverLap(cryptogram);
        }
        return cryptogram;
    }

    static boolean checkOverLap(String cryptogram){
        char[] cryArr = cryptogram.toCharArray();
        for (int i = 0; i < cryArr.length - 1; i++){
            if(cryArr[i] == cryArr[i + 1]){
                return true;
            }
        }
        return false;
    }

    static String rmOverLap(String cryptogram){
        char[] cryArr = cryptogram.toCharArray();

        int index = 0;
        for (int i = 0; i < cryArr.length - 1; i++){
            if(cryArr[i] == cryArr[i + 1]){
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char element : cryArr) sb.append(element);
        sb.delete(index, index + 2);

        return sb.toString();
    }
}
