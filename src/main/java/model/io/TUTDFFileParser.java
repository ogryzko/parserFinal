package model.io;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class TUTDFFileParser {

    private final String NEWLINE = "\n";
    HeaderSegment headerSegment;
    TrailSegment trailSegment;

    public Segment parseSegment(String line){
        return null; // todo
    }

    public TUTDFData parseFile(BufferedReader reader) throws IOException {
        String currentLine = reader.readLine();
        headerSegment = (HeaderSegment) parseSegment(currentLine);
        while ((currentLine = reader.readLine()) != null) {
            // todo
        }
        return null; // todo
    }

    public Subject parseSubject(){
        return null; // todo
    }
}
