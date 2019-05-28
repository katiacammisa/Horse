package Morse;

import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateTest{

    Translate translate = new Translate();


    @Test
    public void toMorse() {
        translate.toMorse("Hash Martin").print();
    }

    @Test
    public void toText() {

        System.out.println(translate.toText(".... --- .-.. .-     -- .- .-. - .. -. "));
    }
}