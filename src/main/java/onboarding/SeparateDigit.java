package onboarding;

import java.util.List;

public class SeparateDigit {
    int[] separatedNumber;
    int size;

    public void digitSeparating(List<Integer> bookPage) {
        String stringNumber= bookPage.toString().replaceAll("[^0-9]","");
        size=stringNumber.length();
        separatedNumber =new int[size];
        for(int i=0;i<size;i++){
            separatedNumber[i]=(int)stringNumber.charAt(i)-'0';
        }
    }

}
