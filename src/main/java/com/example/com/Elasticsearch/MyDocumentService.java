package com.example.com.Elasticsearch;

import co.elastic.clients.elasticsearch.core.knn_search.KnnSearchQuery;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDocumentService {
    private final MyDocumentRepository myDocumentRepository;

    public MyDocumentService(MyDocumentRepository myDocumentRepository) {
        this.myDocumentRepository = myDocumentRepository;
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
}
