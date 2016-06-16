package export;

import org.junit.Test;
import tree.TreeNode;

import static org.junit.Assert.*;

/**
 * This class represents ...
 * <p>
 * Created by Skyler Layne © 2016
 */
public class ExportCsvTest {

    @Test
    public void testValidFilename() throws Exception {
        ExportCsv exporter = new ExportCsv("filename", new TreeNode(null));
        assertEquals(exporter.validFilename(), "filename.csv");

        exporter = new ExportCsv("filename.csv", new TreeNode(null));
        assertEquals(exporter.validFilename(), "filename.csv");
    }
}