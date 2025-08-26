package com.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(ItemController.class)
class ItemControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstItem() {
        this.graphQlTester
				.documentName("item")
				.variable("id", "1")
                .execute()
                .path("itemById")
                .matchesJson("""
                    {
                        "id": "1",
                        "name": "Name1",
                        "type": "ALPHA",
                        "itemProperty": {
                          "id": 1,
                          "name": "One"
                        }
                    }
                """);
    }
}
