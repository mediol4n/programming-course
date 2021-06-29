public class ArabRzym {
    private static String[] rliczby = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private static int[] aliczby = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    public static int rzym2arab(String rzym) throws ArabRzymException {
        rzym = rzym.toUpperCase(); // konwersja na duże znaki

        String[] parts = rzym.split("");
        for (int i = 0; i < parts.length; i++) { // sprawdzam, czy podany napis zawiera litery z zapisu rzymskiego
            if (!checkCorrect(parts[i])) {
                throw new ArabRzymException("To nie jest liczba!");
            }
        }

        int arab = 0;
        int indx = 0;
        for (int i = (rliczby.length - 1); i >= 0; i--) {
            while (rzym.startsWith(rliczby[i], indx) == true) {
                arab += aliczby[i];
                indx += rliczby[i].length();
            }
        }

        if (rzym.equals(arab2rzym(arab))) { // sprawdzam, czy liczba rzymska została prawidłowo napisana
            return arab;
        } else {
            throw new ArabRzymException("Liczba jest nieprawdiłowo zapisana!");
        }
    }

    public static String arab2rzym(int arab) throws ArabRzymException {
        if (arab == 0) {
            return "0";
        }

        if (arab >= 4000 || arab < 0) { // sprawdzam, czy podana liczba jest z zakresu liczb rzymskich
            throw new ArabRzymException("Liczba spoza zakresu!");
        }

        String rzym = "";
        for (int i = (aliczby.length - 1); i >= 0; i--) {
            while (arab >= aliczby[i]) {
                rzym += rliczby[i];
                arab -= aliczby[i];
            }
        }

        return rzym;
    }

    private static boolean checkCorrect(String letter) { // metoda sprawdzająca czy litery w stringu są literami z
                                                         // zapisu rzymskiego
        for (int i = 0; i < 13; i += 2) {
            if (letter.equals(rliczby[i])) {
                return true;
            }
        }
        return false;
    }
}
