package lk.ijse.file_uploading.service.impl;

import lk.ijse.file_uploading.dto.ImageDTO;
import lk.ijse.file_uploading.entity.Image;
import lk.ijse.file_uploading.repo.FileUploadRepo;
import lk.ijse.file_uploading.service.FileUploadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Service
@Transactional
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveFileLocation(ImageDTO dto) {
        Image img = new Image("");

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getFileString().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFileString().getOriginalFilename()));

            img.setFileString("uploads/" + dto.getFileString().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(img);
       repo.save(img);

    }

    @Override
    public String getLastImageLocation() {
        System.out.println(repo.getLastImageLocation());
        return repo.getLastImageLocation();
    }
}
