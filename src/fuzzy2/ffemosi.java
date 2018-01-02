/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy2;

/**
 *
 * @author MBP
 */
public class ffemosi {
    double drjtkeanggotaan;
    String linguistik;

    public ffemosi(String linguistik, double drjtkeanggotaan) {
        this.drjtkeanggotaan = drjtkeanggotaan;
        this.linguistik = linguistik;
    }

    public double getDrjtkeanggotaan() {
        return drjtkeanggotaan;
    }

    public void setDrjtkeanggotaan(double drjtkeanggotaan) {
        this.drjtkeanggotaan = drjtkeanggotaan;
    }

    public String getLinguistik() {
        return linguistik;
    }

    public void setLinguistik(String linguistik) {
        this.linguistik = linguistik;
    }

    @Override
    public String toString() {
        return "ffemosi{" + "drjtkeanggotaan=" + drjtkeanggotaan + ", linguistik=" + linguistik + '}';
    }
    
    
    
}
