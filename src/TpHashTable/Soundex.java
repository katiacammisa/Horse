package TpHashTable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public final class Soundex {

    private static final char[] mapping = {
            '0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    private static char codeOf (char c) {
        return (mapping[c-'A']);
    }

    private static final int CODE_LENGTH = 4;

    public static void main (String[] args) throws IOException {

        final BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

               // Loop to read all input lines
        read_loop: for (;;) {

            final String s = br.readLine();
            System.out.println("AAAAA " + codeOf(s.toUpperCase().toCharArray()[0]));

            if (s==null)
                break;

            // Check for a blank line
            if (s.length() <= 0) {
                System.out.println ("Bad input line.");
                continue read_loop;
            }

            // Transform input string to all caps
            final char [] input = s.toUpperCase().toCharArray();

            // Check the input line for non-alpha characters
            for (int i = 0; i < input.length; i++) {
                if (!Character.isLetter(input[i])) {
                    System.out.println ("Bad input line.");
                    continue read_loop;
                }
            }

            int code_index=0;
            char[] code = new char[CODE_LENGTH];

            // The 1st character of code is 1st letter of input
            code[code_index++] = input[0];

                      // Save the digit that the first character maps to
            char prev_c = codeOf (input[0]);

                      // Transform the remaining letters in the string
            for (int i = 1; i<s.length() && code_index<CODE_LENGTH; i++) {
                final char c = codeOf (input[i]);
                if (c != '0' && c != prev_c) {
                    code[code_index++] = c;
                }
                prev_c = c;
            }
            // Right pad with '0's to get three digits
            for (int i = code_index; i < CODE_LENGTH; i++) {
                code[i] = '0';
            }
            System.out.println (s + " " + String.valueOf(code));
        }
    }
  }