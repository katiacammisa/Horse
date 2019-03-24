package Morse;

import java.util.HashMap;

public class Translate {

    private HashMap<Character, String> toMorseTable;

    private HashMap<String, Character> toTextTable;

    public Translate() {
        toMorseTable = new HashMap<Character, String>();
        toMorseTable.put('A', (".-"));
        toMorseTable.put('B', ("-..."));
        toMorseTable.put('C', ("-.-."));
        toMorseTable.put('D', ("-.."));
        toMorseTable.put('E', ("."));
        toMorseTable.put('F', ("..-."));
        toMorseTable.put('G', ("--."));
        toMorseTable.put('H', ("...."));
        toMorseTable.put('I', (".."));
        toMorseTable.put('J', (".---"));
        toMorseTable.put('K', ("-.-"));
        toMorseTable.put('L', (".-.."));
        toMorseTable.put('M', ("--"));
        toMorseTable.put('N', ("-."));
        toMorseTable.put('O', ("---"));
        toMorseTable.put('P', (".--."));
        toMorseTable.put('Q', ("--.-"));
        toMorseTable.put('R', (".-."));
        toMorseTable.put('S', ("..."));
        toMorseTable.put('T', ("-"));
        toMorseTable.put('U', ("..-"));
        toMorseTable.put('V', ("...-"));
        toMorseTable.put('W', (".--"));
        toMorseTable.put('X', ("-..-"));
        toMorseTable.put('Y', ("-.--"));
        toMorseTable.put('Z', ("--.."));
        toMorseTable.put('0', ("-----"));
        toMorseTable.put('1', (".----"));
        toMorseTable.put('2', ("..---"));
        toMorseTable.put('3', ("....--"));
        toMorseTable.put('4', ("....-"));
        toMorseTable.put('5', ("....."));
        toMorseTable.put('6', ("-...."));
        toMorseTable.put('7', ("--..."));
        toMorseTable.put('8', ("---.."));
        toMorseTable.put('9', ("----."));
        toMorseTable.put('.', (".-.-.-"));
        toMorseTable.put(',', ("--..--"));
        toMorseTable.put('?', ("..--.."));
        toMorseTable.put('"', (".-..-."));
        toMorseTable.put(' ', ("   "));

        toTextTable = new HashMap<String, Character>();
        toTextTable.put((".-"), 'A');
        toTextTable.put(("-..."), 'B');
        toTextTable.put(("-.-."), 'C');
        toTextTable.put(("-.."), 'D');
        toTextTable.put(("."), 'E');
        toTextTable.put(("..-."), 'F');
        toTextTable.put(("--."), 'G');
        toTextTable.put(("...."), 'H');
        toTextTable.put((".."), 'I');
        toTextTable.put((".---"), 'J');
        toTextTable.put(("-.-"), 'K');
        toTextTable.put((".-.."), 'L');
        toTextTable.put(("--"), 'M');
        toTextTable.put(("-."), 'N');
        toTextTable.put(("---"), 'O');
        toTextTable.put((".--."), 'P');
        toTextTable.put(("--.-"), 'Q');
        toTextTable.put((".-."), 'R');
        toTextTable.put(("..."), 'S');
        toTextTable.put(("-"), 'T');
        toTextTable.put(("..-"), 'U');
        toTextTable.put(("...-"), 'V');
        toTextTable.put((".--"), 'W');
        toTextTable.put(("-..-"), 'X');
        toTextTable.put(("-.--"), 'Y');
        toTextTable.put(("--.."), 'Z');
        toTextTable.put(("-----"), '0');
        toTextTable.put((".----"), '1');
        toTextTable.put(("..---"), '2');
        toTextTable.put(("....--"), '3');
        toTextTable.put(("....-"), '4');
        toTextTable.put(("....."), '5');
        toTextTable.put(("-...."), '6');
        toTextTable.put(("--..."), '7');
        toTextTable.put(("---.."), '8');
        toTextTable.put(("----."), '9');
        toTextTable.put((".-.-.-"), '.');
        toTextTable.put(("--..--"), ',');
        toTextTable.put(("..--.."), '?');
        toTextTable.put((".-..-."), '"');
        toTextTable.put(("   "), ' ');
    }

    public MorsePhrase toMorse(String text){

        text = text.toUpperCase();

        String[] chain = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            String aux = toMorseTable.get(text.charAt(i));
            chain[i] = aux;
        }

        return new MorsePhrase(chain);
    }

    public String toText(String morse){

        String[] morses = new String[morse.length()];
        int counter = 0;

        for (int i = 0; i <morse.length() ; i++) {
            if(morse.charAt(i) == ' '){
                morses[counter] = morse.substring(0, i);
                counter++;
                morse = morse.substring(i+1);
                i = 0;
            }
            if(i == morse.length()-1){
                morses[counter] = morse;
            }

        }

        for (int i = 0; i < morses.length; i++) {
            if(morses[i] == null){
              String[] aux = new String[i];
                for (int j = 0; j < i ; j++) {
                    aux[j] = morses[j];
                }
                morses = aux;
            }
        }

        MorsePhrase phrase = new MorsePhrase(morses);

        String result = "";
        for (int i = 0; i < phrase.getPhrase().length; i++) {
            if(toTextTable.get(phrase.getPhrase()[i]) == null){
                result += " ";
            } else {
                result += toTextTable.get(phrase.getPhrase()[i]);
            }
        }

        return result;
    }
}
