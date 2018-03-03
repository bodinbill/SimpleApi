package app.module.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.module.controller.query.WebItemQuery;
import app.module.controller.query.WebItemSearchQuery;
import app.module.dao.ItemRepository;
import app.module.dto.WebItem;
import app.module.dto.common.Page;
import app.module.entity.ItemEntity;

/**
 * @author Bodin Srisompong
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.POST, headers = {"Accept=application/json"})
    @ResponseBody
    public WebItem create(@RequestBody WebItemQuery query) {
        ItemEntity item = new ItemEntity();
        query.fill(item);
        return new WebItem(itemRepository.save(item));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<WebItem> get(WebItemSearchQuery query) {
        Page<ItemEntity> page = itemRepository.getPage(query);
        return convert(page);
    }

    private Page<WebItem> convert(Page<ItemEntity> page) {
        List<WebItem> webList = new ArrayList<>();

        for (ItemEntity entity : page.getEntities()) {
            webList.add(new WebItem(entity));
        }
        return Page.create(page.getPageInformation(), webList);
    }
}
