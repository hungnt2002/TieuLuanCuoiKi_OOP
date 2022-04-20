package hungnt2004110032;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public abstract class HangHoa implements Serializable {
    
    private String maHang;
    private String tenHang;
    private int soLuongTonKho;
    private double donGia;
    private transient Scanner nhap = new Scanner(System.in);
    private SimpleDateFormat ngayVietNam = new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa(String maHang, String tenHang, int soLuongTonKho, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTonKho = soLuongTonKho;
        this.donGia = donGia;
    }
    
    public HangHoa(){}


    public SimpleDateFormat getNgayVietNam() {
        return ngayVietNam;
    }


    public void setNgayVietNam(SimpleDateFormat ngayVietNam) {
        this.ngayVietNam = ngayVietNam;
    }

    public Scanner getNhap() {
        return nhap;
    }

    public void setMaHang(String maHang) {
        // code ràng buộc mã hàng không được rỗng
        while(maHang.equals("") || maHang.isEmpty()){
            System.out.println("Ma hang khong duoc de trong !");
            System.out.print("Moi ban nhap lai ma hang: ");
            maHang = nhap.nextLine();
        }
            this.maHang = maHang;

    }

    public String getMaHang() {
        return maHang;
    }

    public void setTenHang(String tenHang) {
        // code ràng buộc tên hàng không được rỗng 
        while(tenHang.equals("") || tenHang.isEmpty()){
            System.out.println("Ten hang khong duoc rong!");
            System.out.print("Moi ban nhap lai ten hang: ");
            tenHang = nhap.nextLine();
        }
            this.tenHang = tenHang;
        
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        // code ràng buộc sô lượng tồn kho phải >= 0
        while(soLuongTonKho < 0){
            System.out.println("So luong ton kho phai >= 0 !!!");
            System.out.print("Moi ban nhap lai so luong ton kho: ");
            soLuongTonKho = nhap.nextInt();
        }
            this.soLuongTonKho = soLuongTonKho;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setDonGia(double donGia) {
        // code ràng buộc đơn giá phải lớn hơn 0
        while(donGia <= 0){
            System.out.println("Don gia > 0 !");
            System.out.print("Moi ban nhap lai don gia: ");
            donGia = nhap.nextDouble();
        }
        this.donGia = donGia;

    }

    public double getDonGia() {
        return donGia;
    }

    abstract String danhGiaHangHoa(); // đánh giá mức độ bán buôn

    @Override
    public String toString() {
        return "HangHoa [donGia=" + donGia + ", maHang=" + maHang + ", soLuongTonKho=" + soLuongTonKho + ", tenHang="
                + tenHang + "]";
    }

    
    
}
