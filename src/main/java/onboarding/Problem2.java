package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        try {
            if(!isIncludeCryptogram(cryptogram)) {
                throw new Exception("제한사항에 위배되는 cryptogram입니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decipher(cryptogram);
    }

    private static boolean isIncludeCryptogram(String cryptogram) {
        if(cryptogram.length()<1||cryptogram.length()>1000) return false;
        for (int i = 0; i < cryptogram.length(); i++) {
            char alpa = cryptogram.charAt(i);
            if((alpa<'a'||alpa>'z')) return false;
        }
        return true;
    }

    private static String decipher(String cryptogram) {
        String removedDupStr = "";
        int recentDupIndex=Integer.MIN_VALUE;


        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                recentDupIndex=i+1;
            } else {
                if(recentDupIndex == i) continue;  //중복이었던 index는 추가 X
                removedDupStr += cryptogram.charAt(i);
            }
        }
        //중복이 모두 제거 된 경우를 우선적으로 체크
        if(removedDupStr.length()==0) return "";

        //마지막의 char가 중복에 포함되지 않는경우는 따로 삽입
        if(recentDupIndex!=cryptogram.length()-1)
            removedDupStr += cryptogram.charAt(cryptogram.length()-1);

        //중복이 존재한 경우 재귀
        if(recentDupIndex>0) {
            removedDupStr = decipher(removedDupStr);
        }

        return removedDupStr;
    }
}
