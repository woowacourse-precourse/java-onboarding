package onboarding.problem4;

public class StringConvertor {
    public static String convertString(String string){
        StringBuilder builder = new StringBuilder();

        for(char character : string.toCharArray()){
            builder.append(convertCharacter(character));
        }
        return builder.toString();
    }

    public static char convertCharacter(char character){
        if(Character.isUpperCase(character)){
            return (char)('A' + ('Z'- character));
        }
        if(Character.isLowerCase(character)){
            return (char)('a' + ('z'- character));
        }
        return character;
    }
}
