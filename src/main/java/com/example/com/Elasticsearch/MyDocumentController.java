package com.example.com.Elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class MyDocumentController {

    @Autowired
    private MyDocumentService myDocumentService;

    @PostMapping("/create")
    public MyDocument create(@RequestBody MyDocument myDocument){
        return myDocumentService.createDocument(myDocument);
    }

    @GetMapping("/all")
    public Iterable<MyDocument> all(){
        return myDocumentService.allDocument();
    }

    @PutMapping("/update")
    public MyDocument update(@RequestBody MyDocument myDocument){
        return myDocumentService.updateDocument(myDocument);
    }

    @GetMapping("/{id}")
    public MyDocument byId(@PathVariable("id") String id){
        return myDocumentService.getDocumentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        myDocumentService.deleteDocument(id);
    }

    @GetMapping("/search")
    public List<MyDocument> search(@RequestParam String name){
        return myDocumentService.searchDocument(name);
    }
    @GetMapping("/like/search")
    public List<MyDocument> searchLike(@RequestParam("name") String name) {
        return myDocumentService.searchLikeDocument(name);
    }
}
