package lk.ijse.file_uploading.repo;

import lk.ijse.file_uploading.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public interface FileUploadRepo extends JpaRepository<File, String> {
}
