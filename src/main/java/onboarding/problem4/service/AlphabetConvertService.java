package onboarding.problem4.service;

import onboarding.problem4.utils.CharType;

import java.util.ArrayList;

public class AlphabetConvertService {

   public static ArrayList<Character> convertContray(ArrayList<Character> charList){
      ArrayList<Character> convertedCharList = new ArrayList<>();
      for(char character: charList){
         convertedCharList.add(convertChar(character));
      }
      return convertedCharList;
   }

   private static char convertChar(char character){
      CharType currentChar = CharTypeCheckService.checkCharType(character);
      return currentChar.convert(character);
   }

   public static char convert(char character , int startAsciiCode, int endAsciiCode){

      int originAsciiCode = (int)(character);
      int convertedAsciiCode = asciiConverter(originAsciiCode, startAsciiCode, endAsciiCode);

      return asciiToChar(convertedAsciiCode);
   }

   private static int asciiConverter(int originAsciiCode, int startAsciiCode, int endAsciiCode){
      int convertedAsciiCode = originAsciiCode + (endAsciiCode - originAsciiCode - (originAsciiCode - startAsciiCode));
      return convertedAsciiCode;
   }

   private static char asciiToChar(int ascii){
      return (char)(ascii);
   }
}
