import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class MainlAMA {

    private Window window = new Window(500,500,"Fireball!");
    private ArrayList<Object> object2DS = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private ArrayList<Object> objectsDinding = new ArrayList<>();
    private ArrayList<Object> objectsAtap = new ArrayList<>();
    private ArrayList<Object> objectsBulan = new ArrayList<>();
    private ArrayList<Object> objectsBintang = new ArrayList<>();

    private Circle bulan;
    private Circle bulan2;

    public static void main(String[] args) {
        new MainlAMA().run();;
    }

    public void init(){
        window.init();
        GL.createCapabilities();
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI

//object2DS.add(new Object_2D(
//        Arrays.asList(
//                //lokasi shaderFile menyusaikan objectnya
//                //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
//                //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
//                new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
//        ), new ArrayList<>(
//                List.of(
//                        new Vector3f(0.0f, 0.5f, 0.0f),
//                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                        new Vector3f(0.5f, -0.5f, 0.0f)
//                )
//),
////        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
//        new ArrayList<>(
////                List.of(new Vector3f(255f/255, 236f/255, 25f/255),
////                        new Vector3f(246f/255, 5f/255, 5f/255),
////                        new Vector3f(255f/255, 86f/255, 7f/255)
//
//                List.of(new Vector3f(245/255f, 46/255f, 91/255f),
//                        new Vector3f(10/255f, 118/255f, 238/255f),
//                        new Vector3f(135/255f, 82/255f, 158/255f)
//                )
//        )
//
//));


    objectsRectangle.add(new Rectangle(
            Arrays.asList(
                    //lokasi shaderFile menyusaikan objectnya
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                    //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
            ), new ArrayList<>(
            List.of(
                    new Vector3f(1.0f, -0.5f, 0.0f),
                    new Vector3f(-1.0f, -0.5f, 0.0f),
                    new Vector3f(1.0f, -1.0f, 0.0f),
                    new Vector3f(-1.0f, -1.0f, 0.0f)
            )
    ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
            new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
            Arrays.asList(0,1,2,1,2,3)

    ));

        objectsDinding.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, -0.7f, 0.0f),
                        new Vector3f(-0.5f, -0.2f, 0.0f),
                        new Vector3f(-0.25f, 0.2f, 0.0f),
                        new Vector3f(0.0f, -0.2f, 0.0f),
                        new Vector3f(0.5f, -0.2f, 0.0f),
                        new Vector3f(0.5f, -0.7f, 0.0f),

                        new Vector3f(0.1f, 0.4f, 0.0f),
                        new Vector3f(0.1f, 0.2f, 0.0f),
                        new Vector3f(0.2f, 0.4f, 0.0f),
                        new Vector3f(0.2f, 0.2f, 0.0f)
                )
        ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                Arrays.asList(0,1,5,1,4,5,1,2,3,  6,7,8,7,8,9)

        ));
        objectsAtap.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.6f, -0.2f, 0.0f),
                        new Vector3f(-0.25f, 0.3f, 0.0f),
                        new Vector3f(0.25f, 0.3f, 0.0f),
                        new Vector3f(0.6f, -0.2f, 0.0f),

                        new Vector3f(0.05f, 0.45f, 0.0f),
                        new Vector3f(0.05f, 0.4f, 0.0f),
                        new Vector3f(0.25f, 0.45f, 0.0f),
                        new Vector3f(0.25f, 0.4f, 0.0f)
                )
        ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),
                Arrays.asList(0,1,2,0,2,3,  4,5,6,5,6,7)

        ));


        ArrayList<Vector3f> verticesB;
        verticesB = new ArrayList<>(
                List.of(

                        new Vector3f(-0.5f, -0.7f, 0.0f)

                ));
        int pix = 10;
        float r = 0.1f;
        double incTetha = 360/pix;
        for(int i = 0;i<pix;i++ ) {
            double angle = Math.toRadians(i*incTetha);
            verticesB.add(new Vector3f( (float)((r * (Math.cos(angle))-0.8)),  (float)((r * (Math.sin(angle))+0.8)), 0.0f));
//            System.out.println( (float)((r * (Math.cos(angle)))-0.4));
//            System.out.println( (float)((r * (Math.sin(angle)))-0.4));
        }
        /*objectsBulan.add(new CircleLama(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ), verticesB
                ,
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(1.0f, 1.0f, 1.0f, 0.8f),
                Arrays.asList(3,6,5,4,7,6,5,8,7,6,9,8,7,10,9)

        ));*/

        bulan = new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.8f),0.2f,-0.7f, 0.6f
        );

        bulan2 = new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),0.2f, -0.6f, 0.7f
        );


        ArrayList<Vector3f> verticesB2;
        verticesB2 = new ArrayList<>(
                List.of(


                ));
        int pix2 = 5;
        float r2 = 0.1f;
        double incTetha2 = 360/pix2;
        for(int i = 0;i<pix2;i++ ) {
            double angle2 = Math.toRadians(i*incTetha2);
            verticesB2.add(new Vector3f( (float)((r * (Math.cos(angle2)))),  (float)((r * (Math.sin(angle2)))), 0.0f));
            System.out.println( (float)((r * (Math.cos(angle2)))-0.4));
            System.out.println( (float)((r * (Math.sin(angle2)))-0.4));
        }
        objectsBintang.add(new CircleLama(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ), verticesB2
                ,
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(1.0f, 1.0f, 1.0f, 0.8f),
                Arrays.asList(0,2,4, 1,3,0)

        ));















    }

    public void loop(){
        /*while (window.isOpen()){
            window.update();
//            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
            GL.createCapabilities();

            //code CUMA BOLE DISINI

            for (Object ob: object2DS){
//                ob.draw();
                ob.drawWithVerticesColor();
            }
            for (Object ob: objectsRectangle){
//                ob.draw();
                ob.draw();
            }
            for (Object ob: objectsAtap){
//                ob.draw();
                ob.draw();
            }
            for (Object ob: objectsDinding){
//                ob.draw();
                ob.draw();
            }
            for (Object ob: objectsBulan){
//                ob.draw();
                ob.draw();
            }
            for (Object ob: objectsBintang){
//                ob.draw();
                ob.draw();
            }
            bulan.draw();
            bulan2.draw();


            //Restore state
            glDisableVertexAttribArray(0);

            //Poll  for window events
            //The key callback allows above will only be invoked during this call
            glfwPollEvents();
        }*/
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}