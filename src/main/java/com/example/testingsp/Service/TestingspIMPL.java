package com.example.testingsp.Service;


import com.example.testingsp.DTO.TestingspDTO;
import com.example.testingsp.Entite.TestingSP;
import com.example.testingsp.Repository.TestingspRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestingspIMPL implements  TestingspService{

    @Autowired
    public TestingspRepo testingspRepo;

@Override
    public String addTest(TestingspDTO testingspDTO){

        TestingSP testingsp =new TestingSP(
                testingspDTO.getFeatuers(),
                testingspDTO.getDescription(),
                testingspDTO.getFeatuersid()
        );
        testingspRepo.save(testingsp);
            return testingsp.getFeatuers();
    }


    @Override
    public List showTest (){

    List<TestingSP> showtes = testingspRepo.findAll();
    List<TestingspDTO> testingspDTOList = new ArrayList<>();

    for (TestingSP i: showtes){

        TestingspDTO testingspDTO = new TestingspDTO(
                i.getTestID(),
                i.getFeatuers(),
                i.getDescription(),
                i.getFeatuersid()

        );


    testingspDTOList.add(testingspDTO);
    }
    return  testingspDTOList ;
    }




    public Page<TestingSP> getPage(int page, int pageSize) {
        return testingspRepo.findAll(PageRequest.of(page, pageSize));
    }

 public  long  getPagecount (){
    return  testingspRepo.count();
 }

}
