package com.demos.agora.model.join;

import com.demos.agora.model.study.Study;
import com.demos.agora.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@IdClass(Join.class)
@Data
@Entity
public class Join implements Serializable {
    // Study와 User간의 relation을 나타내는 table

 /*  @EmbeddedId
    private long id;*/

    // We marked the study and user fields with @MapsId
    @ManyToOne
    @Id
    @MapsId("studyId")
    @JoinColumn(name="studyId")
    private Study study;


    @ManyToOne
    @Id
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User user;

    private int role;   // 1 : 그룹장, 0 : 그룹원
    private Date memberSince; // 해당 그룹원의 가입 날짜

}
