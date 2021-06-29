class wyjatek extends Exception {
}

public class LiczbyPierwsze {
      int[] tablica; 
      int rozmiar; 

      public LiczbyPierwsze(int n) {
            for (int i = 2; i <= n; i++) {
                  if (czyPierwsza(i)) {
                        rozmiar++;
                  }
            }
            
            tablica = new int[rozmiar];
            
            int licznik = 0;
            for (int i = 2; i <= n; i++) {
                  if (czyPierwsza(i)) {
                        tablica[licznik] = i;
                        licznik++;
                  }
            }
      }

      public int liczba(int m) throws wyjatek {
            if (m >= rozmiar || m < 0) {
                  throw new wyjatek();
            }
            return tablica[m];
      }

      private boolean czyPierwsza(int p) {
            for (int dzielnik = 2; dzielnik <= Math.sqrt(p); dzielnik++) {
                  if (p % dzielnik == 0) { 
                        return false;
                  }
            }
            return true;
      }
}
