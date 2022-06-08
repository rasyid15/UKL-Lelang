package Aplikasi_Lelang;

public class Main_Lelang {

    public static void main(String[] args) {
        Masyarakat user = new Masyarakat();
        Petugas petugas = new Petugas();
        Barang product = new Barang();
        Transaksi_Lelang Transaksi = new Transaksi_Lelang
        (user, petugas, product);
    }
    
}
