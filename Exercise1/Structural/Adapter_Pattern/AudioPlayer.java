package AP;

import java.util.logging.Logger;

public class AudioPlayer implements MediaPlayer {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void play(String filename, String mediaType) throws Exception {
        if (filename == null || filename.isBlank() || mediaType == null || mediaType.isBlank()) {
            throw new IllegalArgumentException("Filename and media type cannot be blank.");
        }

        if (mediaType.equalsIgnoreCase("mp3") || mediaType.equalsIgnoreCase("mp4")) {
            MediaPlayer adapter = new MediaAdapter(mediaType);
            adapter.play(filename, mediaType);
        } else {
            logger.warning("Unsupported media type: " + mediaType);
        }
    }
}