package lk.ijse.file_uploading.service.impl;

import lk.ijse.file_uploading.dto.ImageDTO;
import lk.ijse.file_uploading.entity.Image;
import lk.ijse.file_uploading.repo.FileUploadRepo;
import lk.ijse.file_uploading.service.FileUploadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(dto);
        repo.save(mapper.map(dto, Image.class));
    }

    @Override
    public String loadFileLocation() {
        System.out.println(repo.getLastImageLocation());
        return repo.getLastImageLocation();
    }
}
