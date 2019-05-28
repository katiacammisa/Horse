package TpHashTable;

import Interfaces.Hashable;


public class Word implements Hashable,Comparable {

    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public int hash(int M) {
        int y = new Soundex().soundEx(word);
        return y % M;
    }

    @Override
    public String toString(){
        return word;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            return 1;
        }
        return word.compareTo(((Word) o).toString());
    }
}
