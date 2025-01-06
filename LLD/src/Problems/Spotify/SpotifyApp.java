package Problems.Spotify;

// Spotify Low-Level Design with Design Patterns

import java.util.*;

// Singleton for User Session Management
class UserSession {
    private static UserSession instance;
    private User currentUser;

    private UserSession() {}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

// User Class
class User {
    private String id;
    private String name;
    private List<Playlist> playlists;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.playlists = new ArrayList<>();
    }

    public void createPlaylist(String name) {
        Playlist playlist = new Playlist.Builder(name).build();
        playlists.add(playlist);
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}

// Builder Pattern for Playlist Construction
class Playlist {
    private String name;
    private List<Song> songs;

     Playlist(Builder builder) {
        this.name = builder.name;
        this.songs = builder.songs;
    }

    public static class Builder {
        private String name;
        private List<Song> songs = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addSong(Song song) {
            songs.add(song);
            return this;
        }

        public Playlist build() {
            return new Playlist(this);
        }
    }

    public List<Song> getSongs() {
        return songs;
    }
}

// Song and Artist Classes
class Song {
    private String id;
    private String title;
    private Artist artist;

    public Song(String id, String title, Artist artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }
}

class Artist {
    private String id;
    private String name;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Factory Pattern for Recommendation Engine
interface RecommendationAlgorithm {
    List<Song> recommend(User user);
}

class CollaborativeFiltering implements RecommendationAlgorithm {
    public List<Song> recommend(User user) {
        // Collaborative filtering logic
        return new ArrayList<>();
    }
}

class ContentBasedFiltering implements RecommendationAlgorithm {
    public List<Song> recommend(User user) {
        // Content-based filtering logic
        return new ArrayList<>();
    }
}

class RecommendationEngine {
    public static RecommendationAlgorithm getAlgorithm(String type) {
        if (type.equals("collaborative")) {
            return new CollaborativeFiltering();
        } else if (type.equals("content")) {
            return new ContentBasedFiltering();
        }
        throw new IllegalArgumentException("Unknown algorithm type");
    }
}

// Strategy Pattern for Search
interface SearchStrategy {
    List<Song> search(String query);
}

class BasicSearch implements SearchStrategy {
    public List<Song> search(String query) {
        // Simple search logic
        return new ArrayList<>();
    }
}

class AdvancedSearch implements SearchStrategy {
    public List<Song> search(String query) {
        // Advanced search logic
        return new ArrayList<>();
    }
}

class SearchService {
    private SearchStrategy strategy;

    public SearchService(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Song> search(String query) {
        return strategy.search(query);
    }
}

// Observer Pattern for Streaming
interface PlaybackListener {
    void onPlaybackStarted(Song song);
    void onPlaybackPaused(Song song);
}

class StreamingService {
    private List<PlaybackListener> listeners = new ArrayList<>();

    public void addListener(PlaybackListener listener) {
        listeners.add(listener);
    }

    public void playSong(Song song) {
        // Playback logic
        notifyPlaybackStarted(song);
    }

    public void pauseSong(Song song) {
        // Pause logic
        notifyPlaybackPaused(song);
    }

    private void notifyPlaybackStarted(Song song) {
        for (PlaybackListener listener : listeners) {
            listener.onPlaybackStarted(song);
        }
    }

    private void notifyPlaybackPaused(Song song) {
        for (PlaybackListener listener : listeners) {
            listener.onPlaybackPaused(song);
        }
    }
}

// Example Usage
public class SpotifyApp {
    public static void main(String[] args) {
        // Singleton for User Session
        UserSession session = UserSession.getInstance();
        User user = new User("1", "Harsh Bhabar");
        session.setCurrentUser(user);

        // Builder Pattern for Playlist
        Playlist playlist = new Playlist.Builder("My Favorites")
                .addSong(new Song("1", "Shape of You", new Artist("1", "Ed Sheeran")))
                .addSong(new Song("2", "Blinding Lights", new Artist("2", "The Weeknd")))
                .build();

//        user.createPlaylist(playlist);

        // Factory for Recommendation Engine
        RecommendationAlgorithm algorithm = RecommendationEngine.getAlgorithm("collaborative");
        List<Song> recommendations = algorithm.recommend(user);

        // Strategy for Search
        SearchService searchService = new SearchService(new BasicSearch());
        List<Song> searchResults = searchService.search("Shape of You");

        // Observer for Streaming
        StreamingService streamingService = new StreamingService();
        streamingService.addListener(new PlaybackListener() {
            @Override
            public void onPlaybackStarted(Song song) {
                System.out.println("Playing: " + song.getTitle());
            }

            @Override
            public void onPlaybackPaused(Song song) {
                System.out.println("Paused: " + song.getTitle());
            }
        });

        streamingService.playSong(new Song("1", "Shape of You", new Artist("1", "Ed Sheeran")));
    }
}

