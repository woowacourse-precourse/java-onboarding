package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer;
        String regex = "(\\w)(\\1+)";
        Pattern patternRegex = Pattern.compile(regex);

        while (true) {
            Matcher patternMatcher = patternRegex.matcher(cryptogram);
            StringBuilder stringBuilder = new StringBuilder();

            while (patternMatcher.find()) {
                patternMatcher.appendReplacement(stringBuilder, "");
            }
            patternMatcher.appendTail(stringBuilder);
            cryptogram = String.valueOf(stringBuilder);

            System.out.println(cryptogram);
            patternMatcher = patternRegex.matcher(cryptogram);
            if (!patternMatcher.find()) {
                answer = cryptogram;
                break;
            }
        }
        return answer;
    }
}


//
//        Pattern pattern = Pattern.compile("^.*(.)\\1.*$");
//        Matcher matcher;
//
//        matcher = pattern.matcher(cryptogram);
//
//
//
//        if (matcher.find()) System.out.println(matcher.group());
////        while(matcher.find()){
////            System.out.println(matcher.group());
////        }
////


//        System.out.println(matcher.find());   //group(8)); //  .find());
//        if (matcher.find())System.out.println("Found you!");
//        else System.out.println("Not Found!");
////
//        Pattern p = Pattern.compile("(\\w)\\1+");
//        Matcher m = p.matcher(cryptogram);
//        if (m.find())
//        {
//            System.out.println("Duplicate character " + m.group(1));
//        }


//        String regex = "(\\w)\\1+";
//        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher patternMatcher = regexPattern.matcher(cryptogram);


//        cryptogram = cryptogram.replaceAll(patternMatcher.group(), patternMatcher.group(1));


// browoanoommnaon

//        System.out.println(cryptogram.indexOf(cryptogram.charAt(2)));


//
//        String answer = "";
//        for (int i=0; i<cryptogram.length(); i++){
//
//            if (cryptogram.indexOf(cryptogram.charAt(i)) == i ){
//                answer += cryptogram.charAt(i);
//            }
//        }
//        System.out.println(answer);
//
//        System.out.printf("%s %d \n", cryptogram.charAt(0), cryptogram.indexOf(cryptogram.charAt(0)));
//        System.out.printf("%s %d \n", cryptogram.charAt(1), cryptogram.indexOf(cryptogram.charAt(1)));
//        System.out.printf("%s %d \n", cryptogram.charAt(2), cryptogram.indexOf(cryptogram.charAt(2)));
//        System.out.printf("%s %d \n", cryptogram.charAt(3), cryptogram.indexOf(cryptogram.charAt(3)));
//        System.out.printf("%s %d \n", cryptogram.charAt(4), cryptogram.indexOf(cryptogram.charAt(4)));
//        System.out.printf("%s %d \n", cryptogram.charAt(5), cryptogram.indexOf(cryptogram.charAt(5)));
//        System.out.printf("%s %d \n", cryptogram.charAt(6), cryptogram.indexOf(cryptogram.charAt(6)));
//        System.out.printf("%s %d \n", cryptogram.charAt(7), cryptogram.indexOf(cryptogram.charAt(7)));


//        char[] c = cryptogram.toCharArray();
//

//        System.out.println(c);

