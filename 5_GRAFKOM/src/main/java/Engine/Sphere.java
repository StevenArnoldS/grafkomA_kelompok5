package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11C.*;

public class Sphere extends Circle{
    float r3; //radius Z
    int stackCount;
    int sectorCount;
    float rotation;
    float jarakX, jarakY, jarakZ;
    Vector3f temp_vector = new Vector3f();

    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r, float r2, float xR, float yR, float r3, float zR) {
        super(shaderModuleDataList, color, r, r2, xR, yR);
        this.r3 = r3;
        this.zR = zR;
        createBox();
        setupVAOVBO();
    }

    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r, float r2, float xR, float yR, float r3, float zR, int sectorCount, int stackCount, int type) {
        super(shaderModuleDataList, color, r, r2, xR, yR);

        this.r3 = r3;
        this.zR = zR;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        //createSphere();
        if (type == 1)
            createSphere();
        else if (type == 2)
            createSilinder();
        else if (type == 3)
            createBox();
        else if (type == 4)
            createBox2();
        else if (type == 5)
            createBox3();
        else if (type == 6)
            createCone();
        else if (type == 7)
            createPlane();
        else if (type == 8)
            createCone2();
        else if (type == 9)
            createBox4();
        else if (type == 10)
            createSphere2();
        else if (type == 11)
            createSphere3();
        else if (type == 12)
            createHyperboloidParaboloid();
        else if (type == 13)
            createHalfSphere(1);
        else if (type == 14)
            createHalfSphere(-1);
        else if (type == 15)
            eyeBrowRight();
        else if (type == 16)
            eyeBrowLeft();
        //createEllipticParaboloid();
        setupVAOVBO();
    }

    public void createSilinder(){
        vertices.clear();
        for(float i = 0;i<360;i+=0.1){
            double rad = Math.toRadians(i);
            Float x = (float) (xR+Math.cos(rad)*r);
            Float y = (float) (yR+Math.sin(rad)*r2);
            Float z = zR;
            vertices.add(new Vector3f(x,y,z));

            z = r3;
            vertices.add(new Vector3f(x,y,z));
        }
    }

    public void createSphere(){
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float)Math.PI/sectorCount;
        float stackStep = (float) Math.PI/stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i=0; i<=stackCount; ++i){
            StackAngle = pi/2-i*stackStep;
            x = r * (float) Math.cos(StackAngle);
            y = r2 * (float) Math.cos(StackAngle);
            z = r3 * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount ; ++j){
                sectorAngle = j*sectorStep;
                Vector3f temp_vector = new Vector3f();

                temp_vector.x = xR + x * (float) Math.cos(sectorAngle);
                temp_vector.y = yR + y * (float) Math.sin(sectorAngle);
                temp_vector.z = zR + z;

                vertices.add(temp_vector);
            }
        }
    }

    public void createHalfSphere(int side){
        float pi = (float) Math.PI;
        float sectorStep = side * (float)Math.PI/sectorCount;
        float stackStep = (float) Math.PI/stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i=0; i<=stackCount; ++i){
            StackAngle = pi/2-i*stackStep;
            x = r * (float) Math.cos(StackAngle);
            y = r2 * (float) Math.cos(StackAngle);
            z = r3 * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount ; ++j){
                sectorAngle = j*sectorStep;
                Vector3f temp_vector = new Vector3f();

                temp_vector.x = xR + x * (float) Math.cos(sectorAngle);
                temp_vector.y = yR + y * (float) Math.sin(sectorAngle);
                temp_vector.z = zR + z;

                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere2(){
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float)Math.PI/sectorCount;
        float stackStep = (float) Math.PI/stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i=stackCount/2 -1; i<=stackCount/2; ++i){
            StackAngle = pi/2-i*stackStep;
            x = r * (float) Math.cos(StackAngle);
            y = r2 * (float) Math.cos(StackAngle);
            z = r3 * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount ; ++j){
                sectorAngle = j*sectorStep;
                Vector3f temp_vector = new Vector3f();

                temp_vector.x = xR + x * (float) Math.cos(sectorAngle);
                temp_vector.y = yR + y * (float) Math.sin(sectorAngle);
                temp_vector.z = zR + z;
                vertices.add(temp_vector);
            }
        }
        for (int i=0; i<=stackCount/2; ++i){
            StackAngle = pi/2-i*stackStep;
            x = r * (float) Math.cos(StackAngle);
            y = r2 * (float) Math.cos(StackAngle);
            z = r3 * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount ; ++j){
                sectorAngle = j*sectorStep;
                Vector3f temp_vector = new Vector3f();

                temp_vector.x = xR + x * (float) Math.cos(sectorAngle);
                temp_vector.y = yR + y * (float) Math.sin(sectorAngle);
                temp_vector.z = zR + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere3(){
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float)Math.PI/sectorCount;
        float stackStep = (float) Math.PI/stackCount;
        float sectorAngle, StackAngle, x, y, z;
        for (int i=0; i<=stackCount/2; ++i){
            StackAngle = pi/2-i*stackStep;
            x = r * (float) Math.cos(StackAngle);
            y = r2 * (float) Math.cos(StackAngle);
            z = r3 * (float) Math.sin(StackAngle);

            for (int j = sectorCount*1/5; j <= sectorCount*4/5 ; ++j){
                sectorAngle = j*sectorStep;
                Vector3f temp_vector = new Vector3f();

                temp_vector.x = xR + x * (float) Math.cos(sectorAngle);
                temp_vector.y = yR + y * (float) Math.sin(sectorAngle);
                temp_vector.z = zR + z;
                vertices.add(temp_vector);
            }
        }
    }
    public void createEllipsoid() {
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float)(Math.cos(v) * Math.cos(u));
                temp_vector.y = yR + r2 * (float)(Math.cos(v) * Math.sin(u));
                temp_vector.z = zR + r3 * (float)(Math.sin(v));
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createHyperboloid1() {
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float)((1/Math.cos(v)) * Math.cos(u));
                temp_vector.y = yR + r2 * (float)((1/Math.cos(v)) * Math.sin(u));
                temp_vector.z = zR + r3 * (float)(Math.tan(v));
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createHyperboloid2() {
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float)(Math.tan(v) * Math.cos(u));
                temp_vector.y = yR + r2 * (float)(Math.tan(v) * Math.sin(u));
                temp_vector.z = zR + r3 * (float)(1/Math.cos(v));
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createEllipticCone() {
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float) v * (float)(Math.cos(u));
                temp_vector.y = yR + r2 * (float) v * (float)(Math.sin(u));
                temp_vector.z = zR + r3 * (float) v;
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createCone() {
        for(double v = 0; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float) v * (float)(Math.cos(u));
                temp_vector.y = yR + r2 * (float) v * (float)(Math.sin(u));
                temp_vector.z = zR + r3 * (float) v;
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }
    public void createCone2() {
        for(double v = 0; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = xR + r * (float) v * (float)(Math.cos(u));
                temp_vector.y = yR + r2 * (float) v * (float)(Math.sin(u));
                temp_vector.z = zR + r3 * (float) v;
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createEllipticParaboloid() {
        for(double v = 0; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = r * (float) v * (float)(Math.cos(u));
                temp_vector.y = r2 * (float) v * (float)(Math.sin(u));
                temp_vector.z = (float) Math.pow((float) v, 2);
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }

    public void createHyperboloidParaboloid() {
        for(double v = 0; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                temp_vector.x = r * (float) v * (float)(Math.tan(u));
                temp_vector.y = r2 * (float) v * 1 / (float)(Math.cos(u));
                temp_vector.z = (float) Math.pow((float) v, 2);
                vertices.add(temp_vector);
                temp_vector = new Vector3f();
            }
        }
    }
    public void translateObject(float offsetX, float offsetY, float offsetZ) {
        super.model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        this.xR+=offsetX;
        this.yR+=offsetY;
        this.zR+=offsetZ;
        for(Object child:childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }
        //System.out.println(offsetX+" "+offsetY+" "+offsetZ);
        //System.out.println(rotation+"AWHJHWFA");
        jarakX+=offsetX*Math.cos(Math.toRadians(rotation));
        jarakY+=offsetY;
        jarakZ+=offsetX*Math.sin(Math.toRadians(rotation));
        //System.out.println("JarakX = "+jarakX+", JarakY = "+ jarakY+", JarakZ = "+jarakZ+", Rotation = "+rotation);
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
    /*public void draw(){
        drawSetup();
        glLineWidth(2);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP,0, vertices.size());
        for(Object child:childObject){
            child.draw();
        }
    }*/
    public void createPlane(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 3
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
    }

    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void createBox2(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/5f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/5f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/5f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/5f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void createBox3(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/5f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/5f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/5f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/5f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
    }

    public void createBox4(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/2.0f;
        temp.y = yR;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/2.0f;
        temp.y = yR;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void eyeBrowRight() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/6.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/1.0f;
        temp.y = yR - r2/5.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/0.6f;
        temp.y = yR + r2/6.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/0.6f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/1.0f;
        temp.y = yR - r2/5.9f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void eyeBrowLeft() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //titik 1
        temp.x = xR - r/2.0f;
        temp.y = yR + r2/6.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3
        temp.x = xR + r/1.0f;
        temp.y = yR - r2/5.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4
        temp.x = xR - r/2.0f;
        temp.y = yR - r2/2.0f;
        temp.z = zR - r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5
        temp.x = xR - r/0.6f;
        temp.y = yR + r2/6.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6
        temp.x = xR + r/2.0f;
        temp.y = yR + r2/2.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7
        temp.x = xR + r/1.0f;
        temp.y = yR - r2/5.9f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8
        temp.x = xR - r/0.6f;
        temp.y = yR - r2/2.0f;
        temp.z = zR + r3/1.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak belakang
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    @Override
    public float getxR() {
        return super.getxR();
    }

    @Override
    public float getyR() {
        return super.getyR();
    }

    @Override
    public float getzR() {
        return super.getzR();
    }

    public float getJarakX() {
        return jarakX;
    }

    public float getJarakY() {
        return jarakY;
    }

    public float getJarakZ() {
        return jarakZ;
    }

    @Override
    public float getRotation() {
        return rotation;
    }
}
