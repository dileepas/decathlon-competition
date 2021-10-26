package com.decathlon_competition.services.writer;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.DecathlonCompetition;
import com.decathlon_competition.exception.FileCreationException;

import java.util.List;

public interface FileWriter {
    DecathlonCompetition write(List<Athlete> athletes, String filePath) throws FileCreationException;
}
