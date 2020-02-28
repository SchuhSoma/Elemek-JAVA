/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Soma
 */
public class Elemek {
static ArrayList<ElemekAdatok> ElList=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         Feladat1Beolvasasa();
         Feladat2ElemekSzama();
         Feladat3ElemekRendszama1030();
         Feladat4Olvadas();
         FeladatAtlagTomeg();
         Feladat6Legmagasabb();
         Feladat7Kereses();
         Feladat9Kiiratas();
    }

    private static void Feladat1Beolvasasa()
    {
        System.out.println("1.Feladat: Adatok beolvasása");
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl=new FileReader("elemek.txt");
            try (BufferedReader br = new BufferedReader(fajl))
            {
                int i=0;
                String sor=null;
                
                while ((sor = br.readLine())!=null)
                {
                    String[] dbok=sor.split(";");
                    int Rendszam=Integer.parseInt(dbok[0]);
                    String Vegyjel=dbok[1];
                    String Nev=dbok[2];
                    double Atomtomeg=Double.parseDouble(dbok[3]);
                    double OlvadasPont=Double.parseDouble(dbok[4]);
                    double ForrasPont=Double.parseDouble(dbok[5]);
                    double ElektronNegativitas=Double.parseDouble(dbok[6]);
                    
                    ElemekAdatok El=new ElemekAdatok(Rendszam, Vegyjel, Nev, Atomtomeg, OlvadasPont, ForrasPont, ElektronNegativitas);
                    ElList.add(El);
                   
                    
                }
            }
            System.out.println("\tSikeres beolvasás");
        } 
        catch (IOException| NumberFormatException e) 
        {
            System.out.println("Hiba: " + e);
        }
        
    }

    private static void Feladat2ElemekSzama() 
    {
        System.out.println("\n2.Feladat: Kémiai elemek száma");
        int db=0;
        for (ElemekAdatok elemekAdatok : ElList)
        {
            db++;
        }
        System.out.println("\tKémiai elemek száma: "+db);
    }

    private static void Feladat3ElemekRendszama1030()
    {
        System.out.println("\n3.Feladat: Kémiai elemek melyek rendszáma 10 és 30 közé esik");
        int db=0;
        for (ElemekAdatok elemekAdatok : ElList)
        {
            if(10<elemekAdatok.Rendszam && elemekAdatok.Rendszam<=30)
            {
                db++;
                System.out.println("\tRendszám: "+elemekAdatok.Rendszam+"\tNév:"+elemekAdatok.Nev);
            }
        }
        System.out.println("\tEnnyi elem van "+db+" melynek rendszáma 10 és 30 közé esik");
    }

    private static void Feladat4Olvadas()
    {
        System.out.println("\n4.Feladat: szobahőmérsékleten (293 Kelvin) folyékony halmazállapotú");
        int db = 0;
        for (ElemekAdatok elemekAdatok : ElList)
        {
             if(elemekAdatok.OlvadasPont<293 &&   elemekAdatok.ForrasPont>293 )
                {
                    db++;
                }
        }
        System.out.println("\tÖsszesen:"+db+" elem folyékony szobahőmérsékleten");
    }

    private static void FeladatAtlagTomeg() {
        System.out.println("\n5.Feladat: átlagos közelítő atomtömeg");
         double osszeg = 0;
         double atlag = 0;
         for (ElemekAdatok elemekAdatok : ElList)
        {
            osszeg += elemekAdatok.Atomtomeg;
            atlag = osszeg / ElList.size();
        }
        System.out.println("\tÁtalagos közelitő atomtömeg: "+atlag);
    }

    private static void Feladat6Legmagasabb() 
    {
        System.out.println("\n6.Feladat: legmagasabb olvadaspont");
        double MaxOlvad = ElList.get(0).OlvadasPont;
        String MaxNev = ElList.get(0).Nev;
        for (int i = 0; i < ElList.size(); i++)
        {
            if(ElList.get(i).OlvadasPont>MaxOlvad)
            {
                MaxOlvad=ElList.get(i).OlvadasPont;
                MaxNev=ElList.get(i).Nev;
            }
        }
        System.out.println("\tA legmagasabb olvadáspont:"+MaxOlvad+"  anyag neve:"+MaxNev);
    }

    private static void Feladat7Kereses()
    {
        System.out.println("\n7.Feladat: keresés bemeneti paraméterrel");
       
        System.out.println("\tKérem adja meg a keresett elem rendszámát: ");
        Scanner be=new Scanner(System.in);
        double kulcs=Double.parseDouble(be.next());
        int szamlalo=0;
        
        while(szamlalo<ElList.size() && kulcs!=ElList.get(szamlalo).getRendszam())
        {
            szamlalo++;
            
        }
        if(szamlalo==ElList.size())
        {
          System.out.println("Sajnos nincs ilyen termék");
        }
        else
        {
          System.out.println("\tA keresett elem neve:"+ElList.get(szamlalo).getNev()+" keresett elem rendszáma:"+ElList.get(szamlalo).getRendszam()+" keresett elem tömege:"+ElList.get(szamlalo).getAtomtomeg());
        }
    }

    private static void Feladat9Kiiratas() {
        System.out.println("\n9.Feladat: az egy karakteres vegyjelű elemek rendszámát, nevét és a forráspontjuk és az olvadáspontjuk különbségét");
            int hossz = 0;
            double kulunbseg=0;
            
            for (int i = 0; i < ElList.size(); i++)
            {
                hossz = (ElList.get(i).Vegyjel.length());
                if(hossz<2)
                {
                    kulunbseg=(ElList.get(i).ForrasPont-ElList.get(i).OlvadasPont);
                    System.out.println("\t"+ElList.get(i).Vegyjel+",\t"+ElList.get(i).Nev+",\t{"+ElList.get(i).Rendszam+",\tforráspont, olvadáspont különbség: "+kulunbseg);
                   
                }
            }
            
    }
    
}
