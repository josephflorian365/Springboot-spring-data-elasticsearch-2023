package com.example.com.Elasticsearch;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MyDocumentRepository extends ElasticsearchRepository<MyDocument, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<MyDocument> findByNameUsingCustomQuery(String name);
}
