/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer;

import edu.up.isgc.raytracer.lights.DirectionalLight;
import edu.up.isgc.raytracer.lights.Light;
import edu.up.isgc.raytracer.lights.PointLight;
import edu.up.isgc.raytracer.objects.*;
import edu.up.isgc.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jafet Rodríguez
 * @author Enrique Luna
 */
public class Raytracer {
    /**
     * Generate scenes and generate images
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Date());
        /*
        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0, -10), 160, 160, 800, 800, 0f, 50f));
        scene01.addLight(new PointLight(new Vector3D(0, 0, 0), Color.WHITE, 2));
        scene01.addObject(new Polygon(new Vector3D(0, -2, 0), new Triangle[]{new Triangle(new Vector3D(-5, 0, -5), new Vector3D(5, 0, -5), new Vector3D(5, 0, 5)),
                new Triangle(new Vector3D(5, 0, 5), new Vector3D(-5, 0, 5), new Vector3D(-5, 0, -5))}, Color.white, new Material(0.1, 0,  true, false, 0.8,0,0)));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-2f, -2f, 1f), Color.RED, new Material(0.1, 20,  false, false, 0,0,0)));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(2f, -2f, 0f), Color.WHITE, new Material(0.1, 20,  true, false, 0.8,0,0)));
        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-2f, -1.5f, -1f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene01.addObject(new Sphere(new Vector3D(-0.5f, -0.8f, -1f), 0.5f, Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
         */

        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0.3, -10), 160, 160, 1200, 1200, 0f, 50f));
        scene01.addLight(new PointLight(new Vector3D(0, 0, 0), Color.WHITE, 2));
        scene01.addObject(new Polygon(new Vector3D(0, -2, 0), new Triangle[]{new Triangle(new Vector3D(-5, 0, -5), new Vector3D(5, 0, -5), new Vector3D(5, 0, 5)),
                new Triangle(new Vector3D(5, 0, 5), new Vector3D(-5, 0, 5), new Vector3D(-5, 0, -5))}, Color.white, new Material(0.1, 0,  true, false, 0.8,0,0)));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-2f, -2f, 1f), Color.RED, new Material(0.1, 20,  false, false, 0,0,0)));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(2f, -2f, 0f), Color.WHITE, new Material(0.1, 20,  true, false, 1,0,0)));
        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-2.2f, -1.2f, -1f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene01.addObject(new Sphere(new Vector3D(-0.5f, -0.8f, -1f), 0.5f, Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene01.addObject(new Polygon(new Vector3D(0f, 3f, 5f), new Triangle[]{new Triangle(new Vector3D(5f,5f,0f), new Vector3D(-5f,5f,0f), new Vector3D(-5f,-5f,0f)),
                new Triangle(new Vector3D(-5f,-5f,0f), new Vector3D(5f,-5f,0f), new Vector3D(5f,5f,0f))}, Color.white, new Material(0.1, 0,  true, false, 0,0,0)));



        /*
        Scene scene02 = new Scene();
        scene02.setCamera(new Camera(new Vector3D(0, 0, -10.4), 160, 160, 4000, 4000, 0f, 50f));
        //scene02.addLight(new PointLight(new Vector3D(-2, 1, 2), Color.WHITE, 0.5));
        scene02.addLight(new PointLight(new Vector3D(-2, 1, -2), Color.WHITE, 2.8));
        scene02.addObject(new Polygon(new Vector3D(0, -2, 0), new Triangle[]{new Triangle(new Vector3D(-5, 0, -5), new Vector3D(5, 0, -5), new Vector3D(5, 0, 5)),
                new Triangle(new Vector3D(5, 0, 5), new Vector3D(-5, 0, 5), new Vector3D(-5, 0, -5))}, Color.cyan, new Material(0.1, 0,  true, false, 0.9,0,0)));
        scene02.addObject(new Sphere(new Vector3D(2.2f, -1f, -2f), 1f, Color.WHITE, new Material(0.05,40,true,false,1,0,0)));
        scene02.addObject(new Sphere(new Vector3D(1.4f, -1f, 0f), 1f, Color.WHITE, new Material(0.05,30,true,false,0.9,0,0)));
        scene02.addObject(new Sphere(new Vector3D(0.4f, -1f, 2f), 1f, Color.WHITE, new Material(0.05,50,true,false,0.8,0,0)));
        //////
        scene02.addObject(new Sphere(new Vector3D(-1.8f, -1.8f, 0f), 0.2f, Color.red, new Material(0.1,5,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-2.8f, -1.8f, -1f), 0.2f, Color.black, new Material(0.6,0,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-1.2f, -1.8f, -1.5f), 0.2f, Color.blue, new Material(0.1,20,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-2f, -1.8f, -2f), 0.2f, Color.pink, new Material(0.1,30,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-1.8f, -1.8f, 2f), 0.2f, Color.yellow, new Material(0.1,10,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(0f, -1.8f, -2f), 0.2f, Color.magenta, new Material(0.05,0,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-3f, -1.8f, 0.6f), 0.2f, Color.gray, new Material(0.2,0,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-1f, -1.8f, 2f), 0.2f, Color.green, new Material(0.05,15,false,false,0,0,0)));
//
        scene02.addObject(new Sphere(new Vector3D(-0.6f, -1.8f, -2.5f), 0.2f, Color.white, new Material(0.05,20,false,true,0,0,1.8)));
        scene02.addObject(new Sphere(new Vector3D(-4f, -1.8f, 1f), 0.2f, Color.lightGray, new Material(0.1,0,true,false,1,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-0.8f, -1.8f, 0f), 0.2f, new Color(77, 51, 25), new Material(0.6,0,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-2.6f, -1.8f, 2f), 0.2f, new Color(134, 89, 45), new Material(0.1,0,true,false,0.7,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-3.2f, -1.8f, -2.1f), 0.2f, new Color(102, 0, 0), new Material(0.6,50,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-2f, -1.8f, -3.2f), 0.2f, Color.pink, new Material(0.1,0,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(-1f, -1.8f, -3.4f), 0.2f, Color.white, new Material(0.05,0,false,true,0,0,1.7)));
        scene02.addObject(new Sphere(new Vector3D(-3.2f, -1.8f, -3.2f), 0.2f, Color.magenta, new Material(0.2,20,false,false,0,0,0)));
        scene02.addObject(new Sphere(new Vector3D(0.5f, -1.8f, -3.4f), 0.2f, Color.black, new Material(0.05,30,false,false,0,0,0)));
         */

        /*
        Scene scene03 = new Scene();
        scene03.setCamera(new Camera(new Vector3D(0, 0, -8.5), 160, 160, 1200, 1200, 0f, 50f));
        scene03.addLight(new PointLight(new Vector3D(0, 2, 5), Color.white, 1));
        scene03.addObject(new Polygon(new Vector3D(0, -2, 0), new Triangle[]{new Triangle(new Vector3D(-5, 0, -5), new Vector3D(5, 0, -5), new Vector3D(5, 0, 5)),
                new Triangle(new Vector3D(5, 0, 5), new Vector3D(-5, 0, 5), new Vector3D(-5, 0, -5))}, Color.white, new Material(0.05, 0,  true, false, 1,0,0)));
        scene03.addObject(new Polygon(new Vector3D(0f, -0f, 10f), new Triangle[]{new Triangle(new Vector3D(60f,60f,0f), new Vector3D(-60f,60f,0f), new Vector3D(-60f,-60f,0f)),
                new Triangle(new Vector3D(-60f,-60f,0f), new Vector3D(60f,-60f,0f), new Vector3D(60f,60f,0f))}, Color.pink, new Material(0.3, 0,  false, false, 0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-0.2f, -0.4f, 2f), 0.4f, Color.gray, new Material(0.2,20,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-1f, -1.6f, 1f), 0.3f, Color.yellow, new Material(0.2,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-2f, -1f, 1.5f), 0.4f, Color.red, new Material(0.05,20,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(1f, -1.3f, 2.2f), 0.5f, Color.blue, new Material(0.2,15,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(2f, 0.5f, 1.2f), 0.2f, Color.yellow, new Material(0.1,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(1.4f, 1f, 1.8f), 0.3f, Color.magenta, new Material(0.05,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(0.8f, 1.5f, 2.4f), 0.2f, Color.red, new Material(0.2,20,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-1.2f, 0.8f, 2f), 0.4f, Color.orange, new Material(0.2,30,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-2.1f, 0.3f, 1f), 0.2f, Color.green, new Material(0.2,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(2.5f, -0.7f, 1.3f), 0.3f, Color.orange, new Material(0.1,30,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-2.3f, 2.1f, 1.3f), 0.4f, Color.magenta, new Material(0.1,20,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(-1f, 2.2f, 1.8f), 0.2f, Color.red, new Material(0.1,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(0f, 1.4f, 1f), 0.3f, Color.green, new Material(0.2,20,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(1f, 2.2f, 1.2f), 0.2f, Color.gray, new Material(0.2,15,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(2f, 1.7f, 1.4f), 0.2f, Color.blue, new Material(0.2,10,false,false,0,0,0)));
        scene03.addObject(new Sphere(new Vector3D(0.6f, 0.4f, 1.7f), 0.5f, Color.cyan, new Material(0.1,50,false,false,0,0,0)));

        scene03.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-2f, -1f, 0f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene03.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-1f, 1f, 0f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene03.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(0f, -1f, 0f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene03.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(2f, 0f, 0f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
        scene03.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(1f, 0.2f, 0f), Color.WHITE, new Material(0.1,20,false,true,0,0,1.8)));
         */

        BufferedImage image = raytrace(scene01);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ioe) {
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    /**
     * Calculates the position to ray, takes the closest intersection adn checks the color depending on the lights and material
     * @param scene
     * @return
     */
    public static BufferedImage raytrace(Scene scene) {
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = raycast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    pixelColor = Color.BLACK;
                    for (Light light : lights) {
                        if (!closestIntersection.getObject().getMaterial().isReflective()&&!closestIntersection.getObject().getMaterial().isRefractive()) {
                            Color ambient = ambient(light, closestIntersection);
                            pixelColor = addColor(pixelColor, ambient);
                            Intersection shadow = null;
                            if(light instanceof DirectionalLight){
                                shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.scalarMultiplication(((DirectionalLight) light).getDirection(),-1))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                            }else{
                                shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                            }
                            Color diffuse = diffuse(light, closestIntersection, shadow);
                            pixelColor = addColor(pixelColor, diffuse);
                            if (closestIntersection.getObject().getMaterial().getShininess() > 0) {
                                Color specular = specular(light, closestIntersection, mainCamera);
                                pixelColor = addColor(pixelColor, specular);
                            }
                        }else{
                            if(closestIntersection.getObject().getMaterial().isReflective()){
                                Color reflection = reflection(scene, closestIntersection, new Ray(mainCamera.getPosition(),Vector3D.substract(closestIntersection.getPosition(),mainCamera.getPosition())), light, pixelColor, 0);
                                pixelColor = addColor(pixelColor,reflection);
                            }
                            if(closestIntersection.getObject().getMaterial().isRefractive()){
                                Color refraction = refraction(scene, closestIntersection, new Ray(mainCamera.getPosition(),Vector3D.substract(closestIntersection.getPosition(),mainCamera.getPosition())), light,pixelColor,0);
                                pixelColor = addColor(pixelColor,refraction);
                            }
                        }
                    }
                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }

        return image;
    }

    /**
     * Guarantee that some value its between the boundaries
     * Takes the min value if lower
     * Takes the max value if higher
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * Allows to add two colors
     * @param original
     * @param otherColor
     * @return
     */
    public static Color addColor(Color original, Color otherColor) {
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * Allows to multiply a color to a factor
     * @param original
     * @param factor
     * @return
     */
    public static Color colorMultiplication(Color original, float factor){
        float red = clamp((original.getRed() / 255.0f)*factor, 0, 1);
        float green = clamp((original.getGreen() / 255.0f)*factor, 0, 1);
        float blue = clamp((original.getBlue() / 255.0f)*factor, 0, 1);
        return new Color(red, green, blue);
    }

    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }
        return closestIntersection;
    }

    /**
     * Calculate the ambient color (base color) to generate lambert material in combination with diffuse or blinn phong in case of adding specular
     * @param light
     * @param closestIntersection
     * @return
     */
    public static Color ambient(Light light, Intersection closestIntersection) {
        Color lightColor = light.getColor();
        Color objColor = closestIntersection.getObject().getColor();
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] *= lightColors[colorIndex] * closestIntersection.getObject().getMaterial().getAmbientCoefficient();
        }
        Color ambient = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
        return ambient;
    }

    /**
     * Calculate the diffuse color to generate lambert material in combination with ambient or blinn phong in case of adding specular
     * @param light
     * @param closestIntersection
     * @param shadow
     * @return
     */
    public static Color diffuse(Light light, Intersection closestIntersection, Intersection shadow) {
        float nDotL = light.getNDotL(closestIntersection);
        float intensity = (float) light.getIntensity() * nDotL;

        float distance = (float) Math.sqrt(Math.pow(closestIntersection.getPosition().getX() - light.getPosition().getX(), 2) +
                Math.pow(closestIntersection.getPosition().getY() - light.getPosition().getY(), 2) +
                Math.pow(closestIntersection.getPosition().getZ() - light.getPosition().getZ(), 2));

        if(light instanceof DirectionalLight){
            distance = 1;
        }

        intensity /= Math.pow(distance, 2);

        Color lightColor = light.getColor();
        Color objColor = closestIntersection.getObject().getColor();
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] *= intensity * lightColors[colorIndex];
        }
        Color diffuse = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
        if (shadow != null && shadow.getDistance() < distance) {
            diffuse = Color.BLACK;
        }
        return diffuse;
    }

    /**
     * Calculates the specular color to add shininess to the object
     * Used to generate blinn phong material in combination with ambient and diffuse
     * @param light
     * @param closestIntersection
     * @param mainCamera
     * @return
     */
    public static Color specular(Light light, Intersection closestIntersection, Camera mainCamera) {
        Vector3D H = Vector3D.normalize(Vector3D.add(Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())), Vector3D.normalize(Vector3D.substract(mainCamera.getPosition(), closestIntersection.getPosition()))));
        float specularCoef = (float) Math.pow(Math.max(Vector3D.dotProduct(closestIntersection.getNormal(), H), 0), closestIntersection.getObject().getMaterial().getShininess());

        Color lightColor = light.getColor();
        Color objColor = closestIntersection.getObject().getColor();
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] *= lightColors[colorIndex] * specularCoef;
        }
        Color specular = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
        return specular;
    }

    /**
     * Calculates the direction of the reflection ray, and checks whether it collide with
     * a reflective/refractive surface calling its respective method making it recursive, or taking the object color if its not.
     * @param scene
     * @param closestIntersection
     * @param ray
     * @param light
     * @param pixelColor
     * @param depth
     * @return
     */
    public static Color reflection(Scene scene, Intersection closestIntersection, Ray ray, Light light, Color pixelColor, int depth){
        if (depth >= 5) {
            return pixelColor;
        }
        Camera mainCamera = scene.getCamera();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        float cameraZ = (float) mainCamera.getPosition().getZ();
        ArrayList<Object3D> objects = scene.getObjects();

        Intersection shadow=null;
        if(light instanceof DirectionalLight){
            shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.scalarMultiplication(((DirectionalLight) light).getDirection(),-1))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        }else{
            shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        }
        Color diffuseInitial = diffuse(light, closestIntersection, shadow);
        pixelColor = addColor(pixelColor,diffuseInitial);
        if (closestIntersection.getObject().getMaterial().getShininess() > 0) {
            Color specular = specular(light, closestIntersection, mainCamera);
            pixelColor = addColor(pixelColor, specular);
        }

        pixelColor = colorMultiplication(pixelColor, (float) (1 - closestIntersection.getObject().getMaterial().getReflectionCoefficient()));
        Color ambientInitial = ambient(light,closestIntersection);
        pixelColor = addColor(pixelColor, ambientInitial);

        Vector3D reflectionDirection = Vector3D.substract(ray.getDirection(), Vector3D.scalarMultiplication(closestIntersection.getNormal(), Vector3D.dotProduct(closestIntersection.getNormal(), ray.getDirection()) * 2));
        Ray reflectionRay = new Ray(closestIntersection.getPosition(), reflectionDirection);
        Intersection reflectionIntersection = raycast(reflectionRay, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        if(reflectionIntersection!=null){
            if(reflectionIntersection.getObject().getMaterial().isReflective()){
                Color reflectionColor =  reflection(scene, reflectionIntersection, reflectionRay, light, pixelColor, ++depth);
                reflectionColor = colorMultiplication(reflectionColor, (float) reflectionIntersection.getObject().getMaterial().getReflectionCoefficient());
                pixelColor = addColor(pixelColor,reflectionColor);
            }
            else if(reflectionIntersection.getObject().getMaterial().isRefractive()){
                Color refractionColor = refraction(scene,reflectionIntersection,reflectionRay,light,pixelColor,++depth);
                //refractionColor = colorMultiplication(refractionColor, (float) reflectionIntersection.getObject().getMaterial().getRefractiveCoefficient());
                pixelColor = addColor(pixelColor,refractionColor);
            }
            else{
                Color ambient = ambient(light,reflectionIntersection);
                Color diffuse = diffuse(light, reflectionIntersection, shadow);
                if (reflectionIntersection.getObject().getMaterial().getShininess()>0) {
                    Color specular = specular(light, reflectionIntersection, mainCamera);
                    pixelColor = addColor(pixelColor, specular);
                }
                pixelColor = addColor(pixelColor,ambient);
                pixelColor = addColor(pixelColor,diffuse);
            }
        }
        return pixelColor;
    }

    /**
     * Calculates the direction of the refraction ray based on the reflection index, and checks whether it collide with
     * a reflective/refractive surface calling its respective method making it recursive, or taking the object color if its not.
     *
     * @param scene
     * @param closestIntersection
     * @param ray
     * @param light
     * @param pixelColor
     * @param depth
     * @return
     */
    public static Color refraction(Scene scene, Intersection closestIntersection, Ray ray, Light light, Color pixelColor, int depth){
        if (depth >= 5) {
            return pixelColor;
        }
        Camera mainCamera = scene.getCamera();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        float cameraZ = (float) mainCamera.getPosition().getZ();
        ArrayList<Object3D> objects = scene.getObjects();

        Intersection shadow=null;
        if(light instanceof DirectionalLight){
            shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.scalarMultiplication(((DirectionalLight) light).getDirection(),-1))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        }else{
            shadow = raycast(new Ray(closestIntersection.getPosition(), Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()))), objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        }
        Color diffuseInitial = diffuse(light, closestIntersection, shadow);
        pixelColor = addColor(pixelColor,diffuseInitial);
        if (closestIntersection.getObject().getMaterial().getShininess() > 0) {
            Color specular = specular(light, closestIntersection, mainCamera);
            pixelColor = addColor(pixelColor, specular);
        }
        //pixelColor = colorMultiplication(pixelColor, (float) (1 - closestIntersection.getObject().getMaterial().getRefractiveCoefficient()));
        Color ambientInitial = ambient(light,closestIntersection);
        pixelColor = addColor(pixelColor, ambientInitial);

        ////////////////

        Vector3D normal = closestIntersection.getNormal();
        double c1 = Vector3D.dotProduct(normal,ray.getDirection());
        double n1 = 1;
        double n2 = closestIntersection.getObject().getMaterial().getRefractiveIndex();
        if(c1<0){
            //outside the surface
            c1*=-1;
        }else{
            //inside the surface
            n1=closestIntersection.getObject().getMaterial().getRefractiveIndex();
            n2=1;
            normal = Vector3D.scalarMultiplication(normal,-1);
        }
        double n = n1/n2;
        double c2 = 1-(n*n)*(1-c1*c1);
        Vector3D T = Vector3D.ZERO();
        //Check total internal refraction. No refraction
        if(c2>=0){
            double c2Sqrt = Math.sqrt(c2);
            //T = Vector3D.substract(Vector3D.scalarMultiplication(Vector3D.add(ray.getDirection(),Vector3D.scalarMultiplication(normal,c1)),n),Vector3D.scalarMultiplication(normal,c2Sqrt));
            T = Vector3D.add(Vector3D.scalarMultiplication(ray.getDirection(),n),Vector3D.scalarMultiplication(normal,n*c1-c2Sqrt));
        }
        /*
        Vector3D incident = Vector3D.normalize(Vector3D.substract(closestIntersection.getPosition(),ray.getOrigin()));
        double c1 = Vector3D.dotProduct(closestIntersection.getNormal(),incident);
        double refractionIndex = 1/closestIntersection.getObject().getMaterial().getRefractiveIndex();
        double c2 = Math.sqrt(1-(refractionIndex*refractionIndex)*(1-c1*c1));
        Vector3D T = Vector3D.add(Vector3D.scalarMultiplication(incident,refractionIndex),Vector3D.scalarMultiplication(closestIntersection.getNormal(),refractionIndex*c1-c2));
         */
        Ray refractionRay = new Ray(closestIntersection.getPosition(), T);
        Intersection refractionIntersection = raycast(refractionRay,objects,closestIntersection.getObject(),new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        if(refractionIntersection!=null){
            if(refractionIntersection.getObject().getMaterial().isRefractive()){
                Color refractionColor = refraction(scene,refractionIntersection,refractionRay,light,pixelColor,++depth);
                //refractionColor = colorMultiplication(refractionColor, (float) refractionIntersection.getObject().getMaterial().getRefractiveCoefficient());
                pixelColor = addColor(pixelColor,refractionColor);
            }else if(refractionIntersection.getObject().getMaterial().isReflective()){
                Color reflectionColor =  reflection(scene, refractionIntersection, refractionRay, light, pixelColor, ++depth);
                reflectionColor = colorMultiplication(reflectionColor, (float) refractionIntersection.getObject().getMaterial().getReflectionCoefficient());
                pixelColor = addColor(pixelColor,reflectionColor);
            }else{
                Color ambient = ambient(light,refractionIntersection);
                Color diffuse = diffuse(light, refractionIntersection, shadow);
                if (refractionIntersection.getObject().getMaterial().getShininess()>0) {
                    Color specular = specular(light, refractionIntersection, mainCamera);
                    pixelColor = addColor(pixelColor, specular);
                }
                pixelColor = addColor(pixelColor,ambient);
                pixelColor = addColor(pixelColor,diffuse);
            }
        }
        return pixelColor;
    }
}
