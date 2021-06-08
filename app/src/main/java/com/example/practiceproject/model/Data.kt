package com.example.practiceproject.model



//Splash sreen
class Splash (private var success: Boolean, private var expires_at: String, private var request_token: String)

//List popular
class Popular(private var poster_path: String?, private var title: String?){
    init {
        this.poster_path = poster_path
        this.title = title
    }

    fun getPosterPath(): String?{
        return poster_path
    }
    fun setPosterPath(name: String?) {
        poster_path = name!!
    }

    fun getTitle(): String? {
        return title
    }
    fun setTitle(name: String?) {
        title = name!!
    }
}
