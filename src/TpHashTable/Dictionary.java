package TpHashTable;

import Lists.DynamicList;

import java.io.*;

public class Dictionary {

    private OpenHashTable<Word> dictionary;

    public Dictionary(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(file.canRead()){
            int x = (int) file.length();
            String[] words = new String[x];

            for (int i = 0; i < x; i++) {
                try {
                    words[i] = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            int counter = 0;

            for (int i = 0; i <words.length ; i++) {
                if(words[i] != null){
                    ++counter;
                }
            }

            dictionary = new OpenHashTable<>(counter);

            for (int i = 0; i < counter; i++) {
                insert(words[i]);

            }
        }


    }

    public void insert(String word){
       Word thisWord = new Word(word);
       dictionary.insert(thisWord);
    }


    public DynamicList<Word> find(String s) {

        Word x = new Word(s);
        int hash = 0;
        if (dictionary.search(x) == null)
            return getSimilar(s);

        DynamicList<Word> result = new DynamicList<>();
        result.insertNext(x);
        return result;
    }


    private DynamicList<Word> getSimilar(String s){
        Word x = new Word(s);
        int hash = x.hash(dictionary.getCapacity());
        if(dictionary.getPositionList(hash) != null){
            return dictionary.getPositionList(hash);
        } else {
            System.out.println("No similar words.");
        }
        return null;
    }
}
