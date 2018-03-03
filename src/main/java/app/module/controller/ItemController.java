package app.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.module.controller.query.WebItemQuery;
import app.module.dao.ItemRepository;
import app.module.dto.WebItem;
import app.module.entity.ItemEntity;

/**
 * @author Bodin Srisompong
 */
@Controller
@RequestMapping("/items/{key}")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public WebItem get(@PathVariable("key") Long key) {
        ItemEntity item = itemRepository.findOne(key);
        return new WebItem(item);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public WebItem update(@PathVariable("key") Long key, @RequestBody WebItemQuery query) {
        ItemEntity item = itemRepository.findOne(key);
        query.fill(item);
        return new WebItem(itemRepository.save(item));
    }

    @RequestMapping(method = RequestMethod.POST, params = "_a=delete")
    @ResponseBody
    public WebItem delete(@PathVariable("key") Long key) {
        ItemEntity item = itemRepository.findOne(key);
        itemRepository.delete(item);
        return new WebItem(item);
    }
}
