package onboarding.problem4;

public class Convertor {
    public static String convertString(String word){
        StringBuilder result = new StringBuilder();
        for(int idx=0;idx<word.length();idx++){
            char tempChar = convertCharacter(word.charAt(idx));
            result.append(tempChar);
        }
        return result.toString();
    }

    private static Character convertCharacter(Character character){
        int asciiCode = character;
        if(isLowerCase(asciiCode)){return (char)(155-asciiCode); }
        if(isUpperCase(asciiCode)){return (char)(219-asciiCode); }
        return (char)asciiCode;
    }
    private static boolean isLowerCase(int asciiCode){
        return (asciiCode >=65 ) && (asciiCode <= 90);
    }
    private static boolean isUpperCase(int asciiCode){
        return (asciiCode >=97 ) && (asciiCode <= 122);
    }
}
