package org.openengsb.core.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TransferMapTest {
    @Test
    public void testConvertFromMapToTransfertMap() {
        Map<Integer, String> map = getTestMap();
        TransferMap transfermap = new TransferMap();
        transfermap.putAll(map);
        assertThat(transfermap.size(), is(map.size()));
        for (Integer element : map.keySet()) {
            assertThat(transfermap.containsKey(element), is(true));
            assertThat((String) transfermap.get(element), is(map.get(element)));
        }
    }

    @Test
    public void testConvertFromTransfertMapToMap() {
        Map<Integer, String> map = null;
        TransferMap transfermap = getTestTransfertMap();
        map = transfermap.getMap(new Integer(0), new String());
        assertThat(transfermap.size(), is(map.size()));
        for (Integer element : map.keySet()) {
            assertThat(transfermap.containsKey(element), is(true));
            assertThat((String) transfermap.get(element), is(map.get(element)));
        }
    }

    private Map<Integer, String> getTestMap() {
        Map<Integer, String> result = new HashMap<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            result.put(i, "Testcase" + i);
        }
        return result;
    }

    private TransferMap getTestTransfertMap() {
        TransferMap result = new TransferMap();
        for (int i = 0; i < 1000; i++) {
            result.put(i, "Testcase" + i);
        }
        return result;
    }

}
