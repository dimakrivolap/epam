package entity;

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
}
