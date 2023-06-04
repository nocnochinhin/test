package PHBaoNgoc.QLNV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import PHBaoNgoc.QLNV.model.NhanVien;
@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}
