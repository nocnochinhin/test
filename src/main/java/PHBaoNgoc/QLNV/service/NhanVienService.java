package PHBaoNgoc.QLNV.service;

import PHBaoNgoc.QLNV.model.NhanVien;
import PHBaoNgoc.QLNV.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    /*    public NhanVien getNhanVienById(String id){
            Optional<NhanVien> optionalBook = nhanVienRepository.findById(id);
            return optionalBook.orElse(null);
        }*/
    public void add(NhanVien newNhanVien){
        nhanVienRepository.save(newNhanVien);
    }
    public void updateBook(NhanVien newbook){
        nhanVienRepository.save(newbook);
    }
//    public void deleteBook(String id){
//        nhanVienRepository.deleteById(id);
//    }
}
