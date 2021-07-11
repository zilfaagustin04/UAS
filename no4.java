import java.util.ArrayList;

public class no4 {

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

    static void removeText(String text, String textToBeRemoved, Integer position) {
        ArrayList<String> fixWords = textToArray(text);
        ArrayList<String> deletedWords = new ArrayList<>();

        for(int i = 0; i < fixWords.size(); i++) {
            if(!((i + 1) == position && fixWords.get(i).toLowerCase().equals(textToBeRemoved))) {
                deletedWords.add(fixWords.get(i));
            }
        }

        if(fixWords.size() == deletedWords.size()) {
            System.out.println("Penghapusan kata gagal dilakukan, karena indeks ke "+ position +" bukan "+ textToBeRemoved +".");
        }
        System.out.println(arrayToString(deletedWords));
    }

    public static void main(String args[]) {
        System.out.println("---- 1 ----");
        removeText("Saya sedang belajar struktur data", "sedang", 2);
        System.out.println("---- 2 ----");
        removeText("Saya sedang belajar struktur data", "struktur", 3);
        System.out.println("---- 3 ----");
        removeText("Pemrograman itu sangat mudah", "itu", 2);
    }
}