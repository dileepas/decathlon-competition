package com.decathlon_competition.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DecathlonCompetition {

    private List<Athlete> athleteList;

    public void setAthleteList(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    @XmlElementWrapper(name = "playerlist")
    @XmlElement(name = "player")
    public List<Athlete> getAthleteList() {
        return athleteList;
    }

}
