package onboarding;

import java.util.List;
import java.util.regex.Pattern;

class Word {

  private String word;

  Word(String word) {
    ValidityCheckerProb4 vc = new ValidityCheckerProb4(word);
    this.word = word;
  }

  String getAnswer() {
    Classifier classifier = new Classifier(word);
    return classifier.getChangedString();
  }
}

class ValidityCheckerProb4 {

  private static final int MINLIMIT = 1;
  private static final int MAXLIMIT = 1000;

  ValidityCheckerProb4(String word) {
    lengthValidityCheck(word);
  }

  private void lengthValidityCheck(String word) {
    if (word.length() < MINLIMIT || word.length() > MAXLIMIT) {
      throw new IllegalArgumentException("length of word is not in range.");
    }
  }
}

class Classifier {

  private StringBuffer answer;
  private static final int UPPERSUM = 'A' + 'Z';
  private static final int LOWERSUM = 'a' + 'z';
  private static final int ISUPPERCASE = 0;
  private static final int ISLOWERCASE = 1;
  private static final int ISERROR = 2;
  private static final char LOWERA = 'a';
  private static final char LOWERZ = 'z';
  private static final char UPPERA = 'A';
  private static final char UPPERZ = 'Z';
  private String classifier;

  Classifier(String word) {
    this.classifier = word;
  }

  String getChangedString() {
    StringBuilder stringBuilder = new StringBuilder();
    char chunk;
    for (int i = 0; i < classifier.length(); i++) {
      int classifyId = checkUpperLowerElse(classifier.charAt(i));
      stringBuilder.append(changeChunk(classifyId, classifier.charAt(i)));
    }
    return stringBuilder.toString();
  }

  int checkUpperLowerElse(char chunk) {
    if (chunk >= LOWERA && chunk <= LOWERZ) {
      return ISLOWERCASE;
    }
    if (chunk >= UPPERA && chunk <= UPPERZ) {
      return ISUPPERCASE;
    }
    return ISERROR;
  }

  char changeChunk(int Id, char chunk) {
    if (Id == ISLOWERCASE) {
      return (char) (LOWERSUM - chunk);
    }
    if (Id == ISUPPERCASE) {
      return (char) (UPPERSUM - chunk);
    }
    return chunk;
  }
}

public class Problem4 {

  public static String solution(String word) {
    Word inputWord = new Word(word);
    return (inputWord.getAnswer());
  }
}
