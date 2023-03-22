package edu.up.isgc.raytracer;

/**
 * @author Enrique Luna
 * Allows to create different materials like lambert/ blinn phong and variate its coefficients
 */
public class Material {
    private double ambientCoefficient;
    private double shininess;
    private boolean reflective;
    private boolean refractive;
    private double reflectionCoefficient;
    private double refractiveCoefficient;
    private double refractiveIndex;

    public Material(double ambientCoefficient, double shininess, boolean reflective, boolean refractive, double reflectionCoefficient, double refractiveCoefficient, double refractiveIndex) {
        setAmbientCoefficient(ambientCoefficient);
        setShininess(shininess);
        setReflective(reflective);
        setRefractive(refractive);
        setReflectionCoefficient(reflectionCoefficient);
        setRefractiveCoefficient(refractiveCoefficient);
        setRefractiveIndex(refractiveIndex);
    }

    public double getAmbientCoefficient() {
        return ambientCoefficient;
    }

    public void setAmbientCoefficient(double ambientCoefficient) {
        this.ambientCoefficient = ambientCoefficient;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public boolean isReflective() {
        return reflective;
    }

    public void setReflective(boolean reflective) {
        this.reflective = reflective;
    }

    public boolean isRefractive() {
        return refractive;
    }

    public void setRefractive(boolean refractive) {
        this.refractive = refractive;
    }

    public double getReflectionCoefficient() {
        return reflectionCoefficient;
    }

    public void setReflectionCoefficient(double reflectionCoefficient) { this.reflectionCoefficient = reflectionCoefficient; }

    public double getRefractiveCoefficient() {
        return refractiveCoefficient;
    }

    public void setRefractiveCoefficient(double refractiveCoefficient) {
        this.refractiveCoefficient = refractiveCoefficient;
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }
}
