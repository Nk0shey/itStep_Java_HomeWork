package com.nk0shey.productservice.spec;
import com.nk0shey.productservice.model.Product;
import org.springframework.data.jpa.domain.Specification;
import java.util.Locale;
public class ProductSpecification {
 public static Specification<Product> named(String query) {
  return (root,cq,cb) -> query==null || query.isBlank() ? cb.conjunction() :
   cb.like(cb.lower(root.get("name")), "%"+query.toLowerCase(Locale.ROOT).replace("\\","\\\\").replace("%","\\%").replace("_","\\_")+"%", '\\');
 }
}
