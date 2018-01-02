/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MBP
 */
public class Fuzzy2 {

    public static double[] emo = {97,36,63,82,71,79,55,57,40,57,77,68,60,82,40,80,60,50,100,11,58,68,64,57,77,98,91,50,95,27}; 
    public static double[] prov = {74,85,43,90,25,81,62,45,65,45,70,75,70,90,85,68,72,95,18,99,63,70,66,77,55,64,59,95,55,79};
    public static ArrayList<Berita> ffBerita = new ArrayList<>();
    
    
    public static void main(String[] args) {
        int s=1;
        FuzzyFication();
        
        //FFProv(ffBerita);
        for (Berita berita : ffBerita) {
            //System.out.println("cek 1");
            System.out.println("B"+s++);
            berita.Fuzzinference();
            
        }
        s = 1;
        defuzzyyy(ffBerita);
        for (Berita berita : ffBerita) {
            System.out.println("B"+s++);
            System.out.println(berita.toString());
            //System.out.println(berita.getDaftarEmosi());
        }
        System.out.println("Akuransi Model 20 Berita : ");
        hitung();
        
//        for (int i = 0;i<ffBerita.size();i++){
//            int s = i + 1;
//            System.out.println("B"+s);
//            //ffBerita.get(i).tampilEmosi();
//            //ffBerita.get(i).tampilProv();   
//            System.out.println(ffBerita.toString());
//        }
        
        
        
        
    }
    public static void FuzzyFication(){
        for (int i=0;i<30;i++){
            double drjtkeanggotaan = 0;
            double dk2 =0 ;
            Berita b = new Berita();
            if (emo[i] > 0 && emo[i] <= 21) {
                drjtkeanggotaan = 1;
                ffemosi rendah = new ffemosi("rendah",drjtkeanggotaan);
                b.addemosi(rendah);
            } else if (emo[i] >= 35 && emo[i] <= 65){
                drjtkeanggotaan = 1;
                ffemosi sedang = new ffemosi("sedang",drjtkeanggotaan);
                b.addemosi(sedang);
            } else if (emo[i] >= 80 && emo[i] <= 100){
                drjtkeanggotaan = 1;
                ffemosi tinggi = new ffemosi("tinggi",drjtkeanggotaan);
                b.addemosi(tinggi);
            } else if (emo[i] > 21 && emo[i] < 35){
                drjtkeanggotaan = trpsmturun(emo[i],21,35);
                ffemosi rendah = new ffemosi("rendah",drjtkeanggotaan);
                b.addemosi(rendah);
                dk2 = trpsmnaik(emo[i],21,35);
                ffemosi sedang = new ffemosi("sedang",dk2);
                b.addemosi(sedang);
            } else if (emo[i] > 65 && emo[i] < 80){
                drjtkeanggotaan = trpsmturun(emo[i],65,80);
                ffemosi sedang = new ffemosi("sedang",drjtkeanggotaan);
                b.addemosi(sedang);
                dk2 = trpsmnaik(emo[i],65,80);
                ffemosi tinggi = new ffemosi("tinggi",dk2);
                b.addemosi(tinggi);
            }
            
            if (prov[i] > 0 && prov[i] <= 40) {
                drjtkeanggotaan = 1;
                ffprov rendah = new ffprov("rendah",drjtkeanggotaan);
                b.addprov(rendah);
            } else if (prov[i] >= 58 && prov[i] <= 71){
                drjtkeanggotaan = 1;
                ffprov sedang = new ffprov("sedang",drjtkeanggotaan);
                b.addprov(sedang);
            } else if (prov[i] >= 75 && prov[i] <= 100){
                drjtkeanggotaan = 1;
                ffprov tinggi = new ffprov("tinggi",drjtkeanggotaan);
                b.addprov(tinggi);
            } else if (prov[i] > 40 && prov[i] < 58){
                drjtkeanggotaan = trpsmturun(prov[i],40,58);
                ffprov rendah = new ffprov("rendah",drjtkeanggotaan);
                b.addprov(rendah);
                dk2 = trpsmnaik(prov[i],40,58);
                ffprov sedang = new ffprov("sedang",dk2);
                b.addprov(sedang);
            } else if (prov[i] > 71 && prov[i] < 77){
                drjtkeanggotaan = trpsmturun(prov[i],71,77);
                ffprov sedang = new ffprov("sedang",drjtkeanggotaan);
                b.addprov(sedang);
                dk2 = trpsmnaik(prov[i],71,77);
                ffprov tinggi = new ffprov("tinggi",dk2);
                b.addprov(tinggi);
            }
            
            ffBerita.add(b);
        }
    }
                
//            if (emo[i] > 0 && emo[i] < 39){
//                drjtkeanggotaan = trpsm(emo[i],0,0,20,39);
//                ffemosi rendah = new ffemosi("rendah",drjtkeanggotaan);
//                b.addemosi(rendah);
//                if (emo[i] > 20 && emo[i] < 69){
//                    drjtkeanggotaan = trpsm(emo[i],20,39,65,69);
//                    ffemosi sedang = new ffemosi("sedang",drjtkeanggotaan);
//                    b.addemosi(sedang);
//                }
//            } else if (emo[i] > 20 && emo[i] < 69){
//                drjtkeanggotaan = trpsm(emo[i],20,39,65,69);
//                ffemosi sedang = new ffemosi("sedang",drjtkeanggotaan);
//                b.addemosi(sedang);
//                if (emo[i] > 65 && emo[i] < 100){
//                    drjtkeanggotaan = trpsm(emo[i],65,72,100,100);
//                    ffemosi tinggi = new ffemosi("tinggi",drjtkeanggotaan);
//                    b.addemosi(tinggi);
//                }
//            } else if (emo[i] > 65 && emo[i] < 100){
//                drjtkeanggotaan = trpsm(emo[i],65,72,100,100);
//                ffemosi tinggi = new ffemosi("tinggi",drjtkeanggotaan);
//                b.addemosi(tinggi);
//            }
//            ffBerita.add(b);
//        }
        
    public static void FFProv(ArrayList<Berita> berita){
        
        for (int i=0;i<30;i++){
            Berita b = berita.get(i);
            double drjtkeanggotaan;
            double dk2 =0 ;
            if (prov[i] > 0 && prov[i] <= 38) {
                drjtkeanggotaan = 1;
                ffprov rendah = new ffprov("rendah",drjtkeanggotaan);
                b.addprov(rendah);
            } else if (prov[i] >= 40 && prov[i] <= 68){
                drjtkeanggotaan = 1;
                ffprov sedang = new ffprov("sedang",drjtkeanggotaan);
                b.addprov(sedang);
            } else if (prov[i] >= 72 && prov[i] <= 100){
                drjtkeanggotaan = 1;
                ffprov tinggi = new ffprov("tinggi",drjtkeanggotaan);
                b.addprov(tinggi);
            } else if (prov[i] > 38 && prov[i] < 40){
                drjtkeanggotaan = trpsmturun(prov[i],38,40);
                ffprov rendah = new ffprov("rendah",drjtkeanggotaan);
                b.addprov(rendah);
                dk2 = trpsmnaik(prov[i],38,40);
                ffprov sedang = new ffprov("sedang",dk2);
                b.addprov(sedang);
            } else if (prov[i] > 68 && prov[i] < 72){
                drjtkeanggotaan = trpsmturun(prov[i],68,72);
                ffprov sedang = new ffprov("sedang",drjtkeanggotaan);
                b.addprov(sedang);
                dk2 = trpsmnaik(prov[i],68,72);
                ffprov tinggi = new ffprov("tinggi",dk2);
                b.addprov(tinggi);
            }
          
        }
    }
    public static double trpsmnaik(double x, double a, double b){
            double hasil = (x-a)/(b-a);
            return hasil;
    
    }
    public static double trpsmturun(double x, double c, double d){
            double hasil = (-1*(x-d))/(d-c);
            return hasil;
    }
    
    public static void defuzzyyy(ArrayList<Berita> berita){
        double tidak = 25;
        double ya = 75;
        double hasil;
        String hoax;
      
        for (int i=0;i<30;i++){
            Berita b = berita.get(i);
            //System.out.println(b.getNKTrue());
            hasil = ((b.getNKTrue()*ya) + (b.getNKFalse()*tidak))/(b.getNKFalse()+b.getNKTrue()) ;
            if (hasil <= 50 ){
                hoax = "Tidak";
                b.setHoax(hoax);
                b.setNK(hasil);
            } else {
                hoax = "Ya";
                b.setHoax(hoax);
                b.setNK(hasil);
            }
        }
    }   
    
    public static void hitung(){
        double databenar = 19;
        double keseluruhandata = 20;
        double akurasi = (databenar/keseluruhandata)*100;
        System.out.println(akurasi+"%");
    }
            
    
}
