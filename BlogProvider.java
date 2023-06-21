/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sov.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sov.model.BlogItem;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BlogProvider { 
//    static List<BlogItem> items = new ArrayList<>();
    static Map<String, BlogItem> items = new HashMap<>();
    
    public BlogProvider() {
        initTestData();
    }

    public JsonNode list(String token, Map<String, String> options) {
////        ArrayList optionsReq = new ArrayList();
//        Map<String, String> optionsReq = new HashMap<>();
//        options.forEach((key, value) -> {
////            optionsReq.add( String.format("{'%s': '%s'}", key, value) );
//              optionsReq.put(key, value);
//        });
//        
//        final String req = String.format("{'token':'%s','options':%s}", token, optionsReq.toString());
//        
        try {
//            String example = "[\n" +
//                            "    {\n" +
//                            "        \"id\": \"f4fc8730-550d-11ed-4184-0242ac120005\",\n"  +
//                            "        \"Title\": \"Consectetur Qui Itaque\",\n" +
//                            "        \"Content\": \"Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. Ut est natus dolor autem. Dolorum odit enim. Nostrum soluta consectetur beatae quidem. Eaque ut ipsa exercitationem. Ipsa sunt et tempora natus quos expedita quia dolor. Possimus numquam libero quaerat. Quae autem est veritatis eius molestiae voluptatem qui ea iure. Illum totam quo quibusdam.\",\n" +
//                            "        \"Created At\": \"19/02/2023\",\n" +
//                            "        \"Ready\": true\n" +
//                            "    }]";
            
            ObjectMapper mapper = new ObjectMapper();
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            mapper.writeValue(out, items);
            
            JsonNode result = mapper.readTree(out.toByteArray());
            
            return result;
        } catch (Exception ex) {
            logger.error("Error in list blog", ex);
        }
        
        return null;
    }
    
    public JsonNode get(String token, String id) { 
        try {
//            String example = "{\n" +
//                            "        \"id\": \"f4fc8730-550d-11ed-4184-0242ac120005\",\n"  +
//                            "        \"Title\": \"Consectetur Qui Itaque\",\n" +
//                            "        \"Content\": \"Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. Ut est natus dolor autem. Dolorum odit enim. Nostrum soluta consectetur beatae quidem. Eaque ut ipsa exercitationem. Ipsa sunt et tempora natus quos expedita quia dolor. Possimus numquam libero quaerat. Quae autem est veritatis eius molestiae voluptatem qui ea iure. Illum totam quo quibusdam.\",\n" +
//                            "        \"Created At\": \"19/02/2023\",\n" +
//                            "        \"Ready\": true\n" +
//                            "    }";
            
            ObjectMapper mapper = new ObjectMapper();
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
//            for(BlogItem item : items) {
//                if(item.getId().compareToIgnoreCase(id) == 0 )
//                    mapper.writeValue(out, item);
//            }
            if(items.containsKey(id))
                mapper.writeValue(out, items);
            
            JsonNode result = mapper.readTree(out.toByteArray());
            
            return result;
        } catch (Exception ex) {
            logger.error("Error in get blog", ex);
        }
        
        return null;
    }

    public JsonNode create(String token, Map<String, String> parameters) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            String newId = String.valueOf(items.size());
            
            BlogItem item = new BlogItem();

            item.setId(newId); 
            
            if(parameters.get("title") != null)
                item.setTitle(parameters.get("title"));
            
            if(parameters.get("content") != null)
                item.setContent(parameters.get("content"));

            if(parameters.get("createdAt") != null)
                item.setCreatedAt(parameters.get("createdAt"));

            if(parameters.get("ready") != null)
                item.setReady(parameters.get("ready").compareToIgnoreCase("true") == 0);
            
            items.put(id, item);
            
            mapper.writeValue(out, item);
            
            JsonNode result = mapper.readTree(out.toByteArray());
            
            return result;
        } catch (Exception ex) {
            logger.error("Error in create blog", ex);
        }
        
        return null;        
    }
    
    public JsonNode set(String token, String id, Map<String, String> parameters) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            String currentId = id; 

            boolean isExist = false;
            
            if(item.get(currentId)) {   
                if(parameters.get("title") != null)
                        item.setTitle(parameters.get("title"));

                    if(parameters.get("content") != null)
                        item.setContent(parameters.get("content"));

                    if(parameters.get("createdAt") != null)
                        item.setCreatedAt(parameters.get("createdAt"));

                    if(parameters.get("ready") != null)
                        item.setReady(parameters.get("ready").compareToIgnoreCase("true") == 0);
                   
                    mapper.writeValue(out, item);
                    
                    isExist = true;    
            }
            
            
            if(!isExist)
                throw new Exception("Not found");
            
            JsonNode result = mapper.readTree(out.toByteArray());
            
            return result;
        } catch (Exception ex) {
            logger.error("Error in set blog", ex);
        }
        
        return null;        
    }
    
    protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(BlogProvider.class);

    private void initTestData() {
        BlogItem newItem;
        
        newItem = new BlogItem("0", 
                "Consectetur Qui Itaque", 
                "Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. ", 
                "001",
                true);
        items.put(id,newItem);
        
        newItem = new BlogItem("1", 
                "Consectetur Qui Itaque", 
                "Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. ", 
                "002",
                true);
        items.put(id, newItem);

        newItem = new BlogItem("2", 
                "Consectetur Qui Itaque", 
                "Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. ", 
                "003",
                false);
        items.put(id, newItem);

        newItem = new BlogItem("3", 
                "Consectetur Qui Itaque", 
                "Qui ullam repellendus nobis expedita eaque enim nostrum. Animi laboriosam voluptas qui. ", 
                "004",
                true);
        items.put(id,newItem);
    }

}
