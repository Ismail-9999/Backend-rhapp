package com.example.testingsp.Controller;



import com.example.testingsp.DTO.FileEntity;
import com.example.testingsp.DTO.FileEntityDTO;
import com.example.testingsp.Repository.FileEntityRepo;
import com.example.testingsp.Service.FileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/files")
public class FileEntityCont {

    private static final String UPLOAD_DIR = "C:\\Users\\DELL\\OneDrive\\Bureau\\RHAPP\\Angular_rh-main\\Cv_tech\\Uploaded_Cvtech";

    @Autowired
    private FileEntityRepo fileEntityRepo;
    @Autowired
    private FileEntityService fileEntityService;

    @PostMapping(path = "/savefile/{prospectId}")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @PathVariable String prospectId) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("select a file");
        }
        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String originalFileName = file.getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;
            Path filePath = Paths.get(UPLOAD_DIR, uniqueFileName);

            file.transferTo(filePath.toFile());
            FileEntity fileEntity = new FileEntity(uniqueFileName, prospectId);
            fileEntityRepo.save(fileEntity);
            return ResponseEntity.ok("File uploaded successfully");
        }
        catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload the file");
        }
    }
    @GetMapping(path = "/files")
    public List<FileEntity> getAllFileEntities() {
        return fileEntityService.getAllFileEntities();
    }

    @GetMapping(path = "show")
    public List<FileEntityDTO> showFiles() {
        List<FileEntityDTO> allfiles = fileEntityService.showFiles();
        return allfiles;
    }
}
