package Task003;

import Task002.Vector2D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;

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

    @BeforeClass
    public static void initialization() {
        cm1 = new ComplexMatrix2x2(new ComplexNumber(5, 0));
        cm2 = new ComplexMatrix2x2(new ComplexNumber(2, 0));
    }

    @Test
    public void zeroConstructorShouldWorkCorrectly() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();  // should be all zeros
        ComplexNumber cn = new ComplexNumber(); // zero
        checkForComplexNumberInMatrix(cm, cn);
    }

    @Test
    public void secondConstructorShouldWorkCorrectly() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2(new ComplexNumber(5, 0));  // should be all five
        ComplexNumber cn = new ComplexNumber(5, 0); // five
        checkForComplexNumberInMatrix(cm, cn);
    }

    @Test
    public void thirdConstructorShouldWorkCorrectly() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2(new ComplexNumber(5, 0),
                new ComplexNumber(5, 0), new ComplexNumber(5, 0), new ComplexNumber(5, 0));  // should be all five
        ComplexNumber cn = new ComplexNumber(5, 0); // five
        checkForComplexNumberInMatrix(cm, cn);
    }

    @Test
    public void addMethodShouldReturnSumOfTwoMatrices() {
        ComplexMatrix2x2 result = cm1.add(cm2);
        ComplexNumber cn = new ComplexNumber(7, 0);
        checkForComplexNumberInMatrix(result, cn);
    }

    @Test
    public void multMethodShouldReturnMultiplicationOfTwoMatrices() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(new ComplexNumber(1, 0));
        ComplexMatrix2x2 result = cm1.mult(m);
        ComplexNumber cn = new ComplexNumber(10, 0);
        checkForComplexNumberInMatrix(result, cn);
    }

    @Test
    public void detMethodShouldReturnDeterminantOfTheMatrix() {
        ComplexNumber result = cm1.det();
        Assert.assertEquals(new ComplexNumber(),result);
    }

    @Test
    public void multVectorMethodShouldWorkCorrectly(){
        ComplexVector2D vector2D = mock(ComplexVector2D.class);
        when(vector2D.getA()).thenReturn(new ComplexNumber(1,0));
        when(vector2D.getB()).thenReturn(new ComplexNumber(2,0));
        ComplexVector2D result = cm1.multVector(vector2D);
        ComplexNumber expected = new ComplexNumber(15,0);
        Assert.assertEquals(expected,result.getA());
        Assert.assertEquals(expected,result.getB());
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
