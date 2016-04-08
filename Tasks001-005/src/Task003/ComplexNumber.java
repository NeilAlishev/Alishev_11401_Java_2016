package Task003;

/**
 * @author Nail Alishev
 *         11-401
 *         task 003
 */
public class ComplexNumber {

    private double real, im;


    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double real, double im) {
        this.real = real;
        this.im = im;
    }


    public void setReal(double real) {
        this.real = real;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getReal() {
        return real;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber add(ComplexNumber b) {
        ComplexNumber c = new ComplexNumber();

        c.setReal(real + b.getReal());
        c.setIm(im + b.getIm());
        return c;

    }

    public void add2(ComplexNumber b) {
        real = this.real + b.getReal();
        im = this.im + b.getIm();
    }

    public ComplexNumber sub(ComplexNumber b) {
        ComplexNumber c = new ComplexNumber();

        c.setReal(real - b.getReal());
        c.setIm(im - b.getIm());
        return c;
    }

    public void sub2(ComplexNumber b) {
        real = this.real - b.getReal();
        im = this.im - b.getIm();
    }

    public ComplexNumber multNumber(double x) {
        ComplexNumber c = new ComplexNumber();
        c.setReal(this.real * x);
        c.setIm(this.im * x);
        return c;
    }

    public void multNumber2(double x) {
        real = this.real * x;
        im = this.im * x;

    }

    public ComplexNumber mult(ComplexNumber b) {
        ComplexNumber c = new ComplexNumber();
        c.setReal(real * b.getReal() - im * b.getIm());
        c.setIm(real * b.getIm() + im * b.getReal());
        return c;
    }


    public void mult2(ComplexNumber b) {
        double real1 = real;
        real = real * b.getReal() - im * b.getIm();
        im = real1 * b.getIm() + im * b.getReal();

    }


    public ComplexNumber div(ComplexNumber b) {
        ComplexNumber c = new ComplexNumber();
        b.setReal(b.getReal());
        b.setIm(-b.getIm());
        c = mult(b);
        double k = b.length() * b.length();
        c.setReal(c.getReal() / k);
        c.setIm(c.getIm() / k);
        return c;

    }

    public void div2(ComplexNumber b) {
        ComplexNumber c = new ComplexNumber();
        b.setReal(b.getReal());
        b.setIm(-b.getIm());
        c = mult(b);
        double k = b.length() * b.length();
        real = c.getReal() / k;
        im = c.getIm() / k;


    }

    public double length() {
        double r = Math.sqrt(getReal() * getReal() + getIm() * getIm());
        return r;
    }

    public String toString() {
        if (im > 0) {
            return (getReal() + "+" + getIm() + "i");
        } else if (im == 0) {
            return (getReal() + "");
        } else
            return (getReal() + "" + getIm() + "i");
    }

    public double arg() {
        return Math.atan2(im, real);

    }

    public ComplexNumber pow(double x) {

        double a, b, c;
        ComplexNumber com = new ComplexNumber();
        com.setIm(this.im);
        com.setReal(this.real);

        a = Math.pow(com.length(), x);
        b = Math.cos(x * com.arg());
        c = Math.sin(x * com.arg());
        com.setReal(a * b);
        com.setIm(a * c);

        return com;


    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ComplexNumber))
            return false;
        ComplexNumber c = (ComplexNumber) other;
        return this.real == c.getReal() && this.im == c.getIm();
    }
}
