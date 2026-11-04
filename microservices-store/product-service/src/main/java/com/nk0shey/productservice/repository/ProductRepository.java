package com.nk0shey.productservice.repository;
import com.nk0shey.productservice.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
 @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select p from Product p where p.id=:id")
 Optional<Product> locked(@Param("id") Long id);
}
