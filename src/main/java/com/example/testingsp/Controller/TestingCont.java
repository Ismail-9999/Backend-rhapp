package com.example.testingsp.Controller;


import com.example.testingsp.DTO.TestingspDTO;
import com.example.testingsp.Entite.TestingSP;
import com.example.testingsp.Service.TestingspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("restapi/test")
public class TestingCont {

    @Autowired
    private TestingspService testingspService ;


    @PostMapping(path = "add")
    public String savetest (@RequestBody TestingspDTO testingspDTO){
        String id = testingspService.addTest(testingspDTO);
        return id ;
    }




    @GetMapping (path = "/sp")
    public List<TestingspDTO> showTest(){
        List<TestingspDTO> allTest = testingspService.showTest();
        return allTest ;
    }


    @GetMapping(path = "/page")
    public Page<TestingSP> getPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        return testingspService.getPage(page, pageSize);
    }


    @GetMapping(path = "/count")
    public  long getcount (){
        return testingspService.getPagecount() ;
    }
}
