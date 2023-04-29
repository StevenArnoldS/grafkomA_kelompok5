/*
import Engine.*;
import Engine.Object;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(650, 650, "Ini rumah!");
    private ArrayList<Object> objectsPlane = new ArrayList<>();
    private ArrayList<Object> objectsScenery = new ArrayList<>();
    private ArrayList<Object> objectsTree = new ArrayList<>();

    int rotasiWing = 0;
    boolean wingPlus = true;
    int rotateI=0;
    int rotateII=0;

    private Camera camera = new Camera();
    private Projection projection = new Projection(window.getWidth(), window.getHeight());

    boolean skali = false;
    float planeSize = 0.3f;

    Vector4f merah = new Vector4f(196 / 255f, 21 / 255f, 21 / 255f, 0.0f);
    Vector4f kuning = new Vector4f(205 / 255f, 205 / 255f, 31 / 255f, 0.0f);
    Vector4f merahTua = new Vector4f(186 / 255f, 0 / 255f, 21 / 255f, 0.0f);
    Vector4f kuningTua = new Vector4f(190 / 255f, 190 / 255f, 15 / 255f, 0.0f);

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
                    new Vector4f(0 / 255f, 100 / 255f, 0 / 255f, 0.0f), 20f, 20f, 0, 0, 0, 0, 360, 180, 7
            ));
            objectsScenery.get(0).rotateObjectNormal((float) Math.toRadians(90f), 1f,0,0);
            objectsScenery.get(0).translateObjectNormal(0,-0.5f,0);
        }
        {
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuning, .2f, .2f, 0, 0, 0.5f, -0.5f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuning, .2105f, .2105f, 0, 0, 0.2105f, 0.56f, 360, 180, 1
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuning, .2105f, .2105f, 0, 0, 0.5105f, -0.6f, 360, 180, 1
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), 0.07f, 0.07f, 0, 0, 0.12f, .76f, 360, 180, 1
            ));

            //baling baling
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.get(5).rotateObjectNormal((float) Math.toRadians(120f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.get(6).rotateObjectNormal((float) Math.toRadians(240f), 0, 0, 1f);

            //fins blkg
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.55f, 0.08f, 0.33f, 0, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(7).rotateObjectNormal((float) Math.toRadians(90f), 0, 0, 1f);
            objectsPlane.get(7).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.55f, 0.08f, 0.33f, -0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(180f), 0, 0, 1f);
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merahTua, 0.55f, 0.08f, 0.33f, 0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);

            //papan atas
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlane.get(10).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.3f, 0.5f, 0, 0, 0.05f, -0.3f, 360, 180, 3
            ));
            objectsPlane.get(11).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(180f), 0, 1f, 0);

            //papan bawah
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlane.get(13).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.3f, 0.5f, 0, 0, 0.05f, 0.3f, 360, 180, 3
            ));
            objectsPlane.get(14).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(180f), 0, 1f, 0);


            //pilar
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuningTua, .03f, .03f, 0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(16).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuningTua, .03f, .03f, -0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(17).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);

            //roda kanan
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(20).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(21).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(22).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(23).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuningTua, .03f, .03f, -0, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(24).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(24).rotateObjectNormal((float) Math.toRadians(20f), 1f, 0, 0);
            objectsPlane.get(24).translateObjectNormal(-0.0f, 0.25f, 0.2f);
            for (int i = 18; i < 25; i++) {
                objectsPlane.get(i).translateObjectNormal(-0.5f, -0.5f, -0.3f);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
            }

            //roda kiri 25-31
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(27).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(28).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(29).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(30).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuningTua, .03f, .03f, -0, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(31).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(31).rotateObjectNormal((float) Math.toRadians(20f), 1f, 0, 0);
            objectsPlane.get(31).translateObjectNormal(-0.0f, 0.25f, 0.2f);
            for (int i = 25; i < 32; i++) {
                objectsPlane.get(i).translateObjectNormal(+0.5f, -0.5f, -0.3f);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(-90f), 0, 1f, 0);
            }

            //roda belakang 32-38
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .15f, 0.15f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(34).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(35).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(36).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(37).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    kuningTua, .025f, .025f, -0, 0, 0.18f, -0.18f, 36, 18, 2
            ));
            objectsPlane.get(38).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(38).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, -1f);
            objectsPlane.get(38).translateObjectNormal(0.05f, 0.3f, 0f);
            for (int i = 32; i < 39; i++) {
                objectsPlane.get(i).translateObjectNormal(-0.7f, -0.4f, -0);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(-90f), 0, 1f, 0);
            }


            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
                objectsPlane.get(i).scaleObject(planeSize);
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
        objectsTree.get(0).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(0).translateObjectNormal(0, -0.15f, 0);

        objectsTree.get(1).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(1).scaleObject(0.6f, 0.6f, 0.6f);
        objectsTree.get(1).translateObjectNormal(0.5f, -0.25f, 0);

        objectsTree.get(2).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(2).scaleObject(0.8f, 0.8f, 0.8f);
        objectsTree.get(2).translateObjectNormal(-0.5f, -0.2f, 0);

        objectsTree.get(3).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(3).scaleObject(0.5f, 0.5f, 0.5f);
        objectsTree.get(3).translateObjectNormal(0.3f, -0.3f, 0.3f);

        objectsTree.get(4).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        objectsTree.get(4).scaleObject(0.4f, 0.4f, 0.4f);
        objectsTree.get(4).translateObjectNormal(-0.35f, -0.35f, 0.2f);

        for (int i = 0; i < objectsTree.size(); i++) {
            objectsTree.get(i).translateObjectNormal(0,-1f,0);
            objectsTree.get(i).scaleObject(0.5f);
        }
        objectsScenery.get(0).translateObjectNormal(0,-0.5f,0);
    }


    public void input(){
        int indexOver = -1;
        int jumlah=0;
        float xx;
        float yy;
        float xlama, ylama;
        boolean lagiDalam = false;
        if (window.isKeyPressed(GLFW_KEY_EQUAL)){
            for (int i = 0; i < objectsPlane.size(); i++)
                objectsPlane.get(i).scaleObject(1.1f, 1.1f, 1.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_MINUS)){
            for (int i = 0; i < objectsPlane.size(); i++)
                objectsPlane.get(i).scaleObject(0.9f, 0.9f, 0.9f);
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            //terbang(0);
            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlane.get(i).translateObject(0.02f, 0, 0);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_A)){
            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                objectsPlane.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
            }
            rotateI-=1;
        }
        if (window.isKeyPressed(GLFW_KEY_S)){
            terbang(1);
            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                objectsPlane.get(i).translateObject(-0.02f, 0, 0);
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                objectsPlane.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
                objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
            }
            rotateI+=1;
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN) || window.isKeyPressed(GLFW_KEY_Z)) {
            if (objectsPlane.get(0).getJarakY()>-0.6) {
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).translateObject(0, -0.02f,0);
                }
            }
        }
        if ((window.isKeyPressed(GLFW_KEY_UP) || window.isKeyPressed(GLFW_KEY_X))*/
/* && window.isKeyPressed(GLFW_KEY_W)*//*
) {
            */
/*for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObject(0, 0.02f,0);
            }*//*


            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                objectsPlane.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
            }
            //terbangNaik(0);
            rotateII+=0;
        }
        if (window.isKeyPressed(GLFW_KEY_P)){// woi bledos
            for (int i = 0; i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObject(objectsPlane.get(i).getxR(), objectsPlane.get(i).getyR(), objectsPlane.get(i).getzR());
            }
        }
    }

    private void terbang(int arah) {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
            objectsPlane.get(i).rotateObjectNormal((float)Math.toRadians(-objectsPlane.get(i).getRotation()), 0,1f,0);
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, -1f);
        }
        for (int i = 4; i < 7; i++)
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(19f),1f, 0f, 0);
        //sayap blkg
        if (wingPlus) {
            rotasiWing+=1;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            for (int i = 7; i < 10; i++)// fins blkg
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(-0.7f), 0, 0, 1f);
            if (rotasiWing == 5) wingPlus = false;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        } else {
            rotasiWing-=1;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            for (int i = 7; i < 10; i++)
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(+0.7f), 0, 0, 1f);
            if (rotasiWing == -5) wingPlus = true;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        }

        //roda
        for (int i = 18; i < 24; i++) {
            objectsPlane.get(i).translateObjectNormal(-0.5f*planeSize, 0.5f*planeSize, -0.3f*planeSize);
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(5f),0, 0, arah==0?-1f:1f);
            objectsPlane.get(i).translateObjectNormal(0.5f*planeSize, -0.5f*planeSize, 0.3f*planeSize);
        }
        for (int i = 25; i < 31; i++) {
            objectsPlane.get(i).translateObjectNormal(-0.5f*planeSize, 0.5f*planeSize, 0.3f*planeSize);
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(5f),0, 0, arah==0?-1f:1f);
            objectsPlane.get(i).translateObjectNormal(0.5f*planeSize, -0.5f*planeSize, -0.3f*planeSize);
        }
        for (int i = 32; i < 38; i++) {
            objectsPlane.get(i).translateObjectNormal(0.7f*planeSize, 0.4f*planeSize, 0);
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(5f),0, 0, arah==0?-1f:1f);
            objectsPlane.get(i).translateObjectNormal(-0.7f*planeSize, -0.4f*planeSize, -0);
        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            objectsPlane.get(i).rotateObjectNormal((float)Math.toRadians(objectsPlane.get(i).getRotation()), 0,1f,0);
            objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
        }
    }
    private void terbangNaik(int arah) {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
            objectsPlane.get(i).rotateObjectNormal((float)Math.toRadians(-objectsPlane.get(i).getRotation()), 0,1f,0);
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, -1f);
        }

        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            objectsPlane.get(i).rotateObjectNormal((float)Math.toRadians(objectsPlane.get(i).getRotation()), 0,1f,0);
            objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
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
            for (Object ob: objectsPlane) {
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
