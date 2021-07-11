import java.util.ArrayList;

public class no2 {

    static String vocals[] = {"a", "i", "u", "e", "o"};

    static void resolveVocalAndConsonant(String text) {
        ArrayList<String> vocalObj = new ArrayList<>();
        ArrayList<String> consonantObj = new ArrayList<>();

        for(int i  = 0; i < text.length(); i++) {
            String currentChar = Character.toString(text.charAt(i));
            if(!currentChar.matches("[^a-zA-Z]")) {
                Boolean hasVocalFound = false;
                for(String vocal : vocals) {
                    if(currentChar.toLowerCase().equals(vocal)) {
                        hasVocalFound = true;
                    }
                }
                if(hasVocalFound) {
                    vocalObj.add(currentChar.toLowerCase());
                } else {
                    consonantObj.add(currentChar.toLowerCase());
                }
            }
        }



        System.out.println("Jumlah Vocal : " + vocalObj.size());
        System.out.println(vocalObj);

        System.out.println("Jumlah Konsonan : " + consonantObj.size());
        System.out.println(consonantObj);
    }

    public static void main(String[] args) {

        resolveVocalAndConsonant("Universitas Nusa Putra Sukabumi");
    }
}
