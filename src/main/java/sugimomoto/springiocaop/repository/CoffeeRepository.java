package sugimomoto.springiocaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sugimomoto.springiocaop.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    
}
