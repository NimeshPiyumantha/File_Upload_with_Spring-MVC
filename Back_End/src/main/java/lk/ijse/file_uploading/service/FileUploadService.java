package lk.ijse.file_uploading.service;

import lk.ijse.file_uploading.dto.FileDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public interface FileUploadService {
    void saveFileLocation(@ModelAttribute FileDTO dto);
    ArrayList<FileDTO> loadFileLocation();
}
