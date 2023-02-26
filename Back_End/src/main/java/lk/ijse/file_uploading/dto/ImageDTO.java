package lk.ijse.file_uploading.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageDTO {
    private String id;
    private MultipartFile fileString;

    public ImageDTO(MultipartFile fileString) {
        this.fileString = fileString;
    }
}
