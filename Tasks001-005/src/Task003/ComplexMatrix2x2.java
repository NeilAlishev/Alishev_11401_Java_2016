package Task003;

/**
 * @author Nail Alishev
 *         11-401
 *         task 003
 */
public class ComplexMatrix2x2 {
    private ComplexNumber a[][] = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber c) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = c;
            }

        }
    }

    public ComplexMatrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
        this.a[0][0] = a;
        this.a[0][1] = b;
        this.a[1][0] = c;
        this.a[1][1] = d;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 com) {
        ComplexMatrix2x2 complex = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                complex.a[i][j] = this.a[i][j].add(com.a[i][j]);
            }
        }
        return complex;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 com) {
        ComplexNumber s = new ComplexNumber();
        ComplexMatrix2x2 c = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int q = 0; q < 1; q++) {
                    s = ((a[i][q].mult(com.a[q][j]))).add((a[i][q + 1].mult(com.a[q + 1][j])));
                }
                c.a[i][j] = s;
                s = new ComplexNumber();
            }
        }
        return c;
    }

    public ComplexNumber det() {
        return this.a[0][0].mult(this.a[1][1]).sub(this.a[0][1].mult(this.a[1][0]));
    }

    public ComplexVector2D multVector(ComplexVector2D ratio) {
        ComplexVector2D v = new ComplexVector2D();
        v.setA(a[0][0].mult(ratio.getA()).add(a[0][1].mult(ratio.getB())));
        v.setB(a[1][0].mult(ratio.getA()).add(a[1][1].mult(ratio.getB())));
        return v;
    }

    public ComplexNumber[][] getMatrix() {
        return this.a;
    }
}