package entity;

import java.util.Date;
import java.util.Locale;

public class Gem {
    private String id;
    private String name;
    private Preciousness preciousness;
    private Locale origin;
    private VisualParameter visualParameter;
    private Date extractionTime;
    private Value value;

    public Gem(String name, Preciousness preciousness, Locale origin, VisualParameter visualParameter, Date extractionTime, Value value) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameter = visualParameter;
        this.extractionTime = extractionTime;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public Locale getOrigin() {
        return origin;
    }

    public void setOrigin(Locale origin) {
        this.origin = origin;
    }

    public VisualParameter getVisualParameter() {
        return visualParameter;
    }

    public void setVisualParameter(VisualParameter visualParameter) {
        this.visualParameter = visualParameter;
    }

    public Date getExtractionTime() {
        return extractionTime;
    }

    public void setExtractionTime(Date extractionTime) {
        this.extractionTime = extractionTime;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
