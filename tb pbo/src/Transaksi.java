import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



//Deklarasi Variabel
public class Transaksi  extends Pricelist{
    public Integer noEndorse;
    public String pengirim;
    public String namaBarang;
    public String jenisBarang;
    public String jenisEndorse;
    public Integer banyakPost;
    public Integer totalHarga;

    //Scanner untuk memasukkan data
    Scanner input = new Scanner(System.in);

    //Koneksi ke database
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/dbdataendorse";
    public static String uname = "root";
    public static String pass = "";
    Connection conn;

    //Menambahkan barang ke database
    public void TransaksiEndorse() throws SQLException{
        System.out.println("No Endorse :");
        noEndorse = input.nextInt();
        input.nextLine();

        System.out.println("Nama Brand/Onlineshop : ");
        pengirim = input.nextLine();

        System.out.println("Nama Barang : ");
        namaBarang = input.nextLine();
        
        System.out.println("Jenis Barang (Fashion, Skincare, Make Up, Food, etc) : ");
        jenisBarang = input.nextLine();

        System.out.println("Jenis Postingan : ");
        jenisEndorse = input.nextLine();

        //Percabangan
        switch (jenisEndorse) {
            case "Foto Story":
                System.out.print("Banyak Postingan : ");
                banyakPost = input.nextInt();
                input.nextLine();
                totalHarga = endorseFotoStory * banyakPost;     //Operasi Matematika

                System.out.println("Total Harga : " + totalHarga);
                break;

            case "Video Story":
                System.out.print("Banyak Postingan :");
                banyakPost = input.nextInt();
                input.nextLine();
                totalHarga = endorseVideoStory * banyakPost;    //Operasi Matematika

                System.out.println("Total Harga : "+ totalHarga);
                break;

            case "Foto Feed":
                System.out.print("Banyak Postingan :");
                banyakPost = input.nextInt();
                input.nextLine();
                totalHarga = endorseFotoFeed * banyakPost;      //Operasi Matematika

                System.out.println("Total Harga : "+ totalHarga);
                break;

            case "Video Feed" :
                System.out.print("Banyak Postingan :");
                banyakPost = input.nextInt();
                input.nextLine();
                totalHarga = endorseVideoFeed * banyakPost;     //Operasi Matematika

                System.out.println("Total Harga : "+ totalHarga);
                break;
        
            default:
                break;
        }

        //Menambhakan data Endorse ke database
        String sql = "INSERT INTO endorse (no_endorse, nama_brand, nama_barang, jenis_barang, jenis_endorse, banyak_post, total_harga) VALUES ('"+noEndorse+"', '"+pengirim+"', '"+namaBarang+"', '"+jenisBarang+"', '"+jenisEndorse+"', '"+banyakPost+"', '"+totalHarga+"')";
        conn = DriverManager.getConnection(url, "root", "");
        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Data berhasil ditambah !");

    }

    //Melihat Data Endorse
    public void LihatData() throws SQLException{

        //Method String
        String txt = "Berikut data Endorse Fadil Jaidi :";
        System.out.println(txt.toUpperCase());

        String sql ="SELECT * FROM endorse";
        conn = DriverManager.getConnection(url, "root", "");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

            //Perulangan
            while (result.next()) {
                    System.out.print("No. Endorse\t:");
                    System.out.print(result.getString("no_endorse"));
                    System.out.print("\nNama Brand/Onlineshop\t:");
                    System.out.print(result.getString("nama_brand"));
                    System.out.print("\nNama Barang\t:");
                    System.out.print(result.getString("nama_barang"));
                    System.out.print("\nJenis Barang\t:");
                    System.out.print(result.getString("jenis_barang"));
                    System.out.print("\nJenis Postingan\t:");
                    System.out.print(result.getString("jenis_endorse"));
                    System.out.print("\nBanyak Postingan\t:");
                    System.out.print(result.getString("banyak_post"));
                    System.out.print("\nTotal Harga\t:");
                    System.out.print(result.getString("total_harga"));
                    System.out.println("\n------------------------------------------------");
                }
        
                
            

    }

    //Menghapus Data Endorse
    public void HapusData() throws SQLException {
    String text1 = "\nHapus Data Endorse";
    System.out.println(text1.toUpperCase());
    Scanner dataInput = new Scanner(System.in);

    boolean dataFound;

    do {
        dataFound = false;

        try {
            LihatData();
            System.out.print("Masukkan no Endorse yang akan dihapus : ");
            noEndorse = Integer.parseInt(dataInput.nextLine());

            String sql = "DELETE FROM endorse WHERE no_endorse = " + noEndorse;
            Statement statement = conn.createStatement();

            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Data endorse no " + noEndorse + " berhasil dihapus");
                dataFound = true;  // Set dataFound menjadi true ketika penghapusan berhasil
            } else {
                System.out.println("Data tidak ditemukan. Silakan masukkan nomor endorse yang valid.");
            }

        } catch (SQLException e) {
            System.out.println("Data gagal dihapus");
            System.out.println(e.getMessage());
        }
    } while (!dataFound); // Keluar dari loop hanya jika penghapusan data berhasil
}

    
    
    //Mengubah Data Endorse
    public void UbahData() throws SQLException {
        System.out.print("Ubah Data Endorse\n");
    
        boolean dataFound;
    
        do {
            dataFound = false;
    
            try {
                LihatData();
                System.out.print("\nMasukkan no Endorse yang akan diubah :");
                Integer noEndorse = Integer.parseInt(input.nextLine());
    
                String sql = "SELECT * FROM endorse WHERE no_endorse = " + noEndorse;
                conn = DriverManager.getConnection(url, "root", "");
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
    
                if (result.next()) {
                    System.out.println("Data ditemukan:");
                    System.out.println("\nNo Endorse : " + result.getString("no_endorse"));
                    System.out.println("Nama Brand/Onlineshop : " + result.getString("nama_brand"));
    
                    System.out.println("\nMasukkan perubahan data:");
                    System.out.print("Nama Brand/Onlineshop (" + result.getString("nama_brand") + "): ");
                    String pengirim = input.nextLine();
                    sql = "UPDATE endorse SET nama_brand = '" + pengirim + "' WHERE no_endorse = " + noEndorse;
    
                    if (statement.executeUpdate(sql) > 0) {
                        System.out.println("Data BERHASIL diubah!!");
                        dataFound = true;
                    }
                } else {
                    System.out.println("Data tidak ditemukan!!");
                }
                statement.close();
            } catch (SQLException e) {
                System.err.println("Data GAGAL diubah!!");
                System.err.println(e.getMessage());
            }
        } while (!dataFound); // Ulangi jika nomor endorse tidak ditemukan
    }
    
    

    //Mencari Data Endorse
    public void CariData() throws SQLException {
        System.out.println("Cari Data Endorse");
        System.out.println("");
    
        boolean dataFound;
    
        do {
            dataFound = false; // Menandakan apakah data ditemukan atau tidak
    
            System.out.println("\nMasukkan no Endorse :");
            Integer keyword = Integer.parseInt(input.nextLine());
    
            String sql = "SELECT * FROM endorse WHERE no_endorse LIKE '%" + keyword + "%'";
            conn = DriverManager.getConnection(url, "root", "");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
    
            // Perulangan
            while (result.next()) {
                dataFound = true; // Setel ke true karena data ditemukan
                System.out.print("Data Endorse Fadil Jaidi");
                System.out.print("\nNo Endorse : " + result.getString("no_endorse"));
                System.out.print("\nNama Brand/Onlineshop : " + result.getString("nama_brand"));
                System.out.print("\nNama Barang : " + result.getString("nama_barang"));
                System.out.print("\nJenis Barang : " + result.getString("jenis_barang"));
                System.out.print("\nJenis Endorse : " + result.getString("jenis_endorse"));
                System.out.print("\nBanyak Postingan : " + result.getString("banyak_post"));
                System.out.print("\nTotal Harga : " + result.getString("total_harga"));
                System.out.println("\n---------------------------------------------------");
            }
    
            // Percabangan setelah perulangan
            if (dataFound) {
                System.out.println("Data ditemukan!");
            } else {
                System.out.println("Data tidak ditemukan!!");
            }
    
        } while (!dataFound); // Perulangan jika data tidak ditemukan
    }
    
    
    

}
