package onboarding;

import java.util.List;

public class SeparateDigit {
    int[] separatedNumber;
    int size;

    static final int MAXPAGE = 400;
    static final int MINPAGE = 1;
    public void digitSeparating(List<Integer> bookPage) {
        String stringNumber = bookPage.toString().replaceAll("[^0-9]","");
        size=stringNumber.length();
        separatedNumber = new int[size];
        for(int i=0; i<size; i++){
            separatedNumber[i] = (int)stringNumber.charAt(i)-'0';
        }
    }
    public static boolean isWrongPage(List<Integer> bookPage) {
        int firstPage = bookPage.get(0);
        if(firstPage<MINPAGE||firstPage>MAXPAGE
        || firstPage%2 == 0
        || firstPage - bookPage.get(1) != -1){
            return true;
        }
        return false;
    }

}
