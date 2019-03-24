package Morse;

public class MorsePhrase {

    private String[] phrase;

    public MorsePhrase(String[] phrase) {
        this.phrase = phrase;
    }

    public String[] getPhrase() {
        return phrase;
    }

    public void print(){
        for (int i = 0; i < phrase.length; i++) {
            System.out.print(phrase[i] + " ");
        }
    }
}
