import Engine.Object;
import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Mainlama2 {

    private Window window = new Window(650, 650, "Ini rumah!");
    private ArrayList<Object> object2DS = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private ArrayList<Object> objectsBintang = new ArrayList<>();
    private ArrayList<Object> objectsBulat = new ArrayList<>();
    private ArrayList<Object> objectsAsap = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl2 = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl3 = new ArrayList<>();
    private ArrayList<Object> objectsSphere = new ArrayList<>();
    private ArrayList<Object> objectsPlanet = new ArrayList<>();
    int rotateI=0;

    private Camera camera = new Camera();
    private Projection projection = new Projection(window.getWidth(), window.getHeight());

    public static void main(String[] args) {
        new Mainlama2().run();
    }

    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(0,0,2.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0f));
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI
        object2DS.add(new Object(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        //new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f)
                )
        ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new ArrayList<>(
//                List.of(new Vector3f(255f/255, 236f/255, 25f/255),
//                        new Vector3f(246f/255, 5f/255, 5f/255),
//                        new Vector3f(255f/255, 86f/255, 7f/255)

                        List.of(new Vector3f(245 / 255f, 46 / 255f, 91 / 255f),
                                new Vector3f(10 / 255f, 118 / 255f, 238 / 255f),
                                new Vector3f(135 / 255f, 82 / 255f, 158 / 255f)
                        )
                )

        ));

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
                        new Vector3f(-1.0f, -1.0f, 0.0f),

                        new Vector3f(-1.0f, -0.5f, 0.0f),
                        new Vector3f(-0.95f, -0.45f, 0.0f),
                        new Vector3f(-0.9f, -0.5f, 0.0f),

                        new Vector3f(-0.9f, -0.5f, 0.0f),
                        new Vector3f(-0.85f, -0.45f, 0.0f),
                        new Vector3f(-0.8f, -0.5f, 0.0f),

                        new Vector3f(-0.8f, -0.5f, 0.0f),
                        new Vector3f(-0.75f, -0.45f, 0.0f),
                        new Vector3f(-0.7f, -0.5f, 0.0f),

                        new Vector3f(-0.7f, -0.5f, 0.0f),
                        new Vector3f(-0.65f, -0.45f, 0.0f),
                        new Vector3f(-0.6f, -0.5f, 0.0f),

                        new Vector3f(-0.6f, -0.5f, 0.0f),
                        new Vector3f(-0.55f, -0.45f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),


                        new Vector3f(1.0f, -0.5f, 0.0f),
                        new Vector3f(0.95f, -0.45f, 0.0f),
                        new Vector3f(0.9f, -0.5f, 0.0f),

                        new Vector3f(0.9f, -0.5f, 0.0f),
                        new Vector3f(0.85f, -0.45f, 0.0f),
                        new Vector3f(0.8f, -0.5f, 0.0f),

                        new Vector3f(0.8f, -0.5f, 0.0f),
                        new Vector3f(0.75f, -0.45f, 0.0f),
                        new Vector3f(0.7f, -0.5f, 0.0f),

                        new Vector3f(0.7f, -0.5f, 0.0f),
                        new Vector3f(0.65f, -0.45f, 0.0f),
                        new Vector3f(0.6f, -0.5f, 0.0f),

                        new Vector3f(0.6f, -0.5f, 0.0f),
                        new Vector3f(0.55f, -0.45f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f)
                )
        ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(76 / 255f, 179 / 255f, 32 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33)

        ));

        objectsRectangle.add(new Rectangle(
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
                        new Vector3f(0.25f, 0.4f, 0.0f),

                        new Vector3f(-0.52f, -0.62f, 0.0f),
                        new Vector3f(-0.52f, -0.72f, 0.0f),
                        new Vector3f(0.52f, -0.72f, 0.0f),
                        new Vector3f(0.52f, -0.62f, 0.0f)
                )
        ),
//        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)
                new Vector4f(196 / 255f, 91 / 255f, 48 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3, 4, 5, 6, 5, 6, 7, 8, 9, 10, 8, 10, 11)

        ));
        objectsRectangle.add(new Rectangle(
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
                new Vector4f(200 / 255f, 151 / 255f, 108 / 255f, 1.0f),
                Arrays.asList(0, 1, 5, 1, 4, 5, 1, 2, 3, 6, 7, 8, 7, 8, 9)

        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.3f, -0.7f, 0.0f),
                        new Vector3f(-0.3f, -0.4f, 0.0f),
                        new Vector3f(-0.15f, -0.4f, 0.0f),
                        new Vector3f(-0.15f, -0.7f, 0.0f)
                )
        ),
                new Vector4f(0 / 255f, 91 / 255f, 48 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.27f, -0.67f, 0.0f),
                        new Vector3f(-0.27f, -0.57f, 0.0f),
                        new Vector3f(-0.18f, -0.57f, 0.0f),
                        new Vector3f(-0.18f, -0.67f, 0.0f)
                )
        ),
                new Vector4f(0 / 255f, 60 / 255f, 18 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.27f, -0.53f, 0.0f),
                        new Vector3f(-0.27f, -0.43f, 0.0f),
                        new Vector3f(-0.18f, -0.43f, 0.0f),
                        new Vector3f(-0.18f, -0.53f, 0.0f)
                )
        ),
                new Vector4f(0 / 255f, 60 / 255f, 18 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.36f, -0.29f, 0.0f),
                        new Vector3f(0.36f, -0.5f, 0.0f),
                        new Vector3f(0.15f, -0.5f, 0.0f),
                        new Vector3f(0.15f, -0.29f, 0.0f)
                )
        ),
                new Vector4f(180 / 255f, 180 / 255f, 180 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)));
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.25f, -0.3f, 0.0f),
                        new Vector3f(0.25f, -0.39f, 0.0f),
                        new Vector3f(0.16f, -0.39f, 0.0f),
                        new Vector3f(0.16f, -0.3f, 0.0f),

                        new Vector3f(0.25f, -0.40f, 0.0f),
                        new Vector3f(0.25f, -0.49f, 0.0f),
                        new Vector3f(0.16f, -0.49f, 0.0f),
                        new Vector3f(0.16f, -0.4f, 0.0f),

                        new Vector3f(0.35f, -0.3f, 0.0f),
                        new Vector3f(0.35f, -0.39f, 0.0f),
                        new Vector3f(0.26f, -0.39f, 0.0f),
                        new Vector3f(0.26f, -0.3f, 0.0f),

                        new Vector3f(0.35f, -0.40f, 0.0f),
                        new Vector3f(0.35f, -0.49f, 0.0f),
                        new Vector3f(0.26f, -0.49f, 0.0f),
                        new Vector3f(0.26f, -0.4f, 0.0f)
                )
        ),
                new Vector4f(180 / 255f, 200 / 255f, 200 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3, 4, 5, 6, 4, 6, 7, 8, 9, 10, 8, 10, 11, 12, 13, 14, 12, 14, 15)));


        objectsBulat.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(220 / 255f, 220 / 255f, 220 / 255f, 0.8f), 0.2f, -0.7f, 0.6f
        ));
        objectsBulat.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(190 / 255f, 190 / 255f, 190 / 255f, 0.8f), 0.18f, -0.68f, 0.62f
        ));
        objectsBulat.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(150 / 255f, 150 / 255f, 150 / 255f, 0.8f), 0.03f, -0.8f, 0.65f
        ));
        objectsBulat.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(150 / 255f, 150 / 255f, 150 / 255f, 0.8f), 0.04f, -0.72f, 0.52f
        ));
        objectsBulat.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(46 / 255f, 124 / 255f, 220 / 255f, 0.0f), 0.2f, -0.6f, 0.7f
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(144 / 255f, 97 / 255f, 15 / 255f, 0.0f), 0.07f, 0.045f, -0.3f, -0.77f
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(144 / 255f, 97 / 255f, 15 / 255f, 0.0f), 0.075f, 0.05f, -0.4f, -0.87f
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(144 / 255f, 97 / 255f, 15 / 255f, 0.0f), 0.08f, 0.055f, -0.52f, -0.99f
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(196 / 255f, 91 / 255f, 48 / 255f, 0.0f), 0.06f, -0.23f, -0.1f
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.1f, 0.0f, -0.85f, 3
        ));
        /*objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.1f, 0.3f, -0.85f, 4
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.1f, 0.6f, -0.85f, 5
        ));
        objectsBulat.add(new Circle(//pathway
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.1f, 0.9f, -0.85f, 10
        ));


        objectsAsap.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(188 / 255f, 188 / 255f, 188 / 255f, 0.0f), 0.08f, 0.05f, 0.15f, 0.52f
        ));
        objectsAsap.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(188 / 255f, 188 / 255f, 188 / 255f, 0.0f), 0.04f, 0.05f, 0.22f, 0.57f
        ));
        objectsAsap.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(188 / 255f, 188 / 255f, 188 / 255f, 0.0f), 0.06f, 0.05f, 0.16f, 0.67f
        ));
        objectsAsap.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(188 / 255f, 188 / 255f, 188 / 255f, 0.0f), 0.04f, 0.04f, 0.2f, 0.77f
        ));

        objectsBintang.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), bint(0.06f, 0.6f, 0.7f),
                new Vector4f(230 / 255f, 255 / 255f, 161 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 4)
        ));
        objectsBintang.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), bint(0.07f, -0.2f, 0.85f),
                new Vector4f(230 / 255f, 255 / 255f, 161 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 4)
        ));
        objectsBintang.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), bint(0.08f, -0.7f, 0.2f),
                new Vector4f(230 / 255f, 255 / 255f, 161 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 4)
        ));
        objectsBintang.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), bint(0.08f, 0.7f, 0.3f),
                new Vector4f(230 / 255f, 255 / 255f, 161 / 255f, 1.0f),
                Arrays.asList(0, 1, 2, 4)
        ));

        objectsPointsControl2.add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
        ));

        objectsPointsControl3.add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
        ));


        objectsSphere.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(188 / 255f, 188 / 255f, 188 / 255f, 0.0f), 0.4f, 0.7f, 0.2f, -0.07f, 0.5f, 0.2f, 36, 18
        ));
        objectsSphere.get(0).translateObject(0.5f, 0.5f, 0.5f);
        objectsSphere.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(5 / 255f, 5 / 255f, 5 / 255f, 0.0f), 0.4f, 0.7f, 0.2f, -0.07f, 0.5f, 0.2f, 36, 18
        ));
        objectsSphere.get(0).getChildObject().get(0).translateObject(0.25f, 0.25f, 0.25f);




        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 200 / 255f, 0 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(0).getChildObject().get(0).translateObject(0.25f, 0.25f, 0);
        objectsPlanet.get(0).getChildObject().get(0).setxR(0.25f);
        objectsPlanet.get(0).getChildObject().get(0).setyR(0.25f);
        objectsPlanet.get(0).getChildObject().get(0).setzR(0);
        objectsPlanet.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(0).getChildObject().get(1).translateObject(0.5f, 0.5f, 0.5f);
        objectsPlanet.get(0).getChildObject().get(1).setxR(0.5f);
        objectsPlanet.get(0).getChildObject().get(1).setyR(0.5f);
        objectsPlanet.get(0).getChildObject().get(1).setzR(0.5f);
        objectsPlanet.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0 / 255f, 200 / 255f, 200 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.7f, 0.7f, 0.7f);
        objectsPlanet.get(0).getChildObject().get(1).getChildObject().get(0).setxR(0.7f);
        objectsPlanet.get(0).getChildObject().get(1).getChildObject().get(0).setyR(0.7f);
        objectsPlanet.get(0).getChildObject().get(1).getChildObject().get(0).setzR(0.7f);



        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 0 / 255f, 0 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(1).scaleObject(0.2f, 0.2f,0.2f);
        objectsPlanet.get(1).translateObject(0.3f, 0,0);

        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(200 / 255f, 110 / 255f, 0 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(2).scaleObject(0.3f, 0.3f,0.3f);
        objectsPlanet.get(2).translateObject(0.45f, 0,0);

        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0 / 255f, 200 / 255f, 0 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(3).scaleObject(0.5f, 0.5f,0.5f);
        objectsPlanet.get(3).translateObject(0.7f, 0,0);

        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0 / 255f, 0 / 255f, 200 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(4).scaleObject(0.4f, 0.4f,0.4f);
        objectsPlanet.get(4).translateObject(0.9f, 0,0);

        objectsPlanet.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(111 / 255f, 111 / 255f, 111 / 255f, 0.0f), 0.2f, 0.2f, 0, -0, 0.2f, 0, 36, 18
        ));
        objectsPlanet.get(5).scaleObject(0.1f, 0.1f,0.1f);
        objectsPlanet.get(5).translateObject(0.8f, 0,0);*/
    }

    public ArrayList<Vector3f> bint(float r, float x, float y) {
        ArrayList<Vector3f> verticesB2;
        verticesB2 = new ArrayList<>();
        int pix2 = 5;
        double incTetha2 = 360 / pix2;
        double angle2;
        angle2 = Math.toRadians(0 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        angle2 = Math.toRadians(2 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        angle2 = Math.toRadians(4 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        angle2 = Math.toRadians(1 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        angle2 = Math.toRadians(3 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        angle2 = Math.toRadians(0 * incTetha2);
        verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        return verticesB2;
    }

    public ArrayList<Vector3f> bint(float r, float x, float y, int pix2) {
        ArrayList<Vector3f> verticesB2;
        verticesB2 = new ArrayList<>();
        double incTetha2 = 360 / pix2;
        double angle2;
        for (int i = 0; i < pix2; i++) {
            angle2 = Math.toRadians(i * incTetha2 + 180 / pix2);
            verticesB2.add(new Vector3f((float) ((r * (Math.cos(angle2)))) + x, (float) ((r * (Math.sin(angle2)))) + y, 0.0f));
        }
        return verticesB2;
    }

    public void input(){
        int indexOver = -1;
        int jumlah=0;
        float xx;
        float yy;
        float xlama, ylama;
        boolean lagiDalam = false;
        if (window.isKeyPressed(GLFW_KEY_Q)){
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.5f, 0.5f, 1.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_Z)){
            objectsSphere.get(0).scaleObject(0.9f, 0.9f, 0.9f);
        }
        if (window.isKeyPressed(GLFW_KEY_X)){
            objectsSphere.get(0).scaleObject(1.1f, 1.1f, 1.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)){
            objectsPlanet.get(0).translateObject(-0.01f, 0, 0);
        }
        if (window.isKeyPressed(GLFW_KEY_S)){
            objectsPlanet.get(0).translateObject(0, -0.01f, 0);
        }
        if (window.isKeyPressed(GLFW_KEY_D)){
            objectsPlanet.get(0).translateObject(0.01f, 0, 0);
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            objectsPlanet.get(0).translateObject(0, 0.01f, 0);
        }
        if (window.isKeyPressed(GLFW_KEY_F)){
            objectsPlanet.get(0).rotateObject((float) Math.toRadians(0.2f),0, 1f, 1f);
            objectsPlanet.get(1).rotateObject((float) Math.toRadians(0.3f),0, 1f, 1f);
            objectsPlanet.get(2).rotateObject((float) Math.toRadians(0.5f),0, 1f, 1f);
            objectsPlanet.get(3).rotateObject((float) Math.toRadians(0.4f),0, 1f, 1f);
            objectsPlanet.get(4).rotateObject((float) Math.toRadians(0.6f),0, 1f, 1f);
            objectsPlanet.get(5).rotateObject((float) Math.toRadians(0.4f),0, 1f, 1f);
            rotateI+=1;
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {
            objectsPlanet.get(0).rotateObject((float) Math.toRadians(0.2f),0, 0, 1f);
            for (Object child:objectsPlanet.get(0).getChildObject()) {
                System.out.println(child.getxR());
                child.rotateObject(rotateI*(float) Math.toRadians(0.2f), 0.0f, 0.0f, -1f);
                child.translateObject(child.getxR()*-1, child.getyR()*-1, child.getzR()*-1);
                child.rotateObject(0.2f, 0.0f, 0.0f, 1f);
                child.translateObject(child.getxR(), child.getyR(), child.getzR());
                child.rotateObject(rotateI*(float) Math.toRadians(0.2f), 0.0f, 0.0f, 1f);
            }
            objectsPlanet.get(1).rotateObject(rotateI*(float) Math.toRadians(0.3f),0, 0, -1f);
            objectsPlanet.get(1).translateObject(-0.3f, 0, 0);
            objectsPlanet.get(1).rotateObject((float) Math.toRadians(2f), 0, 0, 1f);
            objectsPlanet.get(1).translateObject(0.3f, 0, 0);
            objectsPlanet.get(1).rotateObject(rotateI*(float) Math.toRadians(0.3f),0, 0, 1f);

            objectsPlanet.get(2).rotateObject(rotateI*(float) Math.toRadians(0.5f),0, 0, -1f);
            objectsPlanet.get(2).translateObject(-0.45f, 0, 0);
            objectsPlanet.get(2).rotateObject((float) Math.toRadians(1f), 0, 0, 1f);
            objectsPlanet.get(2).translateObject(0.45f, 0, 0);
            objectsPlanet.get(2).rotateObject(rotateI*(float) Math.toRadians(0.5f),0, 0, 1f);

            objectsPlanet.get(3).rotateObject(rotateI*(float) Math.toRadians(0.4f),0, 0, -1f);
            objectsPlanet.get(3).translateObject(-0.7f, 0, 0);
            objectsPlanet.get(3).rotateObject((float) Math.toRadians(1f), 0, 0, 1f);
            objectsPlanet.get(3).translateObject(0.7f, 0, 0);
            objectsPlanet.get(3).rotateObject(rotateI*(float) Math.toRadians(0.4f),0, 0, 1f);

            objectsPlanet.get(4).rotateObject(rotateI*(float) Math.toRadians(0.6f),0, 0, -1f);
            objectsPlanet.get(4).translateObject(-0.9f, 0, 0);
            objectsPlanet.get(4).rotateObject((float) Math.toRadians(1f), 0, 0, 1f);
            objectsPlanet.get(4).translateObject(0.9f, 0, 0);
            objectsPlanet.get(4).rotateObject(rotateI*(float) Math.toRadians(0.6f),0, 0, 1f);
        }

        if (window.isKeyPressed(GLFW_KEY_H)){
            objectsPlanet.get(5).rotateObject(rotateI*(float) Math.toRadians(0.4f),0, 0, -1f);
            objectsPlanet.get(5).translateObject(-0.7f, 0, 0);
            objectsPlanet.get(5).rotateObject((float) Math.toRadians(1f), 0, 0, 1f);
            objectsPlanet.get(5).translateObject(0.7f, 0, 0);
            objectsPlanet.get(5).rotateObject(rotateI*(float) Math.toRadians(0.4f),0, 0, 1f);
        }

        if (window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();
            //System.out.println("x:"+pos.x+" ;y:"+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f)/(window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f)/(-window.getHeight()/2.0f);
            boolean inside = false;
            for (int i = 0; i < objectsPointsControl.size(); i++){
                if(objectsPointsControl.get(i) instanceof Circle){
                    //System.out.println(((Circle) objectsPointsControl.get(i)).isInside(pos.x, pos.y));
                    if (((Circle) objectsPointsControl.get(i)).isInside(pos.x, pos.y)){
                        inside=true;
                        indexOver = i;
                        lagiDalam = true;
                        break;
                    }
                } else System.out.println("NOT CIRCLE");
            }/*
            System.out.println(inside+"ini");*/
            if ((!(pos.x > 1 || pos.x < -0.97)&& !(pos.y > 1 || pos.y < -0.97))&&!inside&&!lagiDalam){
                /*System.out.println("aaaa");
                System.out.println("x:" + pos.x + " ;y:" + pos.y);*/
                System.out.println("KEBUAT");
                jumlah++;
                objectsPointsControl.add(new Circle(//pathway
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new Vector4f(250 / 255f, 0 / 255f, 0 / 255f, 0.0f), 0.05f, pos.x, pos.y, 4
                ));
                objectsPointsControl2.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
                objectsPointsControl3.set(0, new Object(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 0.0f, 1.0f)
                ));
                for (float t = 0;t < 1;t+=0.01){
                    xx = 0;
                    yy = 0;
                    for (int i = 0; i < objectsPointsControl.size();i++){
                        xx += Math.pow((1-t), (objectsPointsControl.size()-1-i)) * Math.pow(t, i) * (((Circle)objectsPointsControl.get(i)).getxR());
                        yy += Math.pow((1-t), (objectsPointsControl.size()-1-i)) * Math.pow(t, i) * (((Circle)objectsPointsControl.get(i)).getyR());
                    }
                    if (objectsPointsControl.size()>1) {
                        objectsPointsControl3.get(0).addVertices(new Vector3f(xx, yy, 0));
                        System.out.println("KEADD");
                        System.out.println("x:" + xx + ", y:" + yy);

                    }
                }










            } else {
                if (indexOver!=-1) {
                    objectsPointsControl.set(indexOver, (new Circle(//pathway
                                    Arrays.asList(
                                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                    ),
                                    new Vector4f(250 / 255f, 0 / 255f, 0 / 255f, 0.0f), 0.05f, pos.x, pos.y, 4
                            ))
                    );
                    objectsPointsControl2.get(0).setVertices(new Vector3f(pos.x, pos.y, 0), indexOver);
                    objectsPointsControl3.set(0, new Object(
                            Arrays.asList(
                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                            ), new ArrayList<>(),
                            new Vector4f(1.0f, 1.0f, 0.0f, 1.0f)
                    ));
                    for (float t = 0;t < 1.1;t+=0.1){
                        xx = 0;
                        yy = 0;
                        for (int i = 0; i < objectsPointsControl.size();i++){
                            xx += Math.pow((1-t), (objectsPointsControl.size()-1-i)) * Math.pow(t, i) * (((Circle)objectsPointsControl.get(i)).getxR());
                            yy += Math.pow((1-t), (objectsPointsControl.size()-1-i)) * Math.pow(t, i) * (((Circle)objectsPointsControl.get(i)).getyR());
                        }
                        if (objectsPointsControl.size()>1) {
                            objectsPointsControl3.get(0).addVertices(new Vector3f(xx, yy, 0));
                            System.out.println("KEADD");
                            System.out.println("x:" + xx + ", y:" + yy);

                        }
                    }
                    //if (window.getMouseInput().isLeftButtonRelease()) System.out.println("HAHAHAHHA");
                }
            }
        }
    }
    /* INPUT LAMA WOI
    public void input(){
        int indexx = 0;
        if (window.isKeyPressed(GLFW_KEY_W)){
            System.out.println("W");
        }
        if (window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();
            System.out.println("x:"+pos.x+" ;y:"+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f)/(window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f)/(-window.getHeight()/2.0f);
            if ((!(pos.x > 1 || pos.x < -0.99)&& !(pos.y > 1 || pos.y < -0.99))){
                System.out.println("x:" + pos.x + " ;y:" + pos.y);
                objectsPointsControl.get(indexx).addVertices(new Vector3f(pos.x,pos.y,0));
            }
        }
        if (window.getMouseInput().isLeftButtonPressed()){
            objectsPointsControl.add(new Object_2D(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ), new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
            ));
            indexx++;
        }
    }*/

    public void loop() {
        while (window.isOpen()) {
            window.update();
//            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            glClearColor(46 / 255f, 124 / 255f, 220 / 255f, 0.0f);
            GL.createCapabilities();

            input();

            //code CUMA BOLE DISINI

            /*for (Object_2D ob : object2DS) {
//                ob.draw();
                ob.drawWithVerticesColor();
            }*/
            /*for (Object_2D ob: objectsRectangle){
//                ob.draw();
                ob.draw();
            }
            for (Object_2D ob: objectsBintang){
//                ob.draw();
                ob.drawLine();
            }
            for (Object_2D ob: objectsAsap){
//                ob.draw();
                ob.draw();
            }
            for (Object_2D ob: objectsBulat){
//                ob.draw();
                ob.draw();
            }*/
           for (Object ob: objectsPointsControl) {
//                ob.draw();
                ob.draw(camera, projection);
            }
            for (Object ob: objectsPointsControl2) {
//                ob.draw();
                ob.draw(camera, projection);
            }
            for (Object ob: objectsPointsControl3) {
//                ob.draw();
                ob.draw(camera, projection);
            }
            /*for (Object ob: objectsSphere) {
//                ob.draw();
                ob.draw();
            }*/
            for (Object ob: objectsPlanet) {
//                ob.draw();
                ob.draw(camera, projection);
            }
            //Restore state
            glDisableVertexAttribArray(0);

            //Poll  for window events
            //The key callback allows above will only be invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}