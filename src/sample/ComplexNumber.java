package sample;

public class ComplexNumber {
    private int re;
    private int im;

    public ComplexNumber(int re, int im) {
        this.re = re;
        this.im = im;
    }

    public int getRe() {
        return re;
    }

    public int getIm() {
        return im;
    }


    //Сложение
    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getRe() + b.getRe(), a.getIm() + b.getIm());
    }
    //Вычитание
    public static ComplexNumber subtract(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getRe() - b.getRe(), a.getIm() - b.getIm());
    }
    //Умножение
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getRe() * b.getRe() - a.getIm() * b.getIm(), a.getRe() * b.getIm() + a.getIm() * b.getRe());
    }
    //Деление
    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        ComplexNumber temp = new ComplexNumber(b.getRe(), (-1) * b.getIm());
        temp = ComplexNumber.multiply(a, temp);
        int denominator = b.getRe() * b.getRe() + b.getIm() * b.getIm();
        return new ComplexNumber(temp.getRe() / denominator, temp.getIm() / denominator);
    }
    //Сравнение
    public static boolean compare (ComplexNumber a, ComplexNumber b)
    {
        double A1 = Math.sqrt(a.getRe() * a.getRe() + a.getIm()* a.getIm());
        double A2 = Math.sqrt(b.getRe() * b.getRe() + b.getIm()* b.getIm());

        return A1 > A2;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComplexNumber)) {
            return false;
        }

        ComplexNumber n = (ComplexNumber) obj;

        // если все норм возвращаем true
        return !((this.re != n.re) | (this.im != n.im)); //если хоть одна  не совпадает,то возвращаем false
    }
}

