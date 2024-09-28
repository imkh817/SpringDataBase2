package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepositoryV3;
import hello.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.itemservice.repository.v2.ItemRespositoryV2;
import hello.itemservice.service.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager em;
    private final ItemRespositoryV2 itemRespositoryV2; // SpringDataJPA에서 자동으로 빈 등록 해준다.

    @Bean
    public ItemServiceV2 itemServiceV2(){
        return new ItemServiceV2(itemQueryRepositoryV2(), itemRespositoryV2);
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2(){
        return new ItemQueryRepositoryV2(em);
    }

    @Bean
    public ItemRepository itemRepository(){
        return new JpaItemRepositoryV3(em);
    }


}
