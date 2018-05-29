package com.project.ucamu.domain.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Content implements Serializable {
    @Column(name = "content_who")
        private String who;
    @Column(name = "content_when")
        private String when;
    @Column(name = "content_where")
        private String where;
    @Column(name = "content_what")
        private String what;
    @Column(name = "content_how")
        private String how;
    @Column(name = "content_why")
        private String why;
}
