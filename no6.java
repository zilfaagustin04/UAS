import java.util.ArrayList;

public class no6 {

    static  String arrayToString(ArrayList<String> sources) {
        String results  = "";

        for(int i = 0;  i < sources.size(); i++) {
            results += (sources.get(i) + (i < sources.size() - 1 ? ", " : " "));
        }
        return results;
    }

    public static void main(String args[]) {
        Integer vakiMoneys[] = {5000, 3000, 6500, 10000, 4000, 4000};
        Integer rinaMoneys[] = {10000, 5000, 5000, 10000, 15000, 10000};
        String days[] = {"Senin", "Selasa", "Rabu", "Kamis", "Jum’at", "Sabtu"};
        ArrayList<String> rinaWin = new ArrayList<>();
        ArrayList<String> vakiWin = new ArrayList<>();
        ArrayList<String> rinaAndVakiSame = new ArrayList<>();
        Integer totalRina = 0;
        Integer totalVaki = 0;


        for (int i = 0; i < days.length; i++) {
            if(vakiMoneys[i] > rinaMoneys[i]) {
                vakiWin.add(days[i]);
            } else if(rinaMoneys[i] > vakiMoneys[i]) {
                rinaWin.add(days[i]);
            } else {
                rinaAndVakiSame.add(days[i]);
            }

            totalRina += rinaMoneys[i];
            totalVaki += vakiMoneys[i];
        }

        System.out.println("Uang saku Vaki lebih banyak dari Rina "+ vakiWin.size() +"x pada hari "+ arrayToString(vakiWin));
        System.out.println("Uang saku Rina lebih banyak dari Vaki "+ rinaWin.size() +"x pada hari "+ arrayToString(rinaWin));
        System.out.println("Uang saku Vaki sama dengan Rina pada "+ rinaAndVakiSame.size() +"x pada hari " + arrayToString(rinaAndVakiSame));
        System.out.println("Total Uang saku Vaki adalah Rp "+ totalVaki +" per/minggu");
        System.out.println("Total Uang saku Rina adalah Rp "+ totalRina +" per/minggu");

    }
}
