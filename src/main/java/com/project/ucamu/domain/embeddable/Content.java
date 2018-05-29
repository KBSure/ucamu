package com.project.ucamu.domain.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Content implements Serializable {
    @Column(name = "contents_who")
        private String who;
    @Column(name = "contents_when")
        private String when;
    @Column(name = "contents_where")
        private String where;
    @Column(name = "contents_what")
        private String what;
    @Column(name = "contents_how")
        private String how;
    @Column(name = "contents_why")
        private String why;
}
