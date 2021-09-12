import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[8];

        a[0] = 18;
        for (int i = 1; i != 8; i++) {
            a[i] = a[i - 1] - 2;
        }

        Random rand = new Random();
        double[] x = new double[12];
        
        for (int i = 0; i != 12; i++) {
            x[i] = rand.nextDouble() * 17 - 2;
        }

        double[][] b = new double[8][12];

        for (int i = 0; i != 8; i++) {
            for (int j = 0; j != 12; j++) {
                if (a[i] == 12) {
                    b[i][j] = Math.atan(
                                    Math.pow(
                                        Math.E,
                                        Math.cbrt(
                                            -Math.exp(x[j])
                                        )
                                    )
                                );
                } else if(a[i] == 6 || a[i] == 8 || a[i] == 18){
                    b[i][j] = Math.sin(
                                    Math.pow(
                                        Math.pow(
                                            Math.tan(x[j]),
                                            0.75D / Math.atan((x[j] + 6.5) / 17)
                                        ),
                                        3 / (2/3 + Math.pow(
                                                Math.pow(
                                                    x[j],
                                                    0.5 / (x[j] - 0.5)
                                                ),
                                                Math.pow(
                                                    (1 - x[j]) / (3 * 4),
                                                    x[j]
                                                )
                                            )
                                        )
                                    )
                                );
                } else{
                    double tmp = Math.log(Math.exp(x[j])); // Equals to x[j] =)
                    b[i][j] = Math.pow(
                                    tmp / (2 * 3),
                                    tmp
                                );
                }
            }
        }

        System.out.printf("  A\\X |");

        for (int i = 0; i != 12; i++) {
            System.out.printf("%10.2f|", x[i]);
        }
        System.out.println();

        for (int i = 0; i != 12 * 11 + 7; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i != 8; i++) {
            System.out.printf("%5d |", a[i]);
            for (int j = 0; j != 12; j++) {
                System.out.printf("%10.2f|", b[i][j]);
            }
            System.out.println();
        }
    }
}
