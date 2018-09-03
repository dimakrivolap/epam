package entity;
/**
 * VisualParameter.
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import java.util.Objects;

public class VisualParameter {
    private String color;
    private byte transparency;
    private byte countFacets;

    public VisualParameter() {
    }

    public VisualParameter(String color, byte transparency, byte countFacets) {
        this.color = color;
        this.transparency = transparency;
        this.countFacets = countFacets;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte getTransparency() {
        return transparency;
    }

    public void setTransparency(byte transparency) {
        this.transparency = transparency;
    }

    public byte getCountFacets() {
        return countFacets;
    }

    public void setCountFacets(byte countFacets) {
        this.countFacets = countFacets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualParameter that = (VisualParameter) o;
        return transparency == that.transparency &&
                countFacets == that.countFacets &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, transparency, countFacets);
    }

    @Override
    public String toString() {
        return "VisualParameter{" +
                "color='" + color + '\'' +
                ", transparency=" + transparency +
                ", countFacets=" + countFacets +
                '}';
    }
}
