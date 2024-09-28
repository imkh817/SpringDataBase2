package hello.itemservice.repository.v2;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SpringJPA를 사용하여 기본 crud 기능 사용
 */
@Repository
public interface ItemRespositoryV2  extends JpaRepository<Item, Long> {

}
