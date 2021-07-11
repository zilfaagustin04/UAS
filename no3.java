import java.util.ArrayList;


class  no3 {
    
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

    static void insertToText(String text, String targetText, Integer targetIndex) {
        ArrayList<String> fixWords = textToArray(text);

        fixWords.add(targetIndex, targetText);

        System.out.println("CASE: " + text);
        System.out.println(arrayToString(fixWords));
    }


    public static void main(String[] args) {
        insertToText("Saya sedang belajar struktur data", "pergi", 2);
        System.out.println("---------------------");
        insertToText("Pemrograman itu sangat mudah", "dan menyenangkan", 4);
    }
}