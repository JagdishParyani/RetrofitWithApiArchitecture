package com.example.apiarchitecture.model


data class Movies(var data: ArrayList<ResModelMovies>) : BaseModel()

data class ResModelMovies(
    var title: String, var image: String,
    var rating: String, var releaseYear: String,
    var genre: List<String>
) : BaseModel()