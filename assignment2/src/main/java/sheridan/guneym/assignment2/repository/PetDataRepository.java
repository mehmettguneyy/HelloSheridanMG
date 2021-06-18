package sheridan.guneym.assignment2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDataRepository extends JpaRepository<PetEntity, Integer> {
}
