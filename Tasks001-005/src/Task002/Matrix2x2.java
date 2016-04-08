package Task002;

/**
 * @author Nail Alishev
 *         11-401
 *         task 002
 */
public class Matrix2x2 {
    private double[][] matrix = new double[2][2];

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double d) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = d;
            }
        }
    }

    public Matrix2x2(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix2x2(double d1, double d2, double d3, double d4) {
        this.matrix[0][0] = d1;
        this.matrix[0][1] = d2;
        this.matrix[1][0] = d3;
        this.matrix[1][1] = d4;
    }


    public Matrix2x2 add(Matrix2x2 m2) {
        Matrix2x2 result = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result.matrix[i][j] = this.matrix[i][j] + m2.matrix[i][j];
            }
        }
        return result;
    }

    public void add2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] + m2.matrix[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 m2) {
        Matrix2x2 result = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result.matrix[i][j] = this.matrix[i][j] - m2.matrix[i][j];
            }
        }
        return result;
    }

    public void sub2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] - m2.matrix[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double d) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.matrix[i][j] = this.matrix[i][j] * d;
            }
        }
        return m;
    }

    public void multNumber2(double d) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] * d;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 m2) {
        Matrix2x2 result = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double s = 0;
                for (int q = 0; q < 2; q++) {
                    s += matrix[i][q] * m2.matrix[q][j];
                }
                result.matrix[i][j] = s;
            }
        }
        return result;
    }

    public void mult2(Matrix2x2 m) {
        double prevMatrix[][] = {{matrix[0][0], matrix[0][1]},
                {matrix[1][0], matrix[1][1]}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double s = 0;
                for (int q = 0; q < 2; q++) {
                    s += prevMatrix[i][q] * m.matrix[q][j];
                }
                this.matrix[i][j] = s;

            }
        }
    }

    public double det() {
        double result = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        return result;
    }

    public void traspon() {
        double p = matrix[1][0];
        matrix[1][0] = matrix[0][1];
        matrix[0][1] = p;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 result = new Matrix2x2();
        result.matrix = matrix;
        double det = det();
        double d, e;
        e = matrix[0][0];
        d = matrix[0][1];
        if (det == 0) {
            throw new IllegalArgumentException();
        } else {
            result.matrix[0][0] = matrix[1][1];
            result.matrix[0][1] = -matrix[1][0];
            result.matrix[1][0] = -d;
            result.matrix[1][1] = e;
            traspon();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    result.matrix[i][j] = result.matrix[i][j] / det;
                }
            }


        }
        return result;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c.matrix[i][j] = matrix[i][j];
            }
        }
        c.matrix[0][0] = matrix[0][0] * matrix[1][0];
        c.matrix[0][1] = matrix[0][1] * matrix[1][0];
        c.matrix[1][0] = matrix[0][0] * matrix[1][0];
        c.matrix[1][1] = matrix[0][0] * matrix[1][1];

        c.matrix[1][0] = c.matrix[1][0] - c.matrix[0][0];
        c.matrix[1][1] = c.matrix[1][1] - c.matrix[0][1];

        c.matrix[0][0] = c.matrix[0][0] * c.matrix[1][1];
        double d = c.matrix[0][1];
        c.matrix[0][1] = c.matrix[0][1] * c.matrix[1][1];


        c.matrix[1][1] = c.matrix[1][1] * d;

        c.matrix[0][1] = c.matrix[0][1] - c.matrix[1][1];

        return c;
    }

    public Vector2D multVector(Vector2D vector) {
        Vector2D result = new Vector2D();
        result.setA(matrix[0][0] * vector.getA() + matrix[0][1] * vector.getB());
        result.setB(matrix[1][0] * vector.getA() + matrix[1][1] * vector.getB());
        return result;
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

}

