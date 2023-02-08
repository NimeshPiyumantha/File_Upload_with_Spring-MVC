package lk.ijse.file_uploading.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class File {
    @Id
    private String id;
}
