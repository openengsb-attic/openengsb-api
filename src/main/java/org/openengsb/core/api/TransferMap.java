package org.openengsb.core.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Replacement for Maps. With normal Maps the WSDL can not be converted to C# files
 */
@SuppressWarnings("serial")
public class TransferMap implements Serializable {
    private MapElement[] elements;
    // If only one field exist, .Net removes the code and replace
    // TransfertMap with MapElement[]
    private int filedforDotNet;

    public int getFiledforDotNet() {
        return filedforDotNet;
    }

    public void setFiledforDotNet(int filedforDotNet) {
        this.filedforDotNet = filedforDotNet;
    }

    public TransferMap() {
        clear();
    }

    public MapElement[] getElements() {
        return elements;
    }

    public void setElements(MapElement[] elements) {
        this.elements = elements;
    }

    public void clear() {
        elements = new MapElement[0];
    }

    public boolean containsKey(Object key) {
        for (MapElement element : elements) {
            if (element.isKeyEqual(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (MapElement element : elements) {
            if (element.isValueEqual(value)) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        for (MapElement element : elements) {
            if (element.isKeyEqual(key)) {
                return element.getValue();
            }
        }
        return null;
    }

    public boolean transferMapEmpty() {
        return elements == null || elements.length <= 0;
    }

    public void put(Object key, Object value) {
        List<MapElement> list = new LinkedList<MapElement>();
        for (MapElement mapElement : elements) {
            list.add(mapElement);
        }
        list.add(new MapElement(key, value));
        elements = (MapElement[]) list.toArray(new MapElement[0]);
    }

    public void putAll(Map<? extends Object, ? extends Object> m) {
        clear();
        List<MapElement> list = new LinkedList<MapElement>();
        for (Object key : m.keySet()) {
            list.add(new MapElement(key, m.get(key)));
        }
        elements = (MapElement[]) list.toArray(new MapElement[0]);
    }

    public int size() {
        return elements.length;
    }

    public <K, V> Map<K, V> getMap(K keyType, V ValueType) {
        return TransferMap.convert(elements, keyType, ValueType);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> convert(MapElement[] elements, K keyType, V ValueType) {
        Map<K, V> result = new HashMap<K, V>();
        for (MapElement transfertMap : elements) {
            result.put((K) transfertMap.getKey(), (V) transfertMap.getValue());
        }
        return result;
    }

}
