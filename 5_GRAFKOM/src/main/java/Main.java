import Engine.*;
import Engine.Object;
import org.joml.Math;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(2000, 1000, "Island");
    private ArrayList<Object> objectsPlane = new ArrayList<>();
    private ArrayList<Object> objectsSailBoat = new ArrayList<>();
    private ArrayList<Object> objectsScenery = new ArrayList<>();
    private ArrayList<Object> objectsTree = new ArrayList<>();
    private ArrayList<Object> objectsHouse = new ArrayList<>();
    private ArrayList<Object> objectsCar = new ArrayList<>();
    private ArrayList<Object> kosteffan = new ArrayList<>();
    private ArrayList<Object> trunks = new ArrayList<>();
    private ArrayList<Object> beringin = new ArrayList<>();
    private ArrayList<Object> bezierRexy = new ArrayList<>();
    private ArrayList<Object> sharkFinAminSumpa = new ArrayList<>();
    private ArrayList<Object> tetrapods = new ArrayList<>();
    private ArrayList<Object> objects = new ArrayList<>();

    int rotasiWing = 0;
    int rotasiSail = 0;
    boolean wingPlus = true;
    boolean sailPlus = true;
    boolean lagiCebur = false;
    int noBrp = 1;
    int rotate1 =0;
    int rotate2 =0;
    int rotate3 =0;
    int rotate4 =0;
    int intervalAsap=0;
    int intervalAsap2=0;
    int batas =0;

    float kecepatanKapal=0.02f;
    private Camera camera = new Camera();
    private Projection projection = new Projection(window.getWidth(), window.getHeight());

    boolean skali = false;
    float planeSize = 0.3f;
    float carSize = 0.3f;
    int intervalTree = 0;
    int intervalKapal = 0;
    int intervalKapalLeft = 0;
    int intervalKapalRight = 0;
    boolean rodaMasuk = false;

    // BIRD
    private ArrayList<Object> objectsBird = new ArrayList<>();
    int wingBird = 0;
    boolean wingBirdPlus = true;
    int rotasiMouth = 0;
    boolean mouthPlus = true;
    int rotateI=0;

    private ArrayList<Object> fish = new ArrayList<>();
    int wingFish = 0;
    boolean wingFishPlus = true;
    int rotasiMouthFish = 0;
    boolean mouthFishPlus = true;
    int intervalFish = 0;
    boolean checkFish = true;
    int rotateII=0;

    private ArrayList<Object> pinWheel = new ArrayList<>();

    Vector4f merah = new Vector4f(196 / 255f, 1 / 255f, 21 / 255f, 0.0f);
    Vector4f kuning = new Vector4f(205 / 255f, 205 / 255f, 31 / 255f, 0.0f);
    Vector4f merahTua = new Vector4f(186 / 255f, 0 / 255f, 21 / 255f, 0.0f);
    Vector4f merahLebihTua = new Vector4f(176 / 255f, 0 / 255f, 11 / 255f, 0.0f);
    Vector4f warnaKapal = new Vector4f(169 / 255f, 124 / 255f, 66/ 255f, 0.0f);
    Vector4f warnaKapalTua = new Vector4f(159 / 255f, 114 / 255f, 56 / 255f, 0.0f);
    Vector4f warnaKapalTuaTua = new Vector4f(149 / 255f, 104 / 255f, 46 / 255f, 0.0f);
    Vector4f warnaKapalTuaTuaTua = new Vector4f(119 / 255f, 74 / 255f, 16 / 255f, 0.0f);
    Vector4f kuningTua = new Vector4f(190 / 255f, 190 / 255f, 15 / 255f, 0.0f);
    Vector4f abuBase = new Vector4f(63 / 255f, 63 / 255f, 63 / 255f, 1.0f);
    Vector4f abuBM = new Vector4f(55 / 255f, 55 / 255f, 55 / 255f, 1.0f);
    Vector4f abuMid = new Vector4f(50 / 255f, 50 / 255f, 50 / 255f, 1.0f);
    Vector4f abutua = new Vector4f(42 / 255f, 42 / 255f, 42 / 255f, 1.0f);
    Vector4f abumuda = new Vector4f(92 / 255f, 92 / 255f, 92 / 255f, 1.0f);
    Vector4f abugaksbrpmuda = new Vector4f(85 / 255f, 85 / 255f, 85 / 255f, 1.0f);
    Vector4f pink = new Vector4f(255 / 255f, 71 / 255f, 171 / 255f, 1.0f);
    Vector4f hitam = new Vector4f(35 / 255f, 35 / 255f, 35 / 255f, 1.0f);
    Vector4f ijotua = new Vector4f(15 / 255f, 36 / 255f, 7 / 255f, 1.0f);

    List<ShaderProgram.ShaderModuleData> shaderModuleDataList = Arrays.asList(
            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
    );

    public static void main(String[] args) {
        new Main().run();
    }

    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(0,0,3.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0f));
        //dua diatas harus paten dan gabole diganti posisinya

        //code CUMA BOLE DISINI
        {
            objectsScenery.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 100 / 255f, 0.0f), 20f, 20f, 0, 0, 0, 0, 360, 180, 7
            ));
            objectsScenery.get(0).rotateObjectNormal((float) Math.toRadians(90f), 1f,0,0);
            objectsScenery.get(0).translateObjectNormal(0,-0.8f,0);
            objectsScenery.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 100 / 255f, 0 / 255f, 0.0f), 1.5f, .005f, 0, 0, 1.5f, 0, 360, 180, 1
            ));
            objectsScenery.get(1).translateObjectNormal(0,-0.8f,0);
            objectsScenery.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(150 / 255f, 100 / 255f, 0 / 255f, 0.0f), 1.6f, .003f, 0, 0, 1.6f, 0, 360, 180, 1
            ));
            objectsScenery.get(2).translateObjectNormal(0,-0.8f,0);
            objectsScenery.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 133 / 255f, 0.0f), 1.986f, .001f, 0, 0, 1.986f, 0, 360, 180, 1
            ));
            objectsScenery.get(3).translateObjectNormal(0,-0.8f,0);
        }//scenery
        {
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    kuning, .2f, .2f, 0, 0, 0.5f, -0.5f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    kuning, .2105f, .2105f, 0, 0, 0.2105f, 0.56f, 360, 180, 1
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    kuning, .2105f, .2105f, 0, 0, 0.5105f, -0.6f, 360, 180, 1
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(80 / 255f, 80 / 255f, 80 / 255f, 0.0f), 0.07f, 0.07f, 0, 0, 0.12f, .76f, 360, 180, 1
            ));

            //baling baling
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.get(5).rotateObjectNormal((float) Math.toRadians(120f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.25f, 0.08f, 0.15f, 0, 0.06f, 0.8f, 360, 180, 4
            ));
            objectsPlane.get(6).rotateObjectNormal((float) Math.toRadians(240f), 0, 0, 1f);

            //fins blkg
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.55f, 0.08f, 0.33f, 0, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(7).rotateObjectNormal((float) Math.toRadians(90f), 0, 0, 1f);
            objectsPlane.get(7).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.55f, 0.08f, 0.33f, -0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(180f), 0, 0, 1f);
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.55f, 0.08f, 0.33f, 0.1f, 0.27f, -0.8f, 360, 180, 5
            ));
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(-8f), 1f, 0, 0);

            //papan atas
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlane.get(10).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.3f, 0.5f, 0, 0, 0.05f, -0.3f, 360, 180, 3
            ));
            objectsPlane.get(11).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, -0.3f, 360, 180, 4
            ));
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(180f), 0, 1f, 0);

            //papan bawah
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlane.get(13).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.3f, 0.5f, 0, 0, 0.05f, 0.3f, 360, 180, 3
            ));
            objectsPlane.get(14).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    merah, 0.7f, 0.5f, .5f, 0, 0.05f, 0.3f, 360, 180, 4
            ));
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(180f), 0, 1f, 0);


            //pilar
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    kuningTua, .03f, .03f, 0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(16).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    kuningTua, .03f, .03f, -0.6f, 0, 0.28f, -0.28f, 36, 18, 2
            ));
            objectsPlane.get(17).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);

            //roda kanan
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(20).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(21).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(22).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(23).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
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
                    shaderModuleDataList,
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .2f, 0.2f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(27).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(28).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(29).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
            ));
            objectsPlane.get(30).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
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
                    shaderModuleDataList,
                    new Vector4f(30 / 255f, 30 / 255f, 30 / 255f, 0.0f), .15f, 0.15f, -0, 0, 0.08f, -0.08f, 36, 18, 2
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(34).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(35).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(36).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.1f, 0.08f, 0.08f, 0, 0.19f, 0, 360, 180, 4
            ));
            objectsPlane.get(37).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

            objectsPlane.add(new Sphere(
                    shaderModuleDataList,
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
            hideTire();
        }//plane
        {
            for (int i = 0; i < 5; i++) {
                objectsTree.add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f), .12f, .12f, 0, 0, 0.5f, -0.5f, 36, 18, 2
                ));
                objectsTree.get(i).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(0 / 255f, 130 / 255f, 0 / 255f, 0.0f), .2f, .2f, 0, 0, 0.5f, -0.5f, 36, 18, 8
                ));
                objectsTree.get(i).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(0 / 255f, 140 / 255f, 0 / 255f, 0.0f), .17f, .17f, 0, 0, 0.5f, -0.8f, 36, 18, 8
                ));
                objectsTree.get(i).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(0 / 255f, 150 / 255f, 0 / 255f, 0.0f), .15f, .15f, 0, 0, 0.4f, -.95f, 36, 18, 6
                ));
            }
            objectsTree.get(0).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsTree.get(0).scaleObject(0.8f);
            objectsTree.get(0).translateObjectNormal(0.5f, -0.3f/0.8f, -0.6f);

            objectsTree.get(1).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsTree.get(1).scaleObject(0.6f);
            objectsTree.get(1).translateObjectNormal(-0.7f, -0.3f/0.6f, -0.4f);

            objectsTree.get(2).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsTree.get(2).scaleObject(0.5f);
            objectsTree.get(2).translateObjectNormal(-0.56f, -0.3f/0.5f, 0);

            objectsTree.get(3).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsTree.get(3).scaleObject(0.6f);
            objectsTree.get(3).translateObjectNormal(0.8f, -0.3f/0.6f, -0.3f);

            objectsTree.get(4).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsTree.get(4).scaleObject(0.8f);
            objectsTree.get(4).translateObjectNormal(-0.9f, -0.3f/0.8f, -0.2f);
        }//tree
        {
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(219 / 255f, 216 / 255f, 208 / 255f, 0.0f), 0.7f, 0.4f, 0, 0, 0.7f, 0, 360, 180, 3
            ));
            objectsHouse.get(0).translateObjectNormal(0,-0.6f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(209 / 255f, 206 / 255f, 198 / 255f, 0.0f), 0.5f, 0.7f, 0, 0, 0.7f, 0, 360, 180, 9
            ));
            objectsHouse.get(1).rotateObject((float) Math.toRadians(90),0,0,1f);
            objectsHouse.get(1).translateObjectNormal(0,-0.15f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.7f, 0.05f, 0, 0, 0.8f, 0, 360, 180, 3
            ));
            objectsHouse.get(2).rotateObject((float) Math.toRadians(54.5),0,0,1f);
            objectsHouse.get(2).translateObjectNormal(-0.2f,-0.15f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    merahTua, 0.7f, 0.05f, 0, 0, 0.8f, 0, 360, 180, 3
            ));
            objectsHouse.get(3).rotateObject((float) Math.toRadians(-54.5),0,0,1f);
            objectsHouse.get(3).translateObjectNormal(0.2f,-0.15f,0);
            objectsHouse.get(2).rotateObject((float) Math.toRadians(180),0,1f,0);
            objectsHouse.get(3).rotateObject((float) Math.toRadians(180),0,1f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    merahLebihTua, 0.18f, 0.5f, 0, 0, 0.18f, 0, 360, 180, 3
            ));
            objectsHouse.get(4).translateObjectNormal(0.2f,0,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(199 / 255f, 199 / 255f, 188 / 255f, 0.0f), 0.05f, 0.05f, 0, 0, 0.05f, 0, 360, 180, 1
            ));
            objectsHouse.get(5).translateObjectNormal(0.2f,0.3f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(199 / 255f, 199 / 255f, 188 / 255f, 0.0f), 0.05f, 0.05f, 0, 0, 0.05f, 0, 360, 180, 1
            ));
            objectsHouse.get(6).translateObjectNormal(0.2f,0.3f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(125 / 255f, 80 / 255f, 14 / 255f, 0.0f), 0.2f, 0.4f, 0, 0, 0.05f, 0, 360, 180, 3
            ));
            objectsHouse.get(7).translateObjectNormal(0,-0.7f,0.35f);

            //mulai dock
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(8).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(8).translateObjectNormal(1.7f,-0.75f,0.3f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(9).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(9).translateObjectNormal(1.7f,-0.75f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(10).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(10).translateObjectNormal(1.4f,-0.75f,0.3f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(11).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(11).translateObjectNormal(1.4f,-0.75f,0);
            //mulai papan
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(12).rotateObjectNormal((float) Math.toRadians(2f),0,1,0);
            objectsHouse.get(12).translateObjectNormal(1.4f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(13).rotateObjectNormal((float) Math.toRadians(-1f),0,1,0);
            objectsHouse.get(13).translateObjectNormal(1.5f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(14).rotateObjectNormal((float) Math.toRadians(-2f),0,1,0);
            objectsHouse.get(14).translateObjectNormal(1.6f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(15).rotateObjectNormal((float) Math.toRadians(1f),0,1,0);
            objectsHouse.get(15).translateObjectNormal(1.7f,-0.75f,0.15f);

            //dock lagi
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(16).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(16).translateObjectNormal(2f,-0.75f,0.3f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(17).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(17).translateObjectNormal(2f,-0.75f,0);

            //papan lagi

            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(18).rotateObjectNormal((float) Math.toRadians(-1f),0,1,0);
            objectsHouse.get(18).translateObjectNormal(1.8f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(19).rotateObjectNormal((float) Math.toRadians(2f),0,1,0);
            objectsHouse.get(19).translateObjectNormal(1.9f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.08f, 0.02f, 0, 0, 0.45f, 0, 360, 180, 3
            ));
            objectsHouse.get(20).rotateObjectNormal((float) Math.toRadians(-1f),0,1,0);
            objectsHouse.get(20).translateObjectNormal(2f,-0.75f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.04f, 0.04f, 0, 0, 0.08f, 0, 360, 180, 10
            ));
            objectsHouse.get(21).rotateObjectNormal((float) Math.toRadians(-90f),1,0,0);
            objectsHouse.get(21).translateObjectNormal(2f,-0.75f,0);
            List<float[]> taliRafia = Arrays.asList(
                    new float[]{2f,0,0},
                    new float[]{1.9f,-0.2f,0},
                    new float[]{1.8f,+0.1f,0},
                    new float[]{1.7f,-0.2f,0},
                    new float[]{1.6f,+0.4f,0},
                    new float[]{1.5f,-0.2f,0},
                    new float[]{1.4f,+0.1f,0},
                    new float[]{1.3f,-0f,0},
                    new float[]{1.2f,+0.4f,0},
                    new float[]{1.1f,-0.2f,0},
                    new float[]{1.0f,+0.1f,0},
                    new float[]{0.7f,-0.28f,0},
                    new float[]{0.7f,-0.38f,0}
            );
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    warnaKapalTuaTuaTua,
                    taliRafia, 10f
            ));
            objectsHouse.get(22).rotateObjectNormal((float) Math.toRadians(90f), 1,0,0);
            objectsHouse.get(22).translateObjectNormal(0,-0.72f,0);
            List<float[]> asapRafia = Arrays.asList(
                    new float[]{0f, 0f, 0f},
                    new float[]{0.1f, 0.1f, 0f},
                    new float[]{0.1f, 0.2f, 0f},
                    new float[]{-0.15f, 0.2f, 0f},
                    new float[]{-0.15f, 0.3f, 0f},
                    new float[]{0.15f, 0.3f, 0f},
                    new float[]{0.15f, 0.4f, 0f},
                    new float[]{-0.125f, 0.4f, 0f}
            );
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(109 / 255f, 106 / 255f, 98 / 255f, 0.0f),
                    asapRafia, 5f
            ));
            objectsHouse.get(23).rotateObjectNormal((float) java.lang.Math.toRadians(180f), 0,0,1);
            objectsHouse.get(23).translateObjectNormal(-1.2f, -0.3f, 0.15f);


            //trunks
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(60 / 255f, 30 / 255f, 0 / 255f, 0.0f),
                    .03f, .03f,
                    0, 0,
                    0.04f, -0.3f,
                    36, 18, 2
            ));
//                trunks.get()
            objectsHouse.get(24).rotateObjectNormal((float)Math.toRadians(25),1,0,0);
            objectsHouse.get(24).rotateObjectNormal((float)Math.toRadians(35),0,1,0);
            objectsHouse.get(24).translateObjectNormal(-1.1f,-0.73f,0.3f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
                    .03f, .03f,
                    0, 0,
                    0.04f, -0.3f,
                    36, 18, 2
            ));
//                trunks.get()
            objectsHouse.get(25).rotateObjectNormal((float)Math.toRadians(25),1,0,0);
            objectsHouse.get(25).rotateObjectNormal((float)Math.toRadians(120),0,1,0);
            objectsHouse.get(25).translateObjectNormal(-1f,-0.73f,0.15f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(80 / 255f, 50 / 255f, 0 / 255f, 0.0f),
                    .03f, .03f,
                    0, 0,
                    0.04f, -0.3f,
                    36, 18, 2
            ));
//                trunks.get()
            objectsHouse.get(26).rotateObjectNormal((float)Math.toRadians(25),1,0,0);
            objectsHouse.get(26).rotateObjectNormal((float)Math.toRadians(280),0,1,0);
            objectsHouse.get(26).translateObjectNormal(-1.4f,-0.73f,0.2f);





            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(196 / 255f, 150 / 255f, 21 / 255f, 0.0f), 0.5f, 0.5f, 0, 0, 0.5f, 0, 360, 180, 1
            ));
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(196 / 255f, 196 / 255f, 21 / 255f, 0.0f), 0.28f, 0.28f, 0, 0, 0.5f, -1.03f, 360, 180, 8
            ));
            objectsHouse.get(28).rotateObject((float) Math.toRadians(90f), 1,0,0);
            for (int i = 27; i< 29; i++) {
                objectsHouse.get(i).scaleObject(0.2f);
                objectsHouse.get(i).translateObjectNormal(-1.2f, -0.6f, 0.17f);
            }

            List<float[]> raiiinbow = Arrays.asList(
                    new float[]{0f, -1f, 0f},
                    new float[]{1f, 1f, 0f},
                    new float[]{2f, -1, 0f}
            );
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(200 / 255f, 0 / 255f, 200 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(29).translateObjectNormal(-1,0,0);
            objectsHouse.get(29).scaleObject(6f);
            objectsHouse.get(29).translateObjectNormal(-0,1,-5);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(0 / 255f, 0 / 255f, 200 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(30).translateObjectNormal(-1,0,0);
            objectsHouse.get(30).scaleObject(7f);
            objectsHouse.get(30).translateObjectNormal(-0,1.2f,-5);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(0 / 255f, 200 / 255f, 0 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(31).translateObjectNormal(-1,0,0);
            objectsHouse.get(31).scaleObject(8f);
            objectsHouse.get(31).translateObjectNormal(-0,1.4f,-5);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(200 / 255f, 200 / 255f, 0 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(32).translateObjectNormal(-1,0,0);
            objectsHouse.get(32).scaleObject(9f);
            objectsHouse.get(32).translateObjectNormal(-0,1.6f,-5);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(200 / 255f, 100 / 255f, 0 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(33).translateObjectNormal(-1,0,0);
            objectsHouse.get(33).scaleObject(10f);
            objectsHouse.get(33).translateObjectNormal(-0,1.8f,-5);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(200 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    raiiinbow, 25f
            ));
            objectsHouse.get(34).translateObjectNormal(-1,0,0);
            objectsHouse.get(34).scaleObject(11f);
            objectsHouse.get(34).translateObjectNormal(-0,2f,-5);


            //batang kursi
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.025f, 0.025f, 0, 0, 0.5f, 0, 360, 180, 2
            ));

            objectsHouse.get(35).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(35).translateObjectNormal(-.8f,-0.6f,0.6f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.025f, 0.025f, 0, 0, 0.5f, 0, 360, 180, 2
            ));

            objectsHouse.get(36).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(36).translateObjectNormal(-1f,-0.6f,0.6f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.025f, 0.025f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(37).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(37).translateObjectNormal(-.8f,-0.75f,0.72f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTuaTua, 0.025f, 0.025f, 0, 0, 0.2f, 0, 360, 180, 2
            ));

            objectsHouse.get(38).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(38).translateObjectNormal(-1f,-0.75f,0.72f);

            //papan kursi
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.05f, 0.02f, 0, 0, 0.3f, 0, 360, 180, 3
            ));
            objectsHouse.get(39).rotateObjectNormal((float) Math.toRadians(89f),0,1,0);
            objectsHouse.get(39).translateObjectNormal(-.9f,-0.75f,0.72f);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, 0.05f, 0.02f, 0, 0, 0.3f, 0, 360, 180, 3
            ));
            objectsHouse.get(40).rotateObjectNormal((float) Math.toRadians(92f),0,1,0);
            objectsHouse.get(40).translateObjectNormal(-.9f,-0.75f,0.65f);

            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.05f, 0.02f, 0, 0, 0.3f, 0, 360, 180, 3
            ));
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, 0.05f, 0.02f, 0, 0, 0.3f, 0, 360, 180, 3
            ));
            for (int i = 41; i<=42;i++) {
                objectsHouse.get(i).rotateObject((float) Math.toRadians(90f), 0,1,0);
            }
            objectsHouse.get(42).rotateObjectNormal((float) Math.toRadians(92f),1,0,0);
            objectsHouse.get(42).translateObjectNormal(-.9f,-0.68f,0.63f);
            objectsHouse.get(41).rotateObjectNormal((float) Math.toRadians(89f),1,0,0);
            objectsHouse.get(41).translateObjectNormal(-.9f,-0.62f,0.63f);
            for (int i = 35; i<=42;i++) {
                objectsHouse.get(i).translateObjectNormal( -0.25f,0,-0.3f);
                objectsHouse.get(i).rotateObject((float) Math.toRadians(13f), 0,1,0);
            }

            //fountain
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    abutua, .5f, 0.5f, 0, 0, 0.5f, 0, 5, 360, 10
            ));
            objectsHouse.get(43).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(43).translateObjectNormal(-0,-0.3f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    abuBase, .5f, 0.5f, 0, 0, 0.5f, 0, 5, 360, 10
            ));
            objectsHouse.get(44).scaleObject(0.4f);
            objectsHouse.get(44).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(44).translateObjectNormal(-0,-0f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 183 / 255f, 0.0f), .5f, 0.5f, 0, 0, 0.5f, 0, 5, 360, 10
            ));
            objectsHouse.get(45).scaleObject(0.8f);
            objectsHouse.get(45).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(45).translateObjectNormal(-0,-0.3f,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 203 / 255f, 0.0f), .5f, 0.5f, 0, 0, 0.5f, 0, 5, 360, 10
            ));
            objectsHouse.get(46).scaleObject(0.36f);
            objectsHouse.get(46).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(46).translateObjectNormal(-0,-0,0);
            List<float[]> airRafia = Arrays.asList(
                    new float[]{0,0,0},
                    new float[]{0.5f,0.25f,0},
                    new float[]{-1f,+0.3f,0}
            );
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(47).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(47).rotateObjectNormal((float) Math.toRadians(0f),0,1,0);
            objectsHouse.get(47).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(48).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(48).rotateObjectNormal((float) Math.toRadians(45f),0,1,0);
            objectsHouse.get(48).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(49).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(49).rotateObjectNormal((float) Math.toRadians(90f),0,1,0);
            objectsHouse.get(49).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(50).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(50).rotateObjectNormal((float) Math.toRadians(135f),0,1,0);
            objectsHouse.get(50).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(51).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(51).rotateObjectNormal((float) Math.toRadians(180f),0,1,0);
            objectsHouse.get(51).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(52).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(52).rotateObjectNormal((float) Math.toRadians(225f),0,1,0);
            objectsHouse.get(52).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(53).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(53).rotateObjectNormal((float) Math.toRadians(270f),0,1,0);
            objectsHouse.get(53).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Bezier(
                    shaderModuleDataList,
                    new ArrayList<>(),
                    new Vector4f(100 / 255f, 100 / 255f, 255/ 255f, 0.0f),
                    airRafia, 5f
            ));
            objectsHouse.get(54).rotateObjectNormal((float) Math.toRadians(90f),0,0,1);
            objectsHouse.get(54).rotateObjectNormal((float) Math.toRadians(315f),0,1,0);
            objectsHouse.get(54).translateObjectNormal(-0,-0,0);
            objectsHouse.add(new Sphere(
                    shaderModuleDataList,
                    abuBase, .25f, 0.25f, 0, 0, 0.5f, -0.5f, 5, 360, 2
            ));
            objectsHouse.get(55).scaleObject(0.4f);
            objectsHouse.get(55).rotateObjectNormal((float) Math.toRadians(90f),1,0,0);
            objectsHouse.get(55).translateObjectNormal(-0,-0.3f,0);



            for (int i = 43; i<=55;i++) {
                objectsHouse.get(i).scaleObject(0.6f);
                objectsHouse.get(i).translateObjectNormal(-0.8f,-0.55f,-0.8f);
            }
        }//house
        {
            objectsSailBoat.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapal, .5f, 0.2f, 0, 0, 0.2f, 0, 5, 180, 10
            ));
            objectsSailBoat.get(0).rotateObjectNormal((float) Math.toRadians(-90f), 0,1,0);
            objectsSailBoat.get(0).rotateObjectNormal((float) Math.toRadians(90f), 0,0,1);
            objectsSailBoat.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, .45f, 0.15f, 0, 0, 0.15f, 0, 5, 180, 10
            ));
            objectsSailBoat.get(1).rotateObjectNormal((float) Math.toRadians(-90f), 0,1,0);
            objectsSailBoat.get(1).rotateObjectNormal((float) Math.toRadians(90f), 0,0,1);
            objectsSailBoat.add(new Sphere(
                    shaderModuleDataList,
                    warnaKapalTua, 0.015f, 0.015f, 0, 0, 0.6f, 0, 72, 180, 2
            ));
            objectsSailBoat.get(2).rotateObjectNormal((float) Math.toRadians(-90f), 1,0,0);
            objectsSailBoat.get(2).translateObjectNormal(0,-0.05f,0);
            objectsSailBoat.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(209 / 255f, 206 / 255f, 198 / 255f, 0.0f), 0.35f, 0.25f, 0, 0, 0.15f, 0, 180, 180, 11
            ));
            objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(-90), 0,0,1);
            objectsSailBoat.get(3).translateObjectNormal(0,0.18f,0.02f);
            for (int i = 0; i < objectsSailBoat.size(); i++) {
                objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
            }

            for(int i = 0; i < objectsSailBoat.size(); i++) {
                objectsSailBoat.get(i).scaleObject(0.6f);
                objectsSailBoat.get(i).translateObject(0,-0.75f,0);
            }
        }//boat
        {
            // main body
            objectsCar.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(18 / 255f, 46 / 255f, 100 / 255f, 0.0f),
                    0.7f, .38f,
                    -0.15f, 0.05f,
                    0.5f, -0.5f,
                    36, 18, 3
            ));

            // 4 RODA MOBIL
            {
                //roda depan kanan
                {
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(41 / 255f, 41 / 255f, 41 / 255f, 0.0f), .2f, 0.2f, -0, 0,
                            0.08f, -0.08f, 36, 18, 2
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(2).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(3).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(4).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(5).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

                    for (int i = 1; i < 7; i++) {
                        objectsCar.get(i).translateObjectNormal(0.25f, -0.15f, -0.3f);
                    }
                }

                //roda depan kiri
                {
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(41 / 255f, 41 / 255f, 41 / 255f, 0.0f), .2f, 0.2f, -0, 0,
                            0.08f, -0.08f, 36, 18, 2
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(9).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(10).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(11).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(12).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

                    for (int i = 7; i < 13; i++) {
                        objectsCar.get(i).translateObjectNormal(0.25f, -0.15f, -0.73f);
                    }
                }
                //roda belakang kanan
                {
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(41 / 255f, 41 / 255f, 41 / 255f, 0.0f), .2f, 0.2f, -0, 0,
                            0.08f, -0.08f, 36, 18, 2
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(15).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(16).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(17).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(18).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

                    for (int i = 13; i < 19; i++) {
                        objectsCar.get(i).translateObjectNormal(-0.45f, -0.15f, -0.3f);
                    }
                }
                //roda belakang kiri
                {
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(41 / 255f, 41 / 255f, 41 / 255f, 0.0f), .2f, 0.2f, -0, 0,
                            0.08f, -0.08f, 36, 18, 2
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(21).rotateObjectNormal((float) Math.toRadians(72f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(22).rotateObjectNormal((float) Math.toRadians(144f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(23).rotateObjectNormal((float) Math.toRadians(216f), 0, 0, 1f);
                    objectsCar.add(new Sphere(
                            shaderModuleDataList,
                            new Vector4f(120 / 255f, 120 / 255f, 120 / 255f, 0.0f), 0.2f, 0.08f, 0.08f, 0, 0.2f, 0, 360, 180, 4
                    ));
                    objectsCar.get(24).rotateObjectNormal((float) Math.toRadians(288f), 0, 0, 1f);

                    for (int i = 19; i < 25; i++) {
                        objectsCar.get(i).translateObjectNormal(-0.45f, -0.15f, -0.73f);
                    }
                }

                // SCALE RODA
//                {
//
//                    // roda depan kanan
//                    for (int i = 1; i < 7; i++) {
//                        objectsCar.get(i).translateObjectNormal(-0.5f,0,0);
//                    }
////                    // roda depan kiri
////                    for (int i = 7; i < 13; i++) {
////                        objectsCar.get(i).translateObjectNormal(-0.5f * 0.4f, 0.5f * 0.4f, -0.3f * 0.4f);
////                        semuaItem.scaleObject(0.35f);
////                        objectsCar.get(i).translateObjectNormal(0.5f * 0.4f, -0.5f * 0.4f, 0.3f * 0.4f);
////                    }
////                    // roda blkg kanan
////                    for (int i = 13; i < 19; i++) {
////                        objectsCar.get(i).translateObjectNormal(1.15f*0.4f, 0.15f*0.4f, 0);
////                        semuaItem.scaleObject(0.35f);
////                        objectsCar.get(i).translateObjectNormal(-1.15f*0.4f, -0.15f*0.4f, -0);
////                    }
////                    // roda blkg kiri
////                    for (int i = 19; i < 25; i++) {
////                        objectsCar.get(i).translateObjectNormal(1.15f*0.4f, 0.15f*0.4f, 0);
////                        semuaItem.scaleObject(0.35f);
////                        objectsCar.get(i).translateObjectNormal(-1.15f*0.4f, -0.15f*0.4f, -0);
////                    }
//                }

            }

            // kap + ekor mobil
            {
                // kap mobil
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(18 / 255f, 46 / 255f, 100 / 255f, 0.0f),
                        0.8f, .28f,
                        0.2f, -0.01f,
                        0.5f, -0.5f,
                        36, 18, 3
                ));

                // ekor mobil
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(18 / 255f, 46 / 255f, 100 / 255f, 0.0f),
                        0.8f, .28f,
                        -0.35f, -0.01f,
                        0.5f, -0.5f,
                        36, 18, 3
                ));


                // hatch back
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(18 / 255f, 46 / 255f, 100 / 255f, 0.0f),
                        0.26f, .15f,
                        -0.35f, 0.4f,
                        0.5f, -0.5f,
                        36, 18, 3
                ));
                objectsCar.get(0).getChildObject().get(2).rotateObjectNormal((float) Math.toRadians(37),0,0,1f);


//                // hatch front
//                objectsCar.get(0).getChildObject().add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                        ),
//                        new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
//                        0.26f, .15f,
//                        -0.35f, 0.4f,
//                        0.5f, -0.5f,
//                        36, 18, 3
//                ));
//                objectsCar.get(0).getChildObject().get(3).rotateObjectNormal((float) Math.toRadians(-30),0,0,1f);
//                objectsCar.get(0).getChildObject().get(3).translateObjectNormal(0.3f,-0.41f,0);
            }

            // lampu depan
            {
                // lampu depan kiri
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(255 / 255f, 226 / 255f, 27 / 255f, 0.0f),
                        0.1f, 0.1f,
                        0.6f, -0.01f,
                        0.12f, -0.65f,
                        36, 18, 3
                ));


                // lampu depan kanan
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(255 / 255f, 226 / 255f, 27 / 255f, 0.0f),
                        0.1f, 0.1f,
                        0.6f, -0.01f,
                        0.12f, -0.35f,
                        36, 18, 3
                ));
            }

            // lampu belakang
            {
                // lampu depan kiri
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(255 / 255f, 15 / 255f, 27 / 255f, 0.0f),
                        0.1f, 0.1f,
                        -0.72f, -0.01f,
                        0.12f, -0.65f,
                        36, 18, 3
                ));


                // lampu depan kanan
                objectsCar.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(255 / 255f, 15 / 255f, 27 / 255f, 0.0f),
                        0.1f, 0.1f,
                        -0.72f, -0.01f,
                        0.12f, -0.35f,
                        36, 18, 3
                ));
            }

            // kecilin sama turunin mobil
            for(int h = 0; h < 25; h++){
                objectsCar.get(h).scaleObject(carSize);
                objectsCar.get(h).translateObject(0,-0.685f,0);
            }

        }//car
        {
            kosteffan.add(new Sphere(
                    shaderModuleDataList,
                    abuBase, 0.5f, 1.0f,
                    0f, 0f,
                    0.4f,
                    0f,
                    360,
                    180, 3
            ));
//        kosteffan.get(0).rotateObjectNormal((float) Math.toRadians(90f), 1f,0,0);
//        kosteffan.get(0).translateObjectNormal(0,-0.8f,0);


//        kosteffan.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                abuBase,
//                0.3f, 0.4f,
//                0.2f, 0f,
//                0.3f,
//                0f,
//                360,
//                180, 1
//        ));
//        Object kepalabase = kosteffan.get(0).getChildObject().get(0);
//        kepalabase.translateObjectNormal(-0.1f,0.0f,0.1f);


            // hidung
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    abuMid,
                    0.4f, 0.4f,
                    0.2f, 0f,
                    0.2f,
                    0f,
                    360,
                    180, 3
            ));
            Object hidung = kosteffan.get(0).getChildObject().get(0);
            hidung.rotateObjectNormal((float) Math.toRadians(20), 0, 0, 1);
            hidung.translateObjectNormal(-0.05f, 0, 0);


            // dahi
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    abuBase,
                    0.25f, 0.2f,
                    0f, 0f,
                    0.4f,
                    0f,
                    360,
                    180, 3
            ));
            Object dahi = kosteffan.get(0).getChildObject().get(1);
//        dahi.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
            dahi.translateObjectNormal(0.24f, 0.44f, 0.0f);


            // dagu
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    abuBase,
                    0.4f, 0.2f,
                    0f, 0f,
                    0.4f,
                    0f,
                    360,
                    180, 3
            ));
            Object dagu = kosteffan.get(0).getChildObject().get(2);
            dagu.rotateObjectNormal((float) Math.toRadians(-65), 0, 0, 1);
            dagu.translateObjectNormal(0.24f, -0.3f, 0.0f);


//        // bibir
//        kosteffan.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                pink,
//                0.23f, 0.04f,
//                0f, 0f,
//                0.3f,
//                0f,
//                360,
//                180, 3
//        ));
//        Object bibir = kosteffan.get(0).getChildObject().get(3);
////        bibir.rotateObjectNormal((float)Math.toRadians(-65),0,0,1);
//        bibir.translateObjectNormal(0.24f,-0.2f,0.0f);


            // mata kanan
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList, hitam,
                    0.25f, 0.2f,
                    0f, 0f,
                    0.38f,
                    0f,
                    360,
                    180, 3
            ));
            Object matakanan = kosteffan.get(0).getChildObject().get(3);
//        dahi.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
            matakanan.translateObjectNormal(0.14f, 0.24f, 0.0f);


            // bibirdower belakang Z
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    pink,
                    0.04f, 0.04f,
                    0f, 0f,
                    0.1f,
                    0f,
                    360,
                    180, 8
            ));
            Object bibirdower = kosteffan.get(0).getChildObject().get(4);
//        bibir.rotateObjectNormal((float)Math.toRadians(-65),0,0,1);
            bibirdower.translateObjectNormal(0.3f, -0.21f, -0.15f);


            // bibirdower depan Z
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    pink,
                    0.04f, 0.04f,
                    0f, 0f,
                    0.1f,
                    0f,
                    360,
                    180, 8
            ));
            Object bibirdowerdepan = kosteffan.get(0).getChildObject().get(5);
            bibirdowerdepan.rotateObjectNormal((float) Math.toRadians(-180), 1, 0, 0);
            bibirdowerdepan.translateObjectNormal(0.3f, -0.21f, 0.15f);


            // bibirdower belakang Z ATAS
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    pink,
                    0.04f, 0.04f,
                    0f, 0f,
                    0.1f,
                    0f,
                    360,
                    180, 8
            ));
            Object bibirdowerATAS = kosteffan.get(0).getChildObject().get(6);
//        bibir.rotateObjectNormal((float)Math.toRadians(-65),0,0,1);
            bibirdowerATAS.translateObjectNormal(0.3f, -0.15f, -0.22f);
            bibirdowerATAS.rotateObjectNormal((float) Math.toRadians(-15), 1, 0, 0);


            // bibirdower depan Z ATAS
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    pink,
                    0.04f, 0.04f,
                    0f, 0f,
                    0.1f,
                    0f,
                    360,
                    180, 8
            ));
            Object bibirdowerdepanATAS = kosteffan.get(0).getChildObject().get(7);
            bibirdowerdepanATAS.rotateObjectNormal((float) Math.toRadians(180), 1, 0, 0);
            bibirdowerdepanATAS.translateObjectNormal(0.3f, -0.15f, 0.22f);
            bibirdowerdepanATAS.rotateObjectNormal((float) Math.toRadians(15), 1, 0, 0);


            // telinga depan
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    abuMid,
                    0.2f, 0.4f,
                    0f, 0f,
                    0.4f,
                    0f,
                    360,
                    180, 3
            ));
            Object telingadepan = kosteffan.get(0).getChildObject().get(8);
//        telinga.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
            telingadepan.translateObjectNormal(0.0f, 0.12f, 0.1f);


            // telinga belakang
            kosteffan.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    abuMid,
                    0.2f, 0.4f,
                    0f, 0f,
                    0.4f,
                    0f,
                    360,
                    180, 3
            ));
            Object telinga = kosteffan.get(0).getChildObject().get(9);
//        telinga.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
            telinga.translateObjectNormal(0.0f, 0.12f, -0.1f);

//        // bola mata blkg
//        kosteffan.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                merah,
//                0.03f, 0.03f,
//                0f, 0f,
//                0.03f,
//                0f,
//                360,
//                180, 1
//        ));
//        Object bolamata = kosteffan.get(1);
////        bolamata.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
//        bolamata.translateObjectNormal(0.24f,0.24f,-0.1f);
//
//
//        // bola mata dpn
//        kosteffan.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                merah,
//                0.03f, 0.03f,
//                0f, 0f,
//                0.03f,
//                0f,
//                360,
//                180, 1
//        ));
//        Object bolamataDEPAN = kosteffan.get(2);
////        bolamata.rotateObjectNormal((float)Math.toRadians(20),0,0,1);
//        bolamataDEPAN.translateObjectNormal(0.24f,0.24f,0.1f);


            for (int i = 0; i < kosteffan.size(); i++) {
                kosteffan.get(i).rotateObjectNormal((float) Math.toRadians(10), 0, 0, 1);
                kosteffan.get(i).rotateObject((float) Math.toRadians(-45), 0, 1, 0);
                kosteffan.get(i).rotateObject((float) Math.toRadians(-180), 0, 1, 0);
                kosteffan.get(i).translateObjectNormal(0, -0.3f, -0.8f);
            }
        }// ko steffan
        {
            // batang pohon
            {
                trunks.add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
                        .05f, .05f,
                        0, 0,
                        0.03f, -0.3f,
                        36, 18, 2
                ));
//                trunks.get()
                trunks.get(0).rotateObjectNormal((float)Math.toRadians(35),0,1,0);
                trunks.get(0).translateObjectNormal(0.8f,-0.73f,0f);

                trunks.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
                        .05f, .05f,
                        0, 0,
                        0.03f, -0.3f,
                        36, 18, 2
                ));
                trunks.get(0).getChildObject().get(0).rotateObjectNormal((float)Math.toRadians(35),0,1
                        ,0);
                trunks.get(0).getChildObject().get(0).translateObjectNormal(0.65f,-0.73f,-0.16f);
                trunks.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-30),0,1,0);

                // kerikils
                trunks.add(new Sphere(
                        shaderModuleDataList,
                        abutua,
                        .05f, .05f,
                        0, 0,
                        0.05f, -0.3f,
                        36, 18, 1
                ));
                trunks.get(1).translateObjectNormal(0.5f, -0.8f, -0.8f);

                for(int jumlahBatu = 0; jumlahBatu<20;jumlahBatu++){
                    if (jumlahBatu!=2) {
                        trunks.get(1).getChildObject().add(new Sphere(
                                shaderModuleDataList,
                                abutua,
                                .05f, .05f,
                                0, 0,
                                0.05f, -0.3f,
                                36, 18, 1
                        ));
                    }else{
                        trunks.get(1).getChildObject().add(new Sphere(
                                shaderModuleDataList,
                                abutua,
                                .08f, .05f,
                                0, 0,
                                0.05f, -0.3f,
                                36, 18, 1
                        ));
                    }
                    trunks.get(1).getChildObject().get(jumlahBatu).translateObjectNormal(0.5f, -0.8f, -0.8f);
                }

                trunks.get(1).getChildObject().get(1).translateObject(-0.1f,0,0);
                trunks.get(1).getChildObject().get(2).translateObject(-1.2f,0.0f,1.40f);
                trunks.get(1).getChildObject().get(3).translateObject(-1.3f,0.0f,1.50f);
                trunks.get(1).getChildObject().get(4).translateObject(-0.05f,0.0f,1.40f);

                // dkt maoi
                trunks.get(1).getChildObject().get(5).translateObject(-0.3f,0f,0.4f);
                trunks.get(1).getChildObject().get(6).translateObject(-0.2f,0f,0.4f);
                trunks.get(1).getChildObject().get(7).translateObject(-0.25f,0f,0.5f);




            }
        } // trunks
        {
            // batang pohon
            {
//                beringin.add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                        ),
//                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
//                        .12f, .12f,
//                        0, 0,
//                        0.3f, -0.5f,
//                        36, 18, 2
//                ));
//                Object batang = beringin.get(0);
//                batang.rotateObjectNormal((float)Math.toRadians(90),1,0,0);

                beringin.add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
                        0.2f, 0.6f,
                        0, 0,
                        0.7f, -0.5f,
                        36, 18, 8
                ));
                Object akar = beringin.get(0);
                akar.rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                akar.translateObject(0f,-0.0f,0f);


                beringin.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(70 / 255f, 40 / 255f, 0 / 255f, 0.0f),
                        0.5f, .2f,
                        0, 0,
                        1f, -0.5f,
                        36, 18, 8
                ));
                Object akar2 = akar.getChildObject().get(0);
//                Object akar2 = beringin.get(1);
                akar2.rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                akar2.translateObject(0f,0.2f,0f);


                beringin.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(80 / 255f, 45 / 255f, 10 / 255f, 0.0f),
                        .3f, .3f,
                        0, 0, 2f, -0.5f,
                        36, 18, 2
                ));
                Object batang = akar.getChildObject().get(1);
//                Object batang = beringin.get(2);
                batang.rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                batang.translateObjectNormal(-0f,0.5f,-0f);
                akar.translateObjectNormal(-0.8f,-0.3f,-1f);
            }

            // daun"
            {
                beringin.add(new Sphere(
                        shaderModuleDataList,
                        new Vector4f(8 / 255f, 87 / 255f, 19 / 255f, 0.0f),
                        1.2f, 1.3f,
                        0, 0,
                        0.6f, -0.5f,
                        36, 18, 10
                ));
                Object daunberingin = beringin.get(1);
                daunberingin.rotateObjectNormal((float)Math.toRadians(-90),1,0,0);
                daunberingin.translateObjectNormal(-0.7f,1.3f,-0.8f);
            }
//
//            for (int beringinItem = 0;beringinItem<beringin.size();beringinItem++){
//                beringin.get(beringinItem).translateObjectNormal(1.8f,0f,-0.3f);
//            }
        }//beringin

        {
//            float[] hm = [0.1f,0.4f];
//            List<float[]> tes = new ArrayList<>();
//            tes.add(hm);
            Object daunBeringin = beringin.get(1);
            List<float[]> akarA = Arrays.asList(
                    new float[]{0f, 0f, 0f},
                    new float[]{0.2f, 0.2f, 0f},
                    new float[]{0.2f, 0.4f, 0f},
                    new float[]{-0.3f, 0.4f, 0f},
                    new float[]{-0.3f, 0.6f, 0f},
                    new float[]{0.3f, 0.6f, 0f},
                    new float[]{0.3f, 0.8f, 0f},
                    new float[]{-0.25f, 0.8f, 0f},
                    new float[]{-0.17f, 0.88f, 0f},
                    new float[]{-0.24f, 0.94f, 0f}
            );

            List<float[]> akarB = Arrays.asList(
                    new float[]{0f, 0f, 0f},
                    new float[]{-0.2f, 0.2f, 0f},
                    new float[]{-0.2f, 0.4f, 0f},
                    new float[]{0.3f, 0.4f, 0f},
                    new float[]{0.3f, 0.6f, 0f},
                    new float[]{-0.3f, 0.6f, 0f},
                    new float[]{-0.3f, 0.8f, 0f},
                    new float[]{0.25f, 0.8f, 0f},
                    new float[]{0.17f, 0.88f, 0f},
                    new float[]{0.24f, 0.94f, 0f}
            );

            {
                {
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier(
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarB, 3f
                    ));
                } // akar gantung 1-7

                {
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 8
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 9
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,
                            akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 10
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 11
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarB, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 12
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarA, 3f
                    ));
                    daunBeringin.getChildObject().add(new Bezier( // NOMER 13
                            shaderModuleDataList,
                            new ArrayList<>(),
                            ijotua,akarA, 3f
                    ));
                } // akar gantung
            }
            for (int counter = 0; counter < daunBeringin.getChildObject().size() / 2; counter++) {
                daunBeringin.getChildObject().get(counter).translateObject(2f, 0.1f, 0.0f);
            }

            // geser" akar gantung
            {
                daunBeringin.getChildObject().get(0).translateObjectNormal(0.0f,-0.0f,0.0f);
                daunBeringin.getChildObject().get(1).translateObjectNormal(0.2f,-0.05f,0.0f);
                daunBeringin.getChildObject().get(2).translateObjectNormal(0.2f,0.0f,-0.8f);
                daunBeringin.getChildObject().get(3).translateObjectNormal(-0.4f,0.3f,-0.5f);
                daunBeringin.getChildObject().get(4).translateObjectNormal(-0.8f,0.4f,-0.5f);
                daunBeringin.getChildObject().get(5).translateObjectNormal(-0.4f,-0.05f,-1.2f);
                daunBeringin.getChildObject().get(6).translateObjectNormal(-0.9f,0.2f,-0.7f);
                daunBeringin.getChildObject().get(7).translateObjectNormal(-0.4f,-0.05f,-0.5f);
                daunBeringin.getChildObject().get(8).translateObjectNormal(-1.2f,0.2f,-0.2f);
                daunBeringin.getChildObject().get(9).translateObjectNormal(-1.2f,0.2f,-1.7f);
                daunBeringin.getChildObject().get(10).translateObjectNormal(-0.6f,0.1f,-1.7f);
                daunBeringin.getChildObject().get(11).translateObjectNormal(-1.2f,0.2f,-1.2f);
                daunBeringin.getChildObject().get(12).translateObjectNormal(-1.5f,0.0f,-1.2f);
                daunBeringin.getChildObject().get(13).translateObjectNormal(0.0f,0.2f,-0.4f);
            } // geser" akar gantung

            // buah ta daun mbo
            {
//                daunBeringin.getChildObject().get(0).getChildObject().add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                        ),
//                        new Vector4f(18 / 255f, 46 / 255f, 100 / 255f, 0.0f),
//                        0.7f, .7f,
//                        0.0f, 0.0f,
//                        0.7f, 0.0f,
//                        36, 18, 1
//                ));
            }// buah ta daun mbo

        }// nyoba bezier

        for (int beringinItem = 0;beringinItem<beringin.size();beringinItem++){
            beringin.get(beringinItem).translateObjectNormal(1.8f,0f,-0.3f);
        }
        //inisiasi world
        {
            //kapal
            for(int k = 0; k < 180; k++) {
                lagiCebur = true;
                float fastBoat = ((Math.max(Math.abs(objectsSailBoat.get(0).getJarakZ()), Math.abs(objectsSailBoat.get(0).getJarakX())) > 1.2f) ? kecepatanKapal :kecepatanKapal/2);
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * 2f), 0, 1f, 0);
                    objectsSailBoat.get(i).translateObject(fastBoat, 0, 0);
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * -2f), 0, 1f, 0);
                }
            }
            for(int k = 0; k < 50; k++) {
                ceburLeft();
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
                    objectsSailBoat.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);//woi z blm
                    objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
                }
                rotate3 += 1;
            }

            //pesawat
            for(int k = 0; k < 80; k++) {
                terbang(0);
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * 2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObject(0.02f, 0, 0);
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * -2f), 0, 1f, 0);
                }
                if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f) && objectsPlane.get(0).getJarakY()<-0.56){
                    float jarY=-0.56f-objectsPlane.get(0).getJarakY();
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, jarY, 0);
                    }
                    if(rodaMasuk) showTire();
                } else if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) > 1.4f)) {
                    if(!rodaMasuk) hideTire();
                }
            }
            for(int k = 0; k < 70; k++) {
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                    objectsPlane.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
                }
                rotate1 += 1;
            }
            for(int k = 0; k < 50; k++) {
                terbang(0);
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * 2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObject(0.02f, 0, 0);
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * -2f), 0, 1f, 0);
                }
                if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f) && objectsPlane.get(0).getJarakY()<-0.56){
                    float jarY=-0.56f-objectsPlane.get(0).getJarakY();
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, jarY, 0);
                    }
                    if(rodaMasuk) showTire();
                } else if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) > 1.4f)) {
                    if(!rodaMasuk) hideTire();
                }
            }
            for(int k = 0; k < 70; k++) {
                if (objectsPlane.get(0).getJarakY() > -0.56) {
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, -0.02f, 0);
                    }
                } else if (objectsPlane.get(0).getJarakY() > -0.7 && (Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) > 1.4f)) {
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, -0.02f, 0);
                    }
                    if (!rodaMasuk) hideTire();
                } else if (Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f){
                    if (rodaMasuk) showTire();
                }
            }
        } // kapal

        {

            sharkFinAminSumpa.add(new Sphere(
                    shaderModuleDataList, abutua,
                    0.1f, 0.3f,
                    0, 0,
                    0.35f, 0.0f,
                    36, 18, 8
            ));
            sharkFinAminSumpa.get(0).translateObjectNormal(0,0,0);
            sharkFinAminSumpa.get(0).rotateObjectNormal((float)Math.toRadians(90),1,0,0);

            sharkFinAminSumpa.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList, abutua,
                    0.1f, 0.3f,
                    0, 0,
                    0.35f, 0.0f,
                    36, 18, 8
            ));
            sharkFinAminSumpa.get(0).getChildObject().get(0).translateObjectNormal(0,0,0);
            sharkFinAminSumpa.get(0).getChildObject().get(0).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
            sharkFinAminSumpa.get(0).getChildObject().get(0).rotateObjectNormal((float)Math.toRadians(70),1,0,0);

            sharkFinAminSumpa.get(0).rotateObjectNormal((float)Math.toRadians(5),0,0,0);
            sharkFinAminSumpa.get(0).scaleObject(0.5f);
            sharkFinAminSumpa.get(0).translateObjectNormal(0.0f,-0.65f,0);
            sharkFinAminSumpa.get(0).translateObjectNormal(-2.2f,0,0);

        } // SHARK FIN AMIN

        {
            {
                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(0).translateObjectNormal(0.10f,0,0);
                tetrapods.get(0).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(0).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);

                tetrapods.get(0).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(0).translateObjectNormal(-0.1f,1.1f,0f);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(1).translateObjectNormal(0.10f,0,0);
                tetrapods.get(1).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(1).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(1).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(1).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(1).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(1).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(1).translateObjectNormal(0.5f,0.5f,-0.2f);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(2).translateObjectNormal(0.10f,0,0);
                tetrapods.get(2).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(2).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(2).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(2).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(2).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(2).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(2).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(2).rotateObjectNormal((float)Math.toRadians(120),0,1,0);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(3).translateObjectNormal(0.10f,0,0);
                tetrapods.get(3).getChildObject().add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(3).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(3).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(3).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(3).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(3).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(3).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(3).rotateObjectNormal((float)Math.toRadians(-120),0,1,0);


                for (int ttp = 0 ; ttp < 4; ttp++){
                    tetrapods.get(ttp).rotateObjectNormal((float)Math.toRadians(30),0,0,1);
                }
            } // tetrapods1 ( 0 - 3 )
            {
                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(4).translateObjectNormal(0.10f,0,0);
                tetrapods.get(4).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(4).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);

                tetrapods.get(4).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(4).translateObjectNormal(-0.1f,1.1f,0f);



                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(5).translateObjectNormal(0.10f,0,0);
                tetrapods.get(5).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(5).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(5).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(5).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(5).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(5).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(5).translateObjectNormal(0.5f,0.5f,-0.2f);




                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(6).translateObjectNormal(0.10f,0,0);
                tetrapods.get(6).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(6).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(6).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(6).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(6).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(6).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(6).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(6).rotateObjectNormal((float)Math.toRadians(120),0,1,0);





                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(7).translateObjectNormal(0.10f,0,0);
                tetrapods.get(7).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(7).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(7).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(7).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(7).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(7).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(7).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(7).rotateObjectNormal((float)Math.toRadians(-120),0,1,0);

                for (int ttp = 4 ; ttp < 8; ttp++){
                    tetrapods.get(ttp).rotateObjectNormal((float)Math.toRadians(60),0,0,1);
                }
            } // tetrapods2 ( 4 - 7 )
            {
                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(8).translateObjectNormal(0.10f,0,0);
                tetrapods.get(8).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(8).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(8).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(8).translateObjectNormal(-0.1f,1.1f,0f);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(9).translateObjectNormal(0.10f,0,0);
                tetrapods.get(9).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(9).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(9).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(9).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(9).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(9).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(9).translateObjectNormal(0.5f,0.5f,-0.2f);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(10).translateObjectNormal(0.10f,0,0);
                tetrapods.get(10).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(10).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(10).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(10).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(10).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(10).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(10).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(10).rotateObjectNormal((float)Math.toRadians(120),0,1,0);

                tetrapods.add(new Sphere(
                        shaderModuleDataList, abumuda,
                        0.17f, 0.17f,
                        0, 0,
                        0.55f, 0.0f,
                        36, 18, 2
                ));
                tetrapods.get(11).translateObjectNormal(0.10f,0,0);
                tetrapods.get(11).getChildObject().add(new Sphere(
                        shaderModuleDataList, abugaksbrpmuda,
                        0.2f, 0.2f,
                        0, 0,
                        0.5f, 0.0f,
                        36, 18, 8
                ));
                tetrapods.get(11).getChildObject().get(0).translateObjectNormal(0.1f,0f,0f);
                tetrapods.get(11).rotateObjectNormal((float)Math.toRadians(90),1,0,0);
                tetrapods.get(11).translateObjectNormal(0f,1.3f,0f);
                tetrapods.get(11).rotateObjectNormal((float)Math.toRadians(120),0,0,1);
                tetrapods.get(11).rotateObjectNormal((float)Math.toRadians(25),0,1,0);
                tetrapods.get(11).translateObjectNormal(0.5f,0.5f,-0.2f);
                tetrapods.get(11).rotateObjectNormal((float)Math.toRadians(-120),0,1,0);

                for (int ttp = 8 ; ttp < 12; ttp++){
                    tetrapods.get(ttp).rotateObjectNormal((float)Math.toRadians(60),1,0,1);
                }
            } // tetrapods3 ( 8 - 11 )

            for (int ttp = 0 ; ttp < tetrapods.size(); ttp++){
                tetrapods.get(ttp).scaleObject(0.25f);
            }
            for (int ttp = 0 ; ttp<4; ttp++){
                tetrapods.get(ttp).translateObjectNormal(1.5f,-0.75f,-0.8f);
            }
            for (int ttp = 4 ; ttp<8; ttp++){
                tetrapods.get(ttp).translateObjectNormal(1.9f,-0.75f,-0.5f);
            }
            for (int ttp = 8 ; ttp<12; ttp++){
                tetrapods.get(ttp).translateObjectNormal(1.8f,-0.83f,-1f);
            }


//            tetrapods.get(0).rotateObjectNormal((float)Math.toRadians(90),1,0,0);

        } // tetrapod

        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,1.0f,1.0f),
                (float) 0.4/2.5f,(float)0.4/2.5f,0.0f,
                0.0f,
                0.1f,
                0.0f,
                36,
                18,2
        ));
        objects.get(0).translateObject(0.0f,-0.2f,0.3f);

//        jarum panjang
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                (float)0.015f,(float)0.3/2.5f,0.0f,
                0.0f,
                (float)0.01/2.5f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(0).translateObject(0.0f,-0.125f,0.4f);

//        jarum pendek
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                (float)0.2/2.5f,0.015f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(1).translateObject(0.04f,-0.175f,0.4f);

//        tanda jam 3
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                (float)0.06/2.5f,0.01f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(2).translateObject(0.125f,-0.175f,0.4f);

//        tanda jam 9
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                (float) 0.06/2.5f,0.01f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(3).translateObject(-0.125f,-0.175f,0.4f);

//        tanda jam 12
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f, (float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(4).translateObject(0.0f,-0.075f,0.4f);

//        tanda jam 6
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f,(float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(5).translateObject(0.0f,-0.325f,0.4f);

//        tanda jam 11
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f,(float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(6).translateObject(-0.1f,-0.05f,0.4f);
        objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,1.0f);

//        tanda jam 5
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f,(float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(7).translateObject(-0.1f,-0.3f,0.4f);
        objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,1.0f);

//        tanda jam 10
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.007f,(float) 0.035/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(8).translateObject(-0.095f,0.015f,0.19f);
        objects.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,3f);

//        tanda jam 4
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.007f,(float) 0.035/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(9).translateObject(-0.1f,-0.125f,0.19f);
        objects.get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,3f);

//        tanda jam 1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f,(float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(10).translateObject(0.1f,-0.045f,0.4f);
        objects.get(0).getChildObject().get(10).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,-1.0f);

//        tanda jam 7
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.01f,(float) 0.06/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(11).translateObject(0.1f,-0.295f,0.4f);
        objects.get(0).getChildObject().get(11).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,-1.0f);

//        tanda jam 8
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.007f,(float) 0.035/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(12).translateObject(0.1f,-0.125f,0.19f);
        objects.get(0).getChildObject().get(12).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,-3f);

//        tanda jam 2
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.007f,(float) 0.035/2.5f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(0).getChildObject().get(13).translateObject(0.095f,0.02f,0.19f);
        objects.get(0).getChildObject().get(13).rotateObject((float)Math.toRadians(30f),0.0f,0.0f,-3f);

//        balon udara
//        badan utama 1
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.4f,0.4f,0.0f,
                0.0f,
                0.4f,
                0.0f,
                36,
                18,1
        ));
        objects.get(1).translateObject(-1.5f,0.95f,-0.5f);

//       badan utama 2
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.2f,0.2f,0.0f,
                0.0f,
                0.2f,
                0.0f,
                36,
                18,6
        ));
        objects.get(1).getChildObject().get(0).translateObject(-1.5f,0.5f,0.4f);
        objects.get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90),1.0f,0.0f,0.0f);

//        badan utama 3
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,140/255f,0.0f,1.0f),
                0.15f,0.15f,0.0f,
                0.0f,
                0.15f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(1).translateObject(-1.5f,-0.5f,-0.525f);
        objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);

//        tali 1
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(128/255f,128/255f,128/255f,1.0f),
                0.0105f,0.0105f,0.0f,
                0.0f,
                0.2f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(2).translateObject(-1.63f,-0.5f,-0.45f);
        objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);


//        tali 2
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(128/255f,128/255f,128/255f,1.0f),
                0.0105f,0.0105f,0.0f,
                0.0f,
                0.2f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(3).translateObject(-1.37f,-0.5f,-0.45f);
        objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);

//        tali 3
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(128/255f,128/255f,128/255f,1.0f),
                0.0105f,0.0105f,0.0f,
                0.0f,
                0.2f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(4).translateObject(-1.5f,-0.3605f,-0.45f);
        objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);

//        tali 4
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(128/255f,128/255f,128/255f,1.0f),
                0.0105f,0.0105f,0.0f,
                0.0f,
                0.2f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(5).translateObject(-1.5f,-0.6395f,-0.45f);
        objects.get(1).getChildObject().get(5).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);

        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(139/255f,69/255f,19/255f,1.0f),
                0.15f,0.15f,0.0f,
                0.0f,
                0.175f,
                0.0f,
                36,
                18,2
        ));
        objects.get(1).getChildObject().get(6).translateObject(-1.5f,-0.5f,-0.25f);
        objects.get(1).getChildObject().get(6).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);

//        ayunan
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.5f,0.05f,0.0f,
                0.0f,
                0.05f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).translateObject(0.7f,-0.3f,0.3f);
        objects.get(2).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.05f,0.6f,0.0f,
                0.0f,
                0.05f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).getChildObject().get(0).translateObject(0.5f,-0.6f,0.3f);

        objects.get(2).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.05f,0.6f,0.0f,
                0.0f,
                0.05f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).getChildObject().get(1).translateObject(0.9f,-0.6f,0.3f);
        objects.get(2).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.01f,0.35f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).getChildObject().get(0).getChildObject().get(0).translateObject(0.8f,-0.475f,0.3f);
        objects.get(2).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.01f,0.35f,0.0f,
                0.0f,
                0.01f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).getChildObject().get(0).getChildObject().get(1).translateObject(0.6f,-0.475f,0.3f);objects.get(2).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(150/255f,75/255f,1.0f,1.0f),
                0.3f,0.01f,0.0f,
                0.0f,
                0.3f,
                0.0f,
                36,
                18,3
        ));
        objects.get(2).getChildObject().get(0).getChildObject().get(2).translateObject(0.7f,-0.65f,0.3f);

        // BIRD ----------------
        {
            // BODY ---------------- #0
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(167 / 255f, 19 / 255f, 41 / 255f, 0.0f),
                    .2f, .2f, 0f, 0f, .2f, 0f, 360, 180, 1
            ));
            objectsBird.get(0).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(104 / 255f, 83 / 255f, 52 / 255f, 0.0f),
                    .18f, .18f, 0f, -0.02f, .18f, 0.02f, 360, 180, 1
            ));
            // ---------------------
            // MOUTH --------------- #1
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(155 / 255f, 112 / 255f, 44 / 255f, 0.0f),
                    .08f, .07f, 0f, -0.02f, .17f, 0.12f, 360, 180, 13
            ));
            objectsBird.get(1).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(88 / 255f, 55 / 255f, 14 / 255f, 0.0f),
                    .07f, .04f, 0f, -0.02f, .11f, 0.15f, 360, 180, 14
            ));
            objectsBird.get(1).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(95 / 255f, 55 / 255f, 14 / 255f, 0.0f),
                    .065f, .065f, 0f, -0.025f, .065f, 0.16f, 360, 180, 1
            ));
            // ---------------------
            // EYES ---------------- #2
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(157 / 255f, 151 / 255f, 136 / 255f, 0.0f),
                    .05f, .05f, 0.035f, 0.05f, .03f, 0.17f, 360, 180, 1
            ));
            objectsBird.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(157 / 255f, 151 / 255f, 136 / 255f, 0.0f),
                    .05f, .05f, -0.035f, 0.05f, .03f, 0.17f, 360, 180, 1
            ));
            objectsBird.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .015f, .015f, -0.03f, 0.05f, .015f, 0.2f, 360, 180, 1
            ));
            objectsBird.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .015f, .015f, 0.03f, 0.05f, .015f, 0.2f, 360, 180, 1
            ));
            // ---------------------
            // EYEBROW ------------- #3
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .05f, .04f, -0.011f, 0.09f, .03f, 0.2f, 360, 180, 15
            ));
            objectsBird.get(3).rotateObjectNormal(-(float) Math.toRadians(20f), 0, 1f, 0);
            objectsBird.get(3).rotateObjectNormal(-(float) Math.toRadians(10f), 0, 0, 1f);

            objectsBird.get(3).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .05f, .04f, 0.011f, 0.09f, .03f, 0.2f, 360, 180, 16
            ));
            objectsBird.get(3).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(20f), 0, 1f, 0);
            objectsBird.get(3).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            // ---------------------
            // UPPER HEAD ---------- #4
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .027f, .07f, 0f, 0.2f, .03f, 0f, 360, 180, 1
            ));
            objectsBird.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .027f, .07f, 0.08f, 0.17f, .03f, 0f, 360, 180, 1
            ));
            objectsBird.get(4).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(35f), 0, 0, 1f);

            objectsBird.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .027f, .07f, -0.08f, 0.17f, .03f, 0f, 360, 180, 1
            ));
            objectsBird.get(4).getChildObject().get(1).rotateObjectNormal(-(float) Math.toRadians(35f), 0, 0, 1f);
            // ---------------------
            // WINGS --------------- #5
            objectsBird.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, -0.2f, 0f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, -0.18f, 0.06f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(20f), 0, 0, 1f);

            objectsBird.get(5).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, -0.18f, -0.06f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().get(1).rotateObjectNormal(-(float) Math.toRadians(20f), 0, 0, 1f);

            objectsBird.get(5).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, 0.2f, 0f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, 0.18f, 0.06f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().get(3).rotateObjectNormal(-(float) Math.toRadians(20f), 0, 0, 1f);

            objectsBird.get(5).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(122 / 255f, 13 / 255f, 26 / 255f, 0.0f),
                    .08f, .01f, 0.18f, -0.06f, .06f, 0f, 360, 180, 13
            ));
            objectsBird.get(5).getChildObject().get(4).rotateObjectNormal((float) Math.toRadians(20f), 0, 0, 1f);
            // ----------------------
            for (int i = 0; i < objectsBird.size(); i++) {
                objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
                objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
                objectsBird.get(i).scaleObject(0.5f);
                objectsBird.get(i).translateObjectNormal(-0.3f, -0.71f, 0.5f);
            }
        }
        // ---------------------

        // FISH ----------------
        {
            // BODY ---------------- #0
            fish.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(212 / 255f, 145 / 255f, 0 / 255f, 0.0f),
                    .2f, .2f, 0f, 0f, .25f, 0f, 360, 180, 1
            ));
            // MOUTH --------------- #1
            fish.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(155 / 255f, 112 / 255f, 44 / 255f, 0.0f),
                    .08f, .07f, 0f, -0.02f, .17f, 0.12f, 360, 180, 13
            ));
            fish.get(1).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(88 / 255f, 55 / 255f, 14 / 255f, 0.0f),
                    .07f, .04f, 0f, -0.02f, .11f, 0.15f, 360, 180, 14
            ));
            fish.get(1).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(95 / 255f, 55 / 255f, 14 / 255f, 0.0f),
                    .065f, .065f, 0f, -0.025f, .065f, 0.16f, 360, 180, 1
            ));
            // ---------------------
            // EYES ---------------- #2
            fish.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(157 / 255f, 151 / 255f, 136 / 255f, 0.0f),
                    .05f, .05f, 0.035f, 0.05f, .03f, 0.23f, 360, 180, 1
            ));
            fish.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(157 / 255f, 151 / 255f, 136 / 255f, 0.0f),
                    .05f, .05f, -0.035f, 0.05f, .03f, 0.23f, 360, 180, 1
            ));
            fish.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .015f, .015f, -0.03f, 0.05f, .015f, 0.25f, 360, 180, 1
            ));
            fish.get(2).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 0.0f),
                    .015f, .015f, 0.03f, 0.05f, .015f, 0.25f, 360, 180, 1
            ));
            // ---------------------
            // UPPER HEAD ---------- #4
            fish.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .027f, .07f, 0f, 0.2f, .03f, 0f, 360, 180, 1
            ));
            fish.get(3).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .027f, .07f, 0.08f, 0.17f, .03f, 0f, 360, 180, 1
            ));
            fish.get(3).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(35f), 0, 0, 1f);

            fish.get(3).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .027f, .07f, -0.08f, 0.17f, .03f, 0f, 360, 180, 1
            ));
            fish.get(3).getChildObject().get(1).rotateObjectNormal(-(float) Math.toRadians(35f), 0, 0, 1f);
            // ---------------------
            // WINGS --------------- #5
            fish.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, -0.2f, 0f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, -0.18f, 0.06f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(20f), 0, 0, 1f);

            fish.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, -0.18f, -0.06f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().get(1).rotateObjectNormal(-(float) Math.toRadians(20f), 0, 0, 1f);

            fish.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, 0.2f, 0f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, 0.18f, 0.06f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().get(3).rotateObjectNormal(-(float) Math.toRadians(20f), 0, 0, 1f);

            fish.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(186 / 255f, 74 / 255f, 0 / 255f, 0.0f),
                    .08f, .01f, 0.18f, -0.06f, .06f, 0f, 360, 180, 13
            ));
            fish.get(4).getChildObject().get(4).rotateObjectNormal((float) Math.toRadians(20f), 0, 0, 1f);
            // ----------------------
            for (int i = 0; i < fish.size(); i++) {
                fish.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
                fish.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
                fish.get(i).scaleObject(0.4f);
                fish.get(i).translateObjectNormal(-0.3f, -0.75f, 1.8f);
            }
        }
        // ---------------------
        // ---------------------

        // PINWHEEL ------------
        {
            // BALINGBALING -------- #1
            pinWheel.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 0.0f)
                    , .8f, .3f, -0.49f, 0, .1f, 0.2f, 360, 180, 4
            ));
            pinWheel.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 0.0f),
                    .8f, .3f, -0.49f, 0, .1f, 0.2f, 360, 180, 4
            ));
            pinWheel.get(1).rotateObjectNormal((float) Math.toRadians(90f), 0, 0, 1f);
            pinWheel.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 0.0f),
                    .8f, .3f, -0.49f, 0, .1f, 0.2f, 360, 180, 4
            ));
            pinWheel.get(2).rotateObjectNormal((float) Math.toRadians(180f), 0, 0, 1f);
            pinWheel.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 0.0f),
                    .8f, .3f, -0.49f, 0, .1f, 0.2f, 360, 180, 4
            ));
            pinWheel.get(3).rotateObjectNormal((float) Math.toRadians(270f), 0, 0, 1f);

            // TIANG --------------- #0
            pinWheel.add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(145 / 255f, 145 / 255f, 145 / 255f, 0.0f),
                    .1f, .1f, 0f, 0f, 3.0f, 0f, 360, 180, 2
            ));
            pinWheel.get(4).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);

            pinWheel.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(145 / 255f, 145 / 255f, 145 / 255f, 0.0f),
                    .1f, .1f, 0f, 0f, .14f, -0.13f, 360, 180, 2
            ));
            pinWheel.get(4).getChildObject().add(new Sphere(
                    shaderModuleDataList,
                    new Vector4f(87 / 255f, 87 / 255f, 87 / 255f, 0.0f),
                    .1f, .1f, 0f, 0f, .07f, 0.19f, 360, 180, 2
            ));
            // ---------------------

            // ---------------------
            for (int i = 0; i < pinWheel.size(); i++) {
//                pinWheel.get(i).rotateObjectNormal((float) Math.toRadians(90f), 0, 1f, 0);
                pinWheel.get(i).scaleObject(0.5f);
                pinWheel.get(i).translateObjectNormal(-0.7f,0f,0.8f);
            }
        }
        // ---------------------
    }


    public void input(){
        Float temp1 = objects.get(0).getChildObject().get(0).getJarakX();
        Float temp2 = objects.get(0).getChildObject().get(0).getJarakY();
        Float temp3 = objects.get(0).getChildObject().get(0).getJarakZ();
        objects.get(0).getChildObject().get(0).translateObject(temp1*-1.5f,temp2*-1.5f,temp3*-1.5f);
        objects.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-0.5f),0f,0.0f,1.0f);
        objects.get(0).getChildObject().get(0).translateObject(temp1*1.5f,temp2*1.5f,temp3*11.5f);
        objects.get(0).getChildObject().get(1).translateObject(temp1*-1.5f,temp2*-1.5f,temp3*-1.5f);
        objects.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-0.05f),0f,0.0f,1.0f);
        objects.get(0).getChildObject().get(1).translateObject(temp1*1.5f,temp2*1.5f,temp3*1.5f);


        putarKincir();


        if (batas <= 200){
            objects.get(1).translateObject(0.0f,0.0005f,0.0f);
//            objects.get(1).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.005f);
        }
        else {
            objects.get(1).translateObject(0.0f,-0.0005f,0.0f);
//            objects.get(1).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.005f);
            if (batas == 400){
                batas = 0;
//                objects.get(1).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-400*0.005f);
            }
        }
        batas++;
//        hiuMuter();
        for (int i = 0; i < sharkFinAminSumpa.size(); i++) {
            sharkFinAminSumpa.get(i).translateObjectNormal(-(sharkFinAminSumpa.get(i).getJarakX()+0.1f), -sharkFinAminSumpa.get(i).getJarakY(), sharkFinAminSumpa.get(i).getJarakZ());
            sharkFinAminSumpa.get(i).rotateObject((float) Math.toRadians(0.6f), 0, 1f, 0);//woi z
            // blm
            sharkFinAminSumpa.get(i).translateObjectNormal(sharkFinAminSumpa.get(i).getJarakX()+0.1f,
                    sharkFinAminSumpa.get(i).getJarakY(), -sharkFinAminSumpa.get(i).getJarakZ());
        }
        for (int i = 0; i < objectsTree.size(); i++) {

            if (intervalTree < 100) {
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(2).rotateObjectNormal((float) Math.toRadians(-1f/27), 1,0,1);
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(0.002f/27,0,0);
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(0,0.15f,0);

                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(1).rotateObjectNormal((float) Math.toRadians(-1f/32), 1,0,1);
                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(0.002f/32,0,0);
                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(0,0.15f,0);

                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(-1f/55), 1,0,1);
                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(0.002f/55,0,0);
                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(0,0.15f,0);
                intervalTree++;
            } else {
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(-0.002f/27,0,0);
                objectsTree.get(i).getChildObject().get(2).rotateObjectNormal((float) Math.toRadians(1f/27),  1,0,1);
                objectsTree.get(i).getChildObject().get(2).translateObjectNormal(0,0.15f,0);

                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(-0.002f/32,0,0);
                objectsTree.get(i).getChildObject().get(1).rotateObjectNormal((float) Math.toRadians(1f/32),  1,0,1);
                objectsTree.get(i).getChildObject().get(1).translateObjectNormal(0,0.15f,0);

                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(0,-0.15f,0);
                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(-0.002f/55,0,0);
                objectsTree.get(i).getChildObject().get(0).rotateObjectNormal((float) Math.toRadians(1f/55),   1,0,1);
                objectsTree.get(i).getChildObject().get(0).translateObjectNormal(0,0.15f,0);
                intervalTree++;
                if (intervalTree > 199) intervalTree = 0;
            }
        }
        if (!window.isKeyPressed(GLFW_KEY_W)) {
            while (intervalKapalRight > 0) {
                objectsSailBoat.get(3).translateObjectNormal(-objectsSailBoat.get(3).getJarakX(), -objectsSailBoat.get(3).getJarakY(), objectsSailBoat.get(3).getJarakZ());
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(-10f), 0, 1, 0);
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).translateObjectNormal(objectsSailBoat.get(3).getJarakX(), objectsSailBoat.get(3).getJarakY(), -objectsSailBoat.get(3).getJarakZ());

                intervalKapalRight--;
            }
            while (intervalKapalLeft > 0) {
                objectsSailBoat.get(3).translateObjectNormal(-objectsSailBoat.get(3).getJarakX(), -objectsSailBoat.get(3).getJarakY(), objectsSailBoat.get(3).getJarakZ());
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(10f), 0, 1, 0);
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).translateObjectNormal(objectsSailBoat.get(3).getJarakX(), objectsSailBoat.get(3).getJarakY(), -objectsSailBoat.get(3).getJarakZ());

                intervalKapalLeft--;
            }
            if (intervalKapal > 0) {
                objectsSailBoat.get(3).translateObjectNormal(-objectsSailBoat.get(3).getJarakX(), -objectsSailBoat.get(3).getJarakY(), objectsSailBoat.get(3).getJarakZ());
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).scaleObject(1/1.1f, 1, 1);
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).translateObjectNormal(objectsSailBoat.get(3).getJarakX(), objectsSailBoat.get(3).getJarakY(), -objectsSailBoat.get(3).getJarakZ());

                intervalKapal--;
            }
        }
        if (!window.isKeyPressed(GLFW_KEY_A)) {
            if (intervalKapalLeft > 0) {
                objectsSailBoat.get(3).translateObjectNormal(-objectsSailBoat.get(3).getJarakX(), -objectsSailBoat.get(3).getJarakY(), objectsSailBoat.get(3).getJarakZ());
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(10f), 0, 1, 0);
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).translateObjectNormal(objectsSailBoat.get(3).getJarakX(), objectsSailBoat.get(3).getJarakY(), -objectsSailBoat.get(3).getJarakZ());

                intervalKapalLeft--;
            }
        }
        if (!window.isKeyPressed(GLFW_KEY_D)) {
            if (intervalKapalRight > 0) {
                objectsSailBoat.get(3).translateObjectNormal(-objectsSailBoat.get(3).getJarakX(), -objectsSailBoat.get(3).getJarakY(), objectsSailBoat.get(3).getJarakZ());
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(-10f), 0, 1, 0);
                objectsSailBoat.get(3).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(3).getRotation()), 0,1f,0);
                objectsSailBoat.get(3).translateObjectNormal(objectsSailBoat.get(3).getJarakX(), objectsSailBoat.get(3).getJarakY(), -objectsSailBoat.get(3).getJarakZ());

                intervalKapalRight--;
            }
        }
        {
            objectsHouse.get(5).scaleObject(1.02f);
            objectsHouse.get(5).translateObject(0, 0.002f, 0);
            if (intervalAsap < 5) {
                objectsHouse.get(4).scaleObject(1,1.02f,1.01f);
            }
            objectsHouse.get(6).scaleObject(1.01f);
            objectsHouse.get(6).translateObject(0.002f, 0.004f, 0);

            intervalAsap++;
            intervalAsap2++;

            objectsHouse.get(23).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
            objectsHouse.get(23).translateObjectNormal(1.2f, 0.3f, -0.15f);
            objectsHouse.get(23).rotateObject((float) Math.toRadians(20f), 0,1,0);
            objectsHouse.get(23).translateObjectNormal(0, 0.01f, 0);
            objectsHouse.get(23).translateObjectNormal(-1.2f, -0.3f, 0.15f);
            objectsHouse.get(23).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
            if (intervalAsap2 > 299) {
                for (int i = 0; i < 300; i++) {
                    objectsHouse.get(23).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
                    objectsHouse.get(23).translateObjectNormal(1.2f, 0.3f, -0.15f);
                    objectsHouse.get(23).rotateObject((float) Math.toRadians(-4f), 0,1,0);
                    objectsHouse.get(23).translateObjectNormal(0, -0.01f, 0);
                    objectsHouse.get(23).translateObjectNormal(-1.2f, -0.3f, 0.15f);
                    objectsHouse.get(23).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
                }
                intervalAsap2 = 0;
            }
            if (intervalAsap > 99) {
                for (int i = 0; i < 100; i++) {
                    objectsHouse.get(5).translateObject(0, -0.002f, 0);
                    objectsHouse.get(5).scaleObject(1 / 1.02f);
                    objectsHouse.get(6).translateObject(-0.002f, -0.004f, 0);
                    objectsHouse.get(6).scaleObject(1 / 1.01f);
                }
                intervalAsap = 0;
            }
            if (intervalAsap == 7) {
                for (int i = 0; i < 5; i++) {
                    objectsHouse.get(4).scaleObject(1,1 / 1.02f,1/1.01f);
                }
            }
            if (intervalAsap<50) {
                for (int i = 27; i < 29; i++) {
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
                    objectsHouse.get(i).translateObjectNormal(1.2f, 0.6f, -0.17f);
                    objectsHouse.get(i).scaleObject(0.95f);
                    objectsHouse.get(i).translateObjectNormal(-1.2f, -0.6f, 0.17f);
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
                }
                for (int i = 47; i<=54;i++) {
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
                    objectsHouse.get(i).translateObjectNormal(0.8f,0.55f,0.8f);
                    objectsHouse.get(i).scaleObject(0.95f);
                    objectsHouse.get(i).translateObjectNormal(-0.8f,-0.55f,-0.8f);
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
                }
            } else {
                for (int i = 27; i < 29; i++) {
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
                    objectsHouse.get(i).translateObjectNormal(1.2f, 0.6f, -0.17f);
                    objectsHouse.get(i).scaleObject(1/0.95f);
                    objectsHouse.get(i).translateObjectNormal(-1.2f, -0.6f, 0.17f);
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
                }
                for (int i = 47; i<=54;i++) {
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * 2f), 0, 1f, 0);
                    objectsHouse.get(i).translateObjectNormal(0.8f,0.55f,0.8f);
                    objectsHouse.get(i).scaleObject(1/0.95f);
                    objectsHouse.get(i).translateObjectNormal(-0.8f,-0.55f,-0.8f);
                    objectsHouse.get(i).rotateObjectNormal((float) Math.toRadians(rotate4 * -2f), 0, 1f, 0);
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_1)) {noBrp = 1;}
        if (window.isKeyPressed(GLFW_KEY_2)) {noBrp = 2;}
        if (window.isKeyPressed(GLFW_KEY_3)) {noBrp = 3;}
        if (window.isKeyPressed(GLFW_KEY_4)) {noBrp = 4;}
        if (window.isKeyPressed(GLFW_KEY_5)) {noBrp = 5;}
        if (window.isKeyPressed(GLFW_KEY_6)) {noBrp = 6;}

        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            objects.get(1).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            objects.get(2).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            for (int i = 0;i < pinWheel.size(); i++) {
                pinWheel.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < tetrapods.size(); i++) {
                tetrapods.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < objectsHouse.size(); i++) {
                objectsHouse.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < trunks.size(); i++) {
                trunks.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < beringin.size(); i++) {
                beringin.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
//            for (int i = 0;i < pinWheel.size(); i++) {
//                pinWheel.get(i).rotateObject((float) Math.toRadians(2f), 0,-1f,0);
//            }
            for (int i = 0;i < objectsTree.size(); i++) {
                objectsTree.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < kosteffan.size(); i++) {
                kosteffan.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
            }
            for (int i = 0;i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                objectsPlane.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);//woi z blm
                objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
            }
            for (int i = 0;i < objectsSailBoat.size(); i++) {
                objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
                objectsSailBoat.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);//woi z blm
                objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
            }
            for (int i = 0;i < objectsCar.size(); i++) {
                objectsCar.get(i).translateObjectNormal(-objectsCar.get(i).getJarakX(), -objectsCar.get(i).getJarakY(), objectsCar.get(i).getJarakZ());
                objectsCar.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);//woi z blm
                objectsCar.get(i).translateObjectNormal(objectsCar.get(i).getJarakX(), objectsCar.get(i).getJarakY(), -objectsCar.get(i).getJarakZ());
            }

            rotate1 += 1;
            rotate2 += 1;
            rotate3 += 1;
            rotate4 += 1;
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            objects.get(1).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            objects.get(2).rotateObject((float) Math.toRadians(2f), 0,1f,0);
//            for (int i = 0;i < pinWheel.size(); i++) {
//                pinWheel.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
//            }
            for (int i = 0;i < pinWheel.size(); i++) {
                pinWheel.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < tetrapods.size(); i++) {
                tetrapods.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < objectsHouse.size(); i++) {
                objectsHouse.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < trunks.size(); i++) {
                trunks.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < objectsTree.size(); i++) {
                objectsTree.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < kosteffan.size(); i++) {
                kosteffan.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
            for (int i = 0;i < beringin.size(); i++) {
                beringin.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
            }
//            for (int i = 0;i < pinWheel.size(); i++) {
//                pinWheel.get(i).rotateObject((float) Math.toRadians(-2f), 0,1f,0);
//            }
            for (int i = 0;i < objectsPlane.size(); i++) {
                objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                objectsPlane.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
            }
            for (int i = 0;i < objectsCar.size(); i++) {
                objectsCar.get(i).translateObjectNormal(-objectsCar.get(i).getJarakX(), -objectsCar.get(i).getJarakY(), objectsCar.get(i).getJarakZ());
                objectsCar.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                objectsCar.get(i).translateObjectNormal(objectsCar.get(i).getJarakX(), objectsCar.get(i).getJarakY(), -objectsCar.get(i).getJarakZ());
            }
            for (int i = 0;i < objectsSailBoat.size(); i++) {
                objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
                objectsSailBoat.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
            }
//            for (int i = 0;i < pinWheel.size(); i++) {
////                pinWheel.get(i).rotateObject((float) Math.toRadians(2f), 0,1f,0);
//                pinWheel.get(i).translateObjectNormal(-pinWheel.get(i).getJarakX(), -pinWheel.get(i).getJarakY(), pinWheel.get(i).getJarakZ());
//                pinWheel.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
//                pinWheel.get(i).translateObjectNormal(pinWheel.get(i).getJarakX(), pinWheel.get(i).getJarakY(), -pinWheel.get(i).getJarakZ());
//            }
            rotate1 -= 1;
            rotate2 -= 1;
            rotate3 -= 1;
            rotate4 -= 1;
        }

        cebur(1);
        if (!window.isKeyPressed(GLFW_KEY_W) || !window.isKeyPressed(GLFW_KEY_S)) {//woiboat
            if (lagiCebur) lagiCebur = false;
        }
        {
            if (rodaMasuk) {
                terbang(0);
            }
            if (window.isKeyPressed(GLFW_KEY_EQUAL)) {
                for (int i = 0; i < objectsPlane.size(); i++)
                    objectsPlane.get(i).scaleObject(1.1f, 1.1f, 1.1f);
            }
            if (window.isKeyPressed(GLFW_KEY_MINUS)) {
                for (int i = 0; i < objectsPlane.size(); i++)
                    objectsPlane.get(i).scaleObject(0.9f, 0.9f, 0.9f);
            }
            if (window.isKeyPressed(GLFW_KEY_W) && noBrp==1) {
                terbang(0);
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * 2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObject(0.02f, 0, 0);
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * -2f), 0, 1f, 0);
                }
                if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f) && objectsPlane.get(0).getJarakY()<-0.56){
                    float jarY=-0.56f-objectsPlane.get(0).getJarakY();
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, jarY, 0);
                    }
                    if(rodaMasuk) showTire();
                } else if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) > 1.4f)) {
                    if(!rodaMasuk) hideTire();
                }
            }
            if (window.isKeyPressed(GLFW_KEY_W) && noBrp==3) {//woiboat
                lagiCebur = true;
                float fastBoat = ((Math.max(Math.abs(objectsSailBoat.get(0).getJarakZ()), Math.abs(objectsSailBoat.get(0).getJarakX())) > 1.2f) ? kecepatanKapal :kecepatanKapal/2);
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * 2f), 0, 1f, 0);
                    objectsSailBoat.get(i).translateObject(fastBoat, 0, 0);
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_S) && noBrp==3) {//woiboat
                lagiCebur = true;
                float fastBoat = ((Math.max(Math.abs(objectsSailBoat.get(0).getJarakZ()), Math.abs(objectsSailBoat.get(0).getJarakX())) > 1.2f) ? kecepatanKapal :kecepatanKapal/2);
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * 2f), 0, 1f, 0);
                    objectsSailBoat.get(i).translateObject(-fastBoat, 0, 0);
                    objectsSailBoat.get(i).rotateObjectNormal((float) Math.toRadians(rotate3 * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_A) && noBrp==1) {
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                    objectsPlane.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                    objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
                }
                rotate1 -= 1;
            }
            if (window.isKeyPressed(GLFW_KEY_A) && noBrp==3) {
                ceburRight();
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
                    objectsSailBoat.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                    objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
                }
                rotate3 -= 1;
            }
            if (window.isKeyPressed(GLFW_KEY_D) && noBrp==3) {
                ceburLeft();
                for (int i = 0; i < objectsSailBoat.size(); i++) {
                    objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
                    objectsSailBoat.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);//woi z blm
                    objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
                }
                rotate3 += 1;
            }
            if (window.isKeyPressed(GLFW_KEY_S) && noBrp==1) {
                terbang(1);
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * 2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObject(-0.02f, 0, 0);
                    objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(rotate1 * -2f), 0, 1f, 0);
                }
                if ((Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f) && objectsPlane.get(0).getJarakY()<-0.56){
                    float jarY=-0.56f-objectsPlane.get(0).getJarakY();
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, jarY, 0);
                    }
                    if(rodaMasuk) showTire();
                }
            }
            if (window.isKeyPressed(GLFW_KEY_D) && noBrp==1) {
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).translateObjectNormal(-objectsPlane.get(i).getJarakX(), -objectsPlane.get(i).getJarakY(), objectsPlane.get(i).getJarakZ());
                    objectsPlane.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
                    objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
                }
                rotate1 += 1;
            }if (window.isKeyPressed(GLFW_KEY_W) && noBrp==2){
            ngengg(0);
            for (int i = 0; i < objectsCar.size(); i++) {
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(rotate2 * 2f), 0, 1f, 0);
                objectsCar.get(i).translateObject(0.02f, 0, 0);
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(rotate2 * -2f), 0, 1f, 0);
            }
        }
            if (window.isKeyPressed(GLFW_KEY_A) && noBrp==2){
                for (int i = 0; i < objectsCar.size(); i++) {
                    objectsCar.get(i).translateObjectNormal(-objectsCar.get(i).getJarakX(), -objectsCar.get(i).getJarakY(), objectsCar.get(i).getJarakZ());
                    objectsCar.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
                    objectsCar.get(i).translateObjectNormal(objectsCar.get(i).getJarakX(), objectsCar.get(i).getJarakY(), -objectsCar.get(i).getJarakZ());
                }
                rotate2 -=1;
            }
            if (window.isKeyPressed(GLFW_KEY_S) && noBrp==2){
                ngengg(1);
                for (int i = 0; i < objectsCar.size(); i++) {
                    objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(rotate2 * 2f), 0, 1f, 0);
                    objectsCar.get(i).translateObject(-0.02f, 0, 0);
                    objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(rotate2 * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_D) && noBrp==2) {
                for (int i = 0; i < objectsCar.size(); i++) {
                    objectsCar.get(i).translateObjectNormal(-objectsCar.get(i).getJarakX(), -objectsCar.get(i).getJarakY(), objectsCar.get(i).getJarakZ());
                    objectsCar.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
                    objectsCar.get(i).translateObjectNormal(objectsCar.get(i).getJarakX(), objectsCar.get(i).getJarakY(), -objectsCar.get(i).getJarakZ());
                }
                rotate2 +=1;
            }
            if (((window.isKeyPressed(GLFW_KEY_DOWN) || window.isKeyPressed(GLFW_KEY_Z)) && window.isKeyPressed(GLFW_KEY_W)) && noBrp==1) {
                if (objectsPlane.get(0).getJarakY() > -0.56) {
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, -0.02f, 0);
                    }
                } else if (objectsPlane.get(0).getJarakY() > -0.7 && (Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) > 1.4f)) {
                    for (int i = 0; i < objectsPlane.size(); i++) {
                        objectsPlane.get(i).translateObject(0, -0.02f, 0);
                    }
                    if (!rodaMasuk) hideTire();
                } else if (Math.max(Math.abs(objectsPlane.get(0).getJarakZ()), Math.abs(objectsPlane.get(0).getJarakX())) < 1.4f){
                    if (rodaMasuk) showTire();
                }
            }
            if (((window.isKeyPressed(GLFW_KEY_UP) || window.isKeyPressed(GLFW_KEY_X)) && window.isKeyPressed(GLFW_KEY_W)) && noBrp==1) {
                for (int i = 0; i < objectsPlane.size(); i++) {
                    objectsPlane.get(i).translateObject(0, 0.02f, 0);
                }
                if (!rodaMasuk) hideTire();
                //terbangNaik(0);
            }
            if (window.isKeyPressed(GLFW_KEY_P)) {// woi bledos
               cebur(0);
            }
            if (window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && noBrp == 4) {
                birdFly();
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                    objectsBird.get(i).translateObject(0.02f, 0, 0);
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_A) && noBrp == 4) {
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).translateObjectNormal(-objectsBird.get(i).getJarakX()+0.3f, -objectsBird.get(i).getJarakY()+0.71f, objectsBird.get(i).getJarakZ()-0.5f);
                    objectsBird.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);
                    objectsBird.get(i).translateObjectNormal(objectsBird.get(i).getJarakX()-0.3f, objectsBird.get(i).getJarakY()-0.71f, -objectsBird.get(i).getJarakZ()+0.5f);
                }
                rotateI-=1;
            }
            if (window.isKeyPressed(GLFW_KEY_S) && !window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && noBrp == 4) {
                birdFly();
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                    objectsBird.get(i).translateObject(-0.02f, 0, 0);
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_D) && noBrp == 4) {
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).translateObjectNormal(-objectsBird.get(i).getJarakX()+0.3f, -objectsBird.get(i).getJarakY()+0.71f, objectsBird.get(i).getJarakZ()-0.5f);
                    objectsBird.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
                    objectsBird.get(i).translateObjectNormal(objectsBird.get(i).getJarakX()-0.3f, objectsBird.get(i).getJarakY()-0.71f, -objectsBird.get(i).getJarakZ()+0.5f);
                }
                rotateI+=1;
            }
            if (window.isKeyPressed(GLFW_KEY_UP) && noBrp == 4) {
                birdFly();
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).translateObject(0, 0.02f,0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_DOWN) && noBrp == 4) {
                if (objectsBird.get(0).getJarakY() >= 0.01f) {
                    birdFly();
                    for (int i = 0; i < objectsBird.size(); i++) {
                        objectsBird.get(i).translateObject(0, -0.02f, 0);
                    }
                }
            }
            if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && window.isKeyPressed(GLFW_KEY_W) && noBrp == 4){
                birdFly();
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                    objectsBird.get(i).translateObject(0.05f, 0, 0);
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
                }
            }
            if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && window.isKeyPressed(GLFW_KEY_S) && noBrp == 4){
                birdFly();
                for (int i = 0; i < objectsBird.size(); i++) {
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * 2f), 0, 1f, 0);
                    objectsBird.get(i).translateObject(-0.05f, 0, 0);
                    objectsBird.get(i).rotateObjectNormal((float) Math.toRadians(rotateI * -2f), 0, 1f, 0);
                }
            }
//            swim();
            intervalFish++;
            for (int i = 0; i < fish.size(); i++) {
//                fish.get(i).translateObjectNormal(-(fish.get(i).getJarakX() + 0.1f), -fish.get(i).getJarakY() - 0.01f, fish.get(i).getJarakZ());
                fish.get(i).rotateObject((float) Math.toRadians(0.5f), 0, 1f, 0);
//                fish.get(i).translateObjectNormal(fish.get(i).getJarakX() + 0.1f, fish.get(i).getJarakY() + 0.01f, -fish.get(i).getJarakZ());
            }
//            System.out.println(intervalFish);
            if (intervalFish >= 140 && intervalFish <= 165) {
                for (int i = 0; i < fish.size(); i++) {
                    fish.get(i).translateObjectNormal(0,-0.01f,0);
                }
            }
            if (intervalFish >= 165 && intervalFish <= 190) {
                for (int i = 0; i < fish.size(); i++) {
                    fish.get(i).translateObjectNormal(0, +0.01f, 0);
                }
            }
            if (intervalFish == 191) intervalFish = 0;

//            if (fish.get(0).getJarakY() >= .5f) {
//                System.out.println("cok");
//            }

//            intervalFish++;
//            for (int i = 0; i < fish.size(); i++) {
//                fish.get(i).translateObject(0,-0.01f,0);
//            }
//            if (intervalFish > 70) {
//                for (int j = 0; j < fish.size(); j++) {
//                    fish.get(j).translateObject(0,+0.01f,0);
//                }
//                intervalFish -= 1;
//            }

//            if (window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && noBrp == 5) {
//                if (fish.get(0).getJarakZ() <= 1.3f) {
//                    swim();
//                    for (int i = 0; i < fish.size(); i++) {
//                        fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * 2f), 0, 1f, 0);
//                        fish.get(i).translateObject(0.02f, 0, 0);
//                        fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * -2f), 0, 1f, 0);
//                    }
//                }
//            }
//            if (window.isKeyPressed(GLFW_KEY_A) && noBrp == 5) {
//                for (int i = 0; i < fish.size(); i++) {
//                    fish.get(i).translateObjectNormal(-fish.get(i).getJarakX()+0.3f, -fish.get(i).getJarakY()+0.75f, fish.get(i).getJarakZ()-1.8f);
//                    fish.get(i).rotateObject((float) Math.toRadians(2f), 0, 1f, 0);//woi z blm
//                    fish.get(i).translateObjectNormal(fish.get(i).getJarakX()-0.3f, fish.get(i).getJarakY()-0.75f, -fish.get(i).getJarakZ()+1.8f);
//                }
//                rotateII-=1;
//            }
//            if (window.isKeyPressed(GLFW_KEY_S) && !window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && noBrp == 5) {
//                swim();
//                for (int i = 0; i < fish.size(); i++) {
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * 2f), 0, 1f, 0);
//                    fish.get(i).translateObject(-0.02f, 0, 0);
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * -2f), 0, 1f, 0);
//                }
//            }
//            if (window.isKeyPressed(GLFW_KEY_D) && noBrp == 5) {
//                for (int i = 0; i < fish.size(); i++) {
//                    fish.get(i).translateObjectNormal(-fish.get(i).getJarakX()+0.3f, -fish.get(i).getJarakY()+0.75f, fish.get(i).getJarakZ()-1.8f);
//                    fish.get(i).rotateObject((float) Math.toRadians(-2f), 0, 1f, 0);
//                    fish.get(i).translateObjectNormal(fish.get(i).getJarakX()-0.3f, fish.get(i).getJarakY()-0.75f, -fish.get(i).getJarakZ()+1.8f);
//                }
//                rotateII+=1;
//            }
//            if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && window.isKeyPressed(GLFW_KEY_W) && noBrp == 5){
//                swim();
//                for (int i = 0; i < fish.size(); i++) {
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * 2f), 0, 1f, 0);
//                    fish.get(i).translateObject(0.05f, 0, 0);
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * -2f), 0, 1f, 0);
//                }
//            }
//            if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT) && window.isKeyPressed(GLFW_KEY_S) && noBrp == 5){
//                swim();
//                for (int i = 0; i < fish.size(); i++) {
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * 2f), 0, 1f, 0);
//                    fish.get(i).translateObject(-0.05f, 0, 0);
//                    fish.get(i).rotateObjectNormal((float) Math.toRadians(rotateII * -2f), 0, 1f, 0);
//                }
//            }
//            if (window.isKeyPressed(GLFW_KEY_P) && noBrp == 6) {
//                putarKincir();
//            }
        }
    }

    private void hideTire() {
        for (int i = 18; i < 39; i++) {
            objectsPlane.get(i).translateObjectNormal(0,-500f,0);
        }
        rodaMasuk=true;
    }

    private void showTire() {
        for (int i = 18; i < 39; i++) {
            objectsPlane.get(i).translateObjectNormal(0,+500f,0);
        }
        rodaMasuk=false;
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
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(-0.5f), 0, 0, 1f);
            objectsPlane.get(10).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            objectsPlane.get(13).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            objectsPlane.get(16).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            objectsPlane.get(17).rotateObjectNormal((float) Math.toRadians(-0.5f), 1f, 0, 0);
            if (rotasiWing == 5) wingPlus = false;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        } else {
            rotasiWing-=1;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), -1f, 0, 0);
            for (int i = 7; i < 10; i++)
                objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(+0.5f), 0, 0, 1f);
            objectsPlane.get(10).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            objectsPlane.get(12).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            objectsPlane.get(13).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            objectsPlane.get(15).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            objectsPlane.get(16).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            objectsPlane.get(17).rotateObjectNormal((float) Math.toRadians(0.5f), 1f, 0, 0);
            if (rotasiWing == -5) wingPlus = true;
            objectsPlane.get(8).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
            objectsPlane.get(9).rotateObjectNormal((float) Math.toRadians(90f), 1f, 0, 0);
        }

        //roda
        if (!rodaMasuk) {
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


        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsPlane.size(); i++) {
            objectsPlane.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            objectsPlane.get(i).rotateObjectNormal((float)Math.toRadians(objectsPlane.get(i).getRotation()), 0,1f,0);
            objectsPlane.get(i).translateObjectNormal(objectsPlane.get(i).getJarakX(), objectsPlane.get(i).getJarakY(), -objectsPlane.get(i).getJarakZ());
        }
    }

    private void cebur(int arah) {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(i).getRotation()), 0,1f,0);
        }
        if (lagiCebur) {
            if (intervalKapal <= 5) {
                objectsSailBoat.get(3).scaleObject(1.1f, 1, 1);
                intervalKapal++;
            }
        }
        if(Math.max(Math.abs(objectsSailBoat.get(0).getJarakZ()), Math.abs(objectsSailBoat.get(0).getJarakX())) > 1.2f) {
            if (sailPlus) {
                rotasiSail += 1;
                for (int i = 0; i < objectsSailBoat.size(); i++)
                    objectsSailBoat.get(i).translateObjectNormal(0, 0.001f, 0);
                if (rotasiSail == 30) sailPlus = false;
            } else {
                rotasiSail -= 1;
                for (int i = 0; i < objectsSailBoat.size(); i++)
                    objectsSailBoat.get(i).translateObjectNormal(0, -0.001f, 0);
                if (rotasiSail == -30) sailPlus = true;
            }
        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(i).getRotation()), 0,1f,0);
            objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
        }
    }

    private void ceburLeft() {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(i).getRotation()), 0,1f,0);
        }

        if (intervalKapalLeft <= 5) {
            objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(-10f), 0, 1, 0);
            intervalKapalLeft++;
        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(i).getRotation()), 0,1f,0);
            objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
        }
    }

    private void ceburRight() {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(i).getRotation()), 0,1f,0);
        }

        if (intervalKapalRight <= 5) {
            objectsSailBoat.get(3).rotateObjectNormal((float) Math.toRadians(10f), 0, 1, 0);
            intervalKapalRight++;
        }

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsSailBoat.size(); i++) {
            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(i).getRotation()), 0,1f,0);
            objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
        }
    }

    public void birdFly() {
        for (int i = 0; i< objectsBird.size(); i++) {
            objectsBird.get(i).translateObjectNormal(-objectsBird.get(i).getJarakX()+0.3f, -objectsBird.get(i).getJarakY()+0.71f, objectsBird.get(i).getJarakZ()-0.5f);
            objectsBird.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(-objectsBird.get(i).getRotation()), 0,1f,0);
            objectsBird.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(10f), 0, 0, -1f);
        }

        if (wingBirdPlus) {
            wingBird += 1;
            objectsBird.get(5).rotateObjectNormal((float) java.lang.Math.toRadians(-3.7f), 0, 0, 1f);
            if (wingBird == 8) wingBirdPlus = false;
        }
        else {
            wingBird -= 1;
            objectsBird.get(5).rotateObjectNormal((float) java.lang.Math.toRadians(+3.7f), 0, 0, 1f);
            if (wingBird == -8) wingBirdPlus = true;
        }

        if (mouthPlus) {
            rotasiMouth += 1 ;
            objectsBird.get(1).getChildObject().get(0).rotateObjectNormal((float) java.lang.Math.toRadians(-0.5f), 0, 0, 1f);
            if (rotasiMouth == 8) mouthPlus = false;
        }
        else {
            rotasiMouth -= 1 ;
            objectsBird.get(1).getChildObject().get(0).rotateObjectNormal((float) java.lang.Math.toRadians(+0.5f), 0, 0, 1f);
            if (rotasiMouth == -8) mouthPlus = true;
        }

        for (int i = 0; i< objectsBird.size(); i++) {
            objectsBird.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(10f), 0, 0, 1f);
            objectsBird.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(objectsBird.get(i).getRotation()), 0,1f,0);
            objectsBird.get(i).translateObjectNormal(objectsBird.get(i).getJarakX()-0.3f, objectsBird.get(i).getJarakY()-0.71f, -objectsBird.get(i).getJarakZ()+0.5f);
        }
    }

    public void swim() {
        for (int i = 0; i< fish.size(); i++) {
            fish.get(i).translateObjectNormal(-fish.get(i).getJarakX()+0.3f, -fish.get(i).getJarakY()+0.75f, fish.get(i).getJarakZ()-1.8f);
            fish.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(-fish.get(i).getRotation()), 0,1f,0);
            fish.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(10f), 0, 0, -1f);
        }

        if (wingFishPlus) {
            wingFish += 1;
            fish.get(4).rotateObjectNormal((float) java.lang.Math.toRadians(-3.7f), 0, 0, 1f);
            if (wingFish == 8) wingFishPlus = false;
        }
        else {
            wingFish -= 1;
            fish.get(4).rotateObjectNormal((float) java.lang.Math.toRadians(+3.7f), 0, 0, 1f);
            if (wingFish == -8) wingFishPlus = true;
        }

        if (mouthFishPlus) {
            rotasiMouthFish += 1 ;
            fish.get(1).getChildObject().get(0).rotateObjectNormal((float) java.lang.Math.toRadians(-0.5f), 0, 0, 1f);
            if (rotasiMouthFish == 8) mouthFishPlus = false;
        }
        else {
            rotasiMouthFish -= 1 ;
            fish.get(1).getChildObject().get(0).rotateObjectNormal((float) java.lang.Math.toRadians(+0.5f), 0, 0, 1f);
            if (rotasiMouthFish == -8) mouthFishPlus = true;
        }

        for (int i = 0; i< fish.size(); i++) {
            fish.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(10f), 0, 0, 1f);
            fish.get(i).rotateObjectNormal((float) java.lang.Math.toRadians(fish.get(i).getRotation()), 0,1f,0);
            fish.get(i).translateObjectNormal(fish.get(i).getJarakX()-0.3f, fish.get(i).getJarakY()-0.75f, -fish.get(i).getJarakZ()+1.8f);
        }
    }

    public void putarKincir() {
        //pindahin smua objek ke state
        for (int i = 0; i< pinWheel.size(); i++) {
            pinWheel.get(i).translateObjectNormal(-pinWheel.get(i).getJarakX()+0.7f, pinWheel.get(i).getJarakY(), pinWheel.get(i).getJarakZ()-0.8f);
            pinWheel.get(i).rotateObjectNormal((float)Math.toRadians(-pinWheel.get(i).getRotation()), 0,1f,0);
//            pinWheel.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, -1f);
        }
        for (int i = 0; i < 4; i++)
            pinWheel.get(i).rotateObjectNormal((float) Math.toRadians(19f),0f, 0f, 1f);

        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< pinWheel.size(); i++) {
//            pinWheel.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            pinWheel.get(i).rotateObjectNormal((float)Math.toRadians(pinWheel.get(i).getRotation()), 0,1f,0);
            pinWheel.get(i).translateObjectNormal(pinWheel.get(i).getJarakX()-0.7f, pinWheel.get(i).getJarakY(), -pinWheel.get(i).getJarakZ()+0.8f);
        }
    }

    private void ngengg(int arah) {
        //pindahin smua objek ke state 0
        for (int i = 0; i< objectsCar.size(); i++) {
            objectsCar.get(i).translateObjectNormal(-objectsCar.get(i).getJarakX(), -objectsCar.get(i).getJarakY(), objectsCar.get(i).getJarakZ());
            objectsCar.get(i).rotateObjectNormal((float)Math.toRadians(-objectsCar.get(i).getRotation()), 0,1f,0);
            objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, -1f);
        }

        //RODA
        {
            // roda depan kanan
            float titikrotasirodakanan = 0.2f;
            for (int i = 1; i < 7; i++) {
                objectsCar.get(i).translateObjectNormal(-titikrotasirodakanan * carSize, titikrotasirodakanan * carSize,
                        -0.3f * carSize);
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(5f), 0, 0, arah == 0 ? -1f : 1f);
                objectsCar.get(i).translateObjectNormal(titikrotasirodakanan * carSize, -titikrotasirodakanan * carSize,
                        0.3f * carSize);
            }
            // roda depan kiri
            for (int i = 7; i < 13; i++) {
                objectsCar.get(i).translateObjectNormal(-titikrotasirodakanan * carSize, titikrotasirodakanan * carSize,
                        -0.3f * carSize);
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(5f), 0, 0, arah == 0 ? -1f : 1f);
                objectsCar.get(i).translateObjectNormal(titikrotasirodakanan * carSize, -titikrotasirodakanan * carSize,
                        0.3f * carSize);
            }
            // roda blkg kanan
            float Xtitikrotasirodakiri = 0.45f;
            float Ytitikrotasirodakiri = 0.07f;
            for (int i = 13; i < 19; i++) {
                objectsCar.get(i).translateObjectNormal(Xtitikrotasirodakiri*carSize, Ytitikrotasirodakiri*carSize, 0);
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(5f),0, 0, arah==0?-1f:1f);
                objectsCar.get(i).translateObjectNormal(-Xtitikrotasirodakiri*carSize, -Ytitikrotasirodakiri*carSize, -0);
            }
            // roda blkg kiri
            for (int i = 19; i < 25; i++) {
                objectsCar.get(i).translateObjectNormal(Xtitikrotasirodakiri*carSize, Ytitikrotasirodakiri*carSize, 0);
                objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(5f),0, 0, arah==0?-1f:1f);
                objectsCar.get(i).translateObjectNormal(-Xtitikrotasirodakiri*carSize, -Ytitikrotasirodakiri*carSize, -0);
            }
        }



        //pindahin smua objek ke state awal sebelum ke state 0
        for (int i = 0; i< objectsCar.size(); i++) {
            objectsCar.get(i).rotateObjectNormal((float) Math.toRadians(10f), 0, 0, 1f);
            objectsCar.get(i).rotateObjectNormal((float)Math.toRadians(objectsCar.get(i).getRotation()), 0,1f,0);
            objectsCar.get(i).translateObjectNormal(objectsCar.get(i).getJarakX(), objectsCar.get(i).getJarakY(), -objectsCar.get(i).getJarakZ());
        }

    }
//    private void hiuMuter() {
//        //pindahin smua objek ke state 0
//        for (int i = 0; i< sharkFinAminSumpa.size(); i++) {
//            sharkFinAminSumpa.get(i).translateObjectNormal(-objectsSailBoat.get(i).getJarakX(), -objectsSailBoat.get(i).getJarakY(), objectsSailBoat.get(i).getJarakZ());
//            sharkFinAminSumpa.get(i).rotateObjectNormal((float)Math.toRadians(-objectsSailBoat.get(i).getRotation()), 0,1f,0);
//        }
//
//        if (intervalhiu <= 5) {
//            sharkFinAminSumpa.get(3).rotateObjectNormal((float) Math.toRadians(10f), 0, 1, 0);
//            sharkFinAminSumpa++;
//        }
//
//        //pindahin smua objek ke state awal sebelum ke state 0
//        for (int i = 0; i< objectsSailBoat.size(); i++) {
//            objectsSailBoat.get(i).rotateObjectNormal((float)Math.toRadians(objectsSailBoat.get(i).getRotation()), 0,1f,0);
//            objectsSailBoat.get(i).translateObjectNormal(objectsSailBoat.get(i).getJarakX(), objectsSailBoat.get(i).getJarakY(), -objectsSailBoat.get(i).getJarakZ());
//        }
//    }

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

            // rexy
            for (Object ob: objectsCar) {
                ob.draw(camera, projection);
            }
            for (Object ob: kosteffan) {
                ob.draw(camera, projection);
            }
            for (Object ob: trunks) {
                ob.draw(camera, projection);
            }
            for (Object ob: beringin) {
                ob.draw(camera, projection);
            }
            for (Object bezRex : bezierRexy){
                bezRex.drawLine(camera, projection);
            }
            for (Object ob: sharkFinAminSumpa){
                ob.draw(camera,projection);
            }
            for (Object ob: tetrapods){
                ob.draw(camera,projection);
            }


            // patrick
            for (Object ob: objectsPlane) {
                ob.draw(camera, projection);
            }
            for (Object ob: objectsSailBoat) {
                ob.draw(camera, projection);
            }
            for (Object ob: objectsTree) {
                ob.draw(camera, projection);
            }
            for (Object ob: objectsHouse) {
                ob.draw(camera, projection);
            }


            // steven
            for(Object object: objects){
                object.draw(camera,projection);
            }

//            for (int i = 1;i<objects.size();i++){
//                objects.get(i).draw(camera,projection);
//            }

            // jodem
            for (Object ob : objectsBird)
                ob.draw(camera, projection);
            for (Object ob : fish)
                ob.draw(camera, projection);
            for (Object ob : pinWheel)
                ob.draw(camera, projection);

//            putarKincir();

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