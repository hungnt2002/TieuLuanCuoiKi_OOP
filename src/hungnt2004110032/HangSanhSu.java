package hungnt2004110032;

import java.util.Date;

public class HangSanhSu extends HangHoa {
    
    private String nhaSanXuat;
    private Date ngayNhapKho;
    
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public HangSanhSu(String maHang, String tenHang, int soLuongTonKho, double donGia, String nhaSanXuat,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public HangSanhSu(){}

    @Override
    String danhGiaHangHoa() {
        
        if(getSoLuongTonKho() > 50 && this.ngayNhapKho.after(new Date())){
            return "Danh gia hang hoa ban cham";
        }

        return "Xem nhu khong danh gia";
        
    }

    @Override
    public String toString() {
        System.out.println("----------Hang Sanh Su----------");
        return super.toString() + "HangSanhSu [ngayNhapKho=" + getNgayVietNam().format(ngayNhapKho) + ", nhaSanXuat=" + nhaSanXuat + "\n" + danhGiaHangHoa() + "]";
    }

    


}
