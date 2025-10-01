package AP;

public class MediaAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String mediaType) {
        switch (mediaType.toLowerCase()) {
            case "mp3" -> advancedMusicPlayer = new Mp3Player();
            case "mp4" -> advancedMusicPlayer = new Mp4Player();
            default -> throw new IllegalArgumentException("Unsupported media type: " + mediaType);
        }
    }

    @Override
    public void play(String filename, String mediaType) throws Exception {
        switch (mediaType.toLowerCase()) {
            case "mp3" -> advancedMusicPlayer.playMp3(filename);
            case "mp4" -> advancedMusicPlayer.playMp4(filename);
            default -> throw new IllegalArgumentException("Unsupported media type: " + mediaType);
        }
    }
}