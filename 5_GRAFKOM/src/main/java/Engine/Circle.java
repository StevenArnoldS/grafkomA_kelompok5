package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15C.*;


public class Circle extends Object {

    List<Integer> index;
    int ibo;

    float r;
    float r2;


    public Circle(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r,float xR, float yR) {
        super(shaderModuleDataList, color);
        this.r = r;
        this.color = color;
        this.vertices = new ArrayList<>();
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = r * Math.cos(i) + xR;
            y = r * Math.sin(i) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r,float xR, float yR, int side) {
        super(shaderModuleDataList, color);
        this.r = r;
        this.color = color;
        this.xR = xR;
        this.yR = yR;
        this.vertices = new ArrayList<>();
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=720/side*Math.PI/360){
            x = r * Math.cos(i+Math.toRadians(180/side)) + xR;
            y = r * Math.sin(i+Math.toRadians(180/side)) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }


    public Circle(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r, float r2,float xR, float yR) {
        super(shaderModuleDataList, color);
        this.r = r;
        this.r2 = r2;
        this.color = color;
        this.xR = xR;
        this.yR = yR;
        this.vertices = new ArrayList<>();
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = r * Math.cos(i) + xR;
            y = r2 * Math.sin(i) + yR;
            //WOIthis.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    /*public void draw(){
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(0);
        glPointSize(1);
        glDrawArrays(GL_TRIANGLE_FAN,0, vertices.size());
    }*/

    public boolean isInside(float xInput, float yInput) {
        //System.out.println("xinput:"+xInput+", xr:"+xR+"yinput:"+yInput+", yr:"+yR);
        return (Math.abs(xInput-xR) < 0.1f && Math.abs(yInput-yR) < 0.1f);
    }

    public float getxR() {
        return xR;
    }

    public float getyR() {
        return yR;
    }
}
