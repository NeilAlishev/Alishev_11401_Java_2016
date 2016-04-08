package Task002;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Nail Alishev
 *         11-401
 *         task 002
 */
public class Matrix2x2Test {
    private static final double EPS = 1e-9;
    private static Matrix2x2 m1;
    private static Matrix2x2 m2;

    @Test
    public void zeroConstructorShouldReturnZeroMatrix() {
        Matrix2x2 matrix = new Matrix2x2();
        checkForNumberInMatrix(matrix, 0);
    }

    @Test
    public void doubleConstructorShouldWorkCorrectly() {
        Matrix2x2 matrix = new Matrix2x2(5);
        checkForNumberInMatrix(matrix, 5);
    }

    @Test
    public void arrayConstructorShouldWorkCorrectly() {
        double[][] localMatrix = new double[2][2];
        localMatrix[0][0] = 1;
        localMatrix[0][1] = 1;
        localMatrix[1][0] = 1;
        localMatrix[1][1] = 1;
        Matrix2x2 matrix = new Matrix2x2(localMatrix);
        checkForNumberInMatrix(matrix, 1);
    }

    @Test
    public void dummyConstructorShouldWorkCorrectly() {
        Matrix2x2 matrix = new Matrix2x2(1, 1, 1, 1);
        double[][] returnedMatrix = matrix.getMatrix();
        checkForNumberInMatrix(matrix, 1);
    }

    @Test
    public void matrixFirstAdditionShouldBeCorrect() {
        Matrix2x2 result = m1.add(m2);
        checkForNumberInMatrix(result, 3);
    }

    @Test
    public void matrixSecondAdditionShouldBeCorrect() {
        Matrix2x2 m = new Matrix2x2(1);
        Matrix2x2 m2 = new Matrix2x2(2);
        m.add2(m2);
        checkForNumberInMatrix(m, 3);
    }

    @Test
    public void matrixSubtractionShouldBeCorrect() {
        Matrix2x2 result = m2.sub(m1);
        checkForNumberInMatrix(result, 1);
    }

    @Test
    public void matrixSecondSubtractionShouldBeCorrect() {
        Matrix2x2 m = new Matrix2x2(2);
        Matrix2x2 m2 = new Matrix2x2(1);
        m.sub2(m2);
        checkForNumberInMatrix(m, 1);
    }

    @Test
    public void multNumberShouldWorkCorrectly() {
        Matrix2x2 result = m2.multNumber(3);
        checkForNumberInMatrix(result, 6);
    }

    @Test
    public void secondMultNumberShouldWorkCorrectly() {
        Matrix2x2 m1 = new Matrix2x2(2);
        m1.multNumber2(2);
        checkForNumberInMatrix(m1, 4);
    }

    @Test
    public void matrixMultiplicationShouldWorkCorrectly() {
        Matrix2x2 result = m1.mult(m2);
        checkForNumberInMatrix(result, 4);
    }

    @Test
    public void secondMatrixMultiplicationShouldWorkCorrectly() {
        Matrix2x2 m1 = new Matrix2x2(1);
        Matrix2x2 m2 = new Matrix2x2(2);
        m1.mult2(m2);
        checkForNumberInMatrix(m1, 4);
    }

    @Test
    public void detMethodShouldReturnCorrectValue() {
        double det = m1.det();
        Assert.assertEquals(det, 0, EPS);
    }

    @Test
    public void transposeMatrixShouldBeCorrect() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        m.traspon();
        double[][] localMatrix = m.getMatrix();
        Assert.assertEquals(localMatrix[0][0], 1, EPS);
        Assert.assertEquals(localMatrix[0][1], 3, EPS);
        Assert.assertEquals(localMatrix[1][0], 2, EPS);
        Assert.assertEquals(localMatrix[1][1], 4, EPS);
    }


    @Test(expected = IllegalArgumentException.class)
    public void inverseMatrixShouldHandleExceptions() {
        m1.inverseMatrix();
    }

    @Test
    public void inverseMatrixShouldBeCorrect() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        double[][] result = m.inverseMatrix().getMatrix();
        Assert.assertEquals(result[0][0], -2, EPS);
        Assert.assertEquals(result[0][1], 1, EPS);
        Assert.assertEquals(result[1][0], 1.5, EPS);
        Assert.assertEquals(result[1][1], -0.5, EPS);
    }

    @Test
    public void diagonalMatrixShouldBeCorrect() {
        Matrix2x2 m = new Matrix2x2(1, 4, 3, 2);
        double[][] returnedMatrix = m.equivalentDiagonal().getMatrix();
        Assert.assertEquals(returnedMatrix[0][0], -30, EPS);
        Assert.assertEquals(returnedMatrix[0][1], 0, EPS);
        Assert.assertEquals(returnedMatrix[1][0], 0, EPS);
        Assert.assertEquals(returnedMatrix[1][1], -120, EPS);
    }

    @Test
    public void multVectorShouldBeCorrect() {
        Vector2D result = m1.multVector(new Vector2D(1, 2));
        Assert.assertEquals(3, result.getA(), EPS);
        Assert.assertEquals(3, result.getB(), EPS);
    }


    @BeforeClass
    public static void initMatrices() {
        m1 = new Matrix2x2(1);
        m2 = new Matrix2x2(2);
    }


    private void checkForNumberInMatrix(Matrix2x2 m, double d) {
        double[][] returnedMatrix = m.getMatrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(d, returnedMatrix[i][j], EPS);
            }
        }
    }

}