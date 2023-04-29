import java.util.Scanner;

public class persegidulu {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[][] arr = new String[15][15];
        for(int i = 0;i<15;i++ ){
            for(int j = 0;j<15;j++ ) {
                arr[i][j] = " ";
            }
        }
        Scanner s = new Scanner(System.in);
        System.out.println("center (X,Y): ");
        int centerX = s.nextInt();
        int centerY = s.nextInt();

        System.out.println("r: ");
        int r = s.nextInt();

        System.out.println("jumlah pixel: ");
        int pix = s.nextInt();


        System.out.println("(" + centerX + ", " + centerY + ")");

        System.out.println("r: " + r);

        System.out.println("pix: " + pix);

        double incTetha = 360/pix;
        System.out.println(incTetha);



        // main code

        for(int i = 0;i<pix;i++ ) {
            double angle = Math.toRadians(i*incTetha);
//            System.out.println("angle: "+angle);
//            System.out.println("cos: "+(Math.cos(angle)));
//            System.out.println("sin: "+(Math.sin(angle)));
            int x = (int)(Math.round(r * (Math.cos(angle))));
            int y = (int)(Math.round(r * (Math.sin(angle))));
//            int x = (int) (centerX + (r * Math.round(Math.cos(angle))));
//            int y = (int) (centerY + (r * Math.round(Math.sin(angle))));
//            System.out.println(i+": "+x+", "+y);
            arr[x+r][y+r]="o";
        }





        // array print
        for(int i = 0;i<15;i++ ){
            for(int j = 0;j<15;j++ ) {
                if (arr[i][j]=="o"){
                    System.out.print(arr[i][j]);
                }else System.out.print(" ");
            }
            System.out.println();
        }

    }
}