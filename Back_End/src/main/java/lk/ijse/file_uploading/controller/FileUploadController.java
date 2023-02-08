package lk.ijse.file_uploading.controller;

import lk.ijse.file_uploading.dto.ImageDTO;
import lk.ijse.file_uploading.entity.Image;
import lk.ijse.file_uploading.repo.FileUploadRepo;
import lk.ijse.file_uploading.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("upload")
@CrossOrigin
public class FileUploadController {

    @Autowired
   private FileUploadService fileRepo;

    @PostMapping
    public String uploadFileWithSpringWay(@RequestPart("image") MultipartFile myFile, ModelMap modelMap) {
        modelMap.addAttribute("file", myFile);
        try {
            byte[] byteArray = myFile.getBytes();
//            String projectPath = "D:\\Project\\File_Upload_with_Spring-MVC\\Front_End\\assets\\image";
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            String path = "/" + myFile.getOriginalFilename();
            Path location = Paths.get(projectPath + path);
            Files.write(location, byteArray);
            myFile.transferTo(location);
            System.out.println(projectPath);

//            String location2 = "assets/" + myFile.getOriginalFilename();
            fileRepo.saveFileLocation(new ImageDTO(null, location.toString()));
            return Base64.getEncoder().encodeToString(byteArray);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public String getAll() {
        return fileRepo.loadFileLocation();
    }

}