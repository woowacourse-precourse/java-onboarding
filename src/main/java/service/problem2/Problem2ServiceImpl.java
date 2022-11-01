package service.problem2;

public class Problem2ServiceImpl implements Problem2Serviceable {
    //조건에 맞는 암호를 구하는 메소드
    public String getCryptogram(String cryptogram) {
        for(int i = 0; i < cryptogram.length() - 1; i++){
            while(cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                String convert1 = cryptogram.charAt(i) + String.valueOf(cryptogram.charAt(i + 1));
                cryptogram = cryptogram.replaceFirst(convert1, "");
                i = i - 1;

                if(cryptogram.equals("")) return "";
            }
        }

        return cryptogram;
    }
}
