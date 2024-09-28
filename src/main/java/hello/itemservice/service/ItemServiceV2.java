package hello.itemservice.service;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import hello.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.itemservice.repository.v2.ItemRespositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class ItemServiceV2 implements ItemService{

    private final ItemQueryRepositoryV2 itemQueryRepositoryV2;
    private final ItemRespositoryV2 itemRespositoryV2;

    @Override
    public Item save(Item item) {
        return itemRespositoryV2.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = itemRespositoryV2.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRespositoryV2.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond itemSearch) {
        return itemQueryRepositoryV2.findAll(itemSearch);
    }
}
