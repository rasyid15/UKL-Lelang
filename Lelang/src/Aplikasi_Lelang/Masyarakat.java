
package Aplikasi_Lelang;

import java.util.ArrayList;

public class Masyarakat implements Lelang{
    
    private ArrayList<String> Nama = new ArrayList<String>();
    private ArrayList<String> Alamat = new ArrayList<String>();
    private ArrayList<String> Telepon = new ArrayList<String>();
     
   public Masyarakat(){
       Nama.add("Ano");
       Alamat.add("Jakarta");
       Telepon.add("081234209724");
       
       Nama.add("Aqi");
       Alamat.add("Bandung");
       Telepon.add("083234209725");
       
       Nama.add("Anne");
       Alamat.add("Surabaya");
       Telepon.add("082237209720");
   
   } 
    
    @Override
    public void setNama(String Nama) {
       this.Nama.add(Nama);
    }

    @Override
    public void setAlamat(String Alamat) {
        this.Alamat.add(Alamat);
    
    }

    @Override
    public void setTelepon(String Telepon) {
        this.Telepon.add(Telepon);
   
    }

    @Override
    public String getNama(int id) {
        return this.Nama.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.Alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
       return this.Telepon.get(id);
    }
    
}
