package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int i = 0;
        while (i != cryptogram.length()-1) { // until we check final character of cryptogram
            if (cryptogram.length() == 0) break; // if the cryptogram = '' than stop checking

            for (i = 0; i < cryptogram.length()-1; i++) { // check string from first to last

                int lastIndex = findLastDuplicatedIndex(cryptogram, i);

                // remove duplication from string
                if (i+1 == lastIndex)
                    cryptogram = cryptogram.substring(0, i+1) + cryptogram.substring(lastIndex);
                else {
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(lastIndex);
                    i = 0;
                }
            }
        }

        answer = checkIfStringTypeAA(cryptogram);
        return answer;
    }

    public static int findLastDuplicatedIndex(String testString, int startIndex){

        char standardChar = testString.charAt(startIndex);
        int lastIndex = startIndex;

        while(standardChar == testString.charAt(lastIndex)){
            lastIndex += 1;
            if (lastIndex>=testString.length()) break;
        }

        return lastIndex;
    }
    public static String checkIfStringTypeAA(String testString){
        // type AA means length==2 && same character
        if (testString.length()==2 && testString.charAt(0)==testString.charAt(1))
            testString = "";
        return testString;
    }

}