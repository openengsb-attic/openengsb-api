package org.openengsb.core.api;

/**
 * Simulation of a single Map entry
 */

public class MapElement {
    private Object key;
    private Object value;

    public MapElement(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isKeyEqual(Object key) {
        return key.equals(this.key);
    }

    public boolean isValueEqual(Object value) {
        return value.equals(this.value);
    }

}
