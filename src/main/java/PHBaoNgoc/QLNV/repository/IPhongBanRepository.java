package PHBaoNgoc.QLNV.repository;

import PHBaoNgoc.QLNV.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository  extends JpaRepository<PhongBan, String> {
}
