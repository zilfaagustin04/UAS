import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static String text = "saat  ini saya  mencari  seorang  bidadari dari  kaya1234563221ngan!23";
    static String vocals[] = {"a", "i", "u", "e", "o"};

    static  String arrayToString(ArrayList<String> sources) {
        String results  = "";

        for (String source : sources) {
            results += (source + " ");
        }

        return results;
    }


    static ArrayList<String> textToArray() {
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            if(!Character.toString(text.charAt(i)).equalsIgnoreCase(" ")) {
                if(i == 0) {
                    words.add(Character.toString(text.charAt(i)));
                } else {
                    if(Character.toString(text.charAt(i - 1)).equalsIgnoreCase(" ")) {
                        words.add(Character.toString(text.charAt(i)));
                    } else {
                        words.set(words.size() - 1, words.get(words.size() - 1) + text.charAt(i));
                    }
                }
            }
        }
        return words;
    }

    // 1
    static void calculateWord() {

        ArrayList<String> fixWords = textToArray();

        System.out.println("Jumlah : " + fixWords.size());

    }

    // 2
    static void calculateCharsType() {

        Integer vocalCount = 0;
        Integer consonantCount = 0;

        for(int i  = 0; i < text.length(); i++) {
            String currentChar = Character.toString(text.charAt(i));
            if(!currentChar.matches("[^a-zA-Z]")) {
                Boolean hasVocalFound = false;
                for(String vocal : vocals) {
                    if(currentChar.equalsIgnoreCase(vocal)) {
                        hasVocalFound = true;
                    }
                }

                if(hasVocalFound) {
                    vocalCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("Jumlah vocal : " + vocalCount);
        System.out.println("Jumlah konsonan : " + consonantCount);
    }

    // 3
    static void insertText() {
        ArrayList<String> fixWords = textToArray();
        Integer targetIndex = 1;
        String targetText = "Siapa hayooo ?";

        ArrayList<String> insertedWords = new ArrayList<>();

        //fixWords.add(2, "coba tebak");

        for(int i = 0; i < fixWords.size(); i++) {
            if(i == targetIndex) {
                insertedWords.add(targetText);
            }
            insertedWords.add(fixWords.get(i));
        }

        System.out.println(arrayToString(insertedWords));

    }

    // 4
    static void removeWord() {
        ArrayList<String> fixWords = textToArray();
        ArrayList<String> deletedWords = new ArrayList<>();
        String textToBeRemoved = "mencari";

        //fixWords.removeIf((String textData) -> textData.equalsIgnoreCase(textToBeRemoved));
        for(String word : fixWords) {
            if(!word.equalsIgnoreCase(textToBeRemoved)) {
                deletedWords.add(word);
            }
        }

        System.out.println(arrayToString(deletedWords));
    }

    // 5
    static void reverseWords() {
        ArrayList<String> fixWords = textToArray();
        ArrayList<String> reversedWords = new ArrayList<>();

        //Collections.reverse(fixWords);

        for(int i = (fixWords.size() - 1); i >= 0; i--) {
            reversedWords.add(fixWords.get(i));
        }

        System.out.println(arrayToString(reversedWords));
    }

    // 6
    static void compareData() {

        String data1[] = {"Saya", "Suka", "Makan", "Roti", "Pake", "Mentega", "Cap", "Kuda", "Terbang"};
        String data2[] = {"Teman", "Saya", "Suka", "Makan", "Cumi", "Mentah"};

        System.out.println("Jumlah data 1 : " +  data1.length + " Jumlah data 2 : " + data2.length);
        ArrayList<String> sameData = new ArrayList<>();
        ArrayList<String> diffData = new ArrayList<>();


        for (String dat1 : data1) {
            for(String dat2 : data2) {
                if(dat1.equalsIgnoreCase(dat2)) {
                    sameData.add(dat1);
                }
            }
        }

        // find diff
        for (String dat1 : data1) {
            Boolean hasSameFound = false;
            for(String same : sameData) {
                if(dat1.equalsIgnoreCase(same)) {
                    hasSameFound = true;
                }
            }
            if (!hasSameFound) {
                diffData.add(dat1);
            }
        }

        for (String dat2 : data2) {
            Boolean hasSameFound = false;
            for(String same : sameData) {
                if(dat2.equalsIgnoreCase(same)) {
                    hasSameFound = true;
                }
            }
            if (!hasSameFound) {
                diffData.add(dat2);
            }
        }


        System.out.println("Persamaan data : " + sameData);
        System.out.println("Perbedaan data : " + diffData);

    }


    // 7
    static void findIndex() {
        ArrayList<String> fixWords = textToArray();
        String textToBeSearch = "mencari";

        //System.out.println(fixWords.indexOf(textToBeSearch));

        for(int i = 0 ; i < fixWords.size(); i++) {
            if(fixWords.get(i).equalsIgnoreCase(textToBeSearch)) {
                System.out.println(i);
            }
        }
    }



    // JUST FOR RUNNER
    public static void main(String[] args) {
//        1. Menghitung jumlah kata (berdasarkan kata, bukan spasi)
//        2. Menghitung jumlah huruf vokal dan konsonan
//        3. Menyisipkan kata
//        4. Menghapus kata
//        5. Membalik kata
//        6. Perbandingan data array
//        7. Pencarian indeks Array
         System.out.println("----- 1 -----");
         calculateWord();
        System.out.println("----- 2 -----");
         calculateCharsType();
        System.out.println("----- 3 -----");
         insertText();
        System.out.println("----- 4 -----");
         removeWord();
        System.out.println("----- 5 -----");
         reverseWords();
        System.out.println("----- 6 -----");
         compareData();
        System.out.println("----- 7 -----");
         findIndex();
    }
}