package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

public class Bezier extends Object{
    float widthepiro = 1f;
    float rotation;
    List<Float> centerPoint;
    private List<float[]> PointControl = new ArrayList<>();
    public Bezier(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                  Vector4f color, List<float[]> PointControl) {
//        Vector4f color, List<float[]> PointControl,float xR,float yR , float zR) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint=Arrays.asList(PointControl.get(0)[0], PointControl.get(0)[1], PointControl.get(0)[2]);
        this.PointControl = PointControl;
        curve();
        setupVAOVBO();
    }
    public Bezier(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                  Vector4f color, List<float[]> PointControl, float widthepiro) {
//        Vector4f color, List<float[]> PointControl,float xR,float yR , float zR) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint=Arrays.asList(PointControl.get(0)[0], PointControl.get(0)[1], PointControl.get(0)[2]);
        this.PointControl = PointControl;
        this.lineWidth = widthepiro;
        curve();
        setupVAOVBO();
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        super.drawLine(camera, projection);
    }

    @Override
    public void drawLine(Camera camera, Projection projection) {
        super.drawLine(camera, projection);
    }

//    @Override
//    public void drawLinewithWidth(Camera camera, Projection projection) {
////        super.drawLinewithWidth(camera, projection, );
//    }

    private int factorial (int a){
        int b =1;
        for (int i = 1; i <= a; i++){
            b*=i;
        }
        return b;
    }

    private int combination(int n, int r){
        return factorial(n)/(factorial(r) * factorial(n-r));
    }

    private int[] pascal(List<float[]> temp){
        int[] pas = new int[temp.size()];

        for (int i =0; i < temp.size(); i++){
            pas[i] = combination(temp.size()-1, i);
        }

        return pas;
    }

    private ArrayList<float[]> bezier(){
        ArrayList<float[]> bz = new ArrayList<>();

        int[] pascal = pascal(this.PointControl);

        for (float t = 0f; t <= 1; t += 0.01f){
            float x = 0;
            int temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                x += pascal[a]*Math.pow((1-t), temp)*Math.pow(t, a)*this.PointControl.get(a)[0];
                temp--;
            }

            float y = 0;
            temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                y += pascal[a]*Math.pow((1-t), temp)*Math.pow(t, a)*this.PointControl.get(a)[1];
                temp--;
            }

            float z = 0;
            temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                z += pascal[a]*Math.pow((1-t), temp)*Math.pow(t, a)*this.PointControl.get(a)[1];
                temp--;
            }

            float[] coord = {x, y, z};
            bz.add(coord);
        }

        return bz;
    }

    public void curve(){
        if (this.PointControl.size() <= 0) return;

        ArrayList<float[]> bz = bezier();

        for (float[] i:
                bz) {
//            System.out.println(i[0] + " " + i[1] + " " + i[2] + " ");
            vertices.add(new Vector3f(i[0],i[1],0));
        }
    }

    public void translateObjectNormal(float offsetX, float offsetY, float offsetZ) {
        super.model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.translateObjectNormal(offsetX, offsetY, offsetZ);
        }
    }

    public void rotateObject(float degree, float x, float y, float z) {
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.rotateObject(degree, x, y, z);
        }
        this.xR = (float) (r * Math.cos(degree) + xR);
        this.yR = (float) (r * Math.sin(degree) + yR);
        rotation+=Math.toDegrees(degree);
        rotation=(360+rotation)%360f;
        //System.out.println(rotation+"DARI ROTATEOBJECT "+Math.toDegrees(degree));
    }

    public void rotateObjectNormal(float degree, float x, float y, float z) {
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.rotateObjectNormal(degree, x, y, z);
        }
        this.xR = (float) (r * Math.cos(degree) + xR);
        this.yR = (float) (r * Math.sin(degree) + yR);
    }

    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void scaleObject(float scale) {
        model = new Matrix4f().scale(scale, scale, scale).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.scaleObject(scale, scale, scale);
        }
    }


}