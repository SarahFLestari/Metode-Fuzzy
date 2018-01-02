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
public class Berita {
    
    public List<ffemosi> daftarEmosi = new ArrayList<>(); 
    public List<ffprov> daftarprov = new ArrayList<>();
    private double nilaiRendah = 0, nilaiTinggi = 0;
    private double NKTrue = 0, NKFalse = 0;
    private String hoax; 
    private double NK;

    
    
    public double getNK() {
        return NK;
    }

    public void setNK(double NK) {
        this.NK = NK;
    }

    public String getEmosi(){
        return daftarEmosi.toString();
    }
    
    public String getHoax() {
        return hoax;
    }

    public void setHoax(String hoax) {
        this.hoax = hoax;
    }
            
    @Override
    public String toString() {
        return  "NKTrue = " + NKTrue + ", NKFalse = " + NKFalse + " Hoax = "+hoax +"(" + NK+")";
    }

    public double getNKTrue() {
        return NKTrue;
    }

    public double getNKFalse() {
        return NKFalse;
    }
    
    
    
    public void addemosi(ffemosi e){
        daftarEmosi.add(e);
    }
    public void addprov(ffprov p){
        daftarprov.add(p);
    }

    public List<ffemosi> getDaftarEmosi() {
        return daftarEmosi;
    }
    
    public void Fuzzinference(){
        for (ffemosi e : daftarEmosi) {
            for (ffprov p : daftarprov) {
                System.out.println("emosi " + e.getLinguistik()+"(" +e.getDrjtkeanggotaan()+ ")");
                System.out.println("provokasi " + p.getLinguistik()+"(" +p.getDrjtkeanggotaan()+ ")");
                if (e.getLinguistik() == "rendah" && p.getLinguistik() == "rendah") {
                    
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiRendah = e.getDrjtkeanggotaan();
                    } else {
                        nilaiRendah = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiRendah > NKFalse) {
                        NKFalse = nilaiRendah;
                    }
                } else if (e.getLinguistik() == "rendah" && p.getLinguistik() == "sedang") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiRendah = e.getDrjtkeanggotaan();
                    } else {
                        nilaiRendah = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiRendah > NKFalse) {
                        NKFalse = nilaiRendah;
                    }
                } else if (e.getLinguistik() == "rendah" && p.getLinguistik() == "tinggi") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiTinggi = e.getDrjtkeanggotaan();
                    } else {
                        nilaiTinggi = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiTinggi > NKTrue) {
                        NKTrue = nilaiTinggi;
                    }
                } else if (e.getLinguistik() == "sedang" && p.getLinguistik() == "rendah") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiRendah = e.getDrjtkeanggotaan();
                    } else {
                        nilaiRendah = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiRendah > NKFalse) {
                        NKFalse = nilaiRendah;
                    }
                } else if (e.getLinguistik() == "sedang" && p.getLinguistik() == "sedang") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiRendah = e.getDrjtkeanggotaan();
                    } else {
                        nilaiRendah = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiRendah > NKFalse) {
                        NKFalse = nilaiRendah;
                    }
                } else if (e.getLinguistik() == "sedang" && p.getLinguistik() == "tinggi") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiTinggi = e.getDrjtkeanggotaan();
                    } else {
                        nilaiTinggi = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiTinggi > NKTrue) {
                        NKTrue = nilaiTinggi;
                    }
                } else if (e.getLinguistik() == "tinggi" && p.getLinguistik() == "rendah") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiRendah = e.getDrjtkeanggotaan();
                    } else {
                        nilaiRendah = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiRendah > NKFalse) {
                        NKFalse = nilaiRendah;
                    }
                } else if (e.getLinguistik() == "tinggi" && p.getLinguistik() == "sedang") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiTinggi = e.getDrjtkeanggotaan();
                    } else {
                        nilaiTinggi = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiTinggi > NKTrue) {
                        NKTrue = nilaiTinggi;
                    }
                } else if (e.getLinguistik() == "tinggi" && p.getLinguistik() == "tinggi") {
                    if (e.getDrjtkeanggotaan() < p.getDrjtkeanggotaan()){
                        nilaiTinggi = e.getDrjtkeanggotaan();
                    } else {
                        nilaiTinggi = p.getDrjtkeanggotaan();
                    }
                    
                    if (nilaiTinggi > NKTrue) {
                        NKTrue = nilaiTinggi;
                    }    
                }
            }
        }
        
    }

    
    
    public void tampilEmosi(){
        for (ffemosi e : daftarEmosi){
            System.out.println("Fuzzyfication emosi: ("+e.getLinguistik()+","+e.getDrjtkeanggotaan()+")");
        }
    }
    public void tampilProv(){
        for (ffprov p : daftarprov){
            System.out.println("Fuzzyfication provokasi: ("+p.getLinguistik()+","+p.getDrjtkeanggotaan()+")");
        }
    }
    
}
