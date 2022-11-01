package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    private static boolean exception(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000){
            return false;
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static String removeDuplication(String str){
        boolean deleted = false;
        String previous = "";
        StringBuilder sb = new StringBuilder();

        for(String word : str.split("")){
            if(previous.equals(word)){
                deleted = true;
                sb.deleteCharAt(sb.lastIndexOf(previous));
                previous = "";
                continue;
            }
            previous = word;
            sb.append(word);
        }

        if(deleted) {
            removeDuplication(sb.toString());
        }


        return sb.toString();
    }
}
