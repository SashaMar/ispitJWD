package racunari.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import racunari.model.Konfiguracija;
@Repository
public interface KonfiguracijaRepository extends JpaRepository<Konfiguracija, Long> {
	@Query("SELECT k FROM Konfiguracija k WHERE"
			+ "(:modelNaziv IS NULL OR k.model.naziv LIKE :modelNaziv) AND"
			+ "(:minCena IS NULL OR k.cena >= :minCena) AND"
			+ "(:maxCena IS NULL OR k.cena <= :maxCena) AND"
			+ "(:minRAM IS NULL OR k.ram >= :minRAM) AND"
			+ "(:maxRAM IS NULL OR k.ram <= :maxRAM)")
	Page<Konfiguracija> pretraga(
			@Param("modelNaziv") String modelNaziv,
			@Param("minCena") Integer minCena,
			@Param("maxCena") Integer maxCena,
			@Param("minRAM") Integer minRAM,
			@Param("maxRAM") Integer maxRAM,
			Pageable pageNum			
			);

}
