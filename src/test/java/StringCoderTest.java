import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class StringCoderTest {

    private String input;
    private String expectedCode;
    private StringCoder stringCoder;

    @Before
    public void init() {
        stringCoder = new StringCoder();
    }

    public StringCoderTest(String input, String expectedCode){
        this.input = input;
        this.expectedCode = expectedCode;
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{
                {"Hello world", "d1e1h1l3o2r1w1"},
                {"Hello wowrld", "d1e1h1l3o2r1w2"},
                {"Ala ma kota", "a4k1l1m1o1t1"},
                {"Java is awesome", "a3e2i1j1m1o1s2v1w1"},
                {"Don't repeat yourself", "a1d1e3f1l1n1o2p1r2s1t2u1y1"},
                {"Don't repeyyyat yourself", "a1d1e3f1l1n1o2p1r2s1t2u1y4"}
        });
    }

    @Test
    public void schouldReturnProperlyCodedString(){
        assertEquals(expectedCode,stringCoder.code(input));
    }
}
