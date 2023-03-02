package lk.ijse.file_uploading.service;

import lk.ijse.file_uploading.dto.ImageDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public interface FileUploadService {
    void saveFileLocation(@ModelAttribute ImageDTO dto);
    String getLastImageLocation();
}
