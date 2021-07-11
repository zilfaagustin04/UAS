import java.util.ArrayList;

public class no5 {

    static  String arrayToString(ArrayList<String> sources) {
        String results  = "";

        for (String source : sources) {
            results += (source + " ");
        }

        return results;
    }

    static ArrayList<String> textToArray(String text) {
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            if(!Character.toString(text.charAt(i)).toLowerCase().equals(" ")) {
                if(i == 0) {
                    words.add(Character.toString(text.charAt(i)));
                } else {
                    if(Character.toString(text.charAt(i - 1)).toLowerCase().equals(" ")) {
                        words.add(Character.toString(text.charAt(i)));
                    } else {
                        words.set(words.size() - 1, words.get(words.size() - 1) + text.charAt(i));
                    }
                }
            }
        }
        return words;
    }

    static String reverseChar(String text, boolean isKataTerbalik) {
        String results = "";
        if(isKataTerbalik) {
            for(int i = text.length() - 1; i >= 0; i--) {
                results += Character.toString(text.charAt(i));
            }
        } else {
            for(int i = 0; i < text.length(); i++) {
                results += Character.toString(text.charAt(i));
            }
        }

        return  results;
    }

    static void reversetext(String text, boolean isKataTerbalik, boolean isUrutanTerbalik) {
        ArrayList<String> fixWords = textToArray(text);
        ArrayList<String> reversedWords = new ArrayList<>();

        if(isUrutanTerbalik) {
            for(int i = (fixWords.size() - 1); i >= 0; i--) {
                reversedWords.add(reverseChar(fixWords.get(i), isKataTerbalik));
            }
        } else {
            for(int i = 0; i < fixWords.size(); i++) {
                reversedWords.add(reverseChar(fixWords.get(i), isKataTerbalik));
            }
        }

        System.out.println(arrayToString(reversedWords));

    }

    public static void main(String args[]) {

        System.out.println("--- 1 ---");
        reversetext("Selamat datang di dunia pemrograman", true, true);
        System.out.println("---- 2 ----");
        reversetext("Selamat datang di dunia pemrograman", false, true);
        System.out.println("---- 3 ----");
        reversetext("Selamat datang di dunia pemrograman", true, false);
        System.out.println("---- 4 ----");
        reversetext("Selamat datang di dunia pemrograman", false, false);
    }
}