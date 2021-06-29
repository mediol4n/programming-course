public class Test {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            if (n > 1) {
                LiczbyPierwsze TablicaLiczbPierwszych = new LiczbyPierwsze(n);

                for (int i = 1; i < args.length; i++) {

                    try {
                        int l = Integer.parseInt(args[i]); // brak entera
                        System.out.println(l + " - " + TablicaLiczbPierwszych.liczba(l));
                    } catch (wyjatek e) {
                        System.out.println(args[i] + " - liczba spoza zakresu");
                    } catch (NumberFormatException ex) {
                        System.out.println(args[i] + " - nieprawidłowa dana");
                    }
                }
            } else {
                System.out.println("Brak liczb pierwszych mniejszych od 2!");
            }
        } catch (NumberFormatException ex) {
            System.out.println(args[0] + " - nieprawidłowy zakres");
        }
    }
}