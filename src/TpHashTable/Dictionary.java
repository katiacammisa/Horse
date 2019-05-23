package TpHashTable;

import java.io.*;

public class Dictionary {

    private OpenHashTable<Word> dictionary;

    public Dictionary(int length, File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dictionary = new OpenHashTable<>(length);
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
                System.out.println(words[i]);
            }

            for (int i = 0; i < counter; i++) {
                insert(words[i]);

            }
        }
    }

    public void insert(String word){
       Word thisWord = new Word(word);
       dictionary.insert(thisWord);
    }
}
