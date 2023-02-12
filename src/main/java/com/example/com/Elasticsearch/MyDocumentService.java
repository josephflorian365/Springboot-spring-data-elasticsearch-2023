package com.example.com.Elasticsearch;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyDocumentService {
    private final MyDocumentRepository myDocumentRepository;
    private final ElasticsearchOperations elasticsearchTemplate;

    public MyDocumentService(MyDocumentRepository myDocumentRepository,ElasticsearchOperations elasticsearchTemplate) {
        this.myDocumentRepository = myDocumentRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public Iterable<MyDocument> allDocument() {
        return myDocumentRepository.findAll();
    }

    public MyDocument createDocument(MyDocument myDocument) {
        return myDocumentRepository.save(myDocument);
    }

    public MyDocument getDocumentById(String id) {
        return myDocumentRepository.findById(id).orElse(null);
    }

    public MyDocument updateDocument(MyDocument myDocument) {
        return myDocumentRepository.save(myDocument);
    }

    public void deleteDocument(String id) {
        myDocumentRepository.deleteById(id);
    }

    public List<MyDocument> searchDocument(String name){
        return myDocumentRepository.findByNameUsingCustomQuery(name);
    }

    public List<MyDocument> searchLikeDocument(String name) {
        return myDocumentRepository.findByNameLike(name);
    }

}
