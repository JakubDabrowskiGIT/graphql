package com.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    @QueryMapping
    public Item itemById(@Argument String id) {
        return Item.getById(id);
    }

    @QueryMapping
    public Item itemByItemProperty(@Argument int id, @Argument String name) {
        return Item.getByItemPropertyId(id);
    }

    @SchemaMapping
    public ItemProperty itemProperty(Item item) {
        return Item.getByItemPropertyId(item.itemProperty().id()).itemProperty();
    }
}
