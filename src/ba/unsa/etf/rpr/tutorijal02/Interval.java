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



}
