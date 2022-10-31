package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        /*
        목표: Given an encrypted string remove repeating letter until there is no repeating letter in the string
        방법: Use a while loop and each loop we iterate through the string and remove repeating letters
        1. create while loop that loops until there is no change made to the string
        2. check if the string is empty. If empty, return empty string
        3. create an empty string
        4. for loop through each index of the string and add to the string from 3. if it is not a repeating letter
        5. loop again with the new string if the string is different from the last string otherwise return the string
         */
        boolean checkChange = true;
        boolean isDuplicate;
        StringBuilder dupRemoved = new StringBuilder();
        String result = cryptogram;
        while (checkChange) {
            if (result.length() == 0) {
                break;
            }
            checkChange = false;
            isDuplicate = false;
            dupRemoved.setLength(0);
            for (int i = 0; i < result.length()-1; i++) {
                if (isDuplicate) {
                    if (result.charAt(i+1) != result.charAt(i)) {
                        isDuplicate = false;
                    }
                    continue;
                }
                if (result.charAt(i) != result.charAt(i+1)) {
                    dupRemoved.append(result.charAt(i));
                } else {
                    isDuplicate = true;
                    checkChange = true;
                }
            }
            //last element remaining
            if (!isDuplicate) {
                dupRemoved.append(result.charAt(result.length()-1));
            }
            result = dupRemoved.toString();
        }
        return result;
    }
}
