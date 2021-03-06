package util;
/**
 * AbstractGemsBuilder. Class contains set with gems.
 * <p>
 * 26 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import entity.Gem;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemsBuilder {
    protected Set<Gem> gems;

    public AbstractGemsBuilder() {
        gems = new HashSet<Gem>();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename);
}
