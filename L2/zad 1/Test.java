public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                int n = Integer.parseInt(args[i]);
                try {
                    System.out.println(n + " - " + ArabRzym.arab2rzym(n));
                } catch (ArabRzymException e) {
                    System.out.println(n + " - " + e.getMessage());
                }
            } catch (NumberFormatException ex) {
                try {
                    System.out.println(args[i] + " - " + ArabRzym.rzym2arab(args[i]));
                } catch (ArabRzymException e) {
                    System.out.println(args[i] + " - " + e.getMessage());
                }
            }
        }

    }
}