package com.example.testingsp.Service;

import com.example.testingsp.DTO.TestingspDTO;
import com.example.testingsp.Entite.TestingSP;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestingspService {
    String addTest(TestingspDTO testingspDTO);

    List showTest();

    Page<TestingSP> getPage(int page, int pageSize);

    long getPagecount();
}
