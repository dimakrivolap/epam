package entity;
/**
 * Gem. Entity class.
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Gem {
    private String id;
    private String name;
    private Preciousness preciousness;
    private Locale origin;
    private VisualParameter visualParameter;
    private Date extractionTime;
    private Value value;

    public Gem() {
        visualParameter = new VisualParameter();
        value = new Value(Unit.CARAT, 0);
    }

    public Gem(String id, String name, Preciousness preciousness, Locale origin, VisualParameter visualParameter, Date extractionTime, Value value) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gem gem = (Gem) o;
        return Objects.equals(id, gem.id) &&
                Objects.equals(name, gem.name) &&
                preciousness == gem.preciousness &&
                Objects.equals(origin, gem.origin) &&
                Objects.equals(visualParameter, gem.visualParameter) &&
                Objects.equals(extractionTime, gem.extractionTime) &&
                Objects.equals(value, gem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, preciousness, origin, visualParameter, extractionTime, value);
    }

    @Override
    public String toString() {
        return "Gem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", origin=" + origin +
                ", visualParameter=" + visualParameter.toString() +
                ", extractionTime=" + extractionTime +
                ", value=" + value.toString() +
                '}';
    }
}
