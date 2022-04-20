package hungnt2004110032;

import java.util.Date;

public class HangThucPham extends HangHoa {
    
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    
    public HangThucPham(String maHang, String tenHang, int soLuongTonKho, double donGia, Date ngaySanXuat,
            Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    public HangThucPham(){}

    @Override
    String danhGiaHangHoa() {
        if(getSoLuongTonKho() > 0 && this.ngayHetHan.after(new Date())){
            return "Danh gia hang hoa kho ban";
        }
        return "Xem nhu khong danh gia";
    }

    @Override
    public String toString()  {
        
        System.out.println("----------Hang Thuc Pham----------");
        return super.toString()
        + "HangThucPham [ngayHetHan=" + getNgayVietNam().format(ngayHetHan) + ", ngaySanXuat=" + getNgayVietNam().format(ngaySanXuat) + ", nhaCungCap=" + nhaCungCap
             + "\n" + danhGiaHangHoa()   + "]";
    }


    

    
}
