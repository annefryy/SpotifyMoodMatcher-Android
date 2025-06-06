# Spotify Mood Matcher

An Android app that generates personalized Spotify playlists based on your mood or activity using AI.

## Features

* Mood/Activity input via text and emoji selection
* AI-powered playlist generation
* Direct Spotify integration for playback
* Playlist saving and rating
* History tracking
* Similar playlist suggestions

## Requirements

* Android Studio Hedgehog | 2023.1.1
* Android SDK 34
* Kotlin 1.9.22
* Spotify Developer Account
* OpenAI API Key (for AI playlist generation)

## Setup

1. Clone the repository
2. Open the project in Android Studio
3. Configure your Spotify API credentials in `app/src/main/java/com/annefryy/spotifymoodmatcher/data/config/SpotifyConfig.kt`
4. Configure your OpenAI API key in the appropriate configuration file
5. Build and run the project

## Dependencies

* Spotify Android SDK
* OpenAI API Client
* Jetpack Compose
* Hilt for dependency injection
* Room for local database
* Retrofit for network calls
* Firebase for authentication and storage

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

* **Views**: Jetpack Compose UI components
* **ViewModels**: Business logic and state management
* **Models**: Data models and entities
* **Repositories**: Data access layer
* **Services**: API clients and business services
* **Utils**: Helper functions and extensions

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/annefryy/spotifymoodmatcher/
│   │   │   ├── auth/           # Authentication related code
│   │   │   ├── data/           # Data layer
│   │   │   │   ├── api/        # API services
│   │   │   │   ├── config/     # Configuration
│   │   │   │   ├── local/      # Local database
│   │   │   │   ├── model/      # Data models
│   │   │   │   ├── remote/     # Remote data sources
│   │   │   │   ├── repository/ # Repository implementations
│   │   │   │   └── storage/    # Local storage
│   │   │   ├── di/            # Dependency injection
│   │   │   ├── ui/            # UI layer
│   │   │   │   ├── navigation/ # Navigation components
│   │   │   │   ├── screens/    # Screen composables
│   │   │   │   ├── theme/      # UI theme
│   │   │   │   └── viewmodel/  # ViewModels
│   │   │   └── utils/         # Utility classes
│   │   └── res/               # Resources
│   └── test/                  # Unit tests
└── build.gradle.kts          # App module build file
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. 