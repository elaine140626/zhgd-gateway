package com.hujiang.project.hs.hsFaceApi;

import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/hs")
public class HsFaceApi {
    @Autowired
    private SystemClient client;
    @PostMapping(value = "/person")
    public String addPerson(@RequestBody String json){
        return client.addPerson(json);
}
}
