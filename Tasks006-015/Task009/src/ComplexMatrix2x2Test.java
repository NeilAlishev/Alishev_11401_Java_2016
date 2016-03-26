import beans.ComplexMatrix2x2;
import beans.ComplexNumber;
import beans.ComplexVector2D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Nail Alishev
 *         11-401
 *         task 003
 */
public class ComplexMatrix2x2Test {
    private static ComplexMatrix2x2 cm1;
    private static ComplexMatrix2x2 cm2;
    private static ComplexNumber cn;
    private static ApplicationContext ac;


    @BeforeClass
    public static void initialization() {
        ac = new ClassPathXmlApplicationContext("spring-config.xml");
        cn = (ComplexNumber) ac.getBean("cn5"); // five
        cm1 = (ComplexMatrix2x2) ac.getBean("cm5");
        cm2 = (ComplexMatrix2x2) ac.getBean("cm2");
    }

    @Test
    public void zeroConstructorShouldWorkCorrectly() {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("cm0");  // should be all zeros
        ComplexNumber cn = (ComplexNumber) ac.getBean("cn0"); // zero
        checkForComplexNumberInMatrix(cm, cn);
    }

    @Test
    public void secondConstructorShouldWorkCorrectly() {
        checkForComplexNumberInMatrix(cm1, cn);
    }

    @Test
    public void thirdConstructorShouldWorkCorrectly() {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("cm5555"); // should be all five
        checkForComplexNumberInMatrix(cm, cn);
    }

    @Test
    public void addMethodShouldReturnSumOfTwoMatrices() {
        ComplexMatrix2x2 result = cm1.add(cm2);
        ComplexNumber cn = (ComplexNumber) ac.getBean("cn7");
        checkForComplexNumberInMatrix(result, cn);
    }

    @Test
    public void multMethodShouldReturnMultiplicationOfTwoMatrices() {
        ComplexMatrix2x2 m = (ComplexMatrix2x2) ac.getBean("cm1");
        ComplexMatrix2x2 result = cm1.mult(m);
        ComplexNumber cn = (ComplexNumber) ac.getBean("cn10");
        checkForComplexNumberInMatrix(result, cn);
    }

    @Test
    public void detMethodShouldReturnDeterminantOfTheMatrix() {
        ComplexNumber result = cm1.det();
        Assert.assertEquals(ac.getBean("cn0"), result);
    }

    @Test
    public void multVectorMethodShouldWorkCorrectly() {
        ComplexVector2D vector2D = mock(ComplexVector2D.class);
        when(vector2D.getA()).thenReturn((ComplexNumber) ac.getBean("cn1"));
        when(vector2D.getB()).thenReturn((ComplexNumber) ac.getBean("cn2"));
        ComplexVector2D result = cm1.multVector(vector2D);
        ComplexNumber expected = (ComplexNumber) ac.getBean("cn15");
        Assert.assertEquals(expected, result.getA());
        Assert.assertEquals(expected, result.getB());
    }

    public void checkForComplexNumberInMatrix(ComplexMatrix2x2 m, ComplexNumber cn) {
        ComplexNumber[][] result = m.getMatrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cn, result[i][j]);
            }
        }
    }
}
