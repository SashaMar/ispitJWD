package racunari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import racunari.model.Proizvodjac;
@Repository
public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Long> {

}
