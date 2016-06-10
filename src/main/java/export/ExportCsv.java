package export;

import tree.Tree;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents a CSV exporter.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class ExportCsv<T> implements Exporter {

    private String filename;
    private Tree<T> tree;

    private ExportCsv(String filename) {
        this.filename = filename;
    }

    /**
     * Create a new CSV exporter, with a given filename and a tree to export
     *
     * @param filename the name of the file to export to
     * @param tree the tree to export
     */
    public ExportCsv(String filename, Tree<T> tree) {
        this(filename);
        this.tree = tree;
    }

    @Override
    public void export() {

        try {
            FileWriter writer = new FileWriter(validFilename());

            // Loop over each

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return a CSV-ified filename of this copy of the filename.
     *
     * @return a valid csv filename
     */
    public String validFilename() {
        if(!filename.contains(".csv")) {
            this.filename = filename + ".csv";
        }

        return this.filename;
    }
}
