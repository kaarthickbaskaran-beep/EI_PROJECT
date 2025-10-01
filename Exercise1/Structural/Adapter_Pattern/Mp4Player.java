package AP;

import java.util.logging.Logger;

public class Mp4Player implements AdvancedMediaPlayer {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void playMp4(String filename) throws Exception {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename cannot be blank.");
        }
        logger.info("Playing MP4 file: " + filename);
        Thread.sleep(500); 
        logger.info("Finished playing MP4: " + filename);
    }

    @Override
    public void playMp3(String filename) {
       
    }
}