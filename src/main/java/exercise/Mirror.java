package exercise;

import java.util.Arrays;

// Sprawdzamy cza nyapis jest palindromem
public class Mirror {
    public Boolean checkTextArray(String text){
        // zapisanie tekstu w tablicy znaków
        char [] textArray = text.toCharArray();
        for(int i = 0; i < (textArray.length / 2) + 1; i++){
            if(textArray[i] != textArray[textArray.length - 1 - i]){
                return false;
            }
        }
        return true;
    }
    public Boolean checkTextString(String text){
        for(int i = 0; i < (text.length() / 2) + 1; i++){
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public Boolean checkTextStringBuffer(String text){
        // String jest typem niezmiennym
        // StringBuffer jest typem edytowalnym
        StringBuffer editableText = new StringBuffer(text);
        // .toString zapisuje edytowany text do typu string i możemy go porównać z innym napisem
        return editableText.reverse().toString().equals(text);
    }

    public static void main(String[] args) {
        System.out.println(new Mirror().checkTextArray("ABBBA"));
        System.out.println(new Mirror().checkTextString("ABBBAS"));
        System.out.println(new Mirror().checkTextStringBuffer("ABBBAS"));
        System.out.println(new Mirror().checkTextStringBuffer("ABBBA"));
    }
}
