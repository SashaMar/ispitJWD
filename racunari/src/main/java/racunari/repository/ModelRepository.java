package racunari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import racunari.model.Model;
@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
	List<Model> findByProizvodjacId(Long proizvodjacId);

}
