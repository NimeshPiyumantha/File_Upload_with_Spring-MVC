package lk.ijse.file_uploading.controller;

import lk.ijse.file_uploading.dto.ImageDTO;
import lk.ijse.file_uploading.service.FileUploadService;
import lk.ijse.file_uploading.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/uploads")
@CrossOrigin
public class FileUploadController {

    @Autowired
   private FileUploadService fileRepo;

    @PostMapping
    public ResponseUtil uploadFileWithSpringWay(@ModelAttribute ImageDTO dto) {
       fileRepo.saveFileLocation(dto);
       return new ResponseUtil("ok","Successfuly",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/lastImageLoad")
    public ResponseUtil getAllDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", fileRepo.getLastImageLocation());
    }
}