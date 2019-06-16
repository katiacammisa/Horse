package TpHashTable;

import java.io.File;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        File file = new File("Hash");
        Dictionary dic = new Dictionary(file);


        Scanner scanner = new Scanner(System.in);

        read_loop: for(;;) {

            System.out.println("Enter words to search.");

            String text = scanner.next();
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) {

                if(dic.find(words[i]).isVoid()){
                    System.out.println("The word is not in de dictionary, nor are similar words.");
                } else {
                    System.out.println("Did you mean " + dic.find(words[i]).toString() + "?");
                }
            }
        }

    }
}
