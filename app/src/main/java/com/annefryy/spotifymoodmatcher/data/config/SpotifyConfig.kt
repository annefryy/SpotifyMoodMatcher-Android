package com.annefryy.spotifymoodmatcher.data.config

object SpotifyConfig {
    const val CLIENT_ID = "7f30fce9d71841af9cec3e274c8cfdb0"
    const val CLIENT_SECRET = "a0ebec69937e4af8b3a6414f6391fb93"
    const val REDIRECT_URI = "spotifymoodmatcher://auth"
    const val AUTH_ENDPOINT = "https://accounts.spotify.com/authorize"
    const val TOKEN_ENDPOINT = "https://accounts.spotify.com/api/token"
    const val API_BASE_URL = "https://api.spotify.com/v1"
    
    private val SCOPE_LIST = listOf(
        "user-read-private",
        "user-read-email",
        "playlist-modify-public",
        "playlist-modify-private",
        "user-library-read",
        "user-library-modify"
    )
    
    val SCOPES = SCOPE_LIST.joinToString(" ")
    
    val AUTH_URL = "$AUTH_ENDPOINT?" +
            "client_id=$CLIENT_ID" +
            "&redirect_uri=$REDIRECT_URI" +
            "&response_type=code" +
            "&scope=$SCOPES"
} 