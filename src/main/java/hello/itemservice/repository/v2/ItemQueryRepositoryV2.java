package hello.itemservice.repository.v2;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static hello.itemservice.domain.QItem.*;

/**
 * 동적 쿼리만 조회하는 레포지토리
 * 기본 crud는 SpringJPA를 사용하고 동적쿼리는 Querydsl을 사용
 */
@Repository
public class ItemQueryRepositoryV2 {

    private final JPAQueryFactory query;

    public ItemQueryRepositoryV2(EntityManager em){
        this.query = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond){
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        return query.select(item)
                .from(item)
                .where(likeItemName(itemName),maxPriceloe(maxPrice))
                .fetch();

    }

    private BooleanExpression likeItemName(String itemName){
        if(StringUtils.hasText(itemName)){
            return item.itemName.like("%"+itemName+"%");
        }
        return null;
    }

    private BooleanExpression maxPriceloe(Integer maxPrice){
        if(maxPrice != null){
            return item.price.loe(maxPrice);
        }
        return null;
    }


}
