import java.util.ArrayList;

public class no1 {
    static String vocals[] = {"a", "i", "u", "e", "o"};


    static ArrayList<String> textToArray(String text) {
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            if(!Character.toString(text.charAt(i)).equals(" ")) {
                if(i == 0) {
                    words.add(Character.toString(text.charAt(i)));
                } else {
                    if(Character.toString(text.charAt(i - 1)).equals(" ")) {
                        words.add(Character.toString(text.charAt(i)));
                    } else {
                        words.set(words.size() - 1, words.get(words.size() - 1) + text.charAt(i));
                    }
                }
            }
        }
        return words;
    }

    static boolean hasVocal(String word) {

        for(String vocal : vocals) {
            if(word.toLowerCase().equals(vocal)) {
                return  true;
            }
        }
        return  false;
    }

    static ArrayList<String> ignoreDupVocals(ArrayList<String> data) {
        ArrayList<String> results = new ArrayList<>();
        for(String text : data) {
            ArrayList<String> registeredVocals = new ArrayList<>();

            boolean hasDupFound = false;

            for(int i = 0 ; i < text.length(); i++) {
                String textOIdx = Character.toString(text.charAt(i));

                for(String voc: registeredVocals) {
                    if(voc.toLowerCase().equals(textOIdx.toLowerCase())) {
                        hasDupFound  = true;
                    }
                }

                if(hasVocal(textOIdx)) {
                 registeredVocals.add(textOIdx);
                }
            }

            if(!hasDupFound) {
                results.add(text);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println("---- 1 ----");
        ArrayList<String> case1 = ignoreDupVocals(textToArray("Universitas Nusa Putra Sukabumi"));
        System.out.println("Jumlah kata : " + case1.size());

        // Case 2
        System.out.println("---- 2 ----");
        ArrayList<String> case2 = ignoreDupVocals(textToArray("Pemrograman"));
        System.out.println("Jumlah kata : " + case2.size());

        // Case 3
        System.out.println("---- 3 -----");
        ArrayList<String> case3 = ignoreDupVocals(textToArray("Belajar pemrograman Struktur Data berbasis JAVA"));
        System.out.println("Jumlah kata : " + case3.size());
    }
}
