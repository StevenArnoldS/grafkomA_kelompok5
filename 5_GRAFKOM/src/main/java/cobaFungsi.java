public class cobaFungsi {
    public static void main(String[] args) {
        float xx;
        float yy;
        int[] x = new int[2];
        x[0] = 1;
        x[1] = 2;
        int[] y = new int[2];
        y[0] = 2;
        y[1] = 3;
        for (float t = 0;t < 1;t+=0.1){
            xx = 0;
            yy = 0;
            for (int i = 0; i < 2;i++){
                xx += Math.pow((1-t), (2-i)) * Math.pow(t, i) * x[i];
                yy += Math.pow((1-t), (2-i)) * Math.pow(t, i) * y[i];
            }
            System.out.println("x:"+xx+", y:"+yy);

        }
    }
}
