package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11C.glDrawArrays;
import static org.lwjgl.opengl.GL11C.glLineWidth;
import static org.lwjgl.opengl.GL11C.glPointSize;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;


public class Object extends ShaderProgram {

    List<Vector3f> vertices;
    List<Vector3f> verticesColor;
    int vao;
    int vbo;
    int vboColor;
    float xR;
    float yR;
    float zR;

    float r;

    float lineWidth=3;
    float pointSize=3;
    List<Object> childObject;
    UniformsMap uniformsMap;
    Vector4f color;

    Matrix4f model;
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        this.color = color;
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
        childObject = new ArrayList<>();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, Vector4f color) {
        super(shaderModuleDataList);
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
        /*this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();*/
    }

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //set vbo color
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
}

    public void drawSetup(Camera camera, Projection projection){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());

        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor(){
        bind();
        
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        //bind vbo color
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);

        //draw vertices
        //optional (ketebalan)
        glLineWidth(1);

        //optional (size vertex)
        glPointSize(0);

        glDrawArrays(GL_POLYGON,0, vertices.size());
        for(Object child:childObject){
            child.draw(camera, projection);
        }
    }
    /*public void drawGLLine(){
        drawSetup();

        //draw vertices
        //optional (ketebalan)
        glLineWidth(1);

        //optional (size vertex)
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP,0, vertices.size());
    }*/

    public void addVertices(Vector3f newVertices) {
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void setVertices(Vector3f newV, int ind) {
        vertices.set(ind, newV);
        setupVAOVBO();
    }


//    public void drawLine() {
//        drawSetup();
//        glLineWidth(3);
//        glPointSize(3);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }
    public void drawLine(Camera camera, Projection projection) {
        drawSetup(camera, projection);
        glLineWidth(lineWidth);
        glPointSize(pointSize);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
//    public void drawLine(Camera camera, Projection projection, int customWidth) {
//        drawSetup(camera, projection);
//        glLineWidth(lineWidth);
//        glPointSize(pointSize);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }
    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();

        //draw vertices
        //optional (ketebalan)
        glLineWidth(1);

        //optional (size vertex)
        glPointSize(0);

        //wajib (parametes pertama tergantung mau buat apa, contoh dibawah untuk segitiga GL_TRIANGLES)
       /*
        GL_LINES
        GL_LINE_STRIPS
        GL_LINE_LOOP
        GL_TRIANGLES
        GL_TRIANGLES_FAN
        GL_POINT
        */
        //parameter kedua, mxdnya mau gambar dari index/vertex ke berapa
        //parametes ketiga buat mau gambar berapa vertex
        glDrawArrays(GL_TRIANGLES,0, vertices.size());
    }

    public boolean isInside() {
        System.out.println("NOT CIRCLE");
        return false;
    };

    public float getxR() {
        return 1;
    }

    public float getyR() {
        return 1;
    }

    public void translateObject(float offsetX, float offsetY, float offsetZ) {
    }
    public void translateObjectNormal(float offsetX, float offsetY, float offsetZ) {
    }

    public void rotateObject(float degree, float x, float y, float z) {
    }

    public void rotateObjectNormal(float degree, float x, float y, float z) {
    }

    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
    }

    public void setxR(float xR) {
        this.xR = xR;
    }

    public void setyR(float yR) {
        this.yR = yR;
    }

    public float getzR() {
        return zR;
    }

    public void setzR(float zR) {
        this.zR = zR;
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    public void scaleObject(float v) {
        model = new Matrix4f().scale(v, v, v).mul(new Matrix4f(model));
    }
    public float getJarakX() {
        return 1;
    }

    public float getJarakY() {
        return 1;
    }

    public float getJarakZ() {
        return 1;
    }

    public float getRotation() {
        return 1;
    }

    protected void drawLinewithWidth(Camera camera, Projection projection, float widthepiro) {
    }
}
