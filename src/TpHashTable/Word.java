package TpHashTable;

import Interfaces.Hashable;


public class Word implements Hashable {

    private String word;

    public Word(String word) {
        this.word = word;
    }

    private static final char[] mapping = {
            '0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    private static char codeOf (char c) {
        return (mapping[c-'A']);
    }


    @Override
    public int hash(int M) {
        char[] c = word.toUpperCase().toCharArray();
        int x = 0;
        for (int i = 0; i < c.length; i++) {
            x += (int) codeOf(c[i]);
        }

        return x % M;
    }
}
