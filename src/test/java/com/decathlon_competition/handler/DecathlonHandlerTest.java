package com.decathlon_competition.handler;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.DecathlonCompetition;
import com.decathlon_competition.exception.FileCreationException;
import com.decathlon_competition.services.process.impl.DecathlonPlaceDecider;
import com.decathlon_competition.services.process.impl.DecathlonPointsCalculator;
import com.decathlon_competition.services.process.Decider;
import com.decathlon_competition.services.process.PointsCalculator;
import com.decathlon_competition.services.reader.CSVFileReader;
import com.decathlon_competition.services.reader.impl.CSVFileReaderImpl;
import com.decathlon_competition.services.writer.FileWriter;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DecathlonHandlerTest {

    FileWriter fileWriter = Mockito.mock(FileWriter.class);

    CSVFileReader reader = new CSVFileReaderImpl();
    PointsCalculator pointsCalculator = new DecathlonPointsCalculator();
    Decider decider = new DecathlonPlaceDecider();

    @Test
    public void getSuccessResult() throws Exception {
        when(fileWriter.write(anyList(),eq("decathlon-result.xml"))).thenReturn(new DecathlonCompetition());
        DecathlonHandler handler = new DecathlonHandler(reader,fileWriter,pointsCalculator,decider);
        List<Athlete> response =  handler.process("src/test/resources/results.csv","decathlon-result.xml");
        assertEquals(4,response.size());
    }

    @Test (expected = FileCreationException.class)
    public void testThrowingExceptioWhenCreatingXMLFile() throws Exception {
        when(fileWriter.write(anyList(),eq("decathlon-result.xml"))).thenThrow(new FileCreationException("",null));
        DecathlonHandler handler = new DecathlonHandler(reader,fileWriter,pointsCalculator,decider);
        handler.process("src/test/resources/results.csv","decathlon-result.xml");
    }
}
