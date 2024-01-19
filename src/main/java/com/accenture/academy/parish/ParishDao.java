package com.accenture.academy.parish;

import com.accenture.academy.cemetery.CemeteryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARISH")
public class ParishDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String parishName;
    @OneToOne
    PriestDao priestDao;
    @OneToOne
    ChurchDao churchDao;
    @OneToMany
    @JoinColumn(name = "parish_id")
    private Set<MemberDao> members;
    @OneToOne
    private CemeteryDao cemeteryDao;

    public ParishDao(String parishName, PriestDao priestDao, ChurchDao churchDao, Set<MemberDao> members, CemeteryDao cemeteryDao) {
        this.parishName = parishName;
        this.priestDao = priestDao;
        this.churchDao = churchDao;
        this.members = members;
        this.cemeteryDao = cemeteryDao;
    }
}
