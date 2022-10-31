package edu.ucdenver.morse;

import java.util.HashMap;

public class Morse {
    private String morseCharacters;
    private String normalCharacters;
    private HashMap<String, String> morseToNormal = new HashMap<>();
    private HashMap<String, String> normalToMorse = new HashMap<>();


    public Morse(){
        morseToNormal.put("A",".-");morseToNormal.put("B","-...");morseToNormal.put("C","-.-.");
        morseToNormal.put("D","-..");morseToNormal.put("E",".");morseToNormal.put("F","..-.");
        morseToNormal.put("G","--.");morseToNormal.put("H","....");morseToNormal.put("I","..");
        morseToNormal.put("J",".---");morseToNormal.put("J","-.-");morseToNormal.put("L",".-..");
        morseToNormal.put("M","--");morseToNormal.put("N","-.");morseToNormal.put("O","---");
        morseToNormal.put("P",".--.");morseToNormal.put("Q","--.-");morseToNormal.put("R",".-.");
        morseToNormal.put("S","...");morseToNormal.put("T","-");morseToNormal.put("U","..-");
        morseToNormal.put("V","...-");morseToNormal.put("W",".--");morseToNormal.put("X","-..-");
        morseToNormal.put("Y","-.--");morseToNormal.put("Z","--..");morseToNormal.put("1",".----");
        morseToNormal.put("2","..---");morseToNormal.put("3","...--");morseToNormal.put("4","....-");
        morseToNormal.put("5",".....");morseToNormal.put("6","-....");morseToNormal.put("7","--...");
        morseToNormal.put("8","---..");morseToNormal.put("9","----.");morseToNormal.put("0","-----");
        morseToNormal.put(" "," ");


        normalToMorse.put(".-","A");normalToMorse.put("-...","B");normalToMorse.put("-.-.","C");
        normalToMorse.put("-..","D");normalToMorse.put(".","E");normalToMorse.put("..-.","F");
        normalToMorse.put("--.","G");normalToMorse.put("....","H");normalToMorse.put("..","I");
        normalToMorse.put(".---","J");normalToMorse.put("-.-","K");normalToMorse.put(".-..","L");
        normalToMorse.put("--","M");normalToMorse.put("-.","N");normalToMorse.put("---","O");
        normalToMorse.put(".--.","P");normalToMorse.put("--.-","Q");normalToMorse.put(".-.","R");
        normalToMorse.put("...","S");normalToMorse.put("-","T");normalToMorse.put("..-","U");
        normalToMorse.put("...-","V");normalToMorse.put(".--","W");normalToMorse.put("-..-","X");
        normalToMorse.put("-.--","Y");normalToMorse.put("--..","Z");normalToMorse.put(".----","1");
        normalToMorse.put("..---","2");normalToMorse.put("...--","3");normalToMorse.put("....-","4");
        normalToMorse.put(".....","5");normalToMorse.put("-....","6");normalToMorse.put("--...","7");
        normalToMorse.put("---..","8");normalToMorse.put("----.","9");normalToMorse.put("-----","0");
        normalToMorse.put(" "," ");

    }

    public String decode(String deString){
        String decodedString = "";
        String uDeString = deString.toUpperCase();
        for(int i = 0; i < deString.length(); i++) {
            String tempStr = Character.toString(uDeString.charAt(i));
            decodedString= decodedString + morseToNormal.get(tempStr) + "=";
        }
        return decodedString;


    }

    public String encode(String enString){
        String encodedString = "";
        int eqCounter = 0;
        String tempStr2 = "";
        for(int i = 0; i < enString.length(); i++){
            if(enString.charAt(i) == '='){
                eqCounter++;
                System.out.println(eqCounter);
            }
        }

        for(int j = 0; j < enString.length(); j++){
            tempStr2 = "";
            while(enString.charAt(j) != '='){
                tempStr2 = tempStr2 + enString.charAt(j);
                j++;
                }
            if(enString.charAt(j) == '='){
                encodedString = encodedString  + normalToMorse.get(tempStr2);
                }
            }
        return encodedString;
    }
}
