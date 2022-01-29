package yang.mocktest;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author yang
 * @className MockTest
 * @description TODO
 * @date 2021/7/12 11:27
 * @Version 1.0
 */
public class MockTest {
    @Test
    public void mockTest(){
        List mock = mock(List.class);

        mock.add("one");
        mock.add("two");
        mock.add("two");

        when(mock.size()).thenReturn(1);

        Assert.assertEquals(mock.size(),1);

        verify(mock,atLeastOnce()).add("one");
        verify(mock,times(2)).add("two");
        verify(mock,times(2)).add("two");
    }

    @Test
    public void testMap(){
        Map map = new HashMap<>();
        map.putAll(null);
    }
}
