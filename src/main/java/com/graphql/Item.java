package com.graphql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record Item(String id, String name, Type type, ItemProperty itemProperty) {

    private static List<Item> items = Arrays.asList(
            new Item("1", "Name1", Type.ALPHA, new ItemProperty(1, "One")),
            new Item("2", "Name2", Type.OMEGA, new ItemProperty(1, "One")),
            new Item("3", "Name3", Type.BETA, new ItemProperty(2, "Two")),
            new Item("4", "Name4", Type.BETA, new ItemProperty(2, "Two"))
    );

    public static Item getById(String id) {
        return items.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Item> getByItem(Item itemSearch) {
        List<Item> itemsList = new ArrayList<>();
        if (itemSearch != null && itemSearch.id() != null) {
            itemsList.addAll(
                    items.stream()
                    .filter(item -> item.id().equals(itemSearch.id())).toList());
        }

        if (itemSearch != null && itemSearch.name() != null) {
            itemsList.addAll(
                    items.stream()
                            .filter(item -> item.name().equals(itemSearch.name())).toList());
        }

        if (itemSearch != null && itemSearch.type() != null) {
            itemsList.addAll(
                    items.stream()
                            .filter(item -> item.type().equals(itemSearch.type())).toList());
        }

        return itemsList;
    }

    public static Item getByItemPropertyId(int id) {
        return items.stream()
                .filter(item -> item.itemProperty().id() == id)
                .findFirst()
                .orElse(null);
    }
}
