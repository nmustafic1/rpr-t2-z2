package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval  {
    private double pocetna, krajnja;
    private boolean pripadaPocetna, pripadaKrajnja;

    public Interval  (double pocetnaTacka, double krajnjaTacka,
                                                     boolean pripadaPocetna, boolean pripadaKrajnja) {
        if (pocetnaTacka > krajnjaTacka) throw  new IllegalArgumentException("Pocetna tacka je veca od krajnje");
        pocetna = pocetnaTacka; krajnja = krajnjaTacka; this.pripadaPocetna = pripadaPocetna; this.pripadaKrajnja = pripadaKrajnja;
    }

    public Interval () {
        pocetna = 0; krajnja = 0; pripadaKrajnja = false; pripadaPocetna = false;
    }
    public boolean isNull () {
        if (pocetna == 0 && krajnja == 0 && pripadaPocetna == false && pripadaKrajnja == false) return true;
        return  false;
    }
    public boolean isIn (double tacka) {
        if (tacka > pocetna && tacka < krajnja) return true;
        if (pripadaPocetna == true && pocetna == tacka) return  true;
        if (pripadaKrajnja == true && krajnja == tacka) return  true;
        return  false;
    }
    public Interval intersect(Interval i) {
        Interval presjek = new Interval();
        if (pocetna >= i.pocetna && krajnja <= i.krajnja) {
            presjek.pocetna = pocetna;
            presjek.krajnja = krajnja;
            if (pripadaPocetna == true) presjek.pripadaPocetna = true;
            else presjek.pripadaPocetna = false;
            if (pripadaKrajnja == true) presjek.pripadaKrajnja = true;
            else presjek.pripadaKrajnja = false;
        }

        else if (pocetna <= i.pocetna && krajnja <= i.krajnja) {
            presjek.pocetna = i.pocetna;
            presjek.krajnja = krajnja;
            if (i.pripadaPocetna == true) presjek.pripadaPocetna = true;
            else presjek.pripadaPocetna = false;
            if (pripadaKrajnja == true) presjek.pripadaKrajnja = true;
            else presjek.pripadaKrajnja = false;
        }
        else if (pocetna <= i.pocetna && krajnja >= i.krajnja) {
            presjek.pocetna = i.pocetna;
            presjek.krajnja = i.krajnja;
            if (i.pripadaPocetna == true) presjek.pripadaPocetna = true;
            else presjek.pripadaPocetna = false;
            if (i.pripadaKrajnja == true) presjek.pripadaKrajnja = true;
            else presjek.pripadaKrajnja = false;
        }
        else if (pocetna >= i.pocetna && krajnja >= i.krajnja) {
            presjek.pocetna = pocetna;
            presjek.krajnja = i.krajnja;
            if (pripadaPocetna == true) presjek.pripadaPocetna = true;
            else presjek.pripadaPocetna = false;
            if (i.pripadaKrajnja == true) presjek.pripadaKrajnja = true;
            else presjek.pripadaKrajnja = false;
        }
        return  presjek;
    }
    public static Interval intersect (Interval i1, Interval i2) {
        return i1.intersect(i2);
    }
    @Override
    public String toString() {
        if (isNull()) return "()";
        String s = new String();
        if (pripadaPocetna == true) s= "[";
        else s= "(";
        s = s + pocetna + "," + krajnja;
        if (pripadaKrajnja == true) s= s + "]";
        else s= s + ")";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetna, pocetna) == 0 &&
                Double.compare(interval.krajnja, krajnja) == 0 &&
                pripadaPocetna == interval.pripadaPocetna &&
                pripadaKrajnja == interval.pripadaKrajnja;
    }


}
