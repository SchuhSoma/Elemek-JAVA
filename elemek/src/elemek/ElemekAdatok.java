/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemek;

/**
 *
 * @author Soma
 */
class ElemekAdatok 
{
        public int  Rendszam;
        public String Vegyjel;
        public String Nev;
        public double Atomtomeg;
        public double OlvadasPont;
        public double ForrasPont;
        public double ElektronNegativitas;

   

    public ElemekAdatok(int  Rendszam, String Vegyjel, String Nev, double Atomtomeg, double OlvadasPont, double ForrasPont, double ElektronNegativitas) {
        this.Rendszam = Rendszam;
        this.Vegyjel = Vegyjel;
        this.Nev = Nev;
        this.Atomtomeg = Atomtomeg;
        this.OlvadasPont = OlvadasPont;
        this.ForrasPont = ForrasPont;
        this.ElektronNegativitas = ElektronNegativitas;
    }

    public double getRendszam() {
        return Rendszam;
    }

    public String getVegyjel() {
        return Vegyjel;
    }

    public String getNev() {
        return Nev;
    }

    public double getAtomtomeg() {
        return Atomtomeg;
    }

    public double getOlvadasPont() {
        return OlvadasPont;
    }

    public double getForrasPont() {
        return ForrasPont;
    }

    public double getElektronNegativitas() {
        return ElektronNegativitas;
    }

   
}
