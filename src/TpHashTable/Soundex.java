package TpHashTable;

public final class Soundex {

    private static final char[] mapping = {
            '0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    private static char codeOf (char c) {
        return (mapping[c-'A']);
    }

    private static final int CODE_LENGTH = 4;

    public int soundEx(String s){

        final char [] input = s.toUpperCase().toCharArray();

        int code_index = 0;
        char[] code = new char[CODE_LENGTH];

        code[code_index++] = input[0];

        char prev_c = codeOf (input[0]);

        for (int i = 1; i<s.length() && code_index<CODE_LENGTH; i++) {

            final char c = codeOf (input[i]);
            if (c != '0' && c != prev_c) {
                code[code_index++] = c; }prev_c = c; }
        for (int i = code_index; i < CODE_LENGTH; i++) {
            code[i] = '0';
        }
        Integer[] value = new Integer[2];
        value[0] = (int) code[0];
        value[1] = Integer.parseInt(String.valueOf(code).substring(1));
        String valueX = "" + value[0] + value[1];
        return Integer.parseInt(valueX);

    }

  }