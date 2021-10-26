package com.decathlon_competition.services.writer.impl;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.DecathlonCompetition;
import com.decathlon_competition.exception.FileCreationException;
import com.decathlon_competition.services.writer.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XMLFileWriter implements FileWriter {

    @Override
    public DecathlonCompetition write(List<Athlete> athletes, String filePath) throws FileCreationException {
        try {
            DecathlonCompetition decathlonCompetition = new DecathlonCompetition();
            decathlonCompetition.setAthleteList(athletes);
            JAXBContext context = JAXBContext.newInstance(DecathlonCompetition.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(filePath);
            marshaller.marshal(decathlonCompetition, file);
            System.out.println("Output file saved in: " + file.getAbsolutePath());
            return decathlonCompetition;
        } catch (JAXBException e) {
            throw new FileCreationException("Unable to write the file", e);
        }
    }
}
