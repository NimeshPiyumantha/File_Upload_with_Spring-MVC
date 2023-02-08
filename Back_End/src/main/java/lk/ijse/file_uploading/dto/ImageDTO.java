package lk.ijse.file_uploading.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    String fileString;

    public ImageDTO(String lastImageLocation) {
        this.fileString = lastImageLocation;
    }
}
