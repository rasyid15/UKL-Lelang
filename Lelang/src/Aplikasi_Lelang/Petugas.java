
package Aplikasi_Lelang;

import java.util.ArrayList;

public class Petugas implements Lelang {
    
    private ArrayList<String> Nama = new ArrayList<String>();
    private ArrayList<String> Alamat = new ArrayList<String>();
    private ArrayList<String> Telepon = new ArrayList<String>();
     
    public Petugas(){
        this.Nama.add("Eqy");
        this.Alamat.add("Semarang");
        this.Telepon.add("082397123452");
    }

    @Override
    public void setNama(String Nama) {
        this.Nama.add(Nama);
    }

    @Override
    public void setAlamat(String Alamat) {
       this.Telepon.add(Alamat);
    }

    @Override
    public void setTelepon(String Telepon) {
        this.Telepon.add(Telepon);
    }

    @Override
    public String getNama(int id) {
        return Nama.get(id);
    }

    @Override
    public String getAlamat(int id) {
       return Alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return Telepon.get(id);
    }
    
}
