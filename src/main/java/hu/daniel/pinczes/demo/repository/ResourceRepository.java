package hu.daniel.pinczes.demo.repository;


import hu.daniel.pinczes.demo.entity.Resource;
import hu.daniel.pinczes.demo.entity.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findAllByType(ResourceType type);
}
