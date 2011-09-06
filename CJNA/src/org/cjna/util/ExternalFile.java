package org.cjna.util;

import java.io.*;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */
public class ExternalFile {
    private BufferedReader exFile;
    public ExternalFile(String ext_file) throws IOException {
       exFile = new BufferedReader(new InputStreamReader(new FileInputStream(ext_file)));
    }
    public String getLine() throws IOException {
       return exFile.readLine();
    }
    
    /**
     * @return
     */
    public boolean havehitEOF() throws IOException {
       return !exFile.ready();
    }
    public void close() throws IOException {
       exFile.close();
    }

} // end class ExternalFile
