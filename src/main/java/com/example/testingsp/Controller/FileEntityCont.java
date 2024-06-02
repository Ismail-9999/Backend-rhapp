package com.example.testingsp.Controller;



import com.example.testingsp.DTO.FileEntity;
import com.example.testingsp.DTO.FileEntityDTO;
import com.example.testingsp.Repository.FileEntityRepo;
import com.example.testingsp.Service.FileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping(path = "/api/files")
public class FileEntityCont {

    private static final String UPLOAD_DIR = "C:\\Users\\DELL\\OneDrive\\Bureau\\RHAPP\\Angular_rh-main\\Cv_tech\\Uploaded_Cvtech";
     //  private static final String UPLOAD_DIR = "/home/iteamma/public_html/grh/Cv_tech/Uploaded_Cvtech";
    @Autowired
    private FileEntityRepo fileEntityRepo;
    @Autowired
    private FileEntityService fileEntityService;

    @PostMapping(path = "/savefile/{prospectId}")
    @CacheEvict(value = "file", allEntries = true)
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
            String uniqueFileName =  originalFileName;
            Path filePath = get(UPLOAD_DIR, uniqueFileName);

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
    @CacheEvict(value = "file", allEntries = true)
    public List<FileEntity> getAllFileEntities() {
        return fileEntityService.getAllFileEntities();
    }

    @GetMapping(path = "show")
    @Cacheable("file")
    public List<FileEntityDTO> showFiles() {
        List<FileEntityDTO> allfiles = fileEntityService.showFiles();
        return allfiles;
    }


   /* @GetMapping("/download/{prospectId}")
    public ResponseEntity<String> downloadFile(String prospectId) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize().resolve(prospectId);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException(prospectId + "was not found on the server");
        }
        String fileContent = new String(Files.readAllBytes(filePath));
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("File-Name", prospectId);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + prospectId + "\"");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders)
                .body(fileContent);

    }


*/



    @GetMapping("/download/{filename}")
    @CacheEvict(value = "file", allEntries = true)
    public ResponseEntity<Resource> downloadFile(@PathVariable ("filename") String filename) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize().resolve(filename);
        if (!Files.exists(filePath) ) {
            throw new FileNotFoundException( filename + "was not found on the server");
        }

        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("FileName",filename);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders)
                .body(resource);
    }


}
