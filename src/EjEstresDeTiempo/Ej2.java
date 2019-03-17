package EjEstresDeTiempo;

public class Ej2 {
    public static void main(String[] args) {
        System.out.println(countA("Hola mi nombre es Almeja"));

    }

    public static int countA(String text){
        int counter =0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'a' || text.charAt(i) == 'A'){
                counter++;
            }
        }
        return counter;
    }
}
