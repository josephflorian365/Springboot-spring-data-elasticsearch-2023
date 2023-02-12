package com.example.com.Elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "myindex")
public class MyDocument {
    @Id
    private String id;
    private String name;
    private String description;
}
