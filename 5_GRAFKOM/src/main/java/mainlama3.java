/*
import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(650, 650, "Ini rumah!");
    private ArrayList<Object> objectsPlanet = new ArrayList<>();
    private ArrayList<Object> objectsScenery = new ArrayList<>();
    private ArrayList<Object> objectsTree = new ArrayList<>();

    int rotasiWing = 0;
    boolean wingPlus = true;
    int rotateI=0;
    int rotateII=0;
    int scale=0;

    int transX=0;

    private Camera camera = new Camera();
    private Projection projection = new Projection(window.getWidth(), window.getHeight());

    public static void main(String[] args) {
        new Main().run();
    }

    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(0,0,2.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0f));
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI
        {
            objectsScenery.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(0 / 255f, 100 / 255f, 0 / 255f, 0.0f), 2f, 2f, 0, 0, 0, 0, 360, 180, 7
            ));
            objectsScenery.get(0).rotateObject((float) Math.toRadians(90f), 1f,0,0);
            objectsScenery.get(0).translateObject(0,-0.5f,0);
        }
        {
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 200 / 255f, 0 / 255f, 0.0f), .2f, .2f, 0, 0, 0.5f, -0.5f, 36, 18, 2
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 200 / 255f, 0 / 255f, 0.0f), .2105f, .2105f, 0, 0, 0.2105f, 0.56f, 360, 180, 1
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 200 / 255f, 0 / 255f, 0.0f), .2105f, .2105f, 0, 0, 0.5105f, -0.6f, 360, 180, 1
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), 0.07f, 0.07f, 0, 0, 0.12f, .76f, 360, 180, 1
            ));

            //baling baling
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlanet.get(5).rotateObject((float) Math.toRadians(120f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlanet.get(6).rotateObject((float) Math.toRadians(240f), 0, 0, 1f);

            //fins blkg
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.55f, 0.08f, 0.33f, 0, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlanet.get(7).rotateObject((float) Math.toRadians(90f), 0, 0, 1f);
            objectsPlanet.get(7).rotateObject((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.55f, 0.08f, 0.33f, -0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlanet.get(8).rotateObject((float) Math.toRadians(180f), 0, 0, 1f);
            objectsPlanet.get(8).rotateObject((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.55f, 0.08f, 0.33f, 0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlanet.get(9).rotateObject((float) Math.toRadians(-8f), 1f, 0, 0);

            //papan atas
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlanet.get(10).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.3f, 0.5f, 0, 0, 0.05f, -0.3f, 360, 180, 3
            ));
            objectsPlanet.get(11).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlanet.get(12).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.get(12).rotateObject((float) Math.toRadians(180f), 0, 1f, 0);

            //papan bawah
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlanet.get(13).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.3f, 0.5f, 0, 0, 0.05f, 0.3f, 360, 180, 3
            ));
            objectsPlanet.get(14).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(200 / 255f, 75 / 255f, 0 / 255f, 0.0f), 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlanet.get(15).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.get(15).rotateObject((float) Math.toRadians(180f), 0, 1f, 0);


            //pilar
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 190 / 255f, 0 / 255f, 0.0f), .03f, .03f, 0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlanet.get(16).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 190 / 255f, 0 / 255f, 0.0f), .03f, .03f, -0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlanet.get(17).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);

            //roda kanan
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(20).rotateObject((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(21).rotateObject((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(22).rotateObject((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(23).rotateObject((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 190 / 255f, 0 / 255f, 0.0f), .03f, .03f, -0, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlanet.get(24).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.get(24).rotateObject((float) Math.toRadians(20f), 1f, 0, 0);
            objectsPlanet.get(24).translateObject(-0.0f, 0.25f, 0.2f);
            for (int i = 18; i < 25; i++) {
                objectsPlanet.get(i).translateObject(-0.5f, -0.5f, -0.3f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(90f), 0, 1f, 0);
            }

            //roda kiri 25-31
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(27).rotateObject((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(28).rotateObject((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(29).rotateObject((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlanet.get(30).rotateObject((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 190 / 255f, 0 / 255f, 0.0f), .03f, .03f, -0, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlanet.get(31).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.get(31).rotateObject((float) Math.toRadians(20f), 1f, 0, 0);
            objectsPlanet.get(31).translateObject(-0.0f, 0.25f, 0.2f);
            for (int i = 25; i < 32; i++) {
                objectsPlanet.get(i).translateObject(+0.5f, -0.5f, -0.3f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(-90f), 0, 1f, 0);
            }

            //roda belakang 32-38
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), .15f, 0.15f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlanet.get(34).rotateObject((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlanet.get(35).rotateObject((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlanet.get(36).rotateObject((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlanet.get(37).rotateObject((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlanet.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(190 / 255f, 190 / 255f, 0 / 255f, 0.0f), .025f, .025f, -0, 0, 0.18f, -0.18f, 36, 18, 2
            ));
            objectsPlanet.get(38).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlanet.get(38).rotateObject((float) Math.toRadians(10f), 0, 0, -1f);
            objectsPlanet.get(38).translateObject(0.05f, 0.3f, 0f);
            for (int i = 32; i < 39; i++) {
                objectsPlanet.get(i).translateObject(-0.7f, -0.4f, -0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(-90f), 0, 1f, 0);
            }


            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(90f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(10f), 0, 0, 1f);
            }
        }

        for (int i = 0; i < 5; i++) {
            objectsTree.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f), .12f, .12f, 0, 0, 0.5f, -0.5f, 36, 18, 2
            ));
            objectsTree.get(i).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(0 / 255f, 130 / 255f, 0 / 255f, 0.0f), .2f, .2f, 0, 0, 0.5f, -0.5f, 36, 18, 6
            ));
            objectsTree.get(i).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(0 / 255f, 140 / 255f, 0 / 255f, 0.0f), .17f, .17f, 0, 0, 0.5f, -0.8f, 36, 18, 6
            ));
            objectsTree.get(i).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(0 / 255f, 150 / 255f, 0 / 255f, 0.0f), .15f, .15f, 0, 0, 0.4f, -.95f, 36, 18, 6
            ));
        }
        objectsTree.get(0).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(0).translateObject(0, -0.15f, 0);

        objectsTree.get(1).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(1).scaleObject(0.6f, 0.6f, 0.6f);
        objectsTree.get(1).translateObject(0.5f, -0.25f, 0);

        objectsTree.get(2).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(2).scaleObject(0.8f, 0.8f, 0.8f);
        objectsTree.get(2).translateObject(-0.5f, -0.2f, 0);

        objectsTree.get(3).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(3).scaleObject(0.5f, 0.5f, 0.5f);
        objectsTree.get(3).translateObject(0.3f, -0.3f, 0.3f);

        objectsTree.get(4).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(4).scaleObject(0.4f, 0.4f, 0.4f);
        objectsTree.get(4).translateObject(-0.35f, -0.35f, 0.2f);

        for (int i = 0; i < objectsTree.size(); i++) {
            objectsTree.get(i).translateObject(0,-1f,0);
            objectsTree.get(i).scaleObject(0.5f);
        }
        objectsScenery.get(0).translateObject(0,-0.5f,0);
    }


    public void input(){
        int indexOver = -1;
        int jumlah=0;
        float xx;
        float yy;
        float xlama, ylama;
        boolean lagiDalam = false;
        if (window.isKeyPressed(GLFW_KEY_Q)){
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).scaleObject(1.1f, 1.1f, 1.1f);
            scale+=1;
        }
        if (window.isKeyPressed(GLFW_KEY_Z)){
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).scaleObject(0.9f, 0.9f, 0.9f);
            scale-=1;
        }
        if (window.isKeyPressed(GLFW_KEY_X)){
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(0.9f),0, 0f, 1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)){


            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).translateObject(transX * -.02f, 0, 0);
            }
            if (scale<0) {
                for (int i = scale; i < 0; i++) {
                    for (int j = 0; j < objectsPlanet.size(); j++) {
                        objectsPlanet.get(j).scaleObject(1/0.9f, 1/0.9f, 1/0.9f);
                    }
                }
            } else {
                for (int i = 0; i < scale; i++) {
                    for (int j = 0; j < objectsPlanet.size(); j++) {
                        objectsPlanet.get(i).scaleObject(1/1.1f, 1/1.1f, 1/1.1f);
                    }
                }
            }

            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(10f), 0, 0, -1f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
            }
            for (int i = 4; i < 7; i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, 1f);
            }
            for (int i = 4; i < 7; i++)
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(19f),1f, 0f, 0);
            for (int i = 4; i < 7; i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, -1f);
            }
            if (wingPlus) {
                rotasiWing+=1;
                objectsPlanet.get(8).rotateObject((float) Math.toRadians(90f), -1f, 0, 0);
                objectsPlanet.get(9).rotateObject((float) Math.toRadians(90f), -1f, 0, 0);
                for (int i = 7; i < 10; i++)
                    objectsPlanet.get(i).rotateObject((float) Math.toRadians(-0.7f), 0, 0, 1f);
                if (rotasiWing == 5) wingPlus = false;
                objectsPlanet.get(8).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
                objectsPlanet.get(9).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            } else {
                rotasiWing-=1;
                objectsPlanet.get(8).rotateObject((float) Math.toRadians(90f), -1f, 0, 0);
                objectsPlanet.get(9).rotateObject((float) Math.toRadians(90f), -1f, 0, 0);
                for (int i = 7; i < 10; i++)
                    objectsPlanet.get(i).rotateObject((float) Math.toRadians(+0.7f), 0, 0, 1f);
                if (rotasiWing == -5) wingPlus = true;
                objectsPlanet.get(8).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
                objectsPlanet.get(9).rotateObject((float) Math.toRadians(90f), 1f, 0, 0);
            }

            //roda
            for (int i = 18; i < 24; i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, 1f);

                objectsPlanet.get(i).translateObject(-0.5f, 0.5f, -0.3f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(5f),0, 0, -1f);
                objectsPlanet.get(i).translateObject(0.5f, -0.5f, 0.3f);

                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, -1f);
            }
            for (int i = 25; i < 31; i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, 1f);

                objectsPlanet.get(i).translateObject(-0.5f, 0.5f, 0.3f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(5f),0, 0, -1f);
                objectsPlanet.get(i).translateObject(0.5f, -0.5f, -0.3f);

                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, -1f);
            }
            for (int i = 32; i < 38; i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, 1f);

                objectsPlanet.get(i).translateObject(0.7f, 0.4f, -0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(5f),0, 0, -1f);
                objectsPlanet.get(i).translateObject(-0.7f, -0.4f, -0);

                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateII * 2f), 0, 0, -1f);
            }
            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(10f), 0, 0, 1f);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, -1f, 0);
            }
            if (scale<0) {
                for (int i = scale; i < 0; i++) {
                    for (int j = 0; j < objectsPlanet.size(); j++) {
                        objectsPlanet.get(j).scaleObject(0.9f, 0.9f, 0.9f);
                    }
                }
            } else {
                for (int i = 0; i < scale; i++) {
                    for (int j = 0; j < objectsPlanet.size(); j++) {
                        objectsPlanet.get(j).scaleObject(1.1f, 1.1f, 1.1f);
                    }
                }
            }

            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).translateObject(transX * .02f, 0, 0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)){
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(2f),0, 0f, 1f);
            rotateII-=1;
        }
        if (window.isKeyPressed(GLFW_KEY_D)){
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(2f),0, 0, -1f);
            rotateII+=1;
        }
        if (window.isKeyPressed(GLFW_KEY_F)){
            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).translateObject(objectsPlanet.get(), 0, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);
                objectsPlanet.get(i).translateObject(transX*0.02f, 0, 0);
            }
            rotateI-=1;
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {
            for (int i = 0; i < objectsPlanet.size(); i++)
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(2f),0, -1f, 0);
            for (int i = 0; i < objectsTree.size(); i++)
                objectsTree.get(i).rotateObject((float) Math.toRadians(2f),0, -1f, 0);
            rotateI+=1;
        }

        if (window.isKeyPressed(GLFW_KEY_C)){
            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).translateObject(-0.02f, 0, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
            }
            transX-=1;
        }
        if (window.isKeyPressed(GLFW_KEY_V)){
            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlanet.get(i).translateObject(0.02f, 0, 0);
                objectsPlanet.get(i).rotateObject((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
            }
            transX+=1;
        }
        if (window.isKeyPressed(GLFW_KEY_P)){
            for (int i = 0; i < objectsPlanet.size(); i++) {
                objectsPlanet.get(i).translateObject(objectsPlanet.get(i).getxR(), objectsPlanet.get(i).getyR(), objectsPlanet.get(i).getzR());
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
//            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            glClearColor(46 / 255f, 124 / 255f, 220 / 255f, 0.0f);
            GL.createCapabilities();

            input();

            //code CUMA BOLE DISINI
            for (Object ob: objectsScenery) {
                ob.draw(camera, projection);
            }
            for (Object ob: objectsPlanet) {
                ob.draw(camera, projection);
            }
            for (Object ob: objectsTree) {
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
}*/
