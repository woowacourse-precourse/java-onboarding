package onboarding.problem4.service;

public class AlphabetConvertService {
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
